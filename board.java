package project.awt;

// awt modules
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class board implements WindowListener, ActionListener{
    
    Frame game_board = new Frame("Game of Life");
    Label l[][];
    Button bshow;
    Button nextgen;
    life_board lb;

    int num;
    final int board_choice;

    int _x;
    int _y;
    final int _width;
    final int _height;

    board(int num, int board_choice){
        _x= 20;
        _y = 20;
        _width= 20;
        _height= 20;
        this.num= num;
        this.board_choice= board_choice;
        this.lb = new life_board(num);
        lb.initialize_glider_board();

    }

    // Conway's life board
    void new_board(){

        bshow = new Button("Show Board");
        bshow.setBounds(_x, _y + 20, 250, 50);
        bshow.setBackground(Color.red);             //color of background
        bshow.setForeground(Color.white);           //color of text in it
        
        nextgen = new Button("Next Gen");
        nextgen.setBounds(_x + 500, _y + 20, 250, 50);
        nextgen.setBackground(Color.red);             //color of background
        nextgen.setForeground(Color.white);           //color of text in it
        _y += 40 + 40;

        l = new Label[num][num];

        // setting bounds and colour
        for(int i= 0; i< num; i++){
            _x= 20;
            for(int j= 0; j< num; j++){
                l[i][j]= new Label();
                l[i][j].setBounds(_x, _y, _width, _height);
                _x += 20;
            }
            _y += 20;
        }
        
        game_board.setSize(850, 950);
        game_board.setLayout(null);
        game_board.setVisible(true);

        // adding label to the frame
        for(int i= 0; i< num; i++){
            for(int j= 0; j< num; j++){
                game_board.add(l[i][j]);
            }
        }
        game_board.add(bshow);
        game_board.add(nextgen);
        
        if(board_choice == 1){
            lb.initialize_oscillator_board();
        }
        else if(board_choice == 2){
            lb.initialize_glider_board();
        }

        first_generation();

        game_board.addWindowListener(this);
        bshow.addActionListener(this);
        nextgen.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bshow){
            lb.print_board();
        }
        else if(e.getSource() == nextgen){
            lb.nextGeneration();
            System.out.println("Moved to next generation");
            next_generation();
        }
    }

    // events set outside the constructor
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Board Opened!");
    }

    // event when window is closed/terminated
    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Board Closed!");
    }

    // event for closing window button
    @Override
    public void windowClosing(WindowEvent e) {
        Frame f = (Frame) e.getSource();
        f.dispose();
        System.out.println("Board Closing!");
    }

    // event when window is on focus
    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Board Activated!");
    }

    // event when window is not on focus
    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Board Deactivated!");
    }

    // event when window is minimized
    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Board Iconified!");
    }

    // event when window out of tray
    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Board Deiconified!");
    }


    void first_generation(){
        // setting bounds and colour
        for(int i= 0; i< num; i++){
            _x= 20;
            for(int j= 0; j< num; j++){
                if(lb.old_board[i][j] == 0){
                    l[i][j].setBackground(Color.gray);
                }
                else if(lb.old_board[i][j] == 1 ){
                    l[i][j].setBackground(Color.green);
                }
            }
        }
    }

    void next_generation(){
        // setting bounds and colour
        for(int i= 0; i< num; i++){
            for(int j= 0; j< num; j++){
                if(lb.old_board[i][j] == 0){
                    l[i][j].setBackground(Color.gray);
                }
                else if(lb.old_board[i][j] == 1 ){
                    l[i][j].setBackground(Color.green);
                }
            }
        }
    }
    


    // public static void main(String[] args) {
    //     board b = new board(40);
    //     b.new_board();
    // }
    
}