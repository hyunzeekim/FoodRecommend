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
   
    
     public Entree(String n, double p, String r, int c, String s, String h, String c1, String c2, String c3){
        super(n,p,r,c,s,h,c1,c2,c3);             
    }   
    
    
    public Food[] checkFood(FileReader f) throws IOException {
        int index = 0;
        
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
        for (int i = 0; i < options.length; i++){
            ratings[i] = super.calculateRating(options[i]);
        }
        
        int[] x = getTwo(ratings)
        
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
            if (array[i] > max)
            {
                index2 = index1
                index1 = i;    
            }
            else if (array[i] > secondMax && array[i] < max)
            {
                index2 = i;
            }
        }
    return new int[] { index1, index2 };
    }
    

    
    
    
    
    
}
