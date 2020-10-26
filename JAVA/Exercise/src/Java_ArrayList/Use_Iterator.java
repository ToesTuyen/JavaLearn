package Java_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Use_Iterator {
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("Minh");
        ar.add("Lan");
        ar.add("Hong");
        ar.add("Huy");
        Iterator<String> it=ar.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
