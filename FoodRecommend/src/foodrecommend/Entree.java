/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommend;

/**
 *
 * @author hyunzeekim
 */
public class Entree extends Food {
    boolean meat;
    boolean seafood;
    boolean noodles;
   
    
    public Entree( double p, boolean s, boolean h, int c, String r, boolean m, boolean s, boolean n){
        super(p,s,g,c,r);
        this.meat = m;
        this.seafood = s;
        this.noodles = n;
                
    }   
    
    public Food checkFood(Food other){
        super.checkFood;
        
        if(other.meat == true && this.meat == true){
        }
        
        if(other.seafood == true && this.veg == true){
        }
        
        if(other.noodles == true && this.highcarbs == true){
        }
    }
    
    public int checkRating(){
        
    }
    
    
    
    
    
}
