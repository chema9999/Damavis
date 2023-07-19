



import java.util.List;

public class Direction{

    

    public boolean isValid (List<List<Character>> labyrinth, int[][] position) {

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 2; j++) {

                if (position[i][j] == -1 || labyrinth.get(i).get(j) == '#') {

                    return false;
                }
            }
        }

     return true;
    }

    public int[][] moveLeft (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][1]++;
            }
        return position;
    }


    public int[][] moveRight (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][1]--;
            }
        return position;
    }


    public int[][] moveUp (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][0]++;
            }
        return position;
    }


    public int[][] moveDown (int[][] position) {
            
            for(int i = 0; i < 3; i++) {
    
                position[i][0]--;
            }
        return position;
    }

    public int[][] rotate (int[][] position) {
            
          position[2][0] = position[0][0]++;
          position[2][1] = position[0][1]++;
          position[0][0] = position[2][0]--;
          position[0][1] = position[2][1]--;  
        return position;
    }
    public static void main(String[] args){}

}