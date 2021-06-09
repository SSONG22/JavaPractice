package generic.question;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericQuestion {
    ConfigFactory configFactory = new ConfigFactory();
    @DisplayName("파라미터 타입으로 ArrayList<Object>")
    @Test
    void arrayListObject(){
        ArrayList<Object> objects = new ArrayList<>(Arrays.asList(1,2,3));
        Object object = configFactory.createConfig(objects);
    }

    @DisplayName("파라미터로 ArrayList<Config>를 받을 때")
    @Test
    void arrayListConfig(){
        ArrayList<Config> list = new ArrayList<>();
        list.add(new Config());
        ConfigHelperArrayList configHelper = new ConfigHelperArrayList();
        Object object = configHelper.createConfig(list);
        // object -> string, integer
    }

    @DisplayName("파라미터 타입으로 List<DynamicConfig>")
    @Test
    void listDynamicConfig(){
        List<DynamicConfig> objects = new ArrayList<>();
        objects.add(new DynamicConfig());
        Object object = configFactory.createConfig(objects);
        // object -> string, integer, dynamic
    }

    @DisplayName("파라미터로 ArrayList<DynamicConfig>를 받을 때")
    @Test
    void arrayListDynamicConfig(){
        ArrayList<DynamicConfig> list = new ArrayList<>();
        list.add(new DynamicConfig());
        Object object = configFactory.createConfig(list);
        // object -> string, integer
        // string integer dynamic
    }

    @DisplayName("파라미터로 List<Object>를 받을 때")
    @Test
    void listObject(){
        List<Object> objects = new ArrayList(Arrays.asList("1",1,2));
        Object object = configFactory.createConfig(objects);
        // object -> "1"
    }

    @DisplayName("파라미터로 List<Config>를 받을 때")
    @Test
    void listConfig(){
        List<Config> configs = new ArrayList<>();
        configs.add(new Config());
        ConfigHelper configHelper = new ConfigHelper();
        Object object = configHelper.createConfig(configs);
        // string, integer
    }

    @DisplayName("파라미터로 List 를 받을 때")
    @Test
    void list() {
        ConfigHelperList configHelper = new ConfigHelperList();
        Object object = configHelper.createConfig(new LinkedList(Arrays.asList("1","2","3")));

    }




}