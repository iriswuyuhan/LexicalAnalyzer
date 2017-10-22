package lexicalimpl;

import lexicalservice.InputProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput implements InputProcess {
    private final String path="./resource/input.txt";

    @Override
    public List<String> readInput() {
        List<String> inputs=new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line=null;
            while ((line=br.readLine())!=null){
                inputs.add(line+"\n");
            }
            br.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return inputs;
    }
}
