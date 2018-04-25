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
    double rating;
    String[] input;
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
    
    //GET INPUTS
    public String[] inputs(){
        //Get inputs from user using the FoodRecommend Class
        input[0] = Double.toString(fr.price);
        input[1] = fr.spice;
        input[2] = fr.hot;
        input[3] = Integer.toString(fr.calorie);
        input[4] = fr.restrictions;
        
        return input;
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
        
        for(int i = 0 ; i < 20; i++){
            
            //Restrictions is priority- check restriction first
            if(menu[i][5].equals(input[4])){
                
                //Then check price
                if(Double.parseDouble(input[0])-3 <= Double.parseDouble(menu[i][1]) && Double.parseDouble(menu[i][1]) <= Double.parseDouble(input[0])+3){
                    
                    //Add the food that fits restriction and price range into an array Recommend1
                    recommend1[i] = new Food(menu[i][0], Double.parseDouble(menu[i][1]), menu[i][2], Integer.parseInt(menu[i][3]), menu[i][4], menu[i][5], menu[i][6], menu[i][7], menu[i][8]);
                    
                    //Add an accuracy point each time the user's input for the following options is the same as the food's
                    if(recommend1[i].spicy.equals(input[1])){
                        accuracy[i]+=2;
                    }            

                    if(recommend1[i].hot.equals(input[2])){
                        accuracy[i]+=2;
                    }            

                    if(Integer.parseInt(input[3])-100 <= recommend1[i].calorie && recommend1[i].calorie >= Integer.parseInt(input[3])+100){
                        accuracy[i]+=2;
                    }
                }
            }
        }
        
        int count = 0;
        for(int z = 0; z < recommend1.length; z++){
            
            //If the highest accuracy score is 6, add all Food items with accuracy score 6 into an array recommendMeal
            if(getMax(accuracy) == 6){
                if(accuracy[z] == 6){
                    recommendMeal[count] = recommend1[z]; 
                }
            }
            
             //If the highest accuracy score is 4, add all Food items with accuracy score 4 into an array recommendMeal           
            else if(getMax(accuracy) == 4){
                if(accuracy[z] == 4){
                    recommendMeal[count] = recommend1[z];
                }
            }
            
            //If the highest accuracy score is 2, add all Food items with accuracy score 2 into an array recommendMeal            
            else if(getMax(accuracy) == 2){
                if(accuracy[z] == 2){
                    recommendMeal[count] = recommend1[z];
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
    
    //CALCULATE PERCENTAGE ACCURACY OF THE OUTPUT COMPARED TO USER'S INPUTS
    public double calculateRating(Food f){
        if(Double.parseDouble(input[0]) == price){
            rating+=2;
        }
        
        if(restrictions.equals(input[4])){
            rating+=2;
        }
        
        if(spicy.equals(input[2])){
            rating+=2;
        }
        
        if(hot.equals(input[3])){
            rating+=2;
        }        
        
        if(Integer.parseInt(input[3]) == calorie){
            rating+=2;
        }
        
        //Accuracy percentage of meal
        return rating/10*100;
        
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
    public void printFood(Food f, Food ff){
        double percentage1 = calculateRating(f);
        double percentage2 = calculateRating(ff);
        
        System.out.println("Your first choice recommended meal is:");
        System.out.println("");
        System.out.println("Name" + "\t " + "Price" + " \t" + "Spicy/Mild" + "\t "  + "Hot/Cold" + "\t" + 
                "Calories" +  "\t" + "Any Used Restricted Ingrediants");        
        System.out.println(name + "\t " + price + " \t" + spicy + "\t "  + hot + "\t" + 
                calorie +  "\t" + restrictions);
        System.out.println("Your meal is " + percentage1 +"% accurate!");
        
        System.out.println("");
        
        System.out.println("Your second choice recommended meal is:");
        System.out.println("");
        System.out.println("Name" + "\t " + "Price" + " \t" + "Spicy/Mild" + "\t "  + "Hot/Cold" + "\t" + 
                "Calories" +  "\t" + "Any Used Restricted Ingredients");        
        System.out.println(name + "\t " + price + " \t" + spicy + "\t "  + hot + "\t" + 
                calorie +  "\t" + restrictions);
        System.out.println("Your meal is " + percentage2 +"% accurate!");        
    }
    
    FoodRecommend fr = new FoodRecommend();
}