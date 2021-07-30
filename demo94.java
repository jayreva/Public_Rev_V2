package demos;

import java.util.ArrayList;
import java.util.Iterator;

public class demo94 {
    public static void main(String[] args) {
        ArrayList<String> mList = new ArrayList<>();

        mList.add("Mark");
        mList.add("Paul");
        mList.add("Watson");

        //System.out.println(mList);
        Iterator iterator = mList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String name:mList) {
            System.out.println(name);
            
        }
    }
}
