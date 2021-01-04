package baby.shark.models;

import baby.shark.Synchronize.Buffer;

import java.io.File;

public class ChangeClass implements Runnable{
    File folder = new File("C:\\Users\\User\\IdeaProjects\\APJ2-Assignment1.2\\src\\txtFiles");
    File[] listOfFiles = folder.listFiles();
    private final Buffer sharedLocation;

    public ChangeClass(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        for (int i = 0; i < listOfFiles.length; i++) {
            try{
                if (listOfFiles[i].getName()!="C:\\Users\\User\\IdeaProjects\\APJ2-Assignment1.2\\src\\txtFiles\\"+(i+1)+".txt"){
                    Thread.sleep(1000);
                    sharedLocation.blockingPut(i+1);
                    System.out.println(listOfFiles[i]);
                    listOfFiles[i].renameTo(new File("C:\\Users\\User\\IdeaProjects\\APJ2-Assignment1.2\\src\\txtFiles\\"+sharedLocation.blockingGet()+".txt"));

                }


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

        }
    }
}
