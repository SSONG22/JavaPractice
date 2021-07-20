package multi_thread;

import java.util.Map;

class MultiThread extends Thread {
    private Map<String, String> map;
    MultiThread(Map<String, String> map){
        this.map = map;
    }
    public void run(){
        try {
            map.put("4", this.getName());
            System.out.println(this.getName()+" "+ map);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
