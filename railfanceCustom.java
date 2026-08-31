import java.util.*;

public class railfanceCustom
 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        String pt = sc.nextLine();
        System.out.println("Enter key : ");
        pt=pt.replaceAll("\\s+", "");
        int key = sc.nextInt();
        
        char[][] rail = new char[key][pt.length()];
        
        for(int i=0;i<key;i++){
            for(int j=0;j<pt.length();j++){
                rail[i][j]='\n';
            }
        }
        int row = 0;
        boolean down = true;
        
        for(int i=0;i<pt.length();i++){
            rail[row][i] = pt.charAt(i);
            
            if (row == 0)
                down = true;
            else if (row == key-1)
                down = false;
            
            if(down)
                row++;
            else
                row--;
        }
        String cipher = "";
        for(int i=0;i<key;i++){
            for(int j=0;j<pt.length();j++){
                if(rail[i][j]!='\n')
                    cipher += rail[i][j];
            }
        }
        System.out.println("Encryption text: "+cipher);
        
        sc.close();
    }
}
