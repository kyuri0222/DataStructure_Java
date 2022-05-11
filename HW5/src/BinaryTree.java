// 자료구조 과제 #5 (60185077 김규리)
import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;
	
	// 트리 생성자
	public BinaryTree() {root= null;}
	
	public Node getRoot() {return root;}
	public void setRoot(Node newRoot) {root = newRoot;}
	
	public boolean isEmpty() {return root == null;}
	
	// preorder(), inorder(), postorder(), levelorder(),
	// size(), height(), isEqual() 메소드 선언 

	// 전위순회
	public void preorder(Node n) {
		if (n!=null) {
			System.out.print(n.getKey()+""); // 노드 n 방문 
			preorder(n.getLeft()); // n의 왼쪽 서브트리 순회
			preorder(n.getRight());  //n의 오른쪽 서브트리 순회 
		}
	}
		
	// 중위순회
	public void inorder(Node n) {
		if (n!=null) {
			inorder(n.getLeft()); // n의 왼쪽 서브트리 순회
			System.out.print(n.getKey()+""); // 노드 n 방문 
			inorder(n.getRight());  //n의 오른쪽 서브트리 순회 
		}
	}
		
		
	// 후위순회 
	public void postorder(Node n) {
		if (n!=null) {
			postorder(n.getLeft()); // n의 왼쪽 서브트리 순회
			postorder(n.getRight());  //n의 오른쪽 서브트리 순회
			System.out.print(n.getKey()+""); // 노드 n 방문 
		}
	}
		
	// 레벨순회 
	public void levelorder(Node root) {
		// 큐 자료구조 이용
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		
		q.add(root); //루트 노드를 큐에 삽입 
		while (!q.isEmpty()) {
			t=q.remove();
			System.out.print(t.getKey()+""); // 제거 노드 출력(방문)
			
		if (t.getLeft() != null)
			q.add(t.getLeft());	
		if (t.getRight() != null)
			q.add(t.getRight());
		}
	}
	
	// 이진트리 복사
	public static Node Copy(Node n) {
		if(n==null)
			return null;
		
        Node copiedTree = new Node(n.getKey(),null,null);
        copiedTree.setLeft(Copy(n.getLeft()));
        copiedTree.setRight(Copy(n.getRight()));
        
        return copiedTree;
		
	}
	
//	< 교수님답안 > 
	
//	public Node Copy2(Node n) {
//		Node left,right;
//		
//		if (n==null) return null;
//		else {
//			left = copy(n.getLeft());
//			right = copy(n.getRight());
//			return new Node(n.getKey()left,right);
//		}
//	}
	
	//n를 루트로 하는 (서브)트리의 노드 수
	public int size(Node n) {
		if(n==null)
			return 0;
		else
			return (1+size(n.getLeft())+ size(n.getRight()));
	}
		
		
	//n를 루트로 하는 (서브)트리의 높이
	public int height(Node n) {
		if(n==null)
			return 0;
		else 
			return (1+Math.max(height(n.getLeft()),
							   height(n.getRight())) );
	}
	
	// 두 트리의 동일성 검사 
	public static boolean isEqual(Node n, Node m) {
		// 둘다 null이면 true, 아니면 false
		if(n==null || m==null)
			return n==m;
		
		// 둘다 null이 아니면 item 비교
		if (n.getKey().compareTo(m.getKey())!=0)
			return false;
		
		// item이 같으면 왼쪽/오른쪽 자식으로 재귀 호출
		return (isEqual(n.getLeft(),m.getLeft())&&
				isEqual(n.getRight(),m.getRight()) );
	}
	

}
