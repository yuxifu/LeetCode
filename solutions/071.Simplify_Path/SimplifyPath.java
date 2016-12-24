/*
 *  Author:      Yuxi Fu
 *  Create Date: 2016-12-22
 */
/*
   Given an absolute path for a file (Unix-style), simplify it.

   For example,
   path = "/home/", => "/home"
   path = "/a/./b/../../c/", => "/c"
 */

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {

// Time: o(n)
// Space: o(1)
// accepted
public String simplifyPath(String path) {
        Stack<String> res = new Stack<String>();
        String[] ps = path.split("/");
        for (String a : ps) {
                if (a.equals("..")) {
                        if (!res.empty()) {
                                res.pop();
                        }
                } else if (a.equals(".") || a.equals("")) {
                        continue;
                } else {
                        res.push(a);
                }
        }
        if (res.empty()) {
                return "/";
        } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < res.size(); ++i)
                        sb.append("/" + res.get(i));
                return sb.toString();
        }
}

// debug
public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/home//fsdf///dds//.././/"));
}

}
