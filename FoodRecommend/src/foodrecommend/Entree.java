/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommend;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author hyunzeekim
 
 */
public class Entree extends Food {
    Food[] options;
    double[] ratings;
    Food[] finalOptions;
    FoodRecommend fr = new FoodRecommend();
   
    //Same constructor made for this
     public Entree(String n, double p, String r, int c, String s, String h, String c1, String c2, String c3){
        super(n,p,r,c,s,h,c1,c2,c3);             
    }   
    
    
    public Food[] checkFood(FileReader f) throws IOException {
        int index = 0;
        //Uses checkFood method from Food class to create a new array based of 3 conditions
        for(int i = 0; i < super.checkFood(f).length; i++){
            if(super.checkFood(f)[i].condition1.equals("Y") && fr.meat == true){
                super.checkFood(f)[i] = options[index++];
            }
            if(super.checkFood(f)[i].condition2.equals("Y") && fr.seafood == true){
                super.checkFood(f)[i] = options[index++];
            }
            if(super.checkFood(f)[i].condition3.equals("Y") && fr.noodles == true){
                super.checkFood(f)[i] = options[index++];
            }
                
        }
     
        //Recalculates the ratings for the new array of Food
        for (int i = 0; i < options.length; i++){
            ratings[i] = super.calculateRating(options[i]);
            
            if (options[i].condition1.equals("Y") && fr.meat == true){
                ratings[i]++;
            }
            if (options[i].condition2.equals("Y") && fr.seafood == true){
                ratings[i]++;
            }
            if (options[i].condition3.equals("Y") && fr.noodles == true){
                ratings[i]++;
            }
            
            ratings[i] = (ratings[i]/13 * 100);
            
        }
        
        //Used to find highest ratings, and returns an array of index values
        int[] x = getTwo(ratings);
        
        //Uses index values to create a new Food array with the two best options
        for (int i = 0; i < x.length; i++){
            finalOptions[x[i]] = options[x[i]];         
        }
        
        return finalOptions;
    }
    
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
    
  public void printFood(Food[] f){
        double percentage1 = calculateRating(f[0]);
        double percentage2 = calculateRating(f[1]);
        
        System.out.println("Your first choice recommended meal is:");
        System.out.println("");
        System.out.println("Name" + "\t " + "Price" + " \t" + "Spicy/Mild" + "\t "  + "Hot/Cold" + "\t" + 
                "Calories" +  "\t" + "Any Used Restricted Ingrediants");        
       System.out.println(f[0].name + "\t " + f[0].price + " \t"
                + f[0].spicy + "\t "  + f[0].hot + "\t" + 
                f[0].calorie +  "\t" +  f[0].restrictions + "\t" +
                f[0].condition1 +  "\t" + f[0].condition2 +  "\t" + 
               f[0].condition3);
        
        System.out.println(percentage1);
        
        System.out.println("");
        
        System.out.println("Your second choice recommended meal is:");
        System.out.println("");
        System.out.println("Name" + "\t " + "Price" + " \t" + "Spicy/Mild" + "\t "  + "Hot/Cold" + "\t" + 
                "Calories" +  "\t" + "Any Used Restricted Ingredients");        
       System.out.println(f[1].name + "\t " + f[1].price + " \t"
                + f[1].spicy + "\t "  + f[1].hot + "\t" + 
                f[1].calorie +  "\t" +  f[1].restrictions + "\t" +
                f[1].condition1 +  "\t" + f[1].condition2 +  "\t" + 
                f[1].condition3);
       
        System.out.println(percentage2);        
    }
    
    
    
    
    
}
