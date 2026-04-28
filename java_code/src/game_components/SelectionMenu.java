package game_components;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                        setCharcater("Hunter");
                        flag = true;
                        break;
                    case 2:
                        setCharcater("Medic");
                        flag = true;
                        break;
                    case 3:
                        setCharcater("Farmer");
                        flag = true;
                        break;
                    default:
                        System.out.println("Invalid choice\n");
                        break;
                }
            }
            //if not, it will yell at the user
            catch (InputMismatchException e){
                System.out.println("Please enter a number\n");
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
