// 자료구조 과제 #8 (60185077 김규리)

public class BHeap<Key extends Comparable<Key>, Value> {
	private Entry[] a; // a[0]은 사용 안함
	private int N; // 힙의 크기
	public BHeap(Entry[] harray, int initaialSize) { // 생성자
		a = harray;
		N = initaialSize;
	}

	public int size() { return N; } // 힙의 크기 리턴 
	
	private boolean greater(int i, int j) { // 키 비교
		return a[j].getKey().compareTo(a[i].getKey()) < 0; }
	
	private void swap(int i, int j) { // a[i]와 a[j]를 교환
		Entry temp = a[i]; a[i] = a[j]; a[j] = temp; }
	
	public void createHeap() { // 초기 힙 만들기
		for (int i = N/2; i > 0; i--) {
			downheap(i);
		}
	}
	
	private void downheap(int i) { 
		while (2*i <= N) { 
			int k = 2 * i; 
			if (k < N && greater(k, k+1)) k++; 
			if (!greater(i, k)) break; 
			swap(i, k); 
			i = k;
		}
	}
	
	public void insert(Key newKey, Value newValue) { 
		Entry<Key, Value> temp = new Entry<Key, Value>(newKey, newValue); 
		a[++N] = temp; 
		upheap(N);
	}
	
	private void upheap(int j) { 
		while (j > 1 && greater(j / 2, j)) { 
			swap(j / 2, j); 
			j = j / 2; 
		}
	}
	
	public Entry deleteMin() { 
		Entry min = a[1]; 
		swap(1, N--); 
		a[N + 1] = null;
		downheap(1); 
		return min;
	}

	public void print() {
		for (int i = 1; i < N + 1; i++) {
			System.out.printf("[" + a[i].getKey() + " " + a[i].getValue() + "]");
		}
		System.out.println();
		System.out.printf("힙 크기 = " + size());
		
		System.out.println();
		System.out.println();
	}

}
