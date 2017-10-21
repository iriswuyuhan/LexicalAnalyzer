package lexicaldata;

public class Token {
    private TokenType type;
    private int attrVal;
    private String litrVal;

    //本代码采用的
    public Token(TokenType type,int attrVal,String litrVal){
        this.type=type;
        this.attrVal=attrVal;
        this.litrVal=litrVal;
    }

    //标准的？
    public Token(TokenType type,int attrVal){
        this.type=type;
        this.attrVal=attrVal;
    }

    //打印token
    public void print(){
        System.out.print("<"+type+","+attrVal+","+litrVal+">");
    }
}
