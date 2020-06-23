/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Bea
 */
public class Match {
    
    private final int rows;
    private final int columns;
    private int row;
    private int column;
    private Scanner sc=new Scanner(System.in);
    private int turn=1;
    private String position;
    private String[][] board;
    
    public Match(){
        this.rows=6;
        this.columns=7;
        board=new String[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                board[i][j]="- ";
            }
        }
    }
    
    public int getRow(){
        return row;
    }
    
    public void setRow(int row){
        this.row=row;
    }
    
    public int getColumn(){
        return column;
    }
    
    public void setColumn(int column){
        this.column=column;
    }
    
    public void setTurn(){
        this.turn=turn+1;
    }
    
    public int getTurn(){
        return turn;
    }
    
    public void printMatch(){
        
        for(int i=0;i<rows;i++){
            System.out.print(rows-i + " ");
            for(int j=0;j<columns;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g");
    }
    
    private int positionRow(int row){
        return 6-row;
    }
    
    private int positionColumn(char column){
        return column - 'a';
    }
    
    public void getPosition(){
        System.out.print("Column: ");
        
        char x=sc.next().charAt(0);
        int c=positionColumn(x);
        setColumn(c);
        
    }
    
    public void playBlue() throws positionException{
        
        do{
            getPosition();
            if(column>6 || column<0){
                throw new positionException("Invalid Position");
            }
            if(verifePosition()==-1){
                throw new positionException("Invalid Position");
            }else{
                this.row=verifePosition();
            }
        }while(column>6 || column<0);
        
        board[row][column]="o ";
        setTurn();
    }
    
    public void playRed() throws positionException{
        
        do{
            getPosition();
            if(column>6 || column<0){
                throw new positionException("Invalid Position");
            }
            if(verifePosition()==-1){
                throw new positionException("Invalid Position");
            }else{
                this.row=verifePosition();
            }
            printPlays();
        }while(column>6 || column<0);
        
        board[row][column]="x ";
        setTurn();
    }
    
    public void printPlays(){
        
        for(int i=0;i<rows;i++){
            System.out.print(rows-i + " ");
            for(int j=0;j<columns;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g");
        
    }
    
    public void controler(){
        
        printPlays();
        
        if(turn%2==0){
            System.out.println("Turn O: ");
            try{
                playBlue();
                board[row][column]="o ";
            }catch(positionException e){
                System.out.println("Invalid Position");
            }

        } else{
            System.out.println("Turn X: ");
            try{
                playRed();
                board[row][column]="x ";
            }catch(positionException e){
                System.out.println("Invalid Position");
            }
        }
            
        
    }
    
    public int exist(int row, int column){
        
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(board[i][j].equals(board[row][column]) && !"- ".equals(board[i][j])){
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public int verifePosition(){
        
        for(int i=5;i>=0;i--){
            if("- ".equals(board[i][column])){
                    return i;
            }
        }
        return -1;
    }
    
    public int winnerVertical(){
        
        for(int i=5;i>2;i--){
            for(int j=0;j<columns;j++){
                if(board[i][j].equals(board[i-1][j]) && board[i-1][j].equals(board[i-2][j]) && board[i-2][j].equals(board[i-3][j]) && ("o ".equals(board[i][j]) || "x ".equals(board[i][j]))){
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public int winnerHorizontal(){
        
        for(int i=0;i<rows;i++){
            for(int j=5;j>2;j--){
                if(board[i][j].equals(board[i][j-1]) && board[i][j-1].equals(board[i][j-2]) && board[i][j-2].equals(board[i][j-3]) && ("o ".equals(board[i][j]) || "x ".equals(board[i][j]))){
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public int winnerNE(){
        
        for(int i=5;i>2;i--){
            for(int j=0;j<columns-3;j++){
                if(board[i][j].equals(board[i-1][j+1]) && board[i-1][j+1].equals(board[i-2][j+2]) && board[i-2][j+2].equals(board[i-3][j+3]) && ("o ".equals(board[i][j]) || "x ".equals(board[i][j]))){
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public int winnerSW(){
        
        for(int i=3;i<rows;i++){
            for(int j=5;j>2;j--){
                if(board[i][j].equals(board[i-1][j-1]) && board[i-1][j-1].equals(board[i-2][j-2]) && board[i-2][j-2].equals(board[i-3][j-3]) && ("o ".equals(board[i][j]) || "x ".equals(board[i][j]))){
                    return 1;
                }
            }
        }
        return 0;
    }
    
    public int draw(){
        int soma=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(!"- ".equals(board[i][j])){
                    soma+=1;
                }
            }
        }
        if(soma==42){
            //empate
            return 1;
        }else
            return 0;
        
    }
    
}
