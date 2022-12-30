package zhilian.z221220;

import java.util.LinkedList;
import java.util.List;

/**
 * 最长回文子串
 * @author zhanghailang
 * @since 2022/12/20 17:50
 **/
public class Backtracing2 {

    List<List<String>> result = new LinkedList();
    LinkedList<String> path = new LinkedList();
    public List<List<String>> partition(String s) {
        backTracjing(path, 0, s);
        return result;
    }

    public void backTracjing(LinkedList<String> path, int startIndex, String s) {

        if (startIndex >= s.length()) {
            result.add(new LinkedList(path));
            return;
        }

        //循环条件 第一个东西的个数
        for(int i = startIndex; i < s.length(); i ++) {
            String ele = s.substring(startIndex, i + 1);
            if (isHWen(ele)) {
                path.add(ele);
            } else {
                continue;
            }
            backTracjing(path, i + 1, s);
            path.removeLast();

        }
    }

    public boolean isHWen(String ele) {
        for(int i=0, j=ele.length()-1; i <= j; i++,j --) {
            if(ele.charAt(i)!=ele.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Backtracing2 backtracing2 = new Backtracing2();
        System.out.println(backtracing2.partition("aab"));
    }
}
