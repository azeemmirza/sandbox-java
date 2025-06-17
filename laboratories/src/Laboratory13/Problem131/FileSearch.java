package Laboratory13.Problem131;

import java.io.*;

/**
//PSEUDO-CODE
boolean searchForFile(Object file, Object startDir) {
	Object[] fileSystemObjects =
						startDir.getContents();
	for(Object o: fileSystemObjects) {
		//base case
		if(isFile(o) && isSameFile(o,f)) {
			return true;
		}

		if(isDirectory(o)) {
			searchForFile(file, o);
		}
	}
	//file not found in startDir
	return false;
}
*/
public class FileSearch {
	static boolean found = false;
	//Store the text that is found in the
	//file that is found in this String variable
	static String discoveredText = null;
	public static boolean searchForFile(String filename, String startDirPath) {
		File startDir = new File(startDirPath);
		return searchRecursive(filename,startDir);
	}
	public static boolean searchRecursive(String fileName, File dir){
		File[] contents = dir.listFiles();
		if(contents == null) return false;
		for(File f : contents){
			if(f.isFile() && f.getName().equals(fileName)){
				printFileContent(f);
				return true;
			}else if(f.isDirectory()){
				if(searchRecursive(fileName,f))
					return true;
			}
		}
		return false; //not found
	}
	public static void printFileContent(File file){
        try {
			StringBuilder sb = new StringBuilder();
			String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
			System.out.println("Fond file :" + file.getAbsolutePath());
			while ((line = reader.readLine()) != null){
				System.out.println(line);
				sb.append(line+"\n");
			}
			discoveredText = sb.toString();
			System.out.println("End of file.");
        } catch (IOException e) {
			System.out.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}

