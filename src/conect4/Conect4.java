/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect4;

/**
 *
 * @author Bea
 */
public class Conect4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Conect 4!!!");
        System.out.println();
        
        Match match=new Match();
        
        
        while(match.winnerVertical()==0 && match.winnerHorizontal()==0 && match.winnerNE()==0 && match.winnerSW()==0 && match.draw()==0){
            match.controler();
                    
        }
        
        match.printPlays();
        
        if(match.draw()==1 && match.winnerVertical()==0 && match.winnerHorizontal()==0 && match.winnerNE()==0 && match.winnerSW()==0){
            System.out.println("Draw");
        }else{
            if (match.getTurn()%2==0){
                System.out.println("Winner X");
            }else{
                System.out.println("Winner O");
            }
        }
        
        System.out.println("End");
        
        
        
    }
    
}
