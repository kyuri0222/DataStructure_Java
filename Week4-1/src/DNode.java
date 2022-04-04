//자료구조(60185077 김규리)

public class DNode <E>{
	private E item;
	private DNode previous;
	private DNode next;
	
	// 노드 생성자 
	public DNode(E newItem, DNode p, DNode q) {
		item = newItem;
		previous = p;
		next = q;
	}

	// get 메소드와 set 메소드 
	public E getItem() { return item;}
	public DNode<E> getPrevious() { return previous;}
	public DNode<E> getNext() { return next;}
	public void setItem(E newItem) { item = newItem;}
	public void setPrevious(DNode p) {previous = p;}
	public void setNext(DNode q) { next = q;}
}