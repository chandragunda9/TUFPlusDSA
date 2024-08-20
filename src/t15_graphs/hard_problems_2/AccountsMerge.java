package t15_graphs.hard_problems_2;

import t15_graphs.mst.DisjointSet;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int n = accounts.size();
        DisjointSet dis = new DisjointSet(n);
        for (int j = 0; j < accounts.size(); j++) {
            List<String> acct = accounts.get(j);
            for (int i = 1; i < acct.size(); i++) {
                String mail = acct.get(i);
                if (!map.containsKey(mail)) {
                    map.put(mail, j);
                } else {
                    dis.unionBySize(map.get(mail), j);
                }
            }
        }
        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int node = dis.findParent(e.getValue());
            mergedMail.get(node).add(e.getKey());
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).isEmpty())
                continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail.get(i));
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][] arr = {

                {"Alice", "alice@mail.com", "alice_work@mail.com"},

                {"Bob", "bob@gmail.com"},

                {"Alice", "alice_personal@mail.com", "alice@mail.com"}

        };
        List<List<String>> li = Arrays.stream(arr).map(l -> Arrays.stream(l).collect(Collectors.toList())).toList();
        System.out.println(accountsMerge(li));
    }
}
