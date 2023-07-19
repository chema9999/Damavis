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
        
    public boolean findPath  (List<List<Character>> labyrinth, int[][] position, List<int[][]> positionsList, int minimumMovements) {

        Direction direc = new Direction();
        List<int[][]> directionOptions = new ArrayList<int[][]>(null);
        directionOptions.add(direc.moveLeft(position));
        directionOptions.add(direc.moveRight(position));
        directionOptions.add(direc.moveUp(position));
        directionOptions.add(direc.moveDown(position));
        directionOptions.add(direc.rotate(position));

        
        for(int k = 0; k < 5; k++) {

            if (direc.isValid(labyrinth, directionOptions.get(k))) {

                positionsList.add(directionOptions.get(k));
                findPath(labyrinth, position, positionsList, minimumMovements +1);
            }

        }

            
        return false;

    }
        
    
}

