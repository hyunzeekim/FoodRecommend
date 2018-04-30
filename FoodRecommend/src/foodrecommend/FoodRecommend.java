/*
 * FoodTester Class
 */
package foodrecommend;
import java.io.IOException;
import java.util.Scanner;

public class FoodRecommend {
    
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
    static String[] inputs = new String[5];
    static String[] app = new String[3];
    static String[] ent = new String[3];
    static String[] des = new String[3];
    
    boolean wantAppetizer = false;
    boolean wantEntree = false;
    boolean wantDessert = false;
    boolean test = false;
    
    Food [] FinalRecommend = new Food[4];
    
    //Method that takes in input from user
    public String[] InputData(){

        Scanner s = new Scanner(System.in);
        String currentInput;
        String [] notNumber = new String[244];
        int n = 0;
        for(n=0; n<45;n++){
            notNumber[n]=Character.toString((char)n);
        }
        notNumber[47]=Character.toString((char)47);
        for(n=58;n<255;n++){
            notNumber[n-11]=Character.toString((char)n);
        }

        //Spicy
        System.out.println("Enter your preference: Spicy or Mild?");
        currentInput = s.next();
        
        while (!currentInput.equalsIgnoreCase("Spicy") && !currentInput.equalsIgnoreCase("Mild") ){
            System.out.println("Please enter again: Spicy or Mild?" );
            currentInput = s.next();
        }       
        spice = currentInput;
        inputs[0] = spice;
        
        //Hot
        System.out.println("Enter your preference: Hot or Cold?");
        currentInput = s.next();
        while (!currentInput.equalsIgnoreCase("Hot") && !currentInput.equalsIgnoreCase("Cold") ){
            System.out.println("Please enter again: Hot or Cold?");
            currentInput = s.next();
        }
        hot = currentInput;
        
        //Price
        System.out.println("Please type in the price that you would like to pay in this format (ex 10.00): ");
        price = s.nextDouble();
        
        currentInput = s.next();
        System.out.println("Please type in the calories that you would like the food to be (ex 350): ");
        while(currentInput.contains(hot))
        calorie = Integer.parseInt(currentInput);
        
        //Restrictions
        System.out.println("Enter one of the following dietary restrictions (Meat / Peanut / Gluten / None): ");
        System.out.println("If you have more than one, please separate the restriction with a semicolon (e.g. Meat;Peanut)");
        currentInput = s.next();
        
        while(!currentInput.equalsIgnoreCase("Meat")&& !currentInput.equalsIgnoreCase("Peanut")&&!currentInput.equalsIgnoreCase("Gluten") 
                &&!currentInput.equalsIgnoreCase("None")&&!
                currentInput.equalsIgnoreCase("Meat;Peanut")&&!currentInput.equalsIgnoreCase("Meat;Gluten")
                &&!currentInput.equalsIgnoreCase("Peanut;Gluten")&&!currentInput.equalsIgnoreCase("Peanut;Meat")&&!
                currentInput.equalsIgnoreCase("Gluten;Meat")&&!currentInput.equalsIgnoreCase("Gluten;Peanut")&&!
                currentInput.equalsIgnoreCase("Meat;Peanut;Gluten")&&!currentInput.equalsIgnoreCase("Meat;Gluten;Peanut")
                &&!currentInput.equalsIgnoreCase("Gluten;Peanut;Meat")&&!currentInput.equalsIgnoreCase("Gluten;Meat;Peanut")
                &&!currentInput.equalsIgnoreCase("Peanut;Meat;Gluten")&&!currentInput.equalsIgnoreCase("Peanut;Gluten;Meat")){
            System.out.println("Incorrect format. Please retype your restrictions in the order (Meat / Peanut / Gluten / None):");
            currentInput = s.nextLine();
        }     
        restrictions = currentInput;   
        
        //Inputs
        inputs[0] = spice;
        inputs[1] = hot;
        inputs[2] = Double.toString(price);
        inputs[3] = Integer.toString(calorie);
        inputs[4] = restrictions;
        
        return inputs;
    }
    
    //Return User Inputs
    public String[] returnUserInput() {
        return inputs;
    }
    
    //Ask user for Meal Type
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

    //APPETIZERS - ask bread / salad / soup
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
        
        //Return "y" or "n"
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
    
    //ENTREE - ask meat / seafood / noodles
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
        
        //return "y" or "n"
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
    
    //DESSERTS - ask beverages / fruits / other
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
        
        //return "y" or "n"
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
 
    //Call methods from subclasses based on user's desired meal type
    public void printDesiredInput(String want)throws IOException{
        FoodRecommend f = new FoodRecommend();

        //call from appetizer subclass
        if(want.equalsIgnoreCase("Appetizers")){
            f.AppetizersInput();
            Appetizers a = new Appetizers("", Double.parseDouble(inputs[2]), inputs[4], Integer.parseInt(inputs[3]), inputs[0], inputs[1], app[0], app[1], app[2]);
            a.printAppetizers();
        }            
        
        //call from entree subclass
        else if(want.equalsIgnoreCase("Entree")){
            f.EntreeInput();
            Entree e = new Entree("", Double.parseDouble(inputs[2]), inputs[4], Integer.parseInt(inputs[3]), inputs[0], inputs[1], app[0], app[1], app[2]);
            e.printEntree();
        }
        
        //call from desserts subclass
        else{       
            f.DessertInput();
            Desserts d = new Desserts("", Double.parseDouble(inputs[2]), inputs[4], Integer.parseInt(inputs[3]), inputs[0], inputs[1], app[0], app[1], app[2]);
            d.printDesserts();
        }    
        
    }
    //Main 
    public static void main(String[] args) throws IOException { 
        FoodRecommend f = new FoodRecommend();
        f.InputData();
        String desired = f.askForType();
        f.printDesiredInput(desired);
    }
}
