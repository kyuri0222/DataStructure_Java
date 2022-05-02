public class test1 {
	public static void f(int N) {
		if(N>0) {
			f(N/2);
			System.out.print(N%2);
		}
	}
	public static void main(String[] args) { f(7);}
}



/*
 public class test1 {
	public static int f(String s, int last) {
		if (last<0) {
			return 0;
		}
		if (s.charAt(last) =='0') {
			return 2*f(s,last-1);
		}
		return 1+2*f(s,last-1);
		}

	public static void main(String[] args) {
		f("110100111",4);
	}
}*/