package com.devnotes.j2se.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		System.out.println(list);

		list.addAll(list);

		System.out.println(list);

		list.clear();

		System.out.println(list);
		
		Vector<String> vctor=new Vector<String>();
		vctor.add("1");
		vctor.add("2");
		vctor.add("3");
		vctor.add("4");
		vctor.add("5");
		System.out.println(vctor);

	}
}
