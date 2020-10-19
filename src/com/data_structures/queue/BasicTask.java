package com.data_structures.queue;

public abstract class BasicTask implements ITask{

    /**
     * 默认优先级
     */
    private Priority priority = Priority.DEFAULT;

    private int sequence;

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public int getSequence() {
        return sequence;
    }

    /**
     * 做优先级比较
     * @param another
     * @return
     *
     * compareTo(E)中传进来的E是另一个Task，如果当前Task比另一个Task更靠前就返回负数，
     * 如果比另一个Task靠后，那就返回正数，如果优先级相等，那就返回0。
     */
    @Override
    public int compareTo(ITask another) {
        final Priority me = this.getPriority();
        final Priority it = another.getPriority();
        return me == it ? this.getSequence() - another.getSequence() : it.ordinal() - me.ordinal();
    }
}
