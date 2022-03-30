package design_pattern.bridge_pattern;

public class Sony implements TV {
    int station = 0;

    @Override
    public void on() {
        System.out.println("Sony ON");
    }

    @Override
    public void off() {
        System.out.println("Sony OFF");
    }

    @Override
    public void tuneChannel(int channel) {
        station = channel;
        System.out.println("Sony tuneChannel = " + channel);
    }

    @Override
    public int getStation() {
        return station;
    }
}
