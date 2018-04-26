/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommend;
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
    String spice;
    String hot;
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
        f1.InputData();
//        f1.askForType();
//        f1.printInfo();
    }
//The constructor that takes in the input from the user to create a FoodRecommend object
    public void InputData(){

        Scanner s = new Scanner(System.in);
        String currentInput;
        System.out.println("Please type in y/n for the following question:");

        System.out.println("Would you prefer spicy?");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Please enter again would you prefer spicy or not?");
            currentInput = s.nextLine();
        }
        spice = currentInput;
        
        
        System.out.println("Would you prefer hot/warm food");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Please enter again would you prefer hot/warm food?");
            currentInput = s.nextLine();
        }
        hot = currentInput;
        
        
        System.out.println("Please type in the price that you would like to pay in this format: 10.00");
        price = s.nextDouble();
        
        
        System.out.println("Please type in the calories that you would like the food to be: Eg: 1300");
        calorie = s.nextInt();
        
        System.out.println("Please type the following if you have these restrictions(Meat, Peanut, Gluten):");
        currentInput = s.nextLine();
        
        while((currentInput.equalsIgnoreCase("meat")||
                currentInput.equalsIgnoreCase("peanut")||currentInput.equalsIgnoreCase("gluten"))!= true){
            System.out.println("Incorrect format. Please retype your restrictions(Meat, Peanut, Gluten)");
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
            System.out.println("Please enter again- would you like appetizer?");
            currentInput = s.nextLine();
        }
        
        wantAppetizer = ToBoolean(currentInput);
        if(wantAppetizer==true){
            AppetizersInput();
        }
        
        System.out.println("Would you like entrees?");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Please enter again- would you like entrees?");
            currentInput = s.nextLine(); 
        }
        wantEntree = ToBoolean(currentInput);
        if(wantEntree==true){
            EntreeInput();
        }
        
        System.out.println("Would you like desserts?");
        currentInput = s.nextLine();
        while (CheckInput(currentInput) != true){
            System.out.println("Please enter again- would you like desserts?");
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
        System.out.println("Salad/Bread/Soup");

        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("Salad")||currentInput.equalsIgnoreCase("Bread")||
                currentInput.equalsIgnoreCase("Soup"))!= true){
            System.out.println("Incorrect format. Please retype:"
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
        System.out.println("Meat/Seafood/Noodles");

        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("meat")||currentInput.equalsIgnoreCase("seafood")||
                currentInput.equalsIgnoreCase("noodles"))!= true){
            System.out.println("Incorrect format. Please retype:"
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
        System.out.println("Beverage/Fruit/Other");

        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("beverage")||currentInput.equalsIgnoreCase("fruit")||
                currentInput.equalsIgnoreCase("other"))!= true){
            System.out.println("Incorrect format. Please retype: beverage/fruit/other");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("beverage")){
            beverage = true;
        }
        else if(currentInput.equals("fruit")){
            fruit = true;
        }
        
        else{
            dessertother = true;
        }
    
 }
    
    public static boolean ToBoolean(String decision){
        if(decision.equalsIgnoreCase("Y")){
            return true;
        }
        else return false;
    }
    public static boolean CheckInput(String decision){
        if (decision.equalsIgnoreCase("Y")||decision.equalsIgnoreCase("N")){
            return true;
        }
        else return false;
    }
    
//The recommendFood function calls the recommendFood function from the subclasses to get the eventual output.
    public void recommendFood(){
        if (wantAppetizer == true){
            FinalRecommend[0] = Appetizers.recommendFood();
        }
        //etc I don't know how exactly the subclasses return the final answer.
        return 
    }
    
//Actually printing the output to the screen.
    public void printInfo(){
        for(int n = 0; n< FinalRecommend.length; n++){
            FinalRecommend[n].printItsInformation();
        }
    }
}
