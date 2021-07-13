/*
Rules of Conway's Game of life:-
                                1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                                2. Any live cell with two or three live neighbours lives on to the next generation.
                                3. Any live cell with more than three live neighbours dies, as if by overpopulation.
                                4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

Rules of code:- 
                1. Any live cell with two or three live neighbours survives.
                2. Any dead cell with three live neighbours becomes a live cell.
                3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.

*/

package project.awt;

class life_board
{       
    int num= 40;
    int[][] old_board= new int[num][num];
    int[][] new_board= new int[num][num];

    life_board(int a){
        num= a;
        System.out.println(num);
    }
    
    // function to initialize the grid as oscillator
    public void initialize_oscillator_board(){
        for(int i= 0; i< num; i++){
            for(int j= 0; j< num; j++){
                
                if((i==2 && j== 1) || (i==2 && j==2) || (i==2 && j==3)){
                    old_board[i][j]= 1;         // Alive Cell
                    new_board[i][j]= 1;         // Alive Cell
                }
                else{
                    old_board[i][j]= 0;         // Dead Cell
                    new_board[i][j]= 0;         // Alive Cell
                }
            }
        }
    }

    // function to initialize the grid glider
    public void initialize_glider_board(){
        for(int i= 0; i< num; i++){
            for(int j= 0; j< num; j++){
                
                if((i==1 && j== 2) || (i==2 && j==3) || (i==3 && j==1) || (i==3 && j==2) || (i==3 && j==3)){
                    old_board[i][j]= 1;         // Alive Cell
                    new_board[i][j]= 1;         // Alive Cell
                }
                else{
                    old_board[i][j]= 0;         // Dead Cell
                    new_board[i][j]= 0;         // Alive Cell
                }
            }
        }
    }

    // function to move to next generation
    void nextGeneration(){

        // Loop through every cell
        for (int i = 1; i < num - 1; i++){
            for (int j = 1; j < num - 1; j++){
                
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;            

                aliveNeighbours += old_board[i][j-1];
                aliveNeighbours += old_board[i][j+1];
                
                aliveNeighbours += old_board[i-1][j-1];
                aliveNeighbours += old_board[i-1][j];
                aliveNeighbours += old_board[i-1][j+1];
                
                aliveNeighbours += old_board[i+1][j-1];
                aliveNeighbours += old_board[i+1][j];
                aliveNeighbours += old_board[i+1][j+1];

                // Implementing the Rules of Life
                // Cell is alive and lonely --> dies
                if ((old_board[i][j] == 1) && (aliveNeighbours < 2))
                    new_board[i][j] = 0;
                
                // Cell is alive and in stable state - lives
                else if((old_board[i][j] == 1) && (aliveNeighbours == 2 || aliveNeighbours == 3))
                    old_board[i][j] = new_board[i][j];

                // Cell is alive and over populated --> dies
                else if ((old_board[i][j] == 1) && (aliveNeighbours > 3))
                    new_board[i][j] = 0;

                // Cell is dead and reproduce --> comes to life
                else if ((old_board[i][j] == 0) && (aliveNeighbours == 3))
                    new_board[i][j] = 1;
                }
        }
        old_board = new_board;
    }

    public void print_board(){
        for(int i= 0; i< num; i++){
            for(int j= 0; j< num; j++){
                System.out.print(old_board[i][j] + " ");
            }
            System.out.println("");
        }

    }
    
}
