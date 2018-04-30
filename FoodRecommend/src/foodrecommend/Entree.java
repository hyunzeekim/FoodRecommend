/*
 * Entree Subclass
 */
package foodrecommend;

import java.io.FileReader;
import java.io.IOException;

public class Entree extends Food {
    Food[] options;
    double[] ratings;
    Food[] finalOptions;
    Food[] finalMeals= new Food[2];
   
    public Entree(String n, double p, String r, int c, String s, String h, String c1, String c2, String c3){
        super(n,p,s,h,c,r,c1,c2,c3);             
    }   
    
    //Check Entrees
    public Food[] checkEnt(FileReader f) throws IOException {
        int index = 0;

        //Uses checkFood method from Food class to create a new array based off 3 conditions
        Food[] recommend = new Food[20];
        recommend = super.checkFood(f);
        
        //Compare inputs to menu
        for(int i = 0; i < recommend.length; i++){
            if(recommend[i].condition1.equals("Y") && fr.ent[0].equalsIgnoreCase("Y")){
                recommend[i] = options[index];
            }
            else if(recommend[i].condition2.equals("Y") && fr.ent[1].equalsIgnoreCase("Y")){
                recommend[i] = options[index];
            }
            else if(recommend[i].condition3.equals("Y") && fr.ent[2].equalsIgnoreCase("Y")){
               recommend[i] = options[index];
            }
            else{
                recommend[0] = options[0];
                recommend[1] = options[1];
            }
            index++;
        }
        
        return options;
    }
    
    //Get rating of food
    public double[] getRating(Food[] ff){
        //Recalculates the ratings for the new array of Food
        for (int i = 0; i < options.length; i++){
            ratings[i] = super.calculateRating(options[i]);
            
            if (ff[i].condition1.equals(fr.ent[0])) {
                ratings[i]++;
            }
            if (ff[i].condition2.equals(fr.ent[1])){
                ratings[i]++;
            }
            if (ff[i].condition3.equals(fr.ent[2])){
                ratings[i]++;
            }
            
            ratings[i] = (ratings[i]/13 * 100);
            
        }
        
        return ratings;
    }
    
    //Get final options
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
    
    //Get two
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
    
    //Get final two outputs
    public void printEntree() throws IOException {
        finalMeals = getFood();
        super.printFood(finalMeals[0], finalMeals[1]);
    }
    
    FoodRecommend fr = new FoodRecommend();
       
}
