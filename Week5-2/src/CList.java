import java.util.NoSuchElementException;

public class CList <E> {
	private Node last; // 마지막 노드 
	private int size;  // 리스트 항목수 
	
	//원형 리스트 생성자 
	public CList() {
		last = null;
		size = 0;
	}
	
	public int size() { return size;}
	public boolean isEmpty() { return size==0; }
	
	// last 다음에 새노드 삽입 
	public void insert(E newItem) {
		Node newNode = new Node(newItem, null);
		
		if (last == null) {
			newNode.setNext(newNode);
			last = newNode;
		}
		else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}
		size++;
	}
	
	// last 다음 삭제 
	public void delete() {
		if(isEmpty()) throw new NoSuchElementException();
		
		Node x = last.getNext();
		if(x==last) last = null;
		else {
			last.setNext(x.getNext());
		}
		size--;
	}
}
