package com.lotus.jewel.sample.collection;

import com.lotus.jewel.sample.collection.set.HashSetBasic;
import com.lotus.jewel.sample.collection.set.TreeSetBasic;

public class TestOfSet {

	public static void main(String[] args) {

		new HashSetBasic().test01();
		
		TreeSetBasic treeSetBasic = new TreeSetBasic();
		treeSetBasic.test01();
		treeSetBasic.test02();
		treeSetBasic.test03();
	}
}
