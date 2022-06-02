//자료구조 과제 #9(60185077 김규리)

class LinearProbing<K, V> {
	private int crushNum = 0;
	private int M = 11; // 테이블 크기
	private K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // key관련 데이터 저장

	private int hash(K Key) { // 해시코드
		return (Key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
	}

	public void put(K key, V data) { // 삽입 연산
		int initialpos = hash(key); // 초기 위치
		int i = initialpos, j = 1;
		do {
			if (a[i] == null) { // 삽입 위치 발견
				a[i] = key; // key를 해시테이블에 저장
				d[i] = data; // key관련 데이터를 동일한 인덱스하에 저장
				return;
			}
			if (a[i].equals(key)) { // 이미 key 존재
				d[i] = data; // 데이터만 갱신
				return;
			}
			i = (initialpos + j++) % M; // i = 다음 위치

			++crushNum;
			System.out.println("입력 값 : " + key + " 충돌 횟수 : " + crushNum);

		} while (i != initialpos); // 현재 i가 초기위치와 같게되면 루프 종료
	}

	public V get(K key) {// 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) { // a[i]가 empty가 아니면
			if (a[i].equals(key))
				return d[i]; // 탐색 성공
			i = (initialpos + j++) % M; // i = 다음 위치
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
		LinearProbing lp = new LinearProbing();

		lp.put(71, "grape");
		lp.put(23, "apple");
		lp.put(73, "banana");
		lp.put(49, "cherry");
		lp.put(54, "mango");
		lp.put(89, "lime");
		lp.put(39, "orange");
		
		System.out.println();
		System.out.println("해시 테이블: ");
		lp.print();
		System.out.println();
	}

}