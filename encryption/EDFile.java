package encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class EDFile {
    Scanner s = new Scanner(System.in);

    public void fileEncryption(){
        EDFile es = new EDFile();
        int r = (int)Math.floor(Math.random() * 5) + 1;
        String key = "" + es.keyGenerator() + es.keyGenerator() + es.keyGenerator() + r + es.keyGenerator() + es.keyGenerator() + es.keyGenerator() + es.keyGenerator();
        try {
            System.out.println("\n***************************");
            System.out.print("\nFile Path: ");
            String path = s.nextLine();
            FileInputStream fin = new FileInputStream(path);
            FileOutputStream fout = new FileOutputStream("EncryptedFile.txt");

            int i, j = 1;
            while ((i = fin.read()) != -1) {
                if (i != 13 && i != 32) {
                    //13 for new line.
                    //32 for space.
                    i = i + (int)r;
                    if(i == 13){
                        i = i-(int)r;
                    }
                }
                fout.write((char) i);
                j++;
            }
            System.out.println("Please, remember this code to decrypt file.");
            System.out.println("Key: " + key);
            System.out.println("This is your Decrypted file path: " + new File("EncryptedFile.txt").getAbsolutePath());
            System.out.println("\n***************************");
            fin.close();
            fout.close();
        } catch (Exception err) {
            err.fillInStackTrace();
        }
    }

    public void fileDecryption() {
        try {
            System.out.println("\n***************************");
            System.out.print("\nEncrypted File path: ");
            String path = s.nextLine();
            System.out.print("Key: ");
            String key = s.nextLine();
            int k = Integer.parseInt(String.valueOf(key.charAt(3)));
            System.out.print("File name: ");
            String name = s.next();

            FileInputStream fin = new FileInputStream(path);
            FileOutputStream fout = new FileOutputStream(name + ".txt");

            int i, j = 1;
            while ((i = fin.read()) != -1) {
                if (i != 13 && i != 32) {
                    //13 for new line.
                    //32 for space.
                    i = i - k;
                    if (i == 13) {
                        i = i + k; //j % 2 == 0 &&
                    }
                }
                fout.write((char) i);
                j++;
            }
            System.out.println("This is your Decrypted file path: " + new File(name + ".txt").getAbsolutePath());
            System.out.println("\n***************************");
            fin.close();
            fout.close();
        } catch (Exception err) {
            err.fillInStackTrace();
        }
    }
    public int keyGenerator(){
        return (int)Math.floor(Math.random() * 9) + 1;
    }
}
