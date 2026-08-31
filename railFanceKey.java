import java.util.*;

public class railFanceKey {
    
    public static StringBuffer encryption(String PT,int Key){
        StringBuffer result1 = new StringBuffer();
        StringBuffer result2 = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for(int i=0;i<PT.length();i++){
            if(i%2==0){
                result1.append(PT.charAt(i));
            }
            else{
                result2.append(PT.charAt(i));
            }
        }
        result.append(result1);
        result.append(result2);
        return result;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Plain Text : ");
        String PT = sc.nextLine().toLowerCase();
        System.out.print("Enter Key/Rail/Depth : ");
        int Key = sc.nextInt();
        
        if(Key==2){
            String a = encryption(PT,Key).toString();
            System.out.println("Encrypted Text : "+a);
        }
        else {
            System.out.println("Key Should Be 2");
        }
           sc.close();
    }
}