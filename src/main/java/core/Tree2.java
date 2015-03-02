package core;

import java.util.Stack;

import util.Arrays;

public class Tree2 {

	public static<A extends Comparable<A>> void preOrder(Node2<A> root, Logic<A> logic) {
		logic.before();
		if (root != null) {
			Stack<Node2<A>> stack = new Stack<Node2<A>>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Node2<A> curr = stack.pop();
				logic.visit(curr);
				if (curr.getRight() != null) {
					stack.push(curr.getRight());
				}
				if (curr.getLeft() != null) {
					stack.push(curr.getLeft());
				}
			}
		}
		logic.after();
	}
	
	public static<A extends Comparable<A>> void inOrder(Node2<A> curr, Logic<A> logic) {
		logic.before();
		if (curr != null) {
			Stack<Node2<A>> parentStack = new Stack<Node2<A>>();
			while (!parentStack.empty() || curr != null) {
				if (curr != null) {
					parentStack.push(curr);
					curr = curr.getLeft();
				}
				else {
					curr = parentStack.pop();
					logic.visit(curr);
					curr = curr.getRight();
				}
			}
		}
		logic.after();
	}
	
	public static<A extends Comparable<A>> void postOrder(Node2<A> curr, Logic<A> logic) {
		logic.before();
		if (curr != null) {
			Stack<Node2<A>> parentStack = new Stack<Node2<A>>();
			Node2<A> prev = null;
			while (!parentStack.isEmpty() || curr != null) {
				if (curr != null) {
					parentStack.push(curr);
					curr = curr.getLeft();
				}
				else {
					Node2<A> peek = parentStack.peek();
					if (peek.getRight() != null && prev != peek.getRight())
						curr = peek.getRight();
					else {
						logic.visit(peek);
						prev = parentStack.pop();
					}
				}
			}
		}
		logic.after();
	}

	public static<A extends Comparable<A>> Node2<A> TreeFromPreOrderInOrder(A[] in, int in_lo, int in_hi, A[] pre, int pre_lo, int pre_hi) {
		if (in_lo > in_hi)
			return null;
		
		Node2<A> n = new Node2<A>(pre[pre_lo]);
		
		int idx = Arrays.indexOf(in, in_lo, in_hi, pre[pre_lo]);
		
		n.setLeft( TreeFromPreOrderInOrder(in, in_lo, idx-1, pre, pre_lo+1, pre_lo+(idx-in_lo)));
		n.setRight(TreeFromPreOrderInOrder(in, idx+1, in_hi, pre, pre_lo+(idx-in_lo)+1, pre_hi));
		
		return n;
	}
}
