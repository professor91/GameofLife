package project.awt;

// awt modules
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class frame implements WindowListener, ActionListener {
    Frame f;
    Button bglider, boscillator, nothing, useless;
    Label l;
    TextField tf1;

    int num;
    
    int _x;
    int _y;
    final int _width;
    final int _height;

    // constructor initializing the 
    frame(){
        _x= 20;
        _y = 40;
        _width = 200;
        _height = 40;
    }

    //function to create a new frame
    public void new_frame(){
        // creating a frame using Frame object
        f = new Frame("Game of Life");
        
        // creating Labels
        Label l1=  new Label("Enter the size of grid (a x a) not more than 40: ");
        l1.setBounds(_x, _y + 20, 300, 30);
        l1.setBackground(Color.white);

        tf1= new TextField();
        tf1.setBounds(_x + 330, _y + 20, 50, 30);
        _y += _height + 40;

        boscillator = new Button("New Oscillator Board");
        boscillator.setBounds(_x, _y, _width, _height);
        boscillator.setBackground(Color.red);             //color of background
        boscillator.setForeground(Color.white);           //color of text in it

        bglider = new Button("New Glider Board");
        bglider.setBounds(_x + _width + 50, _y, _width, _height);
        bglider.setBackground(Color.red);             //color of background
        bglider.setForeground(Color.white);           //color of text in it
        _y += _height + 40;

        nothing = new Button("I do Nothing");
        nothing.setBounds(_x, _y, _width, _height);
        nothing.setBackground(Color.red);             //color of background
        nothing.setForeground(Color.white);           //color of text in it

        useless = new Button("I too am useless");
        useless.setBounds(_x + _width + 50, _y, _width, _height);
        useless.setBackground(Color.red);             //color of background
        useless.setForeground(Color.white);           //color of text in it
        _y += _height + 40;

        // adding components to the frame
        f.add(tf1);
        f.add(l1);
        f.add(bglider);
        f.add(boscillator);
        f.add(nothing);
        f.add(useless);

        // setting properties of the frame
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        // adding listeners
        f.addWindowListener(this);
        bglider.addActionListener(this);
        boscillator.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            num= Integer.parseInt(tf1.getText());
        }
        catch(NumberFormatException message){
            System.out.println("Error : Please enter a number. " + message);
            return;
        }
        catch(ArrayIndexOutOfBoundsException message){
            System.out.println("Error : Please Enter a number greater than 5. " + message);
            return;
        }
        if(num < 5 || num > 40){
            System.out.println("Error : Please Enter a number greater than 5. ");
            return;
        }
        
        if (e.getSource() == boscillator) {
            board b = new board(num, 1);
            b.new_board();
        } else if (e.getSource() == bglider) {
            board b = new board(num, 2);
            b.new_board();
        }
    }

    // events set outside the constructor
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Game GUI Opened!");
    }

    // event when window is closed/terminated
    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Game GUI Closed!");
    }

    // event for closing window button
    @Override
    public void windowClosing(WindowEvent e) {
        Frame f = (Frame) e.getSource();
        f.dispose();
        System.out.println("Game GUI Closing!");
    }

    // event when window is on focus
    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Game GUI Activated!");
    }

    // event when window is not on focus
    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Game GUI Deactivated!");
    }

    // event when window is minimized
    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Game GUI Iconified!");
    }

    // event when window out of tray
    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Game GUI Deiconified!");
    }
}

public class game_gui{   

    public static void main(String[] args) {
        frame f = new frame();
        f.new_frame();
    }
}
