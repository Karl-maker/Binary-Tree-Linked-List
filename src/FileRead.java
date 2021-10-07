
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRead {

    private String filename;
    private ArrayList<String> text = new ArrayList<String>();
    private List<String> lines = new ArrayList<String>();

    public FileRead(String filename){

        this.filename = filename;

        readTextFile(); //On creation of object file is read

    }

    public int getSize(){
        return text.size();
    }

    public String getText(int i){ //Get word based on index
        if(text.get(i) != null) {
            return text.get(i);
        }
        else{
            return null;
        }
    };

    public ArrayList<String> getTextList(){
        return text;
    }

    public void readTextFile(){

        String getword = "";

        try{
            Scanner scanner = new Scanner(new FileReader(filename));
            do{
                    while(scanner.hasNext()){
                        getword = scanner.next();
                        if (getword.equals("")){

                        }
                        else{
                            text.add(getword);
                        }
                    }
            }while(scanner.nextLine() != null);

        } catch(Exception e){
            System.out.println("File not found!");
        }
    }

    @Override
    public String toString() {
        return text + " ";
    }


}



