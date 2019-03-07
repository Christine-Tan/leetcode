/**
 * Created by Seven on 04/01/2019.
 */
public class LendinghomeOA {
        /*
         * Complete the longest_palindrome function below.
         */
        static String longest_palindrome(String input) {
        /*
         * Write your code here.
         */
            char[] c=input.toCharArray();
            int len=c.length;
            //if length is less than 2, return empty string
            if(len<2) return "";

            int start=0,end=0;
            int maxLen=0;
            for(int i=0;i<len;i++){
                if(isPalindrome(input,i-maxLen-1,i)){
                    start=i-maxLen-1;
                    end=i;
                    maxLen+=2;
                }else if(isPalindrome(input,i-maxLen,i)){
                    start=i-maxLen;
                    end=i;
                    maxLen+=1;
                }
            }
            if (end-start<2) return "";
            return input.substring(start,end+1);
        }

        private static boolean isPalindrome(String str,int s,int e){
            if(s<0) return false;

            //check if this is a "palindrome"
            //ignore all case and spaces
            char[] c = str.toLowerCase().toCharArray();
            while(s<e){
                if (c[s]==' '){
                    s++;
                    continue;
                }
                if (c[e]==' '){
                    e--;
                    continue;
                }
                if (c[e--]!=c[s++]){
                    return false;
                }
            }
            return true;
        }

}
