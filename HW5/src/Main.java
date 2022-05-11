// 자료구조 과제 #5 (60185077 김규리)

public class Main {
	
	public static void main(String[] args) {
		Node n1= new Node("A",null,null);
		Node n2= new Node("B",null,null);
		Node n3= new Node("C",null,null);
		Node n4= new Node("D",null,null);
		Node n5= new Node("E",null,null);
		Node n6= new Node("F",null,null);
		Node n7= new Node("G",null,null);
		Node n8= new Node("H",null,null);
		Node n9= new Node("I",null,null);
		
		n1.setLeft(n2); n1.setRight(n3);
		n2.setLeft(n4); n2.setRight(n5);
		n3.setLeft(n6); n3.setRight(n7);
		n6.setLeft(n8); n7.setRight(n9);
		
		BinaryTree t = new BinaryTree();
		t.setRoot(n1);
		
//		System.out.print("트리 노드 수 ="+t.size(t.getRoot())+"\n트리 높이 ="+t.height(t.getRoot()));
		System.out.printf("원본이진트리 전위순회: ");
		t.preorder(t.getRoot());
		System.out.println();
		System.out.printf("원본이진트리 레벨순회: ");
		t.levelorder(t.getRoot());
		System.out.println();
		
		BinaryTree t2 = new BinaryTree();
		t2.setRoot(BinaryTree.Copy(n1));
		
		System.out.printf("복사이진트리 전위순회: ");
		t2.preorder(t2.getRoot());
		System.out.println();
		System.out.printf("복사이진트리 레벨순회: ");
		t2.levelorder(t2.getRoot());
		System.out.println();
		
		System.out.printf("동일성 검사 : "+BinaryTree.isEqual(t.getRoot(),t2.getRoot()));
		
	}

}
