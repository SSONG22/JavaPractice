package effective_java.item47;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // example 1
//        for(ProcessHandle ph : ProcessHandle.allProcesses()::iterator){
//        }

        for(ProcessHandle ph : (Iterable<ProcessHandle>)ProcessHandle.allProcesses()::iterator){
        }

        // example 2
        Stream<String> games = Stream.of("오버워치", "배틀그라운드", "롤");
//        for (String game: games::iterator) { }
//        for(String game : (Iterable<String>) games::iterator){
//            System.out.println(game);
//        }
        for(String game : Adapters.iterableOf(games)){
            System.out.println(game);
        }

        List<String> list =Arrays.asList("a");
        Stream<String> stream = Stream.of("a");
        System.out.println(list +" "+stream);
    }
}
