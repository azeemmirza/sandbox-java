package lesson13.exercise_1;

import java.io.*;

public class FileIO {
    //First create and write to a file named "MyText.txt".
    //Then read in that file and print contents to the console.

    public static void main(String[] args) {
        
        try {
					//Step 1: Create a file MyText.txt and 
        //use a FileWriter, together with a PrintWriter to
        //write the text "my text" to your file
            FileWriter fileWriter = new FileWriter("./file.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("my text");
            printWriter.close();
            fileWriter.close();

            FileReader fileReader = new FileReader("MyText.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

						System.out.println(line);

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
        //Step 2: After closing your writers, use a BufferedReader to
        //read the file you just created. Remember that your file will
        //be placed (by default) at the top level of your Java project
        //(To see it in the project, you must refresh the project.)

    }

}
