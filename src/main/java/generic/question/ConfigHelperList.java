package generic.question;

import java.util.List;

class ConfigHelperList {
    public Object createConfig(List configArgs){
        ConfigFactory factory = new ConfigFactory();
        return factory.createConfig(configArgs);
    }
}
