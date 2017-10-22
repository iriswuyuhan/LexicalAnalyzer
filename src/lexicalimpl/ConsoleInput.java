package lexicalimpl;

import lexicalservice.InputProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInput implements InputProcess {


    @Override
    public List<String> readInput() {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs=new ArrayList<>();
        try {
            inputs.add(br.readLine()+"\n");
            br.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return inputs;
    }
}
