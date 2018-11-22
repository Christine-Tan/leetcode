import java.util.*;

/**
 * Created by Seven on 18/09/2018.
 */
public class EX49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramGroups = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            List<String> list = anagramMap.getOrDefault(c.toString(), new ArrayList<>());
            list.add(str);
            anagramMap.put(c.toString(), list);
        }
        for (String key : anagramMap.keySet()) {
            anagramGroups.add(anagramMap.get(key));
        }
        return anagramGroups;
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EX49 ex = new EX49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ex.groupAnagrams(strs).toString());

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");


    }
}
