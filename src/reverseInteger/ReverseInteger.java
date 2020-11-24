package reverseInteger;

/**
 * Created by Max Zhang on 2020/9/5.
 *
 * 嫖的大佬的想法，思维僵化啊
 * 不能总想着遍历
 *
 * 09/05/2020 00:19	Accepted	1 ms	37.1 MB	java
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int newResult;
        while (x != 0) {
            int tail = x % 10;
            newResult = result * 10 + tail;
            if ((newResult- tail) / 10 != result) return 0;
            result = newResult;
            x /= 10;
        }
        return result;
    }
}
