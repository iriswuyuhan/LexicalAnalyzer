package lexicaldata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TransferTable {
    private int[][] table;
    private final int ROW=9;
    private final int COLUMN=7;

    public TransferTable(){
        this.table=new int[][]{
                {1,2,6,4,5,6,7},
                {1,1,-2,-2,-2,-2,-2},
                {-2,2,-2,-2,-2,-2,-2},
                {-2,-2,-2,-2,-2,-2,-2},
                {-2,-2,-2,-2,-2,-2,-2},
                {-2,-2,-2,-2,-2,-2,-2},
                {-2,2,-2,-2,-2,-2,-2},
                {-2,-2,-2,-2,-2,-2,-2},
                {8,8,3,8,8,8,8}
        };
    }

    public TransferTable(String path){
        table=new int[ROW][COLUMN];
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line=null;
            for(int i=0;i<ROW;i++){
                line=br.readLine();
                String[] str=line.split("\t");
                for(int j=0;j<COLUMN;j++){
                    table[i][j]=Integer.parseInt(str[j]);
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public int nextState(int curState,char c){
        int nextChange=-1;
        if(isLetter(c)){
            nextChange=0;
        } else if(isDigit(c)){
            nextChange=1;
        } else if(c=='"'){
            nextChange=2;
        } else if(c=='='){
            nextChange=3;
        } else if(isCompute(c)){
            nextChange=4;
        } else if(c=='('){
            nextChange=5;
        } else if(c==')'){
            nextChange=6;
        } else if(isNewLine(c)){
            return -2;
        } else {
            return nextChange;
        }
        return table[curState][nextChange];
    }

    private boolean isLetter(char c){
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }

    private boolean isDigit(char c){
        return (c>='0'&&c<='9');
    }

    private boolean isCompute(char c){
        return (c=='+'||c=='-'||c=='*'||c=='/');
    }

    private boolean isNewLine(char c){
        return c=='\n';
    }
}
