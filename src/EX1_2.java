import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Seven on 29/08/2018.
 */
public class EX1_2 {
    public static final int ONE = 1;

    /**
     * 首先要确定
     * 1. case sensitive ？
     * 2. white space significant ？
     * 3. ASCII码字符？
     * 假定均为yes
     * 若两个字符串长度不等，则不可能为其排列
     * 若长度相等，有两种方案
     * 一、将两个字符串分别按ASCII码排序，比较排序后的字符串是否相等
     * 二、计算原始字符串中每个字符出现的次数，再遍历比较字符串，将相应字符数减1，若字符数组中出现小于0的数，则返回false
     * @param oriStr
     * @param checkStr
     * @return
     */
    public boolean isPermutation(String oriStr, String checkStr) {
        if (oriStr.length() == 0 && checkStr.length() == 0) {
            return true;
        }
        if (oriStr.length() == checkStr.length() && oriStr != "" && checkStr != "") {
            Map<String, Integer> oriMap = countElement(oriStr);
            Map<String, Integer> checkMap = countElement(checkStr);
            if (oriMap.equals(checkMap))
                return true;
        }
        return false;
    }

    public Map countElement(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                int value = map.get(c);
                value = value + 1;
                map.put(c, value);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Please Input two String:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String oriStr = br.readLine();
            String checkStr = br.readLine();
            EX1_2 ex = new EX1_2();
            System.out.println(ex.isPermutation(oriStr, checkStr));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
    }
}
