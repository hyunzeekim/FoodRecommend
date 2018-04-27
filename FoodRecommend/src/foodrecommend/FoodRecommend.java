/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommend;
import java.io.IOException;
import java.util.InputMismatchException;
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
    
    String bread;
    String salad;
    String soup;
    String meat;
    String seafood;
    String noodles;
    String beverage;
    String fruit;
    String dessertother;
    String[] inputs = new String[5];
    String[] app = new String[3];
    String[] ent = new String[3];
    String[] des = new String[3];
    
    boolean wantAppetizer = false;
    boolean wantEntree = false;
    boolean wantDessert = false;
    
    Food [] FinalRecommend = new Food[4];
    
//The constructor that takes in the input from the user to create a FoodRecommend object
    public String[] InputData(){

        Scanner s = new Scanner(System.in);
        String currentInput;

        System.out.println("Enter your preference: Spicy or Mild?");
        currentInput = s.next();
        
        while (!currentInput.equalsIgnoreCase("Spicy") && !currentInput.equalsIgnoreCase("Mild") ){
            System.out.println("Please enter again: Spicy or Mild?" );
            currentInput = s.next();
        }       
        spice = currentInput;
        inputs[0] = spice;
        
        System.out.println("Enter your preference: Hot or Cold?");
        currentInput = s.next();
        while (!currentInput.equalsIgnoreCase("Hot") && !currentInput.equalsIgnoreCase("Cold") ){
            System.out.println("Please enter again: Hot or Cold?");
            currentInput = s.next();
        }
        hot = currentInput;
        
        
        System.out.println("Please type in the price that you would like to pay in this format (ex 10.00): ");
        price = s.nextDouble();
        
        System.out.println("Please type in the calories that you would like the food to be (ex 350): ");
        calorie = s.nextInt();
        
        System.out.println("Enter one of the following dietary restrictions (Meat / Peanut / Gluten / None): ");
        System.out.println("If you have more than one, please separate the restriction with a semicolon (e.g. Meat;Peanut)");
        currentInput = s.next();
        
        while(!currentInput.equalsIgnoreCase("Meat")&& !currentInput.equalsIgnoreCase("Peanut")&&!currentInput.equalsIgnoreCase("Gluten") &&
                !currentInput.equalsIgnoreCase("None")&&!currentInput.equalsIgnoreCase("Meat;Peanut")&&!currentInput.equalsIgnoreCase("Meat;Gluten")
                &&!currentInput.equalsIgnoreCase("Peanut;Gluten")&&!currentInput.equalsIgnoreCase("Meat;Peanut;Gluten")){
            System.out.println("Incorrect format. Please retype your restrictions in the order (Meat / Peanut / Gluten / None):");
            currentInput = s.nextLine();
        }     
        restrictions = currentInput;   
        
        inputs[0] = spice;
        inputs[1] = hot;
        inputs[2] = Double.toString(price);
        inputs[3] = Integer.toString(calorie);
        inputs[4] = restrictions;
        
        return inputs;
    }
    
//Asking for if theq user want Appetizers/Entree/Dessert or not
    public String askForType(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Choose one of the following (Appetizers / Entree / Desserts)");
        currentInput = s.nextLine();
        
        while (!currentInput.equalsIgnoreCase("Appetizers") && !currentInput.equalsIgnoreCase("Entree") &&
                !currentInput.equalsIgnoreCase("Desserts")){
            System.out.println("Please enter again (Appetizers / Entree / Desserts)");
            currentInput = s.next();
        }

        return currentInput;
    }

// The askForType function calls the AppetizersInput and the other two functions to get 
    //the unique parameters of different types of food.
    public String[] AppetizersInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Appetizers; please type in one of the following (Salad / Bread / Soup):");

        currentInput = s.next();
        while(!currentInput.equalsIgnoreCase("Salad")&&!currentInput.equalsIgnoreCase("Bread")&&
                !currentInput.equalsIgnoreCase("Soup")){
            System.out.println("Incorrect format. Please retype ( Salad / Bread / Soup )");
            currentInput = s.next();
        }
        
        if(currentInput.equalsIgnoreCase("Bread")){
            app[0] = "Y";
            app[1] = "N";
            app[2] = "N";
        }
        else if(currentInput.equalsIgnoreCase("Salad")){
            app[0] = "N";
            app[1] = "Y";
            app[2] = "N";        
        }
        else if(currentInput.equalsIgnoreCase("Soup")){
            app[0] = "N";
            app[1] = "N";
            app[2] = "Y";
        }
        
        return app;
    }
    
    public String[] EntreeInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Entree, please type in one of the following (Meat / Seafood / Noodles):");

        currentInput = s.next();
        while(!currentInput.equalsIgnoreCase("Meat")&&!currentInput.equalsIgnoreCase("Seafood")&&
                !currentInput.equalsIgnoreCase("Noodles")){
            System.out.println("Incorrect format. Please retype (Meat / Seafood / Noodles):");
            currentInput = s.next();
        }
        
        if(currentInput.equalsIgnoreCase("Meat")){
            ent[0] = "Y";
            ent[1] = "N";
            ent[2] = "N";        
        }
        else if(currentInput.equalsIgnoreCase("Seafood")){
            ent[0] = "N";
            ent[1] = "Y";
            ent[2] = "N";           
        }
        else if(currentInput.equalsIgnoreCase("Noodles")){
            ent[0] = "N";
            ent[1] = "N";
            ent[2] = "Y";           
        }
        return ent;
    } 
 public String[] DessertInput(){
        String currentInput;
        Scanner s = new Scanner(System.in);
        
        System.out.println("You have selected Desserts, please type in one of the following (Beverage / Fruit / Other):");

        currentInput = s.next();
        while(!currentInput.equalsIgnoreCase("Beverage")&&!currentInput.equalsIgnoreCase("Fruit")&&
                !currentInput.equalsIgnoreCase("Other")){
            System.out.println("Incorrect format. Please retype (Beverage / Fruit / Other): ");
            currentInput = s.next();
        }
        
        if(currentInput.equalsIgnoreCase("Beverage")){
            des[0] = "Y";
            des[1] = "N";
            des[2] = "N";           
        }
        else if(currentInput.equalsIgnoreCase("Fruit")){
            des[0] = "N";
            des[1] = "Y";
            des[2] = "N";          
        }
        else if(currentInput.equalsIgnoreCase("Other")){
            des[0] = "N";
            des[1] = "N";
            des[2] = "Y";          
        }
        return des;
    }
    
    //Main 
    public static void main(String[] args) throws IOException { 
        FoodRecommend f = new FoodRecommend();
        String[] userInput = f.InputData();
        String desiredMeal = f.askForType();

        if(desiredMeal.equalsIgnoreCase("Appetizers")){
            String[] app = f.AppetizersInput();
            Appetizers a = new Appetizers("", Double.parseDouble(userInput[2]), userInput[4], Integer.parseInt(userInput[3]), userInput[0], userInput[1], app[0], app[1], app[2]);
            a.printAppetizers();
        }
    }

}
