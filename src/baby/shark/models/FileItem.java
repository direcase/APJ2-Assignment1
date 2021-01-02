package baby.shark.models;

import java.io.File;

public class FileItem {
    private final String path = "C:\\Users\\User\\IdeaProjects\\APJ2-Assignment1\\src\\txtFiles";
    private final String pathToIcons="C:\\Users\\User\\IdeaProjects\\not icloud\\src\\main\\java\\item\\icons\\";
    private final File folder = new File(path);
    private final File iconFolder = new File(pathToIcons);
    private File subfolder;


    public File getFolder() {
        return folder;
    }

    public String getPath() {
        return path;
    }

    public String getType(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }

    public Long getSize(File file) {

        return file.getTotalSpace();
    }

    public String getImg(File file) {
        String fileType = getType(file);
        for (File icon : iconFolder.listFiles()) {
            if (fileType.equals(icon.getName().substring(0, icon.getName().lastIndexOf(".")))) {
                return icon.getName();
            }
        }
        return "none";
    }

    public boolean isItFolder(File file){
        if(true){
            return true;
        }
        return false;
    }

    public File getSubFolder(String folderPath){
        return subfolder = new File(folderPath);
    }
}
