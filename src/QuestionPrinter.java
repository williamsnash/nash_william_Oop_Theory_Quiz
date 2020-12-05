import java.util.ArrayList;

public class QuestionPrinter
{
	/**
	 * Prints the questions and their correct answers to the screen
	 * @param quiz ArrayList that holds all the question objects
	 */
	public void printQuestions(ArrayList<Question> quiz)
	{
		for (Question question : quiz)
		{
			System.out.println(question.getAnswer() + "\t" + question.getQuestion());
		}
	}
}
