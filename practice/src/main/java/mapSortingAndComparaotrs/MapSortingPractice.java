package mapSortingAndComparaotrs;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortingPractice {

    public static void main(String[] args){
        Map<String, Integer> unsortedMap = new HashMap<String, Integer>();
        unsortedMap.put("Prajkta", 3);
        unsortedMap.put("Aadesh", 2);
        unsortedMap.put("Ashutosh", 1);

        Map<String, Integer> sortedMap;
        sortedMap = usingTreeMap(unsortedMap);
        sortedMap = usingStreamAPI(unsortedMap);
        System.out.println("Using Stream API : ");
        sortedMap.forEach((k,v) -> System.out.println("Key : " + k + " Value : " + v));

    }

    static Comparator<Map.Entry<String, Integer>> compareBySecondLetter = (e1, e2) ->{
        String s1 = e1.getKey();
        String s2 = e2.getKey();
        if(s1.length() < 2 && s2.length() < 2)
            return 0;
        if(s1.length() < 2)
            return -1;
        if(s1.length() < 2)
            return 1;
        return (Character.compare(s1.charAt(1), s2.charAt(1)));
    };

    private static Map<String, Integer> usingStreamAPI(Map<String, Integer> unsortedMap) {
        Map<String, Integer> sortedMap = unsortedMap.entrySet()
                .stream()
                .sorted(compareBySecondLetter)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        return sortedMap;
    }

    private static Map<String, Integer> usingTreeMap(Map<String, Integer> unsortedMap) {
        Map<String, Integer> sortedMap;
        sortedMap = new TreeMap<>(Comparator.naturalOrder());
        sortedMap.putAll(unsortedMap);

        sortedMap.forEach((k,v) -> System.out.println("Key : " + k + " Value : " + v));

        System.out.println("\nGoing for second lambda...");
        HashMap<Integer, String> set = new HashMap();
        sortedMap.forEach((k,v) -> {
            System.out.println("Key : " + k + " Value : " + v);
            System.out.println("Executing second line...");
        });
        return sortedMap;
    }
}
