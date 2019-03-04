package com.hsl.test;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private static volatile int i = 0;
    private static volatile int m = 0;


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        MyThread2 myThread2 = new MyThread2(lock);
        MyThread2 myThread21 = new MyThread2(lock);
        MyThread2 myThread22 = new MyThread2(lock);

        Thread thread = new Thread(myThread2);
        thread.setName("line-1");
        Thread thread1 = new Thread(myThread21);
        thread1.setName("line-2");
        Thread thread3 = new Thread(myThread22);
        thread1.setName("line-3");
        thread.start();
        thread1.start();
        thread3.start();

        //System.out.println(i);
    }
    static  class  MyThread2 implements Runnable{
        private ReentrantLock lock = null;

        public MyThread2(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
//            synchronized (Test.class){
//                try {
//                    for (int j = 0; j < 100 ; j++) {
//                        add();
//                        String name = Thread.currentThread().getName();
//                        System.out.println(name+":i="+i+":j="+m);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(":"+lock.getQueueLength());
            lock.lock();
            String name = Thread.currentThread().getName();
            System.out.println(name+":"+lock.getQueueLength());

            try {
                for (int j = 0; j < 100 ; j++) {
                    add();

                    System.out.println(name+":i="+i+":j="+m);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }
    }
    private static void add(){
        i++;
        m+=2;

    }
}
