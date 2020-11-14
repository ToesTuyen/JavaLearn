package interface_list.practice_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortObject {
    public static void main(String[] args) {
        List<String> listUnSort = initializeByName();
        showList(listUnSort);
        List<String> listSort = sortByName(listUnSort);
        showList(listSort);
    }

    public static List<String> initializeByName() {
        String[] arr = {"Nguyen Van C", "Nguyen Van B", "Nguyen Van A", "Nguyen Van F"};
        List<String> listName = new ArrayList<>(Arrays.asList(arr));
        listName.add("Nguyen Van E");
        listName.add("Nguyen Van D");
        return listName;
    }

    public static void showList(List<String> listName) {
        System.out.println("__________________SHOW__________________");
        for (String name : listName) {
            System.out.println(name);
        }
    }

    public static List<String> sortByName(List<String> listName) {
        listName.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

//        Collections.sort(listName, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        return listName;
    }
}
