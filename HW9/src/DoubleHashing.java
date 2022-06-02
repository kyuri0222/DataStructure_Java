//자료구조 과제 #9(60185077 김규리)

class DoubleHashing<K, V> {
	private int crushNum = 0;

	private int N = 0, M = 11; // 테이블 크기
	private K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] dt = (V[]) new Object[M]; // key관련 데이터 저장
	// 해시코드

	private int hash(K Key) {
		return (Key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
	}

	// 삽입 연산
	public void put(K key, V data) {
		int initialpos = hash(key); // 초기 위치
		int i = initialpos;
		int j = 1;
		int d = (7 - (int) key % 7); // 두 번째 해시 함수, d(key) = 7 - key%7;
		do {
			if (a[i] == null) { // 삽입 위치 발견
				a[i] = key; // key를 해시테이블에 저장
				dt[i] = data;
				N++; // key관련 데이터 저장, 항목 수 1증가
				return;
			}
			if (a[i].equals(key)) { // 이미 key 존재
				dt[i] = data; // 데이터만 갱신
				return;
			}
			i = (initialpos + j * d) % M; // i = 다음 위치
			j++;

			++crushNum;
			System.out.println("입력 값 : " + key + " 충돌 횟수 : " + crushNum);

		} while (N < M);
	}

	// 탐색 연산
	public V get(K key) {
		int initialpos = hash(key); // 초기 위치
		int i = initialpos;
		int j = 1;
		int d = (7 - (int) key % 7);
		while (a[i] != null) {
			if (a[i].equals(key))
				return dt[i]; // 탐색 성공
			i = (initialpos + j * d) % M; // i = 다음 위치
			j++;
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
		DoubleHashing dh = new DoubleHashing();

		dh.put(71, "grape");
		dh.put(23, "apple");
		dh.put(73, "banana");
		dh.put(49, "cherry");
		dh.put(54, "mango");
		dh.put(89, "lime");
		dh.put(39, "orange");

		System.out.println();
		System.out.println("해시 테이블: ");
		dh.print();
		System.out.println();
	}
}