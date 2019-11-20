import javax.swing.JFileChooser;
import java.io.*;
import java.util.Scanner;

public class FChooser {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(".");
        int returnValue = chooser.showOpenDialog(null);
        File selectedFile = null;
        if(returnValue == JFileChooser.APPROVE_OPTION){
            selectedFile = chooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
        }
        try{
            RandomAccessFile source = new RandomAccessFile(selectedFile, "rw");
            RandomAccessFile destination = new RandomAccessFile("custom.dat", "rw");
            while(true){
                destination.writeByte(source.readByte());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
