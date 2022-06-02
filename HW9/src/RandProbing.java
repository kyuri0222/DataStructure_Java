//자료구조 과제 #9(60185077 김규리)

import java.util.Random;

public class RandProbing<K, V> {
	private int crushNum = 0;
	private int N = 0, M = 11;
	private K[] a = (K[]) new Object[M];
	private V[] d = (V[]) new Object[M];

	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public void put(K key, V data) {
		int initialpos = hash(key);
		int i = initialpos;
		Random rand = new Random();
		rand.setSeed(10);
		do {
			if (a[i] == null) {
				a[i] = key;
				d[i] = data;
				N++;
				return;
			}
			if (a[i].equals(key)) {
				d[i] = data;
				return;
			}
			i = (initialpos + rand.nextInt(1000)) % M;

			++crushNum;
			System.out.println("입력 값 : " + key + " 충돌 횟수 : " + crushNum);

		} while (N < M);
	}

	public V get(K key) {
		Random rand = new Random();
		rand.setSeed(10);
		int initialpos = hash(key);
		int i = initialpos;

		while (a[i] != null) {
			if (a[i].equals(key))
				return d[i];
			i = (initialpos + rand.nextInt(1000)) % M;
		}
		return null;
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
		RandProbing rp = new RandProbing();

		rp.put(71, "grape");
		rp.put(23, "apple");
		rp.put(73, "banana");
		rp.put(49, "cherry");
		rp.put(54, "mango");
		rp.put(89, "lime");
		rp.put(39, "orange");

		System.out.println();
		System.out.println("해시 테이블: ");
		rp.print();
	}
}