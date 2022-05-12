// 자료구조 과제 #6 (60185077 김규리)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	public Node root;

	public Node getRoot() {
		return root;
	}

	public BST(Key newId, Value newName) { // BST 생성자
		root = new Node(newId, newName);
	}

	// get, put, min, deleteMin, delete 메소드들 선언

	// 트리에서 k값을 갖는 노드를 탐색 & Value 리턴
	public Value get(Key k) {
		return get(root, k);
	}

	// n을 루트로 하는 (서브)트리에서 k값을 갖는 노드를 탐색 & Value 리턴
	public Value get(Node n, Key k) {
		if (n == null)
			return null; // k를 발견 못함

		int t = n.getKey().compareTo(k);

		if (t > 0)
			return get(n.getLeft(), k); // if (k < 노드 n의 id) 왼쪽 서브트리 탐색
		else if (t < 0)
			return get(n.getRight(), k); // if (k > 노드 n의 id) 오른쪽 서브트리 탐색
		else
			return (Value) n.getValue(); // k를 가진 노드 발견
	}

	// 트리에 노드(k,v)를 삽입
	public void put(Key k, Value v) {
		root = put(root, k, v);
	}

	// n을 루트로 하는 (서브)트리에 노드 (k,v)를 삽입
	public Node put(Node n, Key k, Value v) {
		if (n == null)
			return new Node(k, v);

		int t = n.getKey().compareTo(k);
		if (t > 0)
			n.setLeft(put(n.getLeft(), k, v)); // 왼쪽 서브트리에 삽입
		else if (t < 0)
			n.setRight(put(n.getRight(), k, v)); // 오른쪽 서브트리에 삽입
		else
			n.setValue(v); // 노드 n의 name을 v로 갱신
		return n;
	}

	// 트리에서 최소값을 갖는 노드의 key를 리턴
	public Key min() {
		if (root == null)
			return null;

		return (Key) min(root).getKey();
	}

	// n를 루트로 하는 (서브)트리에서 최소값을 갖는 노드를 리턴
	private Node min(Node n) {
		if (n.getLeft() == null)
			return n;

		return min(n.getLeft());
	}

	// 트리에서 최소값을 갖는 노드를 삭제
	public void deleteMin() {
		if (root == null)
			System.out.println("empty 트리");

		root = deleteMin(root);
	}

	// n을 루트로 하는 (서브)트리에서 최소값을 갖는 노드를 삭제
	public Node deleteMin(Node n) {
		if (n.getLeft() == null)
			return n.getRight(); // if (n의 왼쪽자식 == null) n의 오른쪽자식 리턴

		n.setLeft(deleteMin(n.getLeft())); // if (n의 왼쪽자식 != null), n의 왼쪽자식으로 재귀호출
		return n;
	}

	// 트리에서 최대값을 갖는 노드를 삭제
	public void deleteMax() {
		if (root == null)
			System.out.println("empty 트리");

		root = deleteMax(root);
	}

	// n을 루트로 하는 (서브)트리에서 최대값을 갖는 노드를 삭제
	public Node deleteMax(Node n) {
		if (n.getRight() == null)
			return n.getLeft(); // if (n의 오른쪽자식 == null) n의 왼쪽자식 리턴

		n.setRight(deleteMax(n.getRight())); // if (n의 오른쪽자식 != null), n의 오른쪽자식으로 재귀호출
		return n;
	}

	// 트리에서 k값을 갖는 노드를 삭제
	public void delete(Key k) {
		root = delete(root, k);
	}

	// n을 루트로 하는 (서브)트리에서 k값을 갖는 노드를 삭제
	private Node delete(Node n, Key k) {
		if (n == null)
			return null;

		int t = n.getKey().compareTo(k);
		if (t > 0) // if(k < 노드 n의 id) 왼쪽 자식으로 이동
			n.setLeft(delete(n.getLeft(), k));
		else if (t < 0) // if(k < 노드 n의 id) 오른쪽 자식으로 이동
			n.setRight(delete(n.getRight(), k));
		else {
			if (n.getRight() == null) {
				return n.getLeft();
			}
			if (n.getLeft() == null) {
				return n.getRight();
			}
			Node target = n;
			n = min(target.getRight());
			n.setRight(deleteMin(target.getRight()));
			n.setLeft(target.getLeft());
		}
		return n;
	}

	// 트리의 높이 리턴
	public int height() {
		return height(root) + 1;
	}

	// n을 루트로 하는 (서브)트리의 높이 리턴
	public int height(Node n) {
		if (n == null) // null이면 -1 리턴
			return -1;

		return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}

	// 트리 출력 : 3가지 순회 방식 사용
	public void print(Node root) {
		System.out.printf("\ninorder:\n");
		inorder(root);
		System.out.printf("\npreorder:\n");
		preorder(root);
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}

	// 전위순회
	public void preorder(Node n) {
		if (n != null) {
			System.out.print(n.getKey() + " "); // 노드 n 방문
			preorder(n.getLeft()); // n의 왼쪽 서브트리 순회
			preorder(n.getRight()); // n의 오른쪽 서브트리 순회
		}
	}

	// 중위순회
	public void inorder(Node n) {
		if (n != null) {
			inorder(n.getLeft()); // n의 왼쪽 서브트리 순회
			System.out.print(n.getKey() + " "); // 노드 n 방문
			inorder(n.getRight()); // n의 오른쪽 서브트리 순회
		}
	}

	// 레벨순회
	public void levelorder(Node root) {
		// 큐 자료구조 이용
		Queue<Node> q = new LinkedList<Node>();
		Node t;

		q.add(root); // 루트 노드를 큐에 삽입
		while (!q.isEmpty()) {
			t = q.remove();
			System.out.print(t.getKey() + " "); // 제거 노드 출력(방문)

			if (t.getLeft() != null)
				q.add(t.getLeft());
			if (t.getRight() != null)
				q.add(t.getRight());
		}
	}
}
