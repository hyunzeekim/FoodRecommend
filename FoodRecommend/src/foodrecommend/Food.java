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
        Food[] recommendMeal = new Food[20];
        int[] accuracy = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

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
        String spicyInput = fr.spice;
        String hotInput = fr.hot;
        int calorieInput = fr.calorie;
        String restricInput = fr.restrictions;
        
        //Save menu titles into variables
        for(int i = 0 ; i < 20; i++){
            
            //Restrictions is priority- check restriction first
            if(menu[i][5].equals(restricInput)){
                
                //Then check price
                if(priceInput-3 < Double.parseDouble(menu[i][1]) && Double.parseDouble(menu[i][1]) < priceInput+3){
                    
                    //Add the food that fits restriction and price range into an array Recommend1
                    recommend1[i] = new Food(menu[i][0], Double.parseDouble(menu[i][1]), menu[i][2], Integer.parseInt(menu[i][3]), menu[i][4], menu[i][5], menu[i][6], menu[i][7], menu[i][8]);
                    
                    //Add an accuracy point each time the user's input for the following options is the same as the food's
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
            }
        }
        
        int count = 0;
        for(int z = 0; z < recommend1.length; z++){
            
            //If the highest accuracy score is 3, add all Food items with accuracy score 3 into an array recommendMeal
            if(getMax(accuracy) == 3){
                if(accuracy[z] == 3){
                    recommendMeal[count] = recommend1[z];
                    count++;
                    
                }
            }
             //If the highest accuracy score is 2, add all Food items with accuracy score 2 into an array recommendMeal           
            else if(getMax(accuracy) == 2){
                if(accuracy[z] == 2){
                    recommendMeal[count] = recommend1[z];
                    count++;
                }
            }
            
            //If the highest accuracy score is 1, add all Food items with accuracy score 1 into an array recommendMeal            
            else if(getMax(accuracy) == 1){
                if(accuracy[z] == 1){
                    recommendMeal[count] = recommend1[z];
                    count++;
                }
            }
 
            //If the highest accuracy score is 0, recommend1 is the same array as recommendMeal
            else{
                recommendMeal = recommend1;
            }
        }

        //Returns recommendMeal
        return recommendMeal;
    }
    
    //CALCULATE RATING OF THE OUTPUT
    public double calculateRating(Food f){
        double rating;
        rating = 0;
        
        return rating;
    }
    
    //GET MAX VALUE - used in the CheckFood() Method
    public int getMax(int[] a){
        int max = a[0];
        for(int b = 1; b < 20; b++){
            if(a[b] > max){
                max = a[b];
            }
        }
        return max;
    }
    
    //PRINT INFO
    public void printFood(Food f){
        double percentage = calculateRating(f);
        
        System.out.println(name + " " + price + " " + spicy + " "  + hot + " " + 
                calorie + " " + restrictions + " " + percentage);
    }
    
    FoodRecommend fr = new FoodRecommend();
}
