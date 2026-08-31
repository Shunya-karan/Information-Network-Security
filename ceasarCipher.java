import java.util.*;

class ceaserCipher{
  public static StringBuffer encryption(String text,int k){
  StringBuffer result=new StringBuffer();
  for(int i=0;i<text.length();i++){
    if(Character.isUpperCase(text.charAt(i))){
    char ch=(char)(((int)text.charAt(i)+k-65)%26+65);
    result.append(ch);
  }
 
    else{
    char ch=(char)(((int)text.charAt(i)+k-97)%26+97);
    result.append(ch);
  }
  }
  return result;
  }
  public static StringBuffer decryption(String text, int k){
    StringBuffer result1 = new StringBuffer();

    for(int i = 0; i < text.length(); i++){
        if(Character.isUpperCase(text.charAt(i))){
            char ch = (char)(((text.charAt(i) - 65 - k + 26) % 26) + 65);
            result1.append(ch);
        }
        else{
            char ch = (char)(((text.charAt(i) - 97 - k + 26) % 26) + 97);
            result1.append(ch);
        }
    }
    return result1;
}
public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter string: ");
    String s = sc.next();

    System.out.print("Enter key: ");
    int k = sc.nextInt();

    k = k % 26;

    String str = encryption(s, k).toString();

    System.out.println("Cipher Text: " + str);
    System.out.println("Plain Text: " + decryption(str, k));
    sc.close();

}

}