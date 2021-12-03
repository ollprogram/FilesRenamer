package fr.ollprogram.filesrenamer.main;

import java.util.Scanner;

public class SysConsole {
    private Scanner sc;
    public SysConsole(){
        sc = null;
    }
    public void openScan(){
        sc = new Scanner(System.in);
    }
    public Scanner getSc() {
        return sc;
    }
    public void closeScan(){
        sc.close();
        sc = null;
    }
    public void println(String s){
        System.out.println(s);
    }
    public void print(String s){
        System.out.print(s);
    }
    public String getInput(String s){
        if(sc != null){
            println(s);
            print(">>>");
            return sc.nextLine();
        }
        else{
            throw new IllegalStateException("The scanner is closed");
        }
    }
}
