import components.MainComponents;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) {
        //getting the scanner
        Scanner scan = new Scanner(System.in);

        //importing other files
        MainComponents components = new MainComponents();

        //main vars
        boolean flag = false;
        String[] options = {"1. Play", "2. How to Play", "3. Exit"};
        ArrayList<String> howToPLay = components.fileReader("data/how_to_play.txt");

        //main game section
        while (!flag){
            System.out.println("-- Organ Trail Remastered --\n" +
                    "Please select an option:");
            for (String option : options){
                System.out.println(option);
            }

            //seeing what the user chosed
            try{
                int choice = scan.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Playing the game\n");
                        break;
                    case 2:
                        System.out.println("How to play\n");
                        for (String lines : howToPLay){
                            System.out.println(lines);
                        }
                        break;
                    case 3:
                        System.out.println("Exiting the game...\n");
                        flag = true;
                        break;
                    default:
                        System.out.println("Invalid choice.\n");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a number\n");
                scan.nextLine();
            }
        }
    }
}