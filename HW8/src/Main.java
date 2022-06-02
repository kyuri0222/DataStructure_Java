// 자료구조 과제 #8 (60185077 김규리)

public class Main {
	public static void main(String[] args) {
		Entry[] a = new Entry[16];	//a[0]은 사용 안함

		BHeap h = new BHeap(a,0);	//힙 객체 생성
		System.out.println("INSERT 80");
		h.insert(80,80);
		h.print();
		
		System.out.println("INSERT 40");
		h.insert(40,40);
		h.print();
		
		System.out.println("INSERT 70");
		h.insert(70,70);
		h.print();
		
		System.out.println("INSERT 30");
		h.insert(30,30);
		h.print();
		
		System.out.println("INSERT 60");
		h.insert(60,60);
		h.print();
		
		System.out.println("INSERT 20");
		h.insert(20,20);
		h.print();
		
		System.out.println("INSERT 50");
		h.insert(50,50);
		h.print();
		
		System.out.println("INSERT 10");
		h.insert(10,10);
		h.print();
	}
}