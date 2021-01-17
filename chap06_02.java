import java.util.Scanner;

class chap06_02 {
	// a[idx1]�� a[idx2]�� ���� �ٲߴϴ�. 
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; 
		a[idx1] = a[idx2]; 
		a[idx2] = t;
	}

	// ���� ����
	static void bubbleSort(int[] a, int n) {
		int change = 0;
		int compare = 0;		
		int num = 1;
		
		for (int i = 0; i < n - 1; i++) {
			System.out.println ("�н�" + num + ":");
			num++;
			
			for (int j = n - 1; j > i; j--) {
				
				for (int m = 0; m < n - 1; m++)
					System.out.printf("%2d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
					System.out.printf("%2d\n", a[n - 1]);
					compare++;
					if (a[j - 1] > a[j])
						change++;
						swap(a, j - 1, j);
						
			}
			for (int m = 0; m < n; m++)
				System.out.printf("%2d  ", a[m]);
				System.out.println();
		}			
		System.out.println("�񱳸� " + compare + "ȸ �߽��ϴ�.");
		System.out.println("��ȯ�� " + change + "ȸ �߽��ϴ�.");
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("���� ����(���� 1)");
		System.out.print("��ڼ���");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]��");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);				// �迭 x�� ���� �����մϴ�.

	}
}