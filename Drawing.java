import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Drawing extends JComponent{
	
	public int x = 50;
	public int y = 50;
	public int state = 0;

		public BufferedImage image;
		public URL resource = getClass().getResource("run0.png");

	public Drawing(){
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void moveUp(){
		y=y -5;
		repaint();
	}
	public void moveDown(){
		y=y +5;
		repaint();
	}
	public void moveLeft(){
		x=x -5;
		repaint();
	}
	public void moveRight(){
		x=x +5;
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillOval(x,y,50,50);
		g.drawImage(image,x,y,this);
	}
}