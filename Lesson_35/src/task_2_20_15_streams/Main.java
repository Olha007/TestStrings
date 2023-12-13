package task_2_20_15_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> predators = Arrays.asList("lions", "tigers", "bears", "lions");

        Map<Integer, Set<String>> result = predators.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.toSet()
                ));

        result.forEach((key, value) ->System.out.println(key + " letters " + value));
    }
}
