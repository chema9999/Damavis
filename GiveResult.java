

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GiveResult {

    public static List<List<Character>> matrixToList(char[][] matrix,int rows, int cols) {

        List<List<Character>> list = new ArrayList<List<Character>>();
        for(int i = 0; i<rows; i++) {
            List<Character> rowList = new ArrayList<Character>();
            for(int j = 0; j<cols; j++){
                rowList.add(Character.valueOf(matrix[i][j]));
            }
            list.add(rowList);
        }
        return list;
    }
    public static Integer findShortestPath(List<List<Character>> labyrinth) {

        FindPath find = new FindPath();
        int[][] initialPosition = {{0,1},{0,2},{0,3}};
        List<int[][]> pathList = new ArrayList<int[][]>();
        pathList.add(initialPosition);
        if(find.findPath(labyrinth, initialPosition, pathList)){
            List<int[][]> otherPath = new ArrayList<int[][]>();
            int movements = pathList.size();
            while(find.findAnotherPath(labyrinth, initialPosition, otherPath, pathList, movements)){
                pathList.addAll(otherPath);
                movements = otherPath.size();
            } if(pathList.size() != movements) {
                return movements;
            }
            return movements;
        }
        return -1;
    }

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
        System.out.println("Please enter the elements of the labyrinth by rows and separted by a space");
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
       labyrinth = matrixToList(labyrinthMatrix, rows, cols);

       System.out.println("The solution to your labyrinth is" + findShortestPath(labyrinth));
        
    }
}
