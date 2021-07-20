package multi_thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapDemo {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("1", "Malay");
        map.put("2", "Ankit");
        map.put("3", "Chintan");
        Map<String, String> syncmap = Collections.synchronizedMap(map);
        System.out.println("Synchronized map is: " + syncmap);
        // Synchronized map is: {1=Malay, 2=Ankit, 3=Chintan}

        MultiThread[] mt = new MultiThread[3];
        for(int i=0; i<3; i++){
            mt[i] = new MultiThread(syncmap);
            mt[i].start();
        }
        System.out.println(map); // {1=Malay, 2=Ankit, 3=Chintan}
    }
}
