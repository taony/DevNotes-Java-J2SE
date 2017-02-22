package com.devnotes.j2se.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		System.out.println("add:" + list);
		
		List<String> list2= new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add(1,"4");
		list.addAll(2,list2);
		System.out.println("addAll:" + list);

		list.clear();
		list2.clear();

		list.add("A");
		list.add("B");
		list.add("C");
		
		list.add("A");
		list.add("B");
		list.add("D");
		System.out.println("list.retainAll(list2):" + list.retainAll(list2));
		System.out.println("list:" + list);
		

	}
}
