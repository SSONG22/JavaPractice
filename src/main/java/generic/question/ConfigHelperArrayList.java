package generic.question;

import java.util.ArrayList;

class ConfigHelperArrayList {
    public Object createConfig(ArrayList<Config> configArgs){
        ConfigFactory factory = new ConfigFactory();
        return factory.createConfig(configArgs);
    }
}
