import java.util.*;

public class simpleColumnar
 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.next();

        System.out.print("Enter Number of Columns: ");
        int col = sc.nextInt();

        int row = (text.length() + col - 1) / col;

        char[][] matrix = new char[row][col];

        int k = 0;

        // Fill row-wise
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k < text.length())
                    matrix[i][j] = text.charAt(k++);
                else
                    matrix[i][j] = 'X';
            }
        }

        // Display matrix
        System.out.println("\nMatrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Read column-wise
        System.out.print("\nCipher Text: ");
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                System.out.print(matrix[i][j]);
            }
        }

        sc.close();
    }
}