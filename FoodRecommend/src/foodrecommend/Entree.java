/*
 * Entree Subclass
 */
package foodrecommend;

import java.io.FileReader;
import java.io.IOException;


public class Entree extends Food {
    Food[] options = new Food[20];
    double[] ratings = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};;
    Food[] finalOptions = new Food[20];
    Food[] finalMeals= new Food[2];
   
     public Entree(String n, double p, String r, int c, String s, String h, String c1, String c2, String c3){
        super(n,p,s,h,c,r,c1,c2,c3);             
    }   
    
    //Check food
    public Food[] checkEnt(FileReader f) throws IOException {
        int index = 0;

        //Uses checkFood method from Food class to create a new array based of 3 conditions
        Food[] recommend = new Food[20];
        recommend = super.checkFood(f);
        
        //Choose based on the user's preference of entree type
        for(int i = 0; i < recommend.length; i++){
            if (recommend[i] != null) {
                
                if(recommend[i].condition1.equalsIgnoreCase("Y") && fr.ent[0].equalsIgnoreCase("Y")){
                    
                    options[index] = recommend[i];
                }
                else if(recommend[i].condition2.equalsIgnoreCase("Y") && fr.ent[1].equalsIgnoreCase("Y")){
                    
                    options[index] = recommend[i];
                }
                else if (recommend[i].condition3.equalsIgnoreCase("Y") && fr.ent[2].equalsIgnoreCase("Y")){
                    
                    options[index] = recommend[i];
                }
            }
            index++;
        }
        
        if (options.length == 0) {
            options[0] = recommend[0];
            options[1] = recommend[1];
        }
        
        return options;
    }
    
    //get rating for food
    public double[] getRating(Food[] ff){
        //Recalculates the ratings for the new array of Food
        if (ff != null) {
            for (int i = 0; i < ff.length; i++){
                if (ff[i] != null) {
                    ratings[i] = super.calculateRating(ff[i]);
               
                    if (fr.bread != null) {
                        if (ff[i].condition1.equals("Y") && fr.meat.equalsIgnoreCase("Meat")){
                            ratings[i]++;
                        }
                    }
                    if (fr.salad != null) {
                        if (ff[i].condition2.equals("Y") && fr.seafood.equalsIgnoreCase("Seafood")){
                            ratings[i]++;
                        }
                    }
                    if (fr.soup != null) {
                        if (ff[i].condition3.equals("Y") && fr.noodles.equalsIgnoreCase("Noodles")){
                            ratings[i]++;
                        }
                    }
                    ratings[i] = (ratings[i]/13 * 100); 
                }            
            }
        }
        return ratings;
    }
    
    //get Food
    public Food[] getFood() throws IOException {
        //Used to find highest ratings, and returns an array of index values
        FileReader entree = new FileReader("Entree.txt");
        Food[] option = checkEnt(entree); 
        double[] rrating = getRating(option);
        int[] x = getTwo(rrating);
        
        //Uses index values to create a new Food array with the two best options
        for (int i = 0; i < x.length; i++){
            finalOptions[x[i]] = option[x[i]];         
        }
        
        return finalOptions;
    }
    
    //get two
    public static int[] getTwo(double[] array){
      int index1 = 0;
      int index2 = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > index1)
            {
                index2 = index1;
                index1 = i;    
            }
            else if (array[i] > index2 && array[i] < index1)
            {
                index2 = i;
            }
        }
    return new int[] { index1, index2 };
    }
    
    //print entree
    public String printEntree() throws IOException {
        finalMeals = getFood();
        String result = super.printFood(finalMeals);
        System.out.println(result);
        return result;
    }
    
    FoodRecommend fr = new FoodRecommend();
       
}
