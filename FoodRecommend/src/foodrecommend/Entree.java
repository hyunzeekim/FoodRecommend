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
   
    //Same constructor made for this
     public Entree(String n, double p, String r, int c, String s, String h, String c1, String c2, String c3){
        super(n,p,r,c,s,h,c1,c2,c3);             
    }   
    
    public Food[] checkFood(FileReader f) throws IOException {
        int index = 0;
        
        FileReader entree = new FileReader("Entree.txt");
        
        //Uses checkFood method from Food class to create a new array based of 3 conditions
        for(int i = 0; i < super.checkFood(entree).length; i++){
            if(super.checkFood(entree)[i].condition1.equals("Y") && fr.meat == true){
                super.checkFood(entree)[i] = options[index];
            }
            else if(super.checkFood(entree)[i].condition2.equals("Y") && fr.seafood == true){
                super.checkFood(entree)[i] = options[index];
            }
            else if(super.checkFood(entree)[i].condition3.equals("Y") && fr.noodles == true){
                super.checkFood(entree)[i] = options[index];
            }
            else{
                super.checkFood(entree)[0] = options[index];
            }
            index++;
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
    
  public void printEntree(){
        super.printFood(finalOptions[0], finalOptions[1]);
    }
 
}
