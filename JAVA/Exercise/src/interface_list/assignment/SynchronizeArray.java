package interface_list.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SynchronizeArray {


    public static void main(String[] args) {
        int MAX = 200000;
        List<Integer> list = new ArrayList<>();

        //solution 1 : using Collections.synchronizedList()"
        //List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        // case 1: using 2 thread
        // comment the 2 thread , if using solution 2
        /*new Thread(new Runnable() {
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

                    for (int i = 100000; i < MAX; i++) {
                        list.add(i);
                        System.out.println("add _ " + i);

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();*/

        //solution 2 : using thread pool
        //comment the logic . if using solution 1
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAX; i++) {
                    list.add(i);
                    System.out.println("add _ " + i);
                }
            }
        });
        executor.shutdown();

        //Result
        // case 1: using 2 thread
        // result : occur : list size < MAX
        //          expect : list size = MAX
        // solution 1 : using Collections.synchronizedList()
        // solution 2 : using thread pool
        try {
            Thread.sleep(20000);
            System.out.println("Size List = " + list.size() + "");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
