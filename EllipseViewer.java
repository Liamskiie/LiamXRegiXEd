import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


public class EllipseViewer extends JFrame implements KeyListener{

	public Drawing draw;

	public EllipseViewer(){
		this.draw = new Drawing();
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){
			draw.moveUp();
			System.out.println("UP");
		}

		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			draw.moveDown();
			System.out.println("DOWN");
		}

		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			draw.moveLeft();
			System.out.println("LEFT");
		}

		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			draw.moveRight();
			System.out.println("RIGHT");
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			draw.attack();
			System.out.println("ATTACK");
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			draw.taunt();
			System.out.println("TAUNT");
		}
	}
	public void keyTyped(KeyEvent e){
	
	}

	public void keyReleased(KeyEvent e){
	}
	public static void  main (String args[]){
		EllipseViewer myFrame = new EllipseViewer();
		myFrame.setSize(855,550);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		myFrame.add(myFrame.draw);
		myFrame.addKeyListener(myFrame);
	}

}