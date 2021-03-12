package labtest2solutions;

public class StudentQ14 {
	public static void main(String[] args) {
		Result studentResult = new Result(99,90,90,"john doe",1);
		studentResult.calculateTotalMark();
		System.out.println("Student total marks are : "+studentResult.getTotalMark());
	}
}

class Student{
	protected String name;
	protected int rollno;
	
	Student(String name,int rollno){
		this.name = name;
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
}

class Exam extends Student{
	protected int telMarks;
	protected int engMarks;
	protected int hinMarks;
	
	public Exam(int telMarks,int engMarks,int hinMarks,String name,int rollno){
		super(name,rollno);
		this.telMarks = telMarks;
		this.engMarks = engMarks;
		this.hinMarks = hinMarks;
	}
	
	public int getTelMarks() {
		return telMarks;
	}
	public void setTelMarks(int telMarks) {
		this.telMarks = telMarks;
	}
	public int getEngMarks() {
		return engMarks;
	}
	public void setEngMarks(int engMarks) {
		this.engMarks = engMarks;
	}
	public int getHinMarks() {
		return hinMarks;
	}
	public void setHinMarks(int hinMarks) {
		this.hinMarks = hinMarks;
	}
	
}

class Result extends Exam{
	private int totalMark;
	
	public Result(int telMarks,int engMarks,int hinMarks,String name,int rollno) {
		super(telMarks, engMarks, hinMarks, name, rollno);
	}
	
	public int getTotalMark() {
		return totalMark;
	}

	public void calculateTotalMark() {
		this.totalMark = this.telMarks + this.engMarks + this.hinMarks;
	}
}


















