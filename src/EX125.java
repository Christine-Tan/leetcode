/**
 * Created by Seven on 31/10/2018.
 */
public class EX125 {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        char[] c=s.toCharArray();
        int start=0,end=c.length-1;
        while(start<end){
            if('a'<=c[start]&&c[start]<='z'&&'a'<=c[end]&&c[end]<='z'){
                if(c[start]!=c[end])
                    return false;
                start++;
                end--;
            }else{
                if (c[start]<'a'||c[start]>'z') start++;
                if(c[end]<'a'||c[end]>'z') end--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EX125 ex = new EX125();
        System.out.println(ex.isPalindrome("0P"));

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + "ms");


    }
}
