package effective_java.item46;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Freq {
    static final int COUNT = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[COUNT];
        for(int i=0; i<COUNT; i++){
            arr[i] = sc.nextLine();
        }
        Map<String, Long> freq;
        try (Stream<String> words = Arrays.asList(arr).stream()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq);
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed()) // 빈도표에서 가장 흔한 단어
                .limit(10) // 10개를 뽑아내는
                .collect(toList()); // Collectors 의 멤버를 정적 임포트

        System.out.println(topTen);
    }
}