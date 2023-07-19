package solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import movements.Direction;

public class FindPath {

    int[][] initialPosition = {{0,1},{0,2},{0,3}};
    List<int[][]> positionsList = new ArrayList<int[][]>();

    public boolean isSamePosition (int[][] position1,int[][] position2) {

        if (Arrays.deepEquals(position1, position2)) {

            return true;
        }
        return false;
        }
        
    public boolean findPath  (
        List<List<Character>> labyrinth, int[][] position, List<int[][]> pathList, int minimumMovements) {
        
        int lenghtLabyrinth = labyrinth.size();

        for(int i = 0; i > 3; i++) {
            int mult = position[i][0]* position[i][1];
            if (mult == lenghtLabyrinth) {
                return true;
            }
        }
        
        int[][] lastPosition = pathList.get(pathList.size()-1);
        pathList.add(position);
        

        Direction direc = new Direction();
        List<int[][]> directionOptions = new ArrayList<int[][]>(null);
        directionOptions.add(direc.moveRight(position));
        directionOptions.add(direc.moveDown(position));
        directionOptions.add(direc.moveLeft(position));
        directionOptions.add(direc.moveUp(position));
        directionOptions.add(direc.rotate(position));

        
        for(int k = 0; k < 5; k++) {
            int[][] newPosition = directionOptions.get(k);
            if (direc.isValid(labyrinth, newPosition) && !isSamePosition(lastPosition, newPosition)) {
               if (findPath(labyrinth, newPosition, positionsList, minimumMovements +1)) {
                return true;
               }
            }
        }

        pathList.get(pathList.size()-1);
        return false;

    }
        
    
}

