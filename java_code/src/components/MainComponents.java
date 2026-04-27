package components;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainComponents {

    public ArrayList<String> fileReader(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        //tries reading the file
        try{
            //reads all the files then adds it to the lines ArrayList
            List<String> fileLines = Files.readAllLines(Paths.get(fileName));
            lines.addAll(fileLines);
        }
        //if there is a problem reading the file, it will tell us that is had an error reading the file
        catch(Exception e){
            System.out.println("Error in reading " + fileName);
        }

        return lines;
    }
}
