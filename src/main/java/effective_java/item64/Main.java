package effective_java.item64;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Pay payment = new KakaoPay();
        Pay payment = new NaverPay();
        payment.payByCash();
        payment.payByCreditCard();
//        Kakao Pay by cash
//        Kakao Pay by cash

//        Naver Pay by cash
//        Naver Pay by credit card
    }
}
