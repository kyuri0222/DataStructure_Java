// 자료구조 과제 #4 (60185077 김규리)

import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top; // 스택 top 항목을 가진 Node를 가리
	private int size; // 스택의 항목 수

	public ListStack() { // 스택 생성자
		top = null;
		size = 0;
	}

	// 스택 top 항목만을 리턴
	public E peek() {
		// underflow 시 프로그램 정지
		if (isEmpty())
			throw new EmptyStackException();

		return top.getItem();
	}

	// 스택의 항목의 수를 리턴
	public int size() {
		return size;
	}

	// 스택이 empty이면 true 리턴
	public boolean isEmpty() {
		return size == 0;
	}

	// 스택 push 연산
	public void push(E newItem) {
		// top 노드 앞에 새 노드 삽입
		Node newNode = new Node(newItem, top);

		top = newNode; // top이 새 노드 가리킴
		size++; // 스택 항목 수 1 증가
	}

	// 스택 pop 연산
	public E pop() {
		// underflow 시 프로그램 정지
		if (isEmpty())
			throw new EmptyStackException();

		E topItem = top.getItem();
		top = top.getNext(); // top이 top 바로 아래 항목을 가리킴
		size--; // 스택 항목 수를 1 감소

		return topItem;
	}

	// 스택의 항목들을 아래에서 위로 출력
	public void print() {
		if (isEmpty())
			System.out.print("스택이 비어있음.");
		else
			for (Node p = top; p != null; p = p.getNext())
				System.out.print(p.getItem() + "\t ");

		System.out.println();
	}

	// 중위표기법으로 된 식을 후위표기법으로 변환하기
	public void inToPost(String s, ListStack stack) {

		String[] op = s.split("");
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (op[i].equals("(")) {
				stack.push(op[i]);
			} else if (op[i].equals(")")) {
				while (true) {
					if (stack.isEmpty() == true) { break; }
					String tmp = (String) stack.pop();
					if (tmp.equals("(")) {
						break;
					} else {
						result = result + tmp;
					}
				}
			} else if (op[i].equals("+") || op[i].equals("-")) {
				while (true) {
					if (stack.isEmpty() == true) {
						break;
					}
					if (stack.peek().equals("(")) {
						break;
					} else if (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*")|| stack.peek().equals("/")) {
						result = result + stack.pop();
					}
				}
				stack.push(op[i]);
			} else if (op[i].equals("*") || op[i].equals("/")) {
				while (true) {
					if (stack.isEmpty() == true) {
						break;
					}
					if (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("(")) {
						break;
					} else {
						result = result + stack.pop();
					}
				}
				stack.push(op[i]);

			} else {
				result = result + op[i];
			}
		}
		while (stack.isEmpty() == false) {
			result = result + stack.pop();
		}
		System.out.println(result);
	}
}
