/*
 * Food Class
 *    Checks the common restrictions between the three menus
 */
package foodrecommend;

//IMPORTS
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Food {
    //FIELDS
    String restrictions;
    double price;
    String spicy;
    String hot;
    int calorie;
    String name;
    String condition1;
    String condition2;
    String condition3;
    
    FileReader myFiles;
    
    //FOOD CONSTRUCTOR
    public Food(String n, double p, String r, int c, String s, String h, String c1, String c2, String c3){
        name = n;
        restrictions = r;
        price = p;
        calorie = c;
        spicy = s;
        hot = h;
        condition1 = c1;
        condition2 = c2;
        condition3 = c3;
    }
    
    //CHECK RESTRICTIONS - called in subclasses
    public Food[] checkFood(FileReader f) throws IOException {
        
        Food[] recommend1 = new Food[20];
        int[] accuracy = new int[20];

        //Read Menus
        myFiles = f;
        Scanner s = new Scanner(f);
        String [][] menu = new String[20][9];
        int row, col;
        s.nextLine();
        
        //Read file into an array
        for(row = 0; row < 20; row++){
            for(col = 0; col < 20; col++){
                menu[row][col] = s.next();
            }
        }
        
        //Get inputs from user using the FoodRecommend Class
        double priceInput = fr.price;
        String spicyInput = Boolean.toString(fr.spice);
        String hotInput = Boolean.toString(fr.hot);
        int calorieInput = fr.calorie;
        String restricInput = fr.restrictions;
        
        //Save menu titles into variables
        for(int i = 0 ; i < 20; i++){
            if(menu[i][5].equals(restricInput)){
                if(priceInput-3 < Double.parseDouble(menu[i][1]) && Double.parseDouble(menu[i][1]) < priceInput+3){
                    recommend1[i] = new Food(menu[i][0], Double.parseDouble(menu[i][1]), menu[i][2], Integer.parseInt(menu[i][3]), menu[i][4], menu[i][5], menu[i][6], menu[i][7], menu[i][8]);
                }
            }
            
            if(recommend1[i].spicy.equals(spicyInput)){
                accuracy[i]++;
            }            
            
            if(recommend1[i].hot.equals(hotInput)){
                accuracy[i]++;
            }            
            
            if(calorieInput-100 < recommend1[i].calorie && recommend1[i].calorie > calorieInput+100){
                accuracy[i]++;
            }
        }

        
        //Returns array of possible food items based on FIRST SIX user inputs
        return ;
    }
    
    //CALCULATE RATING
    public double calculateRating(Food f){
        double rating;
        
        
        return rating;
    }
    
    //PRINT INFO
    public void printFood(Food f){
        double percentage = calculateRating(f);
        
        System.out.println(name + " " + price + " " + spicy + " "  + hot + " " + 
                calorie + " " + restrictions + " " + percentage);
    }
    
    FoodRecommend fr = new FoodRecommend();
}
