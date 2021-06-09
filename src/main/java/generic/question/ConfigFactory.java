package generic.question;

import java.util.List;

class ConfigFactory {
    Object createConfig(List configList) {
        if (configList.size() == 0) return null;
        return configList.get(0);
    }
}
