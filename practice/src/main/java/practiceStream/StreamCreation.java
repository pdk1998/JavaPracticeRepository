package practiceStream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Function;

public class StreamCreation {
    /* Create stream from:
    1. Array
        1.1 int
        1.2 char
        1.3 String
        1.4 Object
    2. String
    3. Collection
    4. I/O
     */

    public static void main(String[] args){
        //1.1
        int[] intArr = {1,2,3,4,5};
        Stream<Integer> stream = Stream.of(1,2,3,4,5);      //Stream of type Integer
        IntStream istream = Arrays.stream(intArr);                  //stream of primitive int type

        List<Integer> list = Arrays.asList(1,2,3,4);
        stream = list.stream();                                     //Converting from Collection -> returns Stream<Integer>

        istream = stream.mapToInt(Integer :: intValue);             //Converting from Stream<Integer> -> IntStream
        //istream.map(x->x*3).boxed().forEach(System.out::println);

        stream = istream.boxed();                                   //Converting from IntStream -> Stream<Integer>
        istream = Arrays.stream(intArr);
        stream = istream.mapToObj(n->(int)n);                   //Converting from IntStream -> Stream<Integer>

        //1.2
        char[] charr = {'a','b','c','d','e'};
        Stream<Character>  chStream = Stream.of('a','b','c','d');
        //Map<Character, Long> res = chStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(res);

        IntStream chIntStream = new String(charr).chars();
        chStream = chIntStream.mapToObj(c->(char)c);

        //1.3 and 2
        String s = "   This is an interesting    problem ";
        s = s.trim();
        String[] words = s.split("\\s+");
        Stream<String> strStream = Arrays.stream(words);
        //Map<String, Long> wordFrequencies = strStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(wordFrequencies);

        s = "ababcddedeab";
        Map<Character, Long> charFrequencies = s.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charFrequencies);

    }
}
