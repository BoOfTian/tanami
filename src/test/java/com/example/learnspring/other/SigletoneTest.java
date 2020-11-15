package com.example.learnspring.other;

public class SigletoneTest {
    private static volatile SigletoneTest st;

    private SigletoneTest() {

    }

    public static SigletoneTest getInstance() {
        // 第一次检查，volatile关键字
        if (st == null) {
            synchronized (SigletoneTest.class) {

                // 第二次检查，volatile关键字作用
                if (st == null) {
                    st = new SigletoneTest();
                }
            }
        }
        return st;

    }
}
