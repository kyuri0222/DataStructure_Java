//자료구조(60185077 김규리)

import java.util.NoSuchElementException;

public class DList <E> {
	protected DNode head,tail;
	private int size;
	
	//이중 연결 리스트 생성자
	public DList() { 
		head = new DNode(null, null, null);
		tail = new DNode(null, head, null);
		head.setNext(tail);
		size = 0;
	}
	
	public int size() { return size;}
	public boolean isEmpty() { return size==0; }
	
	
	// p가 가리키는 노드 앞에 삽입
	public void insertBefore(DNode p, E newItem) {
		DNode t = p.getPrevious();
		DNode newNode = new DNode(newItem,t,p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size++;
	}
	
	// p가 가리키는 노드 뒤에 삽입
	public void insertAfter(DNode p, E newItem) {
		DNode t = p.getNext();
		DNode newNode = new DNode(newItem, p, t);
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;

	}
	
	// x가 가리키는 노드 삭제 
	public void delete(DNode x) {
		if (x==null) throw new NoSuchElementException();
		
		DNode f = x.getPrevious();
		DNode r = x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}

	// 연결리스트 노드들의 item들을 차례로 출력 
	public void print() {
	if (size>0)
		for (DNode p = head.getNext(); p != tail; p=p.getNext())
			System.out.print(p.getItem()+"\t");
	else  
		System.out.println("리스트 비어있음");
	System.out.println();
	}
}