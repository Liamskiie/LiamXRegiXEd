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
	public BufferedImage bground;
    public BufferedImage image;
    public URL resource = getClass().getResource("hop1.png");
     public URL bg = getClass().getResource("background.png");
	
	public Drawing(){
		try{
			bground = ImageIO.read(bg);
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		if(state == 0){
			resource = getClass().getResource("hop2.png");
		}
		else if (state == 1){
			resource = getClass().getResource("hop3.png");
		}
		else if (state == 2){
			resource = getClass().getResource("hop4.png");
		}
		else if (state == 3){
			resource = getClass().getResource("hop5.png");
		}
		else if (state == 4){
			resource = getClass().getResource("hop6.png");
		}
		else if (state == 5){
			resource = getClass().getResource("hop7.png");
			state=0;
		}		
	   
		state++;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int atkstate = 1; atkstate<5;atkstate++){
					if(atkstate==4){
						resource = getClass().getResource("tan1.png");
					}
					else{
						resource = getClass().getResource("gokuattack"+atkstate+".png");
					}
					try{
						image = ImageIO.read(resource);
					}
					catch(IOException e){
						e.printStackTrace();
					}

					repaint();

					try{
						Thread.sleep(100);
					}
					catch(InterruptedException e){

					}
				}
			}
		});
		thread1.start();
	}
	

	public void moveUp(){
		y=y -5;
		reloadImage();
		repaint();
	}
	public void moveDown(){
		y=y +5;
		reloadImage();
		repaint();
	}
	public void moveLeft(){
		x=x -5;
        reloadImage();
		repaint();
	}
	public void moveRight(){
		x=x +5;
		reloadImage();
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(bground,0,0,this);
		g.drawImage(image,x,y,this);
	}
}
