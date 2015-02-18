package pregunta;

public class Pregunta {
	private String id;
	private String question;
	private String answerTrue;
	private String answer2;
	private String answer3;
	private String answer4;
	
	public Pregunta (String id, String question, String answerTrue, String answer2, String answer3, String answer4){
		this.id = id;
		this.question = question;
		this.answerTrue = answerTrue;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
	}
	
	public Pregunta (String id){
		this.id = id;
	}
	
	public String getAnswerTrue() {
		return answerTrue;
	}

	public void setAnswerTrue(String answer1) {
		this.answerTrue = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getId() {
		return id;
	}
	
	private void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pregunta [id: " + id + ", \nquestion:" + question + ", \nCorrecta: "
				+ answerTrue + ", \nFalsa:" + answer2 + ", \nFalsa:" + answer3
				+ ", \nFalsa:" + answer4 + "]";
	}
	
	
	
}

