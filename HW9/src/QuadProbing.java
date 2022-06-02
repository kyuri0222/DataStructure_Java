//자료구조 과제 #9(60185077 김규리)

class QuadProbing<K, V> {
	private int crushNum = 0;

	private int N = 0, M = 11;
	private K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // key관련 데이터 저장
	// 해시코드

	private int hash(K Key) {
		return (Key.hashCode() & 0x7fffffff) % M;
	}

	// 삽입 연산
	public void  put(K key, V data) {
		int initialpos = hash(key); // 초기 위치
		int i = initialpos, j = 1;
		do {
			if (a[i] == null) { // 삽입 위치 발견
				a[i] = key; // key를 해시테이블에 저장
				d[i] = data;
				N++; // key관련 데이터 저장, 항목 수 1증가
				return;
			}
			if (a[i].equals(key)) { // 이미 key 존재
				d[i] = data; // data만 갱신
				return;
			}
			i = (initialpos + j * j++) % M; // i = 다음 위치

			++crushNum;
			System.out.println("입력 값 : " + key + " 충돌 횟수 : " + crushNum);

		} while (N < M);
	}

	// 탐색 연산
	public V get(K key) {
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) { // a[i]가 empty가 아니면
			if (a[i].equals(key))
				return d[i]; // 탐색 성공
			i = (initialpos + j * j++) % M; // i = 다음 위치
		}
		return null; // 탐색 실패
	}

	// 해시 테이블 보기
	public void print() {
		for (int i = 0; i < M; i++) {
			System.out.print(i + "	");
		}
		System.out.println();
		for (int i = 0; i < M; i++) {
			System.out.print(a[i] + "	");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QuadProbing qp = new QuadProbing();

		qp.put(71, "grape");
		qp.put(23, "apple");
		qp.put(73, "banana");
		qp.put(49, "cherry");
		qp.put(54, "mango");
		qp.put(89, "lime");
		qp.put(39, "orange");

		System.out.println();
		System.out.println("해시 테이블: ");
		qp.print();
		System.out.println();
	}
}