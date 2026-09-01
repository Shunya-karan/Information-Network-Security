import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static void main(String [] args)
    {
      Scanner sc = new Scanner(System.in);
       System.out.print("Enter p: ");
        int p = sc.nextInt();
        System.out.print("Enter q: ");
        int q = sc.nextInt();
        int n = p * q;
        int phi = (p - 1) * (q - 1);
         //  to calculate e
        int e = 2;
        while (e < phi) {
            int a = e;
            int b = phi;
            // to calculate gcd
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            if (a == 1)
                break;
            e++;
        }
        // to calculate d
        int d = 1;
        while ((d * e) % phi != 1) {
            d++;
        }

        System.out.println("n = " + n);
        System.out.println("phi = " + phi);
        System.out.println("e = " + e);
        System.out.println("d = " + d);

        System.out.print("Enter message: less than  "+n +" ");
        int message = sc.nextInt();

        BigInteger M = BigInteger.valueOf(message);
        BigInteger E = BigInteger.valueOf(e);
        BigInteger N = BigInteger.valueOf(n);
        BigInteger D=BigInteger.valueOf(d);

        BigInteger encrypted = M.modPow(E, N);
        BigInteger decrypted = encrypted.modPow(
               D, N);

        System.out.println("Encrypted = " + encrypted);
        System.out.println("Decrypted = " + decrypted);
        sc.close();
    }
}