package brickWall;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Max Zhang on 2020/9/4.
 */
public class BrickWall {

    /*
    * 自己写的算法，有些笨重
    * 不过表现还可以
    *
    * Time Submitted    | Status    | Runtime   | Memory    | Language
    * 09/04/2020 22:50	Accepted	12 ms	    42.7 MB	    java
    *
    */
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp;
        for (List<Integer> integers : wall) {
            temp = 0;
            for (Integer integer : integers) {
                temp += integer;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        Object[] a = map.values().toArray();
        Arrays.sort(a);
        if (a.length == 1) {
            return wall.size();
        }
        return wall.size() - (int)a[a.length-2];


//        改良之后，效果好了一些
//        ######################################################################
//        09/04/2020 22:57	Accepted	10 ms	42.2 MB	java                   #
//        ######################################################################
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int temp;
//        for (List<Integer> integers : wall) {
//            temp = 0;
//            for (int i = 0; i < integers.size() - 1; i++) {
//                temp += integers.get(i);
//                if (map.containsKey(temp)) {
//                    map.put(temp, map.get(temp) + 1);
//                } else {
//                    map.put(temp, 1);
//                }
//            }
//        }
//
//        if (map.keySet().size() == 0) {
//            return wall.size();
//        }
//        Object[] a = map.values().toArray();
//        Arrays.sort(a);
//        return wall.size() - (int)a[a.length-1];
    }
}
