import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Seven on 29/08/2018.
 */
public class EX1_3 {

    public void replaceSpaces(String str, Integer trueLength) {
        //记录所有空格数
        int spaceNum = 0;
        char[] c = str.toCharArray();
        for (int i = 0; i < trueLength; i++) {
            if (c[i] == ' ') {
                spaceNum++;
            }
        }
        //移动字符
        int length = trueLength + spaceNum * 2;
        //end of the string ??? //TODO why
        if (length <= c.length && length > trueLength)
            c[trueLength] = '\0';
        
        int index = length - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                c[index] = '0';
                c[index - 1] = '2';
                c[index - 2] = '%';
                index = index - 3;
            } else {
                c[index] = c[i];
                index--;
            }
        }
        System.out.println(new String(c));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Please Input the String and its Length:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            Integer length = Integer.valueOf(br.readLine());
            EX1_3 ex = new EX1_3();
            ex.replaceSpaces(str, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");
    }
}
