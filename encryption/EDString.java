package encryption;

import java.util.Scanner;

public class EDString {
    Scanner s = new Scanner(System.in);

    public void stringEncryption(){
        EDString es = new EDString();
        int r = (int)Math.floor(Math.random() * 5) + 1;
        String key = "" + es.keyGenerator() + es.keyGenerator() + es.keyGenerator() + r + es.keyGenerator() + es.keyGenerator() + es.keyGenerator() + es.keyGenerator();
        System.out.println("\n***************************");
        System.out.print("\nEnter string: ");
        String str = s.nextLine();
        byte b[] = str.getBytes();
        for (int i= 0; i<b.length; i++) {
            if(b[i] != 32 && b[i] != 13 && b[i]<(127-r) ){
                b[i] = (byte) (b[i] + (int)r);
            }
            System.out.print((char) b[i]);
        }
        System.out.println("\nKey: " + key);
        System.out.println("Done!!");
        System.out.println("\n***************************");
    }

    public void stringDecryption(){
        System.out.println("\n***************************");
        System.out.print("\nEnter string: ");
        String str = s.nextLine();
        System.out.print("Enter Key: ");
        String key = s.nextLine();
        int k = Integer.parseInt(String.valueOf(key.charAt(3)));
        byte b[] = str.getBytes();
        for (int i= 0; i<b.length; i++) {
            if(b[i] != 32 && b[i] != 13 && b[i]<(127-k) ){
                b[i] = (byte) (b[i] - k);
            }
            System.out.print((char) b[i]);
        }
        System.out.println();
        System.out.println("\n***************************");
    }

    public int keyGenerator(){
        return (int)Math.floor(Math.random() * 9) + 1;
    }
}
