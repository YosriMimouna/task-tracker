pragma solidity ^0.5.16;

contract TaskCounter {

    uint numberOfTasks;

    /**
     * Add a new task on-chain.
     *
     */
    function newTask() public {
        numberOfTasks = numberOfTasks + 1;
    }

    /**
     * Get the current number of created tasks.
     *
     */
    function taskCount() public view returns (uint) {
        return numberOfTasks;
    }
}