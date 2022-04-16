// 자료구조 과제 #4 (60185077 김규리)

public class Main {
	public static void main(String[] args) {
		
		ListStack<String> stack1 = new ListStack<String>();
		ListStack<String> stack2 = new ListStack<String>();
		ListStack<String> stack3 = new ListStack<String>();
		ListStack<String> stack4 = new ListStack<String>();

		String test1 = "A-B+C/D";
		String test2 = "A/B-C*D";
		String test3 = "A-B*C+D/E-F";
		String test4 = "(A-B)*C-(D/(E+F))";

		stack1.inToPost(test1, stack1);
		stack2.inToPost(test2, stack2);
		stack3.inToPost(test3, stack3);
		stack4.inToPost(test4, stack4);
		
	}
}