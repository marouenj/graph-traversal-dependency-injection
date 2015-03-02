package core;

public interface Logic<A extends Comparable<A>> {
	
	public void before();
	
	public void after();
	
	public void visit(Node2<A> curr);

}
