import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Seven on 30/08/2018.
 */
public class EX1_4 {

    public boolean containsPalindrome(String str) {
        //将string中出现的所有字符计数
        Map<Character, Integer> totalCount = new HashMap<>();
        int odd = 0;
        for (char c : str.toCharArray()) {
            if (c != ' ') {
                if (totalCount.containsKey(c)) {
                    int num = totalCount.get(c);
                    num = num + 1;
                    totalCount.put(c, num);
                    if (num % 2 == 0)
                        odd--;
                    else
                        odd++;
                } else {
                    totalCount.put(c, 1);
                    odd++;
                }
            }
        }
        //若数目为奇数的字符数<=1
        //则包含回文排列
        return odd <= 1;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Please Input the String");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            EX1_4 ex = new EX1_4();
            System.out.println(ex.containsPalindrome(str.toLowerCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
    }
}
