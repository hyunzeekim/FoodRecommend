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
    
    Appetizers [] AppetizersArray = new Appetizers [20];
    Entree [] EntreeArray = new Entree [20];
    Desserts [] DessertsArray = new Desserts[20];
    
    public static void main(String[] args) {
        
    }
    public void OrderInput() {

        Scanner s = new Scanner(System.in);
        String currentInput;
        System.out.println("Please type in y/n for the following question:");

        System.out.println("Would you prefer spicy or not?");
        currentInput = s.nextLine();
        if (CheckInput(currentInput) == true){
            spice = ToBoolean(currentInput);
        }
        System.out.println("Would you prefer hot/warm food or not?");
        currentInput = s.nextLine();
        if (CheckInput(currentInput) == true){
            hot = ToBoolean(currentInput);
        }
        System.out.println("Please type in the price that you would like to pay in this format: 10.00");
        price = s.nextDouble();
        System.out.println("Please type in the calories that you would like the food to be: Eg: 1300");
        calorie = s.nextInt();
        System.out.println("Please retype the following if you does not want it:(meat, pork, peanut, gluten)");
        currentInput = s.nextLine();
        while((currentInput.equalsIgnoreCase("meat")||currentInput.equalsIgnoreCase("pork")||
                currentInput.equalsIgnoreCase("peanut")||currentInput.equalsIgnoreCase("gluten"))!= true)
            System.out.println("Incorrect format. Please retype the following if you does not want it:(meat, pork, peanut, gluten)");
        restrictions = currentInput;
        
    }
    
    public void AppetizersInput(){
        
    }
    public void EntreeInput(){
        
    }
    public void DessertInput(){
        
    }
    
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
    
    public static void InputMenu()throws FileNotFoundException{
        AppetizersArray = Appetizers.ReadingTheMenuFromFile();
        EntreeArray = Entree.ReadingTheMenuFromFile();
        DessertsArray = Desserts.ReadingTheMenuFromFile();   
    }
}
