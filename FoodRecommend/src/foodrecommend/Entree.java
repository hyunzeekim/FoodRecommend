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
    boolean veg;
    boolean highcarbs;
   
    
    public Entree( double p, boolean s, boolean h, int c, String r, boolean m, boolean v, boolean h){
        super(p,s,g,c,r);
        this.meat = m;
        this.veg = v;
        this.highcarbs = h;
                
    }   
    
    public Food checkFood(Food other){
        super.checkFood;
        
        if(other.meat == true && this.meat == true){
        }
        
        if(other.veg == true && this.veg == true){
        }
        
        if(other.highcarbs == true && this.highcarbs == true){
        }
    }
    
    public int checkRating(){
        
    }
    
    
    
    
    
}
