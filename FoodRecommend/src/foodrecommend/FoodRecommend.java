/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author hyunzeekim
 */
public class FoodRecommend {
    
    /**
     * @param args the command line arguments
     */
            
    double price;
    boolean spice;
    boolean hot;
    int calorie;
    String restrictions;
    
    boolean bread = false;
    boolean salad = false;
    boolean soup = false;
    boolean meat = false;
    boolean seafood = false;
    boolean noodles = false;
    boolean beverage = false;
    boolean fruit = false;
    boolean dessertother = false;
    
    boolean wantAppetizer = false;
    boolean wantEntree = false;
    boolean wantDessert = false;
    
    Food [] FinalRecommend = new Food[4];
    
//All the operations in summary;
    public static void main(String[] args) { 
        FoodRecommend f1 = new FoodRecommend();
        f1.askForType();
        f1.checkFood();
        f1.Output();
    }
//The constructor that takes in the input from the user to create a FoodRecommend object
    public FoodRecommend(){

        Scanner s = new Scanner(System.in);
        String currentInput;
        System.out.println("Please type in y/n for the following question:");

        System.out.println("Would you prefer spicy or not?");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Pealse enter again would you prefer spicy or not?");
            currentInput = s.nextLine();
        }
        spice = ToBoolean(currentInput);
        
        
        System.out.println("Would you prefer hot/warm food or not?");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Pealse enter again would you prefer hot/warm food or not?");
            currentInput = s.nextLine();
        }
        hot = ToBoolean(currentInput);
        
        
        System.out.println("Please type in the price that you would like to pay in this format: 10.00");
        price = s.nextDouble();
        System.out.println("Please type in the calories that you would like the food to be: Eg: 1300");
        calorie = s.nextInt();
        
        System.out.println("Please retype the following if you does not want it:(meat, pork, peanut, gluten)");
        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("meat")||currentInput.equalsIgnoreCase("pork")||
                currentInput.equalsIgnoreCase("peanut")||currentInput.equalsIgnoreCase("gluten"))!= true){
            System.out.println("Incorrect format. Please retype the following if you does not want it:"
                    + "(meat, pork, peanut, gluten)");
            currentInput = s.nextLine();
        }     
        restrictions = currentInput;   
    }
    
//Asking for if the user want Appetizers/Entree/Dessert or not
    public void askForType(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Would you like appetizer?");
        currentInput = s.nextLine();
        
        while (CheckInput(currentInput) != true){
            System.out.println("Pealse enter again would you like appetizer?");
            currentInput = s.nextLine();
        }
        wantAppetizer = ToBoolean(currentInput);
        if(wantAppetizer==true){
            AppetizersInput();
        }
        
        System.out.println("Would you like entrees?");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Pealse enter again would you like entrees?");
            currentInput = s.nextLine(); 
        }
        wantEntree = ToBoolean(currentInput);
        if(wantEntree==true){
            EntreeInput();
        }
        
        System.out.println("Would you like desserts?");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Pealse enter again would you like desserts?");
            currentInput = s.nextLine();
            
        }
        wantDessert = ToBoolean(currentInput);
        if(wantDessert==true){
            DessertInput();
        }
    }

// The askForType function calls the AppetizersInput and the other two functions to get 
    //the unique parameters of different types of food.
    public void AppetizersInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Appetizers, please type in one of the following:");
        System.out.println("salad/bread/soup");

        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("salad")||currentInput.equalsIgnoreCase("bread")||
                currentInput.equalsIgnoreCase("soup"))!= true){
            System.out.println("Incorrect format. Please retype the following if you does not want it:"
                    + "salad/bread/soup");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("salad")){
            salad = true;
        }
        else if(currentInput.equalsIgnoreCase("bread")){
            bread = true;
        }
        else{
            soup = true;
        }
    }
    public void EntreeInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Entree, please type in one of the following:");
        System.out.println("meat/seafood/noodles");

        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("meat")||currentInput.equalsIgnoreCase("seafood")||
                currentInput.equalsIgnoreCase("noudles"))!= true){
            System.out.println("Incorrect format. Please retype the following if you does not want it:"
                    + "meat/seafood/noodles");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("meat")){
            meat = true;
        }
        else if(currentInput.equalsIgnoreCase("seafood")){
            seafood = true;
        }
        else{
            noodles = true;
        }
    }
    public void DessertInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Desserts, please type in one of the following:");
        System.out.println("beverage/fruit/other");

        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("beverage")||currentInput.equalsIgnoreCase("fruit")||
                currentInput.equalsIgnoreCase("other"))!= true){
            System.out.println("Incorrect format. Please retype the following if you does not want it:"
                    + "beverage/fruit/other");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("beverage")){
            beverage = true;
        }
        else if(currentInput.equalsIgnoreCase("fruit")){
            fruit = true;
        }
        else{
            dessertother = true;
        }
    }
    
//the ToBoolean function and the CheckIInput function is 
//just what I wrote in order to simplify the input code, there if no need for you guys to look at these fuctions.  
    public static boolean ToBoolean(String decision){
        if(decision.equalsIgnoreCase("y")){
            return true;
        }
        else return false;
    }
    public static boolean CheckInput(String decision){
        if (decision.equalsIgnoreCase("y")||decision.equalsIgnoreCase("n")){
            return true;
        }
        else return false;
    }
    
//The checkFood function calls the checkFood function from the subclasses to get the eventual output.
    public void checkFood(){
        if (wantAppetizer == true){
            FinalRecommend[0] = Appetizers.checkfood();
        }
        //etc I don't know how exactly the subclasses return the final answer.
        return 
    }
    
//Actually printing the output to the screen.
    public void Output(){
        for(int n = 0; n< FinalRecommend.length; n++){
            FinalRecommend[n].printItsInformation();
        }
    }
    //e
}
