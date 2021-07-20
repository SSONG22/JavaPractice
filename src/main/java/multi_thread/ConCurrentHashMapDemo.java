package multi_thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConCurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "Malay");
        map.put("2", "Ankit");
        map.put("3", "Chintan");

        MultiThread[] mt = new MultiThread[3];
        for(int i=0; i<3; i++){
            mt[i] = new MultiThread(map);
            mt[i].start();
        }
        System.out.println(map); // {1=Malay, 2=Ankit, 3=Chintan}
    }
}
