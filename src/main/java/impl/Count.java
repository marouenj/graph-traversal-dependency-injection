package impl;

import core.Logic;
import core.Node2;
import core.Tree2;

public class Count<A extends Comparable<A>> implements Logic<A> {
	
	private int size = 0;
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public void before() {
	}

	@Override
	public void after() {
	}

	@Override
	public void visit(Node2<A> curr) {
		size++;
	}

	public static void main(String[] args) {
		Integer[] pre = {1, 2, 3, 4, 5, 6, 7};
		Integer[] in  = {3, 2, 4, 1, 6, 5, 7};
		
		Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, 0, in.length-1, pre, 0, pre.length-1);
		
		Count<Integer> cnt = new Count<>();
		Tree2.postOrder(root, cnt);
		System.out.println(cnt.getSize());
	}

}
