import java.util.ArrayList;

public class Question
{
	private String question;
	private ArrayList<String> choices;
	private String answer;
	
	public Question()
	{
		question = "none";
		choices.add("none");
		answer = "none";
	}
	public Question(String question, ArrayList<String> choices, String answer)
	{
		setQuestion(question);
		setChoices(choices);
		setAnswer(answer);
	}
	
	
	public void setQuestion(String question)
	{
		this.question = question;
	}
	public String getQuestion()
	{
		return question;
	}
	
	public void setChoices(ArrayList<String> choices)
	{
		this.choices = choices;
	}
	public ArrayList<String> getchoices()
	{
		return choices;
	}
	
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	public String getAnswer()
	{
		return answer;
	}

	
	@Override
	public String toString() {
		return String.format("%s\n%s\n%s",question,choices,answer);
	}
}
