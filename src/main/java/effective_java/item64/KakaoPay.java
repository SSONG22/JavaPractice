package effective_java.item64;

public class KakaoPay implements Pay{
    @Override
    public void payByCash() {
        System.out.println("Kakao Pay by cash");
    }

    @Override
    public void payByCreditCard() {
        System.out.println("Kakao Pay by cash");
    }
}
