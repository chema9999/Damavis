

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiveResult {


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        List<List<Character>> labyrinth = new ArrayList<List<Character>>();
        char[][] labyrinthMatrix;

        int rows;
        System.out.println("Please enter the number of rows of your labyrinth");
        rows = userInput.nextInt();

        int cols;
        System.out.println("Please enter the number of columns of your labyrinth");
        cols = userInput.nextInt();
        
        labyrinthMatrix = new char[rows][cols];
        System.out.println("Please enter the elements of the labyrinth by rows");
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                labyrinthMatrix[i][j] = userInput.next().charAt(0);
            }
        }

        System.out.println("the labyrinth is");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(labyrinthMatrix[i][j] + "  ");
            System.out.println();
        }
    }
}
