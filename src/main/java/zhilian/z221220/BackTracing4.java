package zhilian.z221220;

import java.util.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/12/21 15:51
 */
public class BackTracing4 {

    List<List<String>> result = new ArrayList<List<String>>();
    LinkedList<String> item = new LinkedList<String>();
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, Integer> cache = new HashMap<>();
        this.dfs(0,1, paths, cache);
        return result;
    }

    private void dfs(int startIndex, int startIndex2, String[] paths, Map<String, Integer> cache) {
        if (startIndex > paths.length) {
            result.add(new LinkedList<>(item));
            return;
        }

        for (int i = startIndex; i < paths.length; i++) {
            String[] split = paths[i].split(" ");
            System.out.println(split);
            if (startIndex2 > split.length - 1) {
                startIndex2 = 1;
                if (item.size() > 1) {
                    result.add(new LinkedList<>(item));
                }
                continue;
            }

            for (int j = startIndex2; j < split.length; j++) {
                String[] split1 = split[j].split("\\(");

                if (cache.containsKey(split1[1])) {
                    item.add(split1[0]);
                }
                cache.put(split1[1],i);

                dfs(i,j+1, paths, cache);

                if (item.size() > 0) {
                    item.removeLast();
                }

            }
            dfs(i+1,startIndex2, paths, cache);



        }
    }

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        BackTracing4 BackTracing4 = new BackTracing4();
        System.out.println(BackTracing4.findDuplicate(paths));
    }
}