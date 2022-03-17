import java.util.Comparator;

public class Student implements Comparable<Student>{
	protected int id;
	String name;
	protected String dept;
	protected int grade;

	public Student(int id, String name, String dept, int grade) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}

	public int getId() { return id; }
	public String getName() { return name; }
	public String getDept() { return dept; }
	public int getGrade() { return grade; }

	// 학번으로 비교하는 compareTo()
	@Override
	public int compareTo(Student s) {
		return this.id - s.id;
	}


	//이름으로 비교하는 compare()
	public static Comparator<Student> CompName = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
	};
	

	//학과이름으로 비교하는 compare()
	public static Comparator<Student> CompDept = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.dept.compareTo(s2.dept);
		}
	};
	
	//학년으로 비교하는 compare()
	public static Comparator<Student> CompGrade = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.grade - s2.grade;
		}
	};
}