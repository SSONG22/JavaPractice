package design_pattern.bridge_pattern;

public class Main {
    public static void main(String[] args) {
        ConcreteRemote rcaControl = new ConcreteRemote(new RCA());
        ConcreteRemote sonyControl = new ConcreteRemote(new Sony());

        rcaControl.on();
        rcaControl.setStation(11);
        rcaControl.nextChannel();
        rcaControl.previousChannel();
        rcaControl.off();

        System.out.println("------------");
        sonyControl.on();
        sonyControl.setStation(2);
        sonyControl.previousChannel();
        sonyControl.nextChannel();
        sonyControl.off();
    }
}
