import java.awt.Color;

import javax.swing.*;
public class Snake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame = new JFrame();
        frame.setTitle("Snake Game");
        frame.setBounds(10, 10, 905, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.DARK_GRAY);
        
        Gameplay gameplay = new Gameplay();
        frame.add(gameplay);
	}

}
