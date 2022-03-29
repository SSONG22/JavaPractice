package di;

public class ThermostatController {

    private static final long ONE_MINUTE = 1000 * 60;

    void regulate(HVAC hvac) throws InterruptedException {
        int goleT, t;
        while (true) {
            Thread.sleep(ONE_MINUTE);
            goleT = hvac.getDesiredTemp();
            t = hvac.getTemp();

            if (t < goleT) {
                hvac.setHeater(true);
                hvac.setCooler(false);
            } else if (t > goleT) {
                hvac.setHeater(false);
                hvac.setCooler(true);
            } else {
                hvac.setHeater(false);
                hvac.setCooler(false);
            }
        }
    }
}
