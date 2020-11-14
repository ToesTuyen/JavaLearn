package interface_list.assignment;

import java.util.Vector;

public class SynchronizeVector {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100000; i++) {
                        list.add(i);
                        System.out.println("add _ " + i);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 100000; i < 200000; i++) {
                        list.add(i);
                        System.out.println("add _ " + i);

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        try {
            Thread.sleep(20000);
            System.out.println("Size List = " + list.size() + "");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
