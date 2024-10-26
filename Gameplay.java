import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;
public class Gameplay extends JPanel implements KeyListener, ActionListener {
	
	
	
	   private int[] snakexlength = new int[750];
	   private int[] snakeylength = new int[750];
	   
	   private boolean right = false;
	   private boolean left = false;
	   private boolean up = false;
	   private boolean down = false;
	   
	   private ImageIcon rightmouth ;
	   private ImageIcon leftmouth ;
	   private ImageIcon upmouth ;
	   private ImageIcon downmouth ;
	   private ImageIcon body ;
	   
	   private int[] enemyxpos = {25,50,75,100,125, 150,175,200,225,250,275,300,325,350, 375, 400, 425, 450,475,500,525,550,575, 600,625,650,675,700,725,750,775,800,825,850};
       private int[] enemyypos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575, 600,625};
       
       private ImageIcon enemyimage;
       private Random random = new Random();
       
       private int xpos = random.nextInt(34);
       private int ypos = random.nextInt(34);

	   
	   private int move = 0;
	   
	   private Timer timer;
	   private int delay = 100;
	   
	   private int lengthofsnake = 3;
	   
	   
	   private ImageIcon titleImage;
	   
	   private int score = 0;
	   
       public Gameplay() {
    	   addKeyListener(this);
    	   setFocusable(true);
    	   setFocusTraversalKeysEnabled(true);
    	   timer = new Timer(delay, this);
    	   timer.start(); 
    	   
       
       
       }
       public void paint(Graphics g) {
    	   
    	   // starting position
    	   if(move == 0) {
    		   snakexlength[0]=100;
    		   snakexlength[1]=75;
    		   snakexlength[2]=50;
    		   
    		   snakeylength[0]=100;
    		   snakeylength[1]=100;
    		   snakeylength[2]=100;
    	   }
    	   // Title border
    	   g.setColor(Color.white);
    	   g.drawRect(24, 10, 851, 55);
    	   
    	   titleImage = new ImageIcon("title.jpg");
    	   titleImage.paintIcon(this, g, 25, 11);
    	   
    	// Gameplay border
    	   g.setColor(Color.white);
    	   g.drawRect(24, 74, 851, 577);
    	   g.setColor(Color.BLACK);
    	   g.fillRect(25, 75, 850, 575);
    	   
    	   // scores
    	   g.setColor(Color.white);
    	   g.setFont(new Font("arial", Font.PLAIN, 14));
    	   g.drawString("Scores : "+score, 780, 30);
    	   
    	   // length
    	   g.drawString("Length : "+lengthofsnake, 780, 50);
    	   
    	   
    	   //mouth
    	   rightmouth = new ImageIcon("right.jpg");
    	   rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
    	   
    	   for(int a=0; a<lengthofsnake; a++) {
    		   if(a==0 && right) {
    			   rightmouth = new ImageIcon("right.jpg");
    	    	   rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
    		   }
    	   
    		   if(a==0 && left) {
    			   leftmouth = new ImageIcon("left.jpg");
    	    	   leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
    		   }
    	   
    		   if(a==0 && up) {
    			   upmouth = new ImageIcon("up.jpg");
    	    	   upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
    		   }
    	   
    		   if(a==0 && down) {
    			   downmouth = new ImageIcon("down.jpg");
    	    	   downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
    		   }
    		   
    		   if(a!=0) {
    			   body = new ImageIcon("body.jpg");
    	    	   body.paintIcon(this, g, snakexlength[a], snakeylength[a]);
    		   }
    	   }
    	   
    	   
    	   
    	   if(enemyxpos[xpos]==snakexlength[0] && enemyypos[ypos]==snakeylength[0]) {
    		   lengthofsnake++;
    		   score++;
    		   xpos = random.nextInt(34);
    		   ypos = random.nextInt(23);
    	   }
    	   
    	   enemyimage = new ImageIcon("ball.jpg");
    	   enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
    	   
    	   for(int b=1; b<lengthofsnake; b++) {
    		   if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0]) {
    			   right=false;
    			   left=false;
    			   up=false;
    			   down=false;
    			   
    			   g.setColor(Color.white);
    			   g.setFont(new Font("arial", Font.PLAIN, 50));
    			   g.drawString("Game Over", 300, 300);
    			   
    			   g.setFont(new Font("arial", Font.PLAIN, 20));
    			   g.drawString("Space to RESTART", 350, 340);
    					   
    		   }
    	   }
    	   g.dispose();
       }
       
       
       
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// right
		if(right) {
			for(int i=lengthofsnake-1;i>=0;i--) {
				snakeylength[i+1]=snakeylength[i];
			}
			for(int i=lengthofsnake;i>=0;i--) {
				if(i==0) {
					snakexlength[i]=snakexlength[i]+25;
				}
				else {
					snakexlength[i]=snakexlength[i-1];
				}
				if(snakexlength[i]>850) {
					snakexlength[i]=25;
				}
			}
			repaint();
		}
		
		// left
		if(left) {
			for(int i=lengthofsnake-1;i>=0;i--) {
				snakeylength[i+1]=snakeylength[i];
			}
			for(int i=lengthofsnake;i>=0;i--) {
				if(i==0) {
					snakexlength[i]=snakexlength[i]-25;
				}
				else {
					snakexlength[i]=snakexlength[i-1];
				}
				if(snakexlength[i]<25) {
					snakexlength[i]=850;
				}
			}
			repaint();
		}
		
		// up
		if(up) {
			for(int i=lengthofsnake-1;i>=0;i--) {
				snakexlength[i+1]=snakexlength[i];
			}
			for(int i=lengthofsnake;i>=0;i--) {
				if(i==0) {
					snakeylength[i]=snakeylength[i]-25;
				}
				else {
					snakeylength[i]=snakeylength[i-1];
				}
				if(snakeylength[i]<75) {
					snakeylength[i]=625;
				}
			}
			repaint();
		}
		
		// down
		if(down) {
			for(int i=lengthofsnake-1;i>=0;i--) {
				snakexlength[i+1]=snakexlength[i];
			}
			for(int i=lengthofsnake;i>=0;i--) {
				if(i==0) {
					snakeylength[i]=snakeylength[i]+25;
				}
				else {
					snakeylength[i]=snakeylength[i-1];
				}
				if(snakeylength[i]>625) {
					snakeylength[i]=75;
				}
			}
			repaint();
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// right key
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					move++;
					if(!left) {
						right=true;
					}
					else {
						right=false;
						left=true;
					}
					up=false;
					down=false;
				}
				
				// left key
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					move++;
					if(!right) {
						left=true;
					}
					else {
						left=false;
						right=true;
					}
					up=false;
					down=false;
				}
				
				// up key
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					move++;
					if(!down) {
						up=true;
					}
					else {
						up=false;
					    down=true;
					}
					right=false;
					left=false;
				}
				
				// down key
				if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					move++;
					if(!up) {
						down=true;
					}
					else {
						down=false;
					    up=true;
					}
					right=false;
					left=false;
				}
				
				// enter
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					score = 0;
					move = 0;
					lengthofsnake = 3;
					repaint();
				}
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	
}
