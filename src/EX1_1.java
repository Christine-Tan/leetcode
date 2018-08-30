import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Seven on 29/08/2018.
 */
public class EX1_1 {
    /**
     * 首先要确认 string是ASCII还是UNICODE
     * 如果可以使用其他数据结构
     * 可以用一个数组存储所有字符，第I位对应字符ASCII码位I的字符
     * 1.若sting 的长度超过字符数组长度，直接返回false
     * 2.遍历字符串，将每个字符存储到对应的第I位字符数组中
     * 若当前字符数组的第I位已有赋值，说明是重复字符
     * @param s
     * @return
     */
    public boolean isUnique(String s){
        for (int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Please Input a String:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = br.readLine();
            EX1_1 ex = new EX1_1();
            System.out.println(ex.isUnique(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");
    }

}
