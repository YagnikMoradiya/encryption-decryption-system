package encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class EDImage {
    Scanner s = new Scanner(System.in);

    public void imageEncryption() {
        EDImage es = new EDImage();
        int r = (int)Math.floor(Math.random() * 5) + 1;
        String key = "" + es.keyGenerator() + es.keyGenerator() + es.keyGenerator() + r + es.keyGenerator() + es.keyGenerator() + es.keyGenerator() + es.keyGenerator();
        System.out.println("\n***************************");
        System.out.print("\nImage Path: ");
        String path = s.nextLine();
        try {
            FileInputStream fin = new FileInputStream(path);
            FileOutputStream fout = new FileOutputStream("image.txt");

            int i;
            while ((i = fin.read()) != -1) {
                fout.write(i + (int)r);
            }
            fin.close();
            fout.close();
            System.out.println("Key : " + key);
            System.out.println("This is your file path: " + new File("image.txt").getAbsolutePath());
            System.out.println("Done!!");
            System.out.println("\n***************************");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void imageDecryption(){
        System.out.println("\n***************************");
        System.out.print("\nEncrypted file path: ");
        String path = s.nextLine();
        System.out.print("Image Name: ");
        String name = s.nextLine();
        System.out.print("Extension: ");
        String extension = s.nextLine();
        if(extension.contains(".")){
            System.out.print("Please, Enter extension without . :");
            extension = s.nextLine();
        }
        System.out.print("Key: ");
        String key = s.nextLine();
        int k = Integer.parseInt(String.valueOf(key.charAt(3)));
        try{
            FileInputStream fin = new FileInputStream(path);
            FileOutputStream fout = new FileOutputStream(name + "." + extension);
            int i;
            while ((i = fin.read()) != -1) {
                fout.write(i - k);
            }
            System.out.println("Image Path: " + new File(name + "." + extension).getAbsolutePath());
            fin.close();
            fout.close();
            System.out.println("Done!!");
            System.out.println("\n***************************");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public int keyGenerator(){
        return (int)Math.floor(Math.random() * 9) + 1;
    }
}
