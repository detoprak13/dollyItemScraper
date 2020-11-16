import Entity.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqlInsertEngWords {

	public static void main(String[] args) {
		File file =
				new File("words_alpha.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int count = 0;
		ArrayList<Word> wordList = new ArrayList<>();
		while (true) {
			assert sc != null;
			if (!sc.hasNextLine()) break;
			String line = sc.nextLine();
			Word word = new Word();
			word.setName(line);
			wordList.add(word);
			if (count >= 100) {
				DBConnect.insertWord(wordList);
				wordList = new ArrayList<>();
			}
			count++;
		}
	}


}
