package com.blockchaincomputing.tasktracker.service;

import com.blockchaincomputing.tasktracker.constants.BlockchainConfigConstants;
import com.blockchaincomputing.tasktracker.model.BlockchainTask;
import com.blockchaincomputing.tasktracker.model.TaskCounter;
import com.blockchaincomputing.tasktracker.repository.BlockchainTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.util.Date;

@Service
public class BlockchainTaskService {

    @Autowired
    private BlockchainTaskRepository blockchainTaskRepository;

    /**
     * calls taskCount function of Smart-Contract deployed on Goerli
     * @return number of tasks created
     * @throws Exception
     */
    public BigInteger getSmartContractTaskCount() throws Exception {
        BigInteger taskCount = new BigInteger("0");

        Credentials credentials = Credentials.create(BlockchainConfigConstants.PRIVATE_KEY);

        Web3j web3j = Web3j.build(new HttpService("https://rpc.slock.it/goerli"));
        TaskCounter taskCounter = TaskCounter.load(BlockchainConfigConstants.CONTRACT_ADDRESS, web3j, credentials, new StaticGasProvider(BigInteger.valueOf(30_000) ,BigInteger.valueOf(30_000)));
        taskCount = taskCounter.taskCount().send();
        web3j.shutdown();
        return taskCount;
    }

    /**
     * Trigger newTask function on deployed Smart-Contract
     * @return
     * @throws Exception
     */
    public String addBlockChainTask() throws Exception {
        Credentials credentials = Credentials.create(BlockchainConfigConstants.PRIVATE_KEY);
        BlockchainTask blockchainTask = new BlockchainTask();
        TransactionReceipt transaction = new TransactionReceipt();
        TransactionReceipt futureReciept = new TransactionReceipt();
        Web3j web3j = Web3j.build(new HttpService("https://rpc.slock.it/goerli"));

        TaskCounter taskCounter = TaskCounter.load(BlockchainConfigConstants.CONTRACT_ADDRESS, web3j, credentials, new StaticGasProvider(BigInteger.valueOf(50_000) ,BigInteger.valueOf(60_000)));
        transaction = taskCounter.newTask().sendAsync().getNow(futureReciept);

        BlockchainTask newTask = new BlockchainTask(transaction.getTransactionIndex().toString(), new Date());
        this.blockchainTaskRepository.save(newTask);

        web3j.shutdown();

        return "Add Transaction success";
    }
}
