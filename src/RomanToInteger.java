import java.util.HashMap;

/**
 * Created by Max Zhang on 2020/9/5.
 *
 * 没什么太好的办法，遍历就行
 * 09/05/2020 12:53	Accepted	4 ms	40.4 MB	java
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int cur, pre = 1, total = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            cur = map.get(s.charAt(i));
            if (cur < pre) {
                total -= cur;
            } else {
                total += cur;
                pre = cur;
            }
        }
        return total;
    }

//    public int romanToInt(String s) {
//        int[] map = new int[256];
//        map['I'] = 1;
//        map['V'] = 5;
//        map['X'] = 10;
//        map['L'] = 50;
//        map['C'] = 100;
//        map['D'] = 500;
//        map['M'] = 1000;
//
//        int ret = 0, pre = 1;
//        for (int i = s.length()-1; i >= 0; --i) {
//            int cur = map[s.charAt(i)];
//            if (cur < pre) ret -= cur;
//            else {
//                pre = cur;
//                ret += cur;
//            }
//        }
//        return ret;
//    }
}
