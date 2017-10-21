package lexicaldata;

public class TransferTable {
    private int[][] table;

    public TransferTable(){
        this.table=new int[][]{
                {1,2,6,4,5},
                {1,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {6,6,3,6,6}
        };
    }

    public TransferTable(String path){

    }

    public int nextState(int curState,char c){
        return 0;
    }

}
