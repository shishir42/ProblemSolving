//2.
// Tag: Array

// Input
// ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
// [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
// Output
// [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]

package com.program.LeetCodeDesign;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream_2 {
    public static void main(String[] args){
        DesignAnOrderedStreamSol sol = new DesignAnOrderedStreamSol(5);
        System.out.println(sol.insert(3, "ccccc"));
        System.out.println(sol.insert(1, "aaaaa"));
        System.out.println(sol.insert(2, "bbbbb"));
        System.out.println(sol.insert(5, "eeeee"));
        System.out.println(sol.insert(4, "ddddd"));

        System.out.println("---------------------");

        System.out.println(sol.insert(3, "ccccc"));
        System.out.println(sol.insert(5, "eeeee"));
        System.out.println(sol.insert(2, "bbbbb"));
        System.out.println(sol.insert(1, "aaaaa"));
        System.out.println(sol.insert(4, "ddddd"));
    }
}

class DesignAnOrderedStreamSol{
    int index; 
    String[] s;

    public DesignAnOrderedStreamSol(int n) {
        s = new String[n];    
    }

    public List<String> insert(int id, String value) {
        s[id - 1] = value;
        List<String> list = new ArrayList<>();
        while(index < s.length){
            if(s[index] == null)
                break;
            list.add(s[index++]);
        }

        return list;
    } 
}
