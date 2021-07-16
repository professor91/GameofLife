# GameofLife
Second Sem JAVA Project

- Clone & Run "game_gui.java" file.

What is Game of Life? (Sources:- https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)

The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.[1] It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves. It is Turing complete and can simulate a universal constructor or any other Turing machine.

Rules of Conway's Game of life:-
                                1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                                2. Any live cell with two or three live neighbours lives on to the next generation.
                                3. Any live cell with more than three live neighbours dies, as if by overpopulation.
                                4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

Rules for code:- 
                1. Any live cell with less than 2 neighbours dies of under-population.
                2. Any live cell with more than 3 neighbours dies of over-population.
                3. Any dead cell with exactly three live neighbours becomes alive due to reproduction.
                4. All other dead cells stay dead.
                
Patterns Included:-
                    1. Oscillator
                    2. Glider

As of now user can only choose from the above mentioned patterns and simulate game of life.
