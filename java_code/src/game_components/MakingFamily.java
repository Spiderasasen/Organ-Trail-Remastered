package game_components;
import components.MainComponents;
import components.RandomSystem;

import java.util.Scanner;
import java.util.ArrayList;

import static components.Colors.RED;
import static components.Colors.RESET;

public class MakingFamily {
    //importing other components
    MainComponents  mainComponents =  new MainComponents();
    RandomSystem randomSystem =  new RandomSystem();

    //opening the files and placing them into a list already
    private ArrayList<String> male_names = mainComponents.fileReader("data/male_names.txt");
    private ArrayList<String> female_names = mainComponents.fileReader("data/female_names.txt");

    //private vars
    private ArrayList<String> family_names = new ArrayList<>();
    private String[] names = {"What is your name?", "What is the name of your Son?", "What is the name of your wife?", "What is the name of your daughter?", "What is the name of your Grandma?"};
    private String player;
    private String son;
    private String wife;
    private String daughter;
    private String grandma;

    //main making the system
    public void makeFamily(Scanner scanner) {
        //asking the user if they want to set there own family names or not
        System.out.println("Would you like to name your own family? (y/n)");
        String choice = scanner.nextLine();
        boolean flag = false;

        //loop for the first section
        while (!flag) {
            //the user chose no
            if (choice.equalsIgnoreCase("n")) {
                flag = true;
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
            else if (choice.equalsIgnoreCase("y")) {
                //looping to see what the user wants to name each family memeber
                while(!flag){
                    //for looping through the array of name options
                    for (String name : names) {
                        System.out.println(name);
                        String inputName = scanner.nextLine();
                        setFamily_names(inputName);
                    }
                    //checks if the user really likes the names they inputed
                    boolean mini_flag = false;
                    while(!mini_flag){ //made it where the user can only type yes or no. nothing else
                        System.out.println(family_names + " \nAre these names ok? y/n");
                        choice = scanner.nextLine();
                        if (choice.equalsIgnoreCase("y")) {
                            mini_flag = true;
                            flag = true;
                        }
                        else if(choice.equalsIgnoreCase("n")){
                            mini_flag = true;
                        }
                        else{
                            System.out.println("Please enter Y/N");
                        }
                    }
                    family_names.clear();
                }

            }
            else {
                System.out.println("Please enter y/n");
            }
            setNames(family_names);
        }
    }


    //setter
    public void setFamily_names(String name) {
        if(name.isEmpty()){
            return;
        }
        family_names.add(name);
    }

    public void setNames(ArrayList<String> names) {
        if(names.size() != 5){
            System.out.println(RED + "Invalid Length" + RESET);
            return;
        }
        this.player = names.get(0);
        this.son = names.get(1);
        this.wife = names.get(2);
        this.daughter = names.get(3);
        this.grandma = names.get(4);
    }

    //getter
    public ArrayList<String> getFamily_names() {
        return family_names;
    }
    public String getPlayer() {return player;}
    public String getSon() {return son;}
    public String getWife() {return wife;}
    public String getDaughter() {return daughter;}
    public String getGrandma() {return grandma;}
}
