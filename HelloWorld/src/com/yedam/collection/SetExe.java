package com.yedam.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.yedam.variable.Member;

public class SetExe {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
//        set.add(100);
        set.add("Hello");

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String result = iter.next();
            System.out.println(result);
        }
        
        // Member 객체 set
        Set<Member> members = new HashSet<Member>();
        members.add(new Member("홍길동", 80));
        members.add(new Member("김민규", 85));
        members.add(new Member("홍길동", 80));
        
        Iterator<Member> mIter = members.iterator();
        while (mIter.hasNext()) {
            System.out.println(mIter.next().toString());
        }
        
        int[] intAry = { 10, 20, 30, 40, 20, 10 };
        Set<Integer> intSet = new HashSet<Integer>();
        for (int i : intAry) {
            intSet.add(i);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> intIter = intSet.iterator();
        while (intIter.hasNext()) {
            result.add(intIter.next());
        }
        
        for (int i : result) {
            System.out.println(i);
        }
        
        result.forEach(num -> {
            System.out.println(num);
        });        
    }
}
