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
        Game game = new Game();

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

            //checking the user entered the right input
            try{
                int choice = scan.nextInt();
                scan.nextLine();

                //seeing what the user has chosen
                switch (choice){
                    case 1:
                        //once the user plays the game, the game will end when its done. not making the user to mainly leave the game they finished the game
                        game.mainGameArea(scan);
                        flag = true;
                        scan.close();
                        break;
                    case 2:
                        System.out.println("How to play\n");
                        for (String lines : howToPLay){
                            System.out.println(lines);
                        }
                        components.pressEnter(scan);
                        break;
                    case 3:
                        System.out.println("Exiting the game...\n");
                        flag = true;
                        scan.close();
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