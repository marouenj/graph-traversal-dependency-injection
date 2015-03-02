package core;

public class Node2<A extends Comparable<A>> {

	private A key;
	private Node2<A> left;
	private Node2<A> right;
	
	public Node2(A key) {
		this(key, null, null);
	}
	
	public Node2(A key, Node2<A> left, Node2<A> right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}
	
	/*
	 * getters and setters
	 */

	public A getKey() {
		return key;
	}
	
	public void setKey(A key) {
		this.key = key;
	}
	
	public Node2<A> getLeft() {
		return left;
	}

	public Node2<A> setLeft(Node2<A> left) {
		this.left = left;
		return this.left;
	}

	public Node2<A> getRight() {
		return right;
	}

	public Node2<A> setRight(Node2<A> right) {
		this.right = right;
		return this.right;
	}
	
}
