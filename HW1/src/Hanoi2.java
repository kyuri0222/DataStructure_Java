// 교수님 답안 

public class Hanoi2 {
	public static void hanoi (int n, char from, char by, char to) {
		if (n == 1) 
			System.out.printf("원반 1을 %c에서 %c로 이동\n", from ,to);
		else{
			hanoi(n-1, from, to, by);
			System.out.printf("원반 %d을 %c에서 %c로 이동\n",n, from, to);
			hanoi(n-1, by, from, to);
			}
	}
	
	public static void main(String[] args) {
		System.out.printf("원반이 3개인 경우\n(원반 이름:크기가 작은-큰 순서 1-2-3)\n\n");
		hanoi(3,'A','B','C');
		System.out.printf("\n");
		System.out.printf("원반이 4개인 경우\n(원반 이름:크기가 작은-큰 순서 1-2-3)\n\n");
		hanoi(4,'A','B','C');
	}
}