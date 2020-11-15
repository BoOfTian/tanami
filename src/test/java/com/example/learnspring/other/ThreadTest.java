package com.example.learnspring.other;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    /*
    线程间变量可见性有三种方式 ：<br/>
    1.final：表示不可变变量，既然都是不可变，那就是 所有使用的线程都不可以改变，即不修改final变量，保证可见性<br/>
    2.volatile：Java语言可见性语句，保证变量修改其他线程可见<br/>
    3.synchronized：因为锁机制，保证可见性
     */

    private static boolean flag = true;
//    private static volatile boolean flag = true;//1。可见性volatile

    /*
     * 产生线程安全问题原因：Java的线程模型<br/>
     * 线程工作内存（局部变量）<-> 主内存（堆），加入变量a，三个线程去读，并修改，后刷新会主内存，主内存的值将是最后刷入线程修改的值
     *
     */
    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (flag) {
                i++;
            }
            System.out.println("变量i=" + i);
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i = 0;
//
//                while (flag) {
//                    synchronized (this) {// 2.加锁，synchronized
//                        i++;
//                    }
//                }
//                System.out.println(this);//com.example.learnspring.other.ThreadTest$1@642cdec0
//                System.out.println("变量i=" + i);
//            }
//        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        System.out.println("主线程结束");
    }


    //TODO 线程生命周期控制
}
