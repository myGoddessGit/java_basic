package com.data_structures.queue;

/**
 * 办事的人
 */
public interface ITask extends Comparable<ITask>{
    void run();
    void setPriority(Priority priority);
    Priority getPriority();

    void setSequence(int sequence);

    int getSequence();
}
