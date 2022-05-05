import java.util.NoSuchElementException;

public class ListQueue <E> {
	private Node<E> front,rear;
	private int size;
	
	public ListQueue() { // 큐 생성자
		front = rear = null;
		size = 0;
	}
	
	// 큐의 항목 수를 리턴 
	public int size() {return size;}
	
	// 큐가 empty이면 true 리턴 
	public boolean isEmpty() {return size == 0; }
	
	
	// 큐 add 연산 
	public void add(E newItem) {
		// 새 노드 생성
	Node newNode = new Node(newItem, null);

	// 큐가 empty이면 front도 newNode를 가리키게 함
	// 그렇지 않으면 rear의 next를 newNode를 가리키게 함
	if (isEmpty()) front = newNode;
	else rear.setNext(newNode);

	rear = newNode; // 마지막 rear가 newNode를 가리킴
	size++; // 큐 항목 수 1증가
	}
	
	// 큐 remove 연산
	public E remove() {
		// underflow시 프로그램 정지
		if (isEmpty())
			throw new NoSuchElementException();
		E frontItem = front.getItem();
		front = front.getNext();
		
		size--; // 큐 항목 수 1 감소
		if (isEmpty()) rear = null;
		
		return frontItem;
	}
	
	// print 연산
	public void print() {
		Node p =front;
		if (isEmpty())
			System.out.print("큐가 empty임");
		for(int i =0; i<size;i++) {
			System.out.print(p.getItem()+"   ");
			p=p.getNext();
		}
		System.out.println();
	}
}