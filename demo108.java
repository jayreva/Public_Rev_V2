package demos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class demo108 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("name", "Mark");
        map.put("roll", 1000);
        map.put("email", "m@gmail.com");
        map.put("active", true);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            //converting to map
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
