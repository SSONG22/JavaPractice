package design_pattern.bridge_pattern;

public class RCA implements TV {
    int station = 0;

    @Override
    public void on() {
        System.out.println("RCA ON");
    }

    @Override
    public void off() {
        System.out.println("RCA OFF");
    }

    @Override
    public void tuneChannel(int channel) {
        station = channel;
        System.out.println("RCA tuneChannel " + channel);
    }

    @Override
    public int getStation() {
        return station;
    }
}
