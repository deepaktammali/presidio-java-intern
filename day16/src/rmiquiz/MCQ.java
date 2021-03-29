package rmiquiz;

public class MCQ {
	private String question;
	private String answer;

	public MCQ(String question,String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
}
