package baby.shark;

import baby.shark.models.Search;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*ChangeClass changeClass=new ChangeClass();
        changeClass.start();*/

        File folder = new File("C:\\Users\\User\\IdeaProjects\\APJ2-Assignment1\\src\\txtFiles");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            Search search = new Search("Java", listOfFiles[i].getName());
            search.start();
            String s=search.getFilename();
            System.out.println(s);
        }
/*
        Search search=new Search("Java","2.txt");
        search.start();
        System.out.println(search.getFilename()+" "+search.getInput()+" "+search.sss());*/
    }

}
