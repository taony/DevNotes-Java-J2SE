package com.devnotes.j2se.threads.quickstart;

public class MyThreadDemo {

    public static void main(String[] args) {

        MyThead mt1 = new MyThead("A");
        MyThead mt2 = new MyThead("B");
        MyThead mt3 = new MyThead("C");

        mt1.run();
        mt2.run();
        mt3.run();
    }
}

class MyThead extends Thread {

    private String name = "";

    MyThead(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println("进入线程 → " + name);

        try {
            Thread.currentThread().sleep(500);
            int i = 0;

            for (; i < 3; i++) {
                System.out.println(name + i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("退出线程 → " + name);

    }
}


