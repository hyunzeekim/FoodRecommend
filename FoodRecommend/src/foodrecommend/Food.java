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
    String[] input = new String[5];
    String [] in = new String[5];
    String[] array = new String[5];
    String [][] menu = new String[20][9];
    Food [] recommendMeal = new Food[20];
    FileReader myFiles;
    
    //FOOD CONSTRUCTOR
    public Food(String n, double p, String s,String h, int c,String r,String c1, String c2, String c3){
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
        int[] accuracy = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        //Read Menus
        myFiles = f;
        Scanner scan = new Scanner(f);
        int row, col;
       
        array = fr.returnUserInput();
        
        while(scan.hasNext()){
            for(row = 0; row < 20; row++){
                for(col = 0; col < 9; col++){
                    menu[row][col] = scan.next();
                }
            }
        }

        for(int i = 0 ; i < 20; i++){
            
            //Restrictions is priority- check restriction first
            if(!array[4].contains(menu[i][5])){
                
                //Then check price
                if(Double.parseDouble(array[2])-3.00 <= Double.parseDouble(menu[i][1]) && Double.parseDouble(menu[i][1]) <= Double.parseDouble(array[2])+3.00){
                    //Add the food that fits restriction and price range into an array Recommend1
                    recommend1[i] = new Food(menu[i][0], Double.parseDouble(menu[i][1]), menu[i][2], menu[i][3], Integer.parseInt(menu[i][4]), menu[i][5], menu[i][6], menu[i][7], menu[i][8]);
                    
                    //Add an accuracy point each time the user's input for the following options is the same as the food's
                    if(recommend1[i].spicy.equals(array[1])){
                        accuracy[i]+=2;
                    }            

                    if(recommend1[i].hot.equals(array[2])){
                        accuracy[i]+=2;
                    }            

                    if(Integer.parseInt(array[3])-100 <= recommend1[i].calorie && recommend1[i].calorie >= Integer.parseInt(array[3])+100){
                        accuracy[i]+=2;
                    }
                    
                }
                
            }
        }
        
        int count = 0;
        
        int max = getMax(accuracy);
                
        for (int z = 0; z < recommend1.length; z++) {
            if(recommend1[z]!=null) {
                recommendMeal[count] = recommend1[z];
                count++;
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
        
        //Print first choice meal
        System.out.println("Your first choice recommended meal is:");
        System.out.println("NAME" + "\t " + "PRICE" + " \t" + "SPICY?" + "\t "  + "HOT?" + "\t" + 
                "CALORIES" +  "\t" + "USED RESTRICTIONS");        
        System.out.println(name + "\t " + price + " \t" + spicy + "\t "  + hot + "\t" + 
                calorie +  "\t" + restrictions + "\t" + condition1 + "\t" + condition2 + "\t" + condition3);
        System.out.println("Your meal is " + percentage1 +"% accurate!");
        
        System.out.println("");
        
        //Print second meal choice
        System.out.println("Your second choice recommended meal is:");
        System.out.println("NAME" + "\t " + "PRICE" + " \t" + "SPICY?" + "\t "  + "HOT?" + "\t" + 
                "CALORIES" +  "\t" + "USED RESTRICTIONS");       
        System.out.println(name + "\t " + price + " \t" + spicy + "\t "  + hot + "\t" + 
                calorie +  "\t" + restrictions + "\t" + condition1 + "\t" + condition2 + "\t" + condition3);
        System.out.println("Your meal is " + percentage2 +"% accurate!");        
    }
    
    FoodRecommend fr = new FoodRecommend();
}