package impl;

import core.Logic;
import core.Node2;
import core.Tree2;

public class IncKeysByVal<A extends Comparable<A>> implements Logic<A> {
	
	private Integer val;
	
	public IncKeysByVal(A val) {
		try {
			if (!isIntegerOrInherents(val))
				System.exit(1);
			else {
				this.val = (Integer)val;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public boolean isIntegerOrInherents(A val) {
		Class<?> clazz = val.getClass();
		while (clazz != null) {
			if (clazz.equals(Integer.class))
				return true;
			clazz = clazz.getSuperclass();
		}
		return false;
	}
	
	@Override
	public void before() {
	}

	@Override
	public void after() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public void visit(Node2<A> curr) {
		Integer oldKey = (Integer)curr.getKey();
		Integer newKey = oldKey + this.val;
		curr.setKey((A) newKey);
	}

	public static void main(String[] args) {
		Integer[] pre = {1, 2, 3, 4, 5, 6, 7};
		Integer[] in  = {3, 2, 4, 1, 6, 5, 7};
		
		Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, 0, in.length-1, pre, 0, pre.length-1);
		Tree2.preOrder(root, new DumpNodes<Integer>(DumpNodes.PRE));
		Tree2.preOrder(root, new IncKeysByVal<Integer>(10));
		Tree2.preOrder(root, new DumpNodes<Integer>(DumpNodes.PRE));
	}

}
