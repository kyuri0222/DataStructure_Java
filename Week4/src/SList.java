//자료구조(60185077 김규리)

import java.util.*;

public class SList <E extends Comparable<E>> {
	
	protected Node head; // 연결 리스트의 첫 노드
	private int size;
	
	public SList() { //연결 리스트 생성자 
		head = null;
		size = 0;
	}
	
	public int size() { return size;}
	public boolean isEmpty() { return size==0; }
	
	public int search(E target) { // target을 탐색 
		Node p = head;
		
		for(int k=0; k<size; k++) {
			if(target == p.getItem()) return k; // 찾으면 
			p=p.getNext();
		}
		return -1; // 못찾으면 -1 리턴 
	}
	
	// 연결리스트 맨 앞에 새 노드 삽입 
	public void insertFront(E newItem) {
		head = new Node(newItem,head);
		size++;
	}
	
	// p 다음에 새노드 삽입 
	public void insertAfter(E newItem, Node p) { // 앞에있는노드 p
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}
	
	// 첫 노드 삭제 
	public void deleteFront() {
		if(isEmpty()) throw new NoSuchElementException();
		
		head = head.getNext();
		size--;
	}
	
	// p 다음 노드를 삭제 
	public void deleteAfter(Node p) {
		if(p==null) throw new NoSuchElementException();
		
		Node t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	
	// 출력 
	public void print() {
		for (Node p =head; p!=null; p=p.getNext()){
			System.out.print(p.getItem()+"    ");
		}
		System.out.println();
	}
}