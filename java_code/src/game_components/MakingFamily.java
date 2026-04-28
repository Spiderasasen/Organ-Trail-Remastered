package game_components;
import components.MainComponents;

import java.util.Scanner;
import java.util.ArrayList;

public class MakingFamily {
    MainComponents  mainComponents =  new MainComponents();

    //opening the files and placing them into a list already
    private ArrayList<String> male_names = mainComponents.fileReader("male_names.txt");
    private ArrayList<String> female_names = mainComponents.fileReader("male_names.txt");

    //private vars
    private ArrayList<String> family_names = new ArrayList<>();

    //main making the system
    public void makeFamily() {
        System.out.println("Making Family");
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
