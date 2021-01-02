package baby.shark.models;

import baby.shark.Synchronize.Buffer;

import java.io.*;

public class Search extends Thread{

    String input;
    String filename;
    //private final Buffer sharedLocation;
    int count=0;
    String res=null;

    public Search(String input, String filename) {
        this.input = input;
        this.filename=filename;
    }

    @Override
    public void run() {
        File f1=new File("C:\\Users\\User\\IdeaProjects\\APJ2-Assignment1\\src\\txtFiles\\"+filename); //Creation of File Descriptor for input file
        String[] words=null;  //Intialize the word Array
        FileReader fr = null;  //Creation of File Reader object

        BufferedReader br; //Creation of BufferedReader object
        String s;  //Intialize the word to zero

        try {
            fr = new FileReader(f1);
            br=new BufferedReader(fr);
            while((s=br.readLine())!=null)   //Reading Content from the file
            {
                words=s.split(" ");  //Split the word using space
                for (String word : words)
                {
                    if (word.equals(input))   //Search for the given word
                    {
                        sss();   //If Present increase the count by one
                    }
                }
            }
            if(count!=0)  //Check for count not equal to zero
            {
                res="The given word is present for "+count+ " Times in the file  "+filename;
            }
            else
            {
                res="The given word is not present in the file";
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);

    }

    public int sss(){
        count++;
        return count;

    }
    public String getInput() {
        return input;
    }

    public String getFilename() {
        return filename;
    }

    public int getCount() {
        return count;
    }

    public String getRes() {
        return res;
    }
}
