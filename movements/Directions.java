package movements;

import java.util.List;

abstract class Directions{

    public boolean isValid (List<List<Character>> labyrinth, int[][] position) {

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++) {

                if (position[i][j] == -1 || labyrinth.get(i).get(j) == '#') {

                    return false;
                }
                return true;
            }
        }


        return false;
    }
}

class Left extends Directions {

    public int[][] moveLeft (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][1]++;
            }
        return position;
    }
}

class Right extends Directions {

    public int[][] moveRight (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][1]--;
            }
        return position;
    }
}

class Up extends Directions {

    public int[][] moveUp (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][0]++;
            }
        return position;
    }
}

class Down extends Directions {

    public int[][] moveUp (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][0]--;
            }
        return position;
    }
}

class Rotate extends Directions {

    public int[][] rotate (int[][] position) {
            
          position[0][0]++;
          position[0][1]++;
          position[2][0]--;
          position[2][1]--;  
        return position;
    }
}