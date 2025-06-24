package lesson13.exercise_1_old;
import static lesson13.exercise_1_old.hidden.Setup.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static final String FILE = System.getProperty("user.dir") + "\\src\\lesson13\\exercise_1\\text.txt";
	public static void main(String[] args) {
		setup();
		try {
			printFileToConsole();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printFileToConsole() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(FILE));
		System.out.println(reader.readLine());
		reader.close();
	}

}
