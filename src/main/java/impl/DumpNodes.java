package impl;

import core.Logic;
import core.Node2;
import core.Tree2;

public class DumpNodes<A extends Comparable<A>> implements Logic<A> {
	
	final static int PRE  = 0;
	final static int IN   = 1;
	final static int POST = 2;
	
	final static String[] map = {"pre-order", "in-order", "post-order"};
	
	private int order;
	
	public DumpNodes(int order) {
		this.order = order;
	}

	@Override
	public void before() {
		System.out.print("dumping in " + map[this.order] + "...\n");
	}

	@Override
	public void after() {
		System.out.print("\nfinished dumping...\n");
	}

	@Override
	public void visit(Node2<A> curr) {
		System.out.print(curr.getKey() + ", ");
	}

	public static void main(String[] args) {
		Integer[] pre = {1, 2, 3, 4, 5, 6, 7};
		Integer[] in  = {3, 2, 4, 1, 6, 5, 7};
		
		Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, 0, in.length-1, pre, 0, pre.length-1);
		
		Tree2.preOrder(root, new DumpNodes<Integer>(DumpNodes.PRE));
		Tree2.inOrder(root, new DumpNodes<Integer>(DumpNodes.IN));
		Tree2.postOrder(root, new DumpNodes<Integer>(DumpNodes.POST));
	}

}
