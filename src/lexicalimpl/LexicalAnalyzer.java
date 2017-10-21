package lexicalimpl;

import lexicaldata.Token;
import lexicaldata.TokenList;
import lexicaldata.TokenType;
import lexicaldata.TransferTable;
import lexicalservice.Analyzer;

import java.util.List;

public class LexicalAnalyzer implements Analyzer{
    private TokenList tokenList;
    private TransferTable transferTable;

    public LexicalAnalyzer(){
        tokenList=new TokenList();
        transferTable=new TransferTable();
    }

    //暂时只能分析赋值语句
    @Override
    public TokenList lexicalAnalyzer(List<String> inputs) {
        int loc=1;
        for(String input:inputs){
            int state=0;
            String litrName="";
            TokenType tokenType=TokenType.NOTYPE;
            for(int i=0;i<input.length();i++){
                char c=input.charAt(i);
                int tempState=transferTable.nextState(state,c);
                if(tempState==-2){
                    litrName=litrName+c;
                    tokenType=TokenType.values()[state];
                    Token token=new Token(tokenType,loc,litrName);
                    tokenList.add(token);
                }
            }
        }
        return tokenList;
    }
}
