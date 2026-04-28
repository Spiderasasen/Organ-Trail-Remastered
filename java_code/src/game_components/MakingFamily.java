package game_components;
import components.MainComponents;
import components.RandomSystem;

import java.util.Scanner;
import java.util.ArrayList;

public class MakingFamily {
    //importing other components
    MainComponents  mainComponents =  new MainComponents();
    RandomSystem randomSystem =  new RandomSystem();

    //opening the files and placing them into a list already
    private ArrayList<String> male_names = mainComponents.fileReader("data/male_names.txt");
    private ArrayList<String> female_names = mainComponents.fileReader("data/female_names.txt");

    //private vars
    private ArrayList<String> family_names = new ArrayList<>();

    //main making the system
    public void makeFamily(Scanner scanner) {
        //asking the user if they want to set there own family names or not
        System.out.println("Would you like to name your own family? (y/n)");
        String choice = scanner.next();

        //the user chose no
        if (choice.equalsIgnoreCase("n")) {

            //looping thougrh 5 (5 family members (2 males and 3 females))
            for(int i = 0; i < 5; i++){
                if (i <= 1){
                    setFamily_names(randomSystem.randomArrayListIndex(male_names));
                }
                else{
                    setFamily_names(randomSystem.randomArrayListIndex(female_names));
                }
            }
            System.out.println("This is your family: " + family_names);
        }
    }


    //setter
    public void setFamily_names(String name) {
        if(name.isEmpty()){
            return;
        }
        family_names.add(name);
    }

    //getter
    public ArrayList<String> getFamily_names() {
        return family_names;
    }
}
