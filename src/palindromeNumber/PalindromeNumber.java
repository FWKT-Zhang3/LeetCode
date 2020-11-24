package palindromeNumber;

/**
 * Created by Max Zhang on 2020/9/5.
 *
 * 自己的写法，还是没有摆脱遇事不决就遍历的想法
 * 内存还可以，但是运行的很慢
 *
 * 09/05/2020 12:03	Accepted	13 ms	38.9 MB	java
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        char[] c = ("" + x).toCharArray();
        int tail;
        for (int i = 0; i < c.length/2; i++) {
            tail = c.length - i - 1;
            if (c[i] != c[tail]) {
                return false;
            }
        }
        return true;
    }


    /*
     * 大佬的写法，妙啊
     *
     * 09/05/2020 12:11	Accepted	6 ms	38.7 MB	java
     */
//    public boolean isPalindrome(int x) {
//        if (x<0 || (x!=0 && x%10==0)) return false;
//        int rev = 0;
//        while (x>rev){
//            rev = rev*10 + x%10;
//            x = x/10;
//        }
//        return (x==rev || x==rev/10);
//    }
}
