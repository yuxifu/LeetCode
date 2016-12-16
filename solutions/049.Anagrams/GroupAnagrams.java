/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-16
 */
/*
   Given an array of strings, group anagrams together.
   For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
   Return:
   [
   ["ate", "eat","tea"],
   ["nat","tan"],
   ["bat"]
   ]

   Solution: Sort the string to see if they're anagrams.
 */

import java.util.*;

public class GroupAnagrams {

// Time: O(n * glogg)
// Space: O(n)
// accepted
public List<List<String> > groupAnagrams(String[] strs) {
        if(strs==null || strs.length == 0) {
                return new ArrayList<List<String> >();
        }
        HashMap<String, List<String> > map = new HashMap<String, List<String> >();
        for (String s:strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String keyStr = String.valueOf(ca);
                if(!map.containsKey(keyStr))
                        map.put(keyStr, new ArrayList<String>());
                map.get(keyStr).add(s);
        }

        for(String key: map.keySet()) {
                Collections.sort(map.get(key));
        }
        return new ArrayList<List<String> >(map.values());
}

// debug
public static void main(String[] args) {
        GroupAnagrams s = new GroupAnagrams();
        String[] strs= new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(strs));
}
}
