import java.util.Scanner;

public class leetcode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("enter new number");
            int si = sc.nextInt();
            if(si==0)
                break;
            System.out.println(si);
        }
    }
}
