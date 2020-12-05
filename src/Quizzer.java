import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quizzer
{
	/**
	 * This does the quzing, it runs baised on the amountOfQuestions varaible, uses the quiz ArrayList to get the question object then print the question and the choices
	 * @param amountOfQuestions User inputed from Theory_Quiz/ line 50
	 * @param quiz The ArrayList of question objects created from the QuestionReader
	 * @param sc The Scanner used to check the users input
	 * @return An integer basied on the amount of questions the user got correct
	 */
	public int quiz(int amountOfQuestions, ArrayList<Question> quiz, Scanner sc)
	{
		Random ran = new Random(4);
		Question question;
		String answer;
		int i = 0;
		int correct = 0;
		do
		{
			question = quiz.get(ran.nextInt(18));
			System.out.println(question.getQuestion());
			System.out.println("A. " + question.getchoices().get(0));
			System.out.println("B. " + question.getchoices().get(1));
			System.out.println("C. " + question.getchoices().get(2));
			System.out.println("D. " + question.getchoices().get(3));
			System.out.print("Type the letter of your choice: ");
			answer = sc.next();
			if(answer.equalsIgnoreCase(question.getAnswer()))
			{
				System.out.println("Correct");
				correct++;
			}
			else if(!answer.equalsIgnoreCase(question.getAnswer()))
			{
				System.out.println("Wrong");
			}
			i++;
		}while(i < amountOfQuestions);
		return correct;
	}
	/*
	 * randomly chooses and presents questions to the student
	 * keeps track of and returns how many questions the student answered correctly
	 */
}
