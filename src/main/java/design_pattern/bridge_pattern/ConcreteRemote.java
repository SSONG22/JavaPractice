package design_pattern.bridge_pattern;

public class ConcreteRemote extends RemoteControl {

    protected ConcreteRemote(TV tv) {
        super(tv);
    }

    @Override
    void on() {
        System.out.println(tv.getClass().getName() + " ON ");
    }

    @Override
    void off() {
        System.out.println(tv.getClass().getName() + " OFF " );
    }

    void setStation(int station) {
        System.out.println(" concrete Remote - setStation");
        setChannel(station);
    }

    void nextChannel() {
        System.out.println(" concrete Remote - nextChannel");
        setChannel(tv.getStation() + 1);
    }

    void previousChannel() {
        System.out.println(" concrete Remote - previousChannel");
        setChannel(tv.getStation() - 1);
    }
}
