
import java.util.*;
public class monoalphabetics{
    
    public static void main(String[]args){
        String key="ZXCBMNASDFGHJKLQWERTYUIOPV";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Plain Text");
        String pt=sc.next().toUpperCase();
        String ct = encrypt(pt, key);
        String pt1=decrypt(ct,key);
        System.out.println("Encrypted "+ct);  
        System.out.println("Decrypted "+pt1);
        sc.close();

    }

    public static String encrypt(String s, String k){
        StringBuffer sb =new StringBuffer(s);
        for(int i=0;i<sb.length();i++){
            int idx;
            char c;
            idx=sb.charAt(i)-65;
            c=k.charAt(idx);
            sb.setCharAt(i, c);
        }
        String ecryptedText = sb.toString();
        return ecryptedText;
        
    }
    public static String decrypt(String s,String key){
        StringBuffer sb =new StringBuffer(s);
        for (int i=0;i<sb.length();i++){
        int idx;
        char c;
        c=sb.charAt (i );
        idx=key.indexOf(c);
        sb.setCharAt(i,(char)(idx+65));
        }
        return sb.toString();
        
    }
}
