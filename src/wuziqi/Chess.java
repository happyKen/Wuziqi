/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wuziqi;

/**
 *
 * @author zekeng
 */
public class Chess {
    
    private static final int BLACK = 2;
    private static final int WHITE = 1;
    private static final int EMPTY = 0;
   
    private static final int MAX = 8;
    private static final int COUNT = 5;
    private int who=2;//轮到谁
    private int[][] chess;
    public Chess(){
        chess = new int[MAX][MAX];
        //初始化棋盘
        for(int i=0;i<MAX;i++){
            for(int j=0;j<MAX;j++){
                chess[i][j]=EMPTY;
            }
        }
       
    }
    public void addChess(int who,int x,int y){
        if(chess[x][y]==EMPTY){
            chess[x][y]=who;
        }else{
           // System.out.println("该位置已有棋子");
            Tip tip = new Tip("该位置已有棋子");
        }
    }
    public boolean checkX(int m,int x,int y){
        int count =0;
        while(true){
        if(x<0 || chess[x][y]!=m){
         break;   
        }
        x--;
        count++;
        }
        if(count==COUNT)
            return true;
        else
            return false;
        
    }
    public boolean checkY(int m,int x,int y){
        int count =0;
        while(true){
        if(y<0 || chess[x][y]!=m){
         break;   
        }
        y--;
        count++;
        }
        if(count==COUNT)
            return true;
        else
            return false;
        
    }
   public boolean checkXY(int m,int x,int y){
        int count =0;
        while(true){
        if(x<0 ||y<0|| chess[x][y]!=m){
         break;   
        }
        y--;
        x--;
        count++;
        }
       if(count==COUNT)
            return true;
        else
            return false;
        
    }
   public boolean checkYX(int m,int x,int y){
        int count =0;
        while(true){
        if(x<0 ||y>MAX|| chess[x][y]!=m){
         break;   
        }
        y++;
        x--;
        count++;
        }
       if(count==COUNT)
            return true;
        else
            return false;
        
    }
            
    public boolean checkWin(int m){
        boolean ch = false;
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
              if(chess[x][y]==m){
        if(checkX(m,x,y)
                ||checkY(m,x,y)
                ||checkXY(m,x,y)
                ||checkYX(m,x,y))
           ch = true;
              }
            }
        }
        return ch;
    }
    public void setWho(int who){
        this.who = who;
    }
    public int getWho(){
        return who;
    }
    public int checkWhoWin(){
        if(checkWin(2))
            return 2;//黑方胜利
        else if(checkWin(1))
            return 1;//白方胜利
            //System.out.println("白方胜利");
        else
            return 0;
            //System.out.println("平手");
    }
}
