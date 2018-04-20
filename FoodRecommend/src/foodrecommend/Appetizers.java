/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommend;

/**
 *
 * @author hyunzeekim
 */
public class Appetizers extends Food {
    boolean bread;
    boolean salad;
    boolean soup;
   
    
    public Appetizers( double p, boolean s, boolean h, int c, String r, boolean b, boolean sal, boolean sou){
        super(p,s,g,c,r);
        this.bread = b;
        this.salad = sal;
        this.soup = sou;
                
    }   
    
    public void checkFood(){
        
    }
    
}
