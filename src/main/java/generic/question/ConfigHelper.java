package generic.question;

import java.util.List;

class ConfigHelper {
    public Object createConfig(List<Config> configArgs){
        ConfigFactory factory = new ConfigFactory();
        return factory.createConfig(configArgs);
    }
}
