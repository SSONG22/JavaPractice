package design_pattern.bridge_pattern;

public interface TV {
    void on();
    void off();
    void tuneChannel(int channel);
    int getStation();
}
