package com.lock;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTestMethods {

    public static void test(int round, int threadNum, CyclicBarrier cyclicBarrier){
        new SyncTest("Sync", round, threadNum, cyclicBarrier).testTime();
        new LockTest("Lock", round, threadNum, cyclicBarrier).testTime();
        new AtomicTest("Atom", round, threadNum, cyclicBarrier).testTime();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            int round = 100 * 1000 * (i + 1);
            int threadNum = 5 * (i + 1);
            CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum * 2 + 1);
            System.out.println("=======================");
            System.out.println("round: " + round + " thread: " + threadNum);
            test(round, threadNum, cyclicBarrier);
        }
    }


    static class SyncTest extends TestTemplate {
        public SyncTest(String _id, int _round, int _threadNum, CyclicBarrier _cb) {
            super(_id, _round, _threadNum, _cb);
        }

        @Override
        void sumValue() {
            super.countValue += preInit[index++%round];
        }

        @Override
        long getValue() {
            return super.countValue;
        }
    }

    static class LockTest extends TestTemplate {

        ReentrantLock lock = new ReentrantLock();

        public LockTest(String _id, int _round, int _threadNum, CyclicBarrier _cb) {
            super(_id, _round, _threadNum, _cb);
        }

        @Override
        void sumValue() {
            try {
                lock.lock();
                super.countValue += preInit[index++%round];
            } finally {
                lock.unlock();
            }
        }

        /**
         * synchronized 关键字不在方法签名中  所以不涉及重载问题
         * @return
         */
        @Override
        long getValue() {
            try {
                lock.lock();
                return super.countValue;
            } finally {
                lock.unlock();
            }
        }
    }

    static class AtomicTest extends TestTemplate {

        public AtomicTest(String _id, int _round, int _threadNum, CyclicBarrier _cb) {
            super(_id, _round, _threadNum, _cb);
        }

        @Override
        void sumValue() {
            super.countValueAtomic.addAndGet(super.preInit[indexAtomic.get() % round]);
        }

        /**
         * synchronized 关键字不在方法签名里面 所以不涉及到重载问题
         * @return
         */
        @Override
        long getValue() {
            return super.countValueAtomic.get();
        }
    }
}
