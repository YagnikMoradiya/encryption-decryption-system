/*
ENCRYPTION DECRYPTION SYSTEM
*/

import encryption.EDFile;
import encryption.EDImage;
import encryption.EDString;

import java.util.Scanner;

public class Call {
    public static void main(String[] args){
        Call c = new Call();
        Scanner scanf = new Scanner(System.in);

        do {
            System.out.println("\n***************************");
            System.out.println("\n1) Encryption");
            System.out.println("2) Decryption");
            System.out.println("9) Exit");
            System.out.println("\n***************************");
            System.out.print("\nChoose option: ");
            int n = scanf.nextInt();

            switch (n){
                case 1: {
                    c.encryption();
                    break;
                }
                case 2:{
                    c.decryption();
                    break;
                }
                case 9: System.exit(0);
                default:
                    System.out.println("Incorrect Option selected.");
            }
        }while(true);
    }

    public void encryption(){
        EDFile f = new EDFile();
        EDString s = new EDString();
        EDImage i = new EDImage();
        Scanner scanf = new Scanner(System.in);

        System.out.println("\n***************************");
        System.out.println("\n1) File encryption");
        System.out.println("2) String encryption");
        System.out.println("3) Image encryption");
        System.out.println("\n*******************************");
        System.out.print("\nChoose option: ");
        int n = scanf.nextInt();
        switch (n) {
            case 1:
                f.fileEncryption();
                break;
            case 2:
                s.stringEncryption();
                break;
            case 3:
                i.imageEncryption();
                break;
            default:
                System.out.println("Incorrect option selected.");
        }
    }

    public void decryption(){
        EDFile f = new EDFile();
        EDString s = new EDString();
        EDImage i = new EDImage();
        Scanner scanf = new Scanner(System.in);

        System.out.println("\n***************************");
        System.out.println("\n1) File decryption");
        System.out.println("2) String decryption");
        System.out.println("3) Image decryption");
        System.out.println("\n***************************");
        System.out.print("\nChoose option: ");
        int n = scanf.nextInt();
        switch (n) {
            case 1:
                f.fileDecryption();
                break;
            case 2:
                s.stringDecryption();
                break;
            case 3:
                i.imageDecryption();
                break;
            default:
                System.out.println("Incorrect option selected.");
        }
    }
}
