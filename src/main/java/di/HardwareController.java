package di;

public class HardwareController implements HVAC{

    @Override
    public int getTemp() {
        return 0;
    }

    @Override
    public int getDesiredTemp() {
        return 0;
    }

    @Override
    public void setHeater(boolean heater) {

    }

    @Override
    public void setCooler(boolean cooler) {

    }
}
