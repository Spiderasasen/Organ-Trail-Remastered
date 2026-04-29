package game_components;
import java.util.InputMismatchException;
import java.util.Scanner;

import static components.Colors.RED;
import static components.Colors.RESET;

public class SelectionMenu {
    //private vars
    private String charcater;
    private String[] options = {"1. Hunter", "2. Medic", "3. Farmer"};
    private boolean flag = false;

    //constructors
    public SelectionMenu(String charcater){
        setCharcater(charcater);
    }

    public SelectionMenu(){
        setCharcater("");
    }

    //main system
    public void menu(Scanner scanner){
        while(!flag){
            try{
                System.out.println("Please select a Character");

                //prints out all the options
                for(String option : options){
                    System.out.println(option);
                }

                //gets the choice and sees if the choise is a valid answer or not
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:
                        setCharcater("Hunter\n");
                        flag = true;
                        break;
                    case 2:
                        setCharcater("Medic\n");
                        flag = true;
                        break;
                    case 3:
                        setCharcater("Farmer\n");
                        flag = true;
                        break;
                    default:
                        System.out.println(RED + "Invalid choice\n" + RESET);
                        break;
                }
                System.out.println("");
            }
            //if not, it will yell at the user
            catch (InputMismatchException e){
                System.out.println(RED +"Please enter a number\n" + RESET);
                scanner.nextLine();
            }
        }
    }

    //getters
    public String getCharcater(){return this.charcater;}


    //setters
    public void setCharcater(String charcater) {
        if(charcater == ""){
            this.charcater = "bill";
        }
        this.charcater = charcater;
    }
}
