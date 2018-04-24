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
        
        
        
        return options;
     
    }
    
    public double findTwoMax(double[] a){
            double max = a[0];
            for(int b = 1; b < a.length; b++){
                if(a[b] > max){
                    max = a[b];
            }
        }
        return max;
        }
    
    
    
    
    
}
