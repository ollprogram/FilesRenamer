package fr.ollprogram.filesrenamer.main;

import java.io.File;

public class FilesManager {
    private final File dir;
    public FilesManager(File dir){
        this.dir = dir;
    }
    public NumberOf changeExtensions(String target, String extension){
        int success = 0;
        int max = 0;
        File[] files = dir.listFiles();
        if(files == null)return new NumberOf(0, 0);
        for(File f : files){
            SimpleFile file = new SimpleFile(f.getAbsolutePath());
            if(file.haveExtension(target)){
                max++;
                if(file.changeExtension(extension))success++;
            }
        }
        return new NumberOf(success, max);
    }

    public NumberOf renameWithIndexes(String target, String name){
        int success = 0;
        int max = 0;
        File[] files = dir.listFiles();
        if(files == null)return new NumberOf(0, 0);
        for(File f : files){
            SimpleFile file = new SimpleFile(f.getAbsolutePath());
            if(file.haveExtension(target)){
                max++;
                if(file.renameTo(file.getAbsolutePath().replace(file.getName()
                        ,name+"_"+success+
                                (file.getExtension().equals("")?"":"."+file.getExtension()))))success++;
            }
        }
        return new NumberOf(success, max);
    }
}
