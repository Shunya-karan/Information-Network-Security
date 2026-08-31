import java.util.Scanner;

public class vernamCipher {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The length of the plain text and the key must be same\n");
        System.out.println("Enter plain text: ");
        String pt = sc.next().toUpperCase().trim();
        System.out.println("Enter key: ");
        String key = sc.next().toUpperCase().trim();
        boolean comparison = compareKeyPt(pt,key);
        if (comparison){
            System.out.println("Correct");
            StringBuffer ct=Encryption(pt,key);
            System.out.println("Encryption:"+ct);
            StringBuffer pt1 = Decryption(ct.toString() , key);
            System.out.println("Decryption:"+pt1);
        }
        else{
            System.out.println("The length of pt and key must be same");
        }
        sc.close();
    } 
    public static boolean compareKeyPt(String pt , String key){
        if (key.length()==pt.length()){
            return true;
        }
        else{
            return false;
        }
    }
    public static StringBuffer Encryption (String pt , String key){
        StringBuffer result = new StringBuffer();
        for (int i=0;i<pt.length();i++){
            char ch = (char)((int)(pt.charAt(i)^key.charAt(i))+97);
            result.append(ch);
        }
        return result;
    }
    public static StringBuffer Decryption (String ct , String key){
        StringBuffer result = new StringBuffer();
        for (int i =0;i<ct.length();i++){
         char ch = (char)((int)(ct.charAt(i)-97)^key.charAt(i)); 
         result.append(ch);
        }
        return result;
    }
    
}


