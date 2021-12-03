package fr.ollprogram.filesrenamer.main;

import java.io.File;

public class SimpleFile extends File {
    private String extension;
    /**
     * Creates a new {@code File} instance by converting the given
     * pathname string into an abstract pathname.  If the given string is
     * the empty string, then the result is the empty abstract pathname.
     *
     * @param pathname A pathname string
     * @throws NullPointerException If the {@code pathname} argument is {@code null}
     */
    public SimpleFile(String pathname) {
        super(pathname);
        extension = null;
        retrieveExtension();
    }
    private void retrieveExtension(){
        String name = this.getName();
        StringBuilder tmp = new StringBuilder();
        for(int i = name.length()-1; i >= 1; i--){
            if(name.charAt(i) == '.'){
                this.extension = tmp.toString();
                return;
            }
            tmp.insert(0, name.charAt(i));
        }
    }

    public boolean changeExtension(String extension){
        if(!extension.equals("")){
            extension = "."+extension;
        }
        if(this.extension != null){
            return renameTo(this.getAbsolutePath().replace("."+this.extension, extension));
        }
        else{
            return renameTo(this.getAbsolutePath()+extension);
        }
    }

    public boolean renameTo(String pathname) {
        return this.renameTo(new File(pathname));
    }

    public String getExtension() {
        if(extension == null)return "";
        return extension;
    }

    public boolean haveExtension(String extension){
        return (this.extension == null && extension.equals("")) || (this.extension != null && this.extension.equals(extension));
    }
}
