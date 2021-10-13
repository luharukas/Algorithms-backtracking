import java.io.*;
import java.util.*;
import java.lang.*;
public class n_queen{
    public static int count=0;
    public static void main(String[] args){
        int n=4;
        int qpsf=0;
        boolean[][] board=new boolean[n][n];
        // board[0][0]=true;
        // board[1][2]=true;
        // for (int i=0;i<board.length;i++){
        //     for (int j=0;j<board[0].length;j++){
        //         System.out.println(isitsafe(board,i,j));
        //     }
        // }
        place(0,0,board,n,qpsf,"");
        System.out.println(count);
    }
    private static void place(int row, int col, boolean[][] board, int nq, int qpsf,String str) {
        if (qpsf==nq){
            count++;
            return ;
        }
        if (col==board[0].length){
            row++;
            col=0;
        }
        if (row==board.length){
            return;
        }
        
        if (isitsafe(board,row,col)){
            board[row][col]=true;
            place(row, col+1, board, nq, qpsf+1,str+"["+row+"-"+col+"]");
            board[row][col]=false;
        }
        place(row, col+1, board, nq, qpsf,str);

    }
    private static boolean isitsafe(boolean[][] board, int row,int col){
        int r,c;
        r=row-1;
        c=col;
        while(r>=0){
            if (board[r][c]){
                return false;
            }
            r--;
        }
        r=row;
        c=col-1;
        while(c>=0){
            if (board[r][c]){
                return false;
            }
            c--;
        }
        r=row-1;
        c=col-1;
        while(r>=0 && c>=0){
            if (board[r][c]){
                return false;
            }
            r--;
            c--;
        }
        r=row-1;
        c=col+1;
        while(r>=0 && c<board[0].length){
            if (board[r][c]){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
    
}