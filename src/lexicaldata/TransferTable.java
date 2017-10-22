package lexicaldata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TransferTable {
    private int[][] table;
    private final int ROW=7;
    private final int COLUMN=5;

    public TransferTable(){
        this.table=new int[][]{
                {1,2,6,4,5},
                {1,1,-2,-2,-2},
                {-2,2,-2,-2,-2},
                {-2,-2,-2,-2,-2},
                {-2,-2,-2,-2,-2},
                {-2,-2,-2,-2,-2},
                {6,6,3,6,6}
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
                    System.out.println(str[j]);
                    table[i][j]=Integer.parseInt(str[j]);
                }
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
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
        } else if(isWhiteSpace(c)){
            return curState;
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

    private boolean isWhiteSpace(char c){
        return (c=='\t'||c==' ');//换行符是语句结束的标志
    }

    private boolean isNewLine(char c){
        return c=='\n';
    }
}
