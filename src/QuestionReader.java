import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * I modified this from your ArticalReader file
 * @author William Nash
 * It create the file link, then goes and make the question object, then finds the key, value pair that i say
 * Then for the choices add it to an ArrayList
 * then adds the question, choices and answer to the Question object then adds that to the questions ArrayList
 * @return returns the ArrayList full of question objects
 */
public class QuestionReader {
	@SuppressWarnings("rawtypes")
	public ArrayList<Question> readFromJSON(String fname) {
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("questions");
			Iterator itr = arr.iterator();

			JSONObject questionObject;
			String question, a,b,c,d, anwser;

			while (itr.hasNext()) {
				questionObject = (JSONObject)itr.next();
				question = questionObject.get("question").toString();
				a = questionObject.get("a").toString();
				b = questionObject.get("b").toString();
				c = questionObject.get("c").toString();
				d = questionObject.get("d").toString();
				ArrayList<String> choices = new ArrayList<String>();
				choices.add(a);
				choices.add(b);
				choices.add(c);
				choices.add(d);
				anwser = questionObject.get("answer").toString();
				questions.add(new Question(question,choices,anwser));
			}
			reader.close();
			return questions;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Fialed to read");
			return null;
		}
	}
}