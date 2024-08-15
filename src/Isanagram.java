import java.util.Arrays;
import java.util.Scanner;

public class Isanagram {
    public Boolean isAnagram(String sc, String sc1){
        Boolean s= true;
        String S1= sc.replaceAll("\\s", "");
        String S2= sc1.replaceAll("\\s", "");
        if (S1.length() != S2.length()) {
            s = false;
        }
        else {
            char[] s1 = S1.toCharArray();
            char[] s2 = S2.toCharArray();
            Arrays.sort(s1);
            Arrays.sort(s2);
            s = Arrays.equals(s1, s2);
        }
       return s;
    }

    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter a new word to check anagram");
         String sc = Sc.nextLine();
        System.out.println("Enter a second new word to check anagram");
         String sc1 =Sc.nextLine();

         Isanagram a = new Isanagram();
            Boolean b = a.isAnagram(sc ,sc1);


                if (b)
                    System.out.println("words are anagram");

                else
                    System.out.println("words are not anagram");



    }
}
