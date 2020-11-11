package practice_list;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeProvider {
    public static Scanner scanner;
    public static List<Long> listTime;

    public static void main(String[] args) {
        initialize();

        do {
            System.out.println("----------------Menu----------------");
            System.out.println("1.Show");
            System.out.println("2.Add more");
            System.out.println("3.Edit");
            System.out.println("4.Delete by pos");
            System.out.println("5.Sort");

            switch (scanner.nextLine()) {
                case "1":
                    show();
                    break;
                case "2":
                    addMore();
                    break;
                case "3":
                    System.out.println("In progress");
                    break;
                case "4":
                    delete(scanner);
                    break;
                case "5":
                    sort();
                    break;
            }
            System.out.println("Do you want continue (Y/N) ?");
        } while (scanner.nextLine().equalsIgnoreCase("Y"));
        System.out.println("end");
    }

    public static void addMore() {
        long newTime = Calendar.getInstance().getTimeInMillis();
        listTime.add(Calendar.getInstance().getTimeInMillis());
        System.out.println("Insert:" + convertTime(newTime));
    }

    public static void delete(Scanner scanner) {
        System.out.println("Import index:");
        int index = Integer.parseInt(scanner.nextLine());
        long oldTime = listTime.get(index - 1);
        listTime.remove(oldTime);
        System.out.println("Delete:" + convertTime(oldTime));
    }

    public static void show() {
        for (Long time : listTime) {
            System.out.println(time + "->" + convertTime(time));
        }
    }

    public static String convertTime(long time) {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return format.format(date);
    }

    public static void sort(){
        listTime.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return Long.compare(o2,o1);
            }
        });
        show();
    }

    public static void initialize() {
        System.out.println("Initialize");
        scanner = new Scanner(System.in);
        listTime = new ArrayList<>();
        listTime.add(1605104840000L);
        listTime.add(1605191240000L);
        listTime.add(1605277640000L);
        listTime.add(1605364040000L);
    }
}
