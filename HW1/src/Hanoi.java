// 자료구조 과제 #1 (60185077 김규리)

public class Hanoi {
	public static void Main(char start, char m, char end, int num) {
		if (num == 0) return;
		Main(start,end,m,num-1);
		System.out.printf("원반 %d을 %c에서 %c로 이동\n",num,start,end);
		Main(m,start,end,num-1);
	}
	
	public static void main(String[] args) {
		System.out.printf("원반이 3개인 경우\n(원반 이름:크기가 작은-큰 순서 1-2-3)\n\n");
		Main('A','B','C',3);
		System.out.printf("\n");
		System.out.printf("원반이 4개인 경우\n(원반 이름:크기가 작은-큰 순서 1-2-3)\n\n");
		Main('A','B','C',4);
	}
}