package di;

public interface HVAC {
    int getTemp();
    int getDesiredTemp();
    void setHeater(boolean heater);
    void setCooler(boolean cooler);
}
