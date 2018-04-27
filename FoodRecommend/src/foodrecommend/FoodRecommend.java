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
    
//The constructor that takes in the input from the user to create a FoodRecommend object
    public void InputData(){

        Scanner s = new Scanner(System.in);
        String currentInput;

        System.out.println("Enter your preference: Spicy or Mild?");
        currentInput = s.nextLine();
        while (!currentInput.equalsIgnoreCase("Spicy") || !currentInput.equalsIgnoreCase("Mild") ){
            System.out.println("Please enter again: Spicy or Mild?");
            currentInput = s.nextLine();
        }
        spice = currentInput;
        
        
        System.out.println("Enter your preference: Hot or Cold?");
        currentInput = s.nextLine();
        while (!currentInput.equalsIgnoreCase("Hot") || !currentInput.equalsIgnoreCase("Cold") ){
            System.out.println("Please enter again: Hot or Cold?");
            currentInput = s.nextLine();
        }
        hot = currentInput;
        
        
        System.out.println("Please type in the price that you would like to pay in this forma (ex 10.00): ");
        price = s.nextDouble();
        
        
        System.out.println("Please type in the calories that you would like the food to be (ex 350): ");
        calorie = s.nextInt();
        
        System.out.println("Enter one of the following dietary restrictions (Meat / Peanut / Gluten / None):");
        currentInput = s.nextLine();
        
        while((!currentInput.equalsIgnoreCase("Meat")||
                !currentInput.equalsIgnoreCase("Peanut")||!currentInput.equalsIgnoreCase("Gluten")) ||
                !currentInput.equalsIgnoreCase("None")){
            System.out.println("Incorrect format. Please retype your restrictions (Meat / Peanut / Gluten / None)");
            currentInput = s.nextLine();
        }     
        restrictions = currentInput;   
    }
    
//Asking for if theq user want Appetizers/Entree/Dessert or not
    public void askForType(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Choose one of the following (Appetizers / Entree / Desserts)");
        currentInput = s.nextLine();
        
        while (!currentInput.equalsIgnoreCase("Appetizers") || !currentInput.equalsIgnoreCase("Entree") ||
                !currentInput.equalsIgnoreCase("Desserts")){
            System.out.println("Please enter again (Appetizers / Entree / Desserts)");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("Appetizers")){
            AppetizersInput();
        }        
        
        else if(currentInput.equalsIgnoreCase("Entree")){
            EntreeInput();
        }        
        
        else if(currentInput.equalsIgnoreCase("Desserts")){
            DessertInput();
        }
       
    }

// The askForType function calls the AppetizersInput and the other two functions to get 
    //the unique parameters of different types of food.
    public void AppetizersInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Appetizers; please type in one of the following (Salad / Bread / Soup):");

        currentInput = s.nextLine();
        while(!currentInput.equalsIgnoreCase("Salad")||!currentInput.equalsIgnoreCase("Bread")||
                !currentInput.equalsIgnoreCase("Soup")){
            System.out.println("Incorrect format. Please retype ( Salad / Bread / Soup");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("Salad")){
            salad = true;
        }
        else if(currentInput.equalsIgnoreCase("Bread")){
            bread = true;
        }
        else if(currentInput.equalsIgnoreCase("Soup")){
            soup = true;
        }
    }
    
    public void EntreeInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Entree, please type in one of the following (Meat / Seafood / Noodles):");

        currentInput = s.nextLine();
        while(!currentInput.equalsIgnoreCase("Meat")||!currentInput.equalsIgnoreCase("Seafood")||
                !currentInput.equalsIgnoreCase("Noodles")){
            System.out.println("Incorrect format. Please retype (Meat / Seafood / Noodles):");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("Meat")){
            meat = true;
        }
        else if(currentInput.equalsIgnoreCase("Seafood")){
            seafood = true;
        }
        else if(currentInput.equalsIgnoreCase("Noodles")){
            noodles = true;
        }
    } 
 public void DessertInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Desserts, please type in one of the following (Beverage / Fruit / Other):");

        currentInput = s.nextLine();
        while(!currentInput.equalsIgnoreCase("Beverage")||!currentInput.equalsIgnoreCase("Fruit")||
                !currentInput.equalsIgnoreCase("Other")){
            System.out.println("Incorrect format. Please retype (Beverage / Fruit / Other): ");
            currentInput = s.nextLine();
        }
        
        if(currentInput.equalsIgnoreCase("Beverage")){
            beverage = true;
        }
        else if(currentInput.equalsIgnoreCase("Fruit")){
            fruit = true;
        }
        
        else if(currentInput.equalsIgnoreCase("Other")){
            dessertother = true;
        }
 }
    
    public static boolean ToBoolean(String decision){
        if(decision.equalsIgnoreCase("Y")){
            return true;
        }
        else return false;
    }
    
    //All the operations in summary;
    public static void main(String[] args) { 
        FoodRecommend f = new FoodRecommend();
        f.InputData();
        f.askForType();
    }

}
