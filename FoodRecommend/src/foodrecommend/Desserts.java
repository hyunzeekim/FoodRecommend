/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommend;

/**
 *
 * @author hyunzeekim
 */
public class Desserts extends Food {
    boolean beverage;
    boolean fruit;
    boolean cake;
   
    
    public Entree( double p, boolean s, boolean h, int c, String r, boolean b, boolean f, boolean ca){
        super(p,s,g,c,r);
        this.beverage = b;
        this.fruit = f;
        this.cake = ca;
                
    }   
    
    public Food checkFood(Food other){
        super.checkFood;
        
        if(other.beverage == true && this.beverage == true){
        }
        
        if(other.fruit == true && this.fruit == true){
        }
        
        if(other.cake == true && this.cake == true){
        }
        
        
    }
    
}
