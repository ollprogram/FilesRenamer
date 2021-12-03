package fr.ollprogram.filesrenamer.main;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        SysConsole c = new SysConsole();
        c.openScan();
        Path path = Paths.get(c.getInput("Absolute path of the directory :"));
        if(path.isAbsolute()){
            File dir = path.toFile();
            if(dir.isDirectory()){
                manageFiles(dir);
            }else c.println("This is not a directory");
        }else c.println("This is not an absolute path");
        c.closeScan();
    }

    public static void manageFiles(File dir){
        SysConsole c = new SysConsole();
        FilesManager manager = new FilesManager(dir);
        c.openScan();
        c.println("Programs : \n" +
                "| 1. change extension | 2. rename all |");
        String answer = c.getInput("Choose your program :");
        if(answer.equals("1")){
            String targetExt = c.getInput("Targeted extension :");
            String extension = c.getInput("New extension :");
            c.println("modifying...");
            NumberOf n = manager.changeExtensions(targetExt, extension);
            c.println(n.success()+" extensions changed of "+n.max());
        }
        else{
            String target = c.getInput("Targeted extension :");
            String name = c.getInput("New indexed name :");
            c.println("modifying...");
            NumberOf n = manager.renameWithIndexes(target, name);
            c.println(n.success()+" extensions changed of "+n.max());
        }
        c.closeScan();
    }
}
