package com.blockchaincomputing.tasktracker.service;

import com.blockchaincomputing.tasktracker.constants.BlockchainConfigConstants;
import com.blockchaincomputing.tasktracker.model.BlockchainTask;
import com.blockchaincomputing.tasktracker.model.TaskCounter;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

@Service
public class BlockchainTaskService {

    public BigInteger getSmartContractTaskCount() throws Exception {
        BigInteger taskCount = new BigInteger("0");

        Credentials credentials = Credentials.create(BlockchainConfigConstants.PRIVATE_KEY);

        Web3j web3j = Web3j.build(new HttpService("https://rpc.slock.it/goerli"));
        TaskCounter taskCounter = TaskCounter.load(BlockchainConfigConstants.CONTRACT_ADDRESS, web3j, credentials, new StaticGasProvider(BigInteger.valueOf(30_000) ,BigInteger.valueOf(30_000)));
        taskCount = taskCounter.taskCount().send();
        web3j.shutdown();
        return taskCount;
    }

    public String addBlockChainTask() throws Exception {
        Credentials credentials = Credentials.create(BlockchainConfigConstants.PRIVATE_KEY);
        BlockchainTask blockchainTask = new BlockchainTask();
        TransactionReceipt transaction = new TransactionReceipt();
        Web3j web3j = Web3j.build(new HttpService("https://rpc.slock.it/goerli"));

        TaskCounter taskCounter = TaskCounter.load(BlockchainConfigConstants.CONTRACT_ADDRESS, web3j, credentials, new StaticGasProvider(BigInteger.valueOf(150_000) ,BigInteger.valueOf(150_000)));
        transaction = taskCounter.newTask().send();

        web3j.shutdown();
        System.out.println(transaction);
        System.out.println(transaction.toString());

        return "Add Transaction success";
    }
}
