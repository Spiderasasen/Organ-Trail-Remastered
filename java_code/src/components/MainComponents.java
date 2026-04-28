package components;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static components.Colors.RED;
import static components.Colors.RESET;

public class MainComponents {
    //file reader
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
            System.out.println(RED + "Error in reading " + fileName + RESET);
        }

        return lines;
    }

    //pressing enter to contuine
    public void pressEnter(Scanner input){
        System.out.println("Press enter to continue...");
        input.nextLine();
    }
}
