package com.devnotes.j2se.threads.quickstart;

public class RunnableDemo {

    public static void main(String[] args) {
        MyRunTread mt1 = new MyRunTread("1");
        MyRunTread mt2 = new MyRunTread("2");
        MyRunTread mt3 = new MyRunTread("3");

        mt1.run();
        mt2.run();
        mt3.run();

    }

}

class MyRunTread implements Runnable {

    private String name = "";

    public MyRunTread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 1;

        for (; i <= 3; i++) {
            System.out.println("线程" + name + "正在执行" + i);
        }
    }
}
