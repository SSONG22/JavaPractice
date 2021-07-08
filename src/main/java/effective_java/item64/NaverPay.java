package effective_java.item64;

public class NaverPay implements Pay {
    @Override
    public void payByCash() {
        System.out.println("Naver Pay by cash");
    }

    @Override
    public void payByCreditCard() {
        System.out.println("Naver Pay by credit card");
    }
}
