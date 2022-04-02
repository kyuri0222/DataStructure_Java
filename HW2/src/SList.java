//자료구조 과제 #2 (60185077 김규리)

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
			if(target == p.getItem()) return k;
			p=p.getNext();
		}
		
		return -1; // 탐색을 실패한 경우 -1 리턴 
	}
	
	// 연결리스트 맨 앞에 새 노드 삽입 
	public void insertFront(E newItem) {
		head = new Node(newItem,head);
		size++;
	}
	
	// 노드 p 바로 다음에 새 노드 삽입 
	public void insertAfter(E newItem, Node p) {
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}
	
	// 리스트의 첫 노드 삭제 
	public void deleteFront() {
		if(isEmpty()) throw new NoSuchElementException();
		
		head = head.getNext();
		size--;
	}
	
	// p가 가리키는 노드의 다음 노드를 삭제 
	public void deleteAfter(Node p) {
		if(p==null) throw new NoSuchElementException();
		
		Node t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	
	// 17번 
	public SList mergeLists(Node p1, Node p2) {
		
		Node tail = this.head;
		
		while(p1!=null && p2!=null) {
			
			if(p1.getItem().compareTo(p2.getItem())<0) {
				tail.setNext(p1);
				p1=p1.getNext();
		}
			else {
				tail.setNext(p2);
				p2=p2.getNext();
			}
			tail=tail.getNext();
		}
		
		if(p1==null) {
			tail.setNext(p2);
		}
		else if(p2==null) {
			tail.setNext(p1);
		}
		
		this.deleteFront();
		return this;
	}
	
	// 20번 
	public void splitList(Node p, int k, SList l1, SList l2) {
		while(p != null) {
			if(p.getItem().compareTo(k)<=0) {
				l1.insertFront(p.getItem());
			}
			else {
				l2.insertFront(p.getItem());
			}
			p=p.getNext();
		}
	}
	
	// 출력 
	public void print() {
		for (Node p =head; p!=null; p=p.getNext()){
			System.out.print(p.getItem()+"    ");
		}
		System.out.println();
	}
}