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
    String[] input = new String[5];
    String [] in = new String[5];
    String[] array = new String[5];
    Food[] menu = new Food[20];
    //String [][] menu = new String[20][9];
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
        Food[] recommendMeal = new Food[20];
        int[] accuracy = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        //Read Menus
        myFiles = f;
        Scanner scan = new Scanner(f);
        //scan.useDelimiter(",");
        int row, col;
       
        array = fr.returnUserInput();
        while(scan.hasNext()) {
           for (row = 0; row < 20; row++) {
                String foodName = scan.next();
                double foodPrice = Double.parseDouble(scan.next());
                String foodSpicy = scan.next();
                String foodHot = scan.next();
                int cal = Integer.parseInt(scan.next());
                String res = scan.next();
                String cond1 = scan.next();
                String cond2 = scan.next();
                String cond3 = scan.next();
                menu[row] = new Food(foodName, foodPrice, foodSpicy, foodHot, cal, res, cond1, cond2, cond3);    
            }
        }
       
        for(int i = 0 ; i < 20; i++){
            
            //Restrictions is priority- check restriction first
            if(!array[4].contains(menu[i].restrictions)){
                //Then check price
                if(Double.parseDouble(array[2])-3.00 <= menu[i].price && menu[i].price <= Double.parseDouble(array[2])+3.00){
                    //Add the food that fits restriction and price range into an array Recommend1
                    recommend1[i] = menu[i];
                    
                    //Add an accuracy point each time the user's input for the following options is the same as the food's
                    if(recommend1[i].spicy.equals(array[0])){
                   
                        accuracy[i]+=2;
                    }            

                    if(recommend1[i].hot.equals(array[1])){
                      
                        accuracy[i]+=2;
                    }            
                    
                    if(Integer.parseInt(array[3])-100 <= recommend1[i].calorie && recommend1[i].calorie <= Integer.parseInt(array[3])+100){
                     
                        accuracy[i]+=2;
                    }
                }
            }
        }
        
        int count = 0;
        
        int max = getMax(accuracy);
        
        for (int z = 0; z < recommend1.length; z++) {
            if(accuracy[z] == max) {
                recommendMeal[count] = recommend1[z];
                count++;
            }
        }
        
        //Returns recommendMeal
        return recommendMeal;
        
    }
    
    //CALCULATE PERCENTAGE ACCURACY OF THE OUTPUT COMPARED TO USER'S INPUTS
    public double calculateRating(Food f){
        double rating = 0;

        if(Double.parseDouble(array[2])-3.00 <= f.price && f.price <= Double.parseDouble(array[2])+3.00){
            rating+=2;
        }
        
        if(!f.restrictions.equalsIgnoreCase(array[4])){
            rating+=2;
        }

        if(f.spicy.equalsIgnoreCase(array[0])){
            rating+=2;
        }

        if(f.hot.equalsIgnoreCase(array[1])){
            rating+=2;
        }        

        if((Integer.parseInt(array[3])-100 <= f.calorie && f.calorie <= Integer.parseInt(array[3])+100)){
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
    public String printFood(Food[] f){
        int printCount = 0;
        String[] str = {"first", "second"};
        String result = "";
        for (int i = 0 ; i < f.length ; i++) {
            if (f[i] != null) {
                if (printCount > 1) {
                    break;
                }
                double percentage = calculateRating(f[i]);
                // print choice meal
                
                String result_0 = "Your " + str[printCount] + " choice recommended meal is:" + "\n";
                String name = "* NAME: " + "\t" + "\t" + f[i].name + "\n";
                String price = "* PRICE: " + "\t" + "\t" + f[i].price + "\n";
                String spicy = "* SPICY?: " + "\t" + "\t" + f[i].spicy + "\n";
                String hot = "* HOT?: " + "\t" + "\t" + f[i].hot + "\n";
                String cal = "* CALORIES: " + "\t" + "\t" + f[i].calorie + "\n";
                String rest = "* RESTRICTIONS: " + "\t" + f[i].restrictions + "\n";
                String result_1 = "Your meal is " + percentage + "% accurate!" + "\n";
                
                result = result_0 + name + price + spicy + hot + cal + rest + result_1;
        
                printCount++;
            }
        }  
        return result;
    }
    
    FoodRecommend fr = new FoodRecommend();
}