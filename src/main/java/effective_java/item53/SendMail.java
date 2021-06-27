package effective_java.item53;

import java.util.ArrayList;
import java.util.List;

class SendMail {
    private String sender;
    private List<Object> content = new ArrayList<>();

    void print(){
        System.out.println("보내는 사람: "+sender);
        System.out.println("내용: "+content);
    }
    void send(Object... args) {
        sender = "ANONYMOUS";
        for (Object s : args) {
            content.add(s);
        }
        print();
    }

    void send(String email, Object... args) {
        sender = email;
        for (Object s : args) {
            content.add(s);
        }
        print();
    }

    public static void main(String[] args) {
        SendMail mail = new SendMail();
        mail.send();
//        보내는 사람: ANONYMOUS
//        내용: []
        mail.send(12345);
//        보내는 사람: ANONYMOUS
//        내용: [12345]
        mail.send("12345");
//        보내는 사람: 12345
//        내용: [12345]
        mail.send("aaaa@email.com", "HI", 1,2,3,4,5);
//        보내는 사람: aaaa@email.com
//        내용: [HI, 1, 2, 3, 4, 5]
    }
}
