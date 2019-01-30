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

public class Drawing extends JComponent{
	
	public int x = 50;
	public int y = 50;
	public int height = 1000;
 	public int width = 1000;

	public int state = 0;

    public BufferedImage image;
    public BufferedImage bground;
    public URL resource = getClass().getResource("hero1walk.png");
    public URL bg = getClass().getResource("background.jpg");

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
			resource = getClass().getResource("hero1walk.png");
		}
		else if (state == 1){
			resource = getClass().getResource("hero2walk.png");
		}
		else if (state == 1){
			resource = getClass().getResource("hero3walk.png");
		}
		else if (state == 1){
			resource = getClass().getResource("hero4walk.png");
		}
		else if (state == 1){
			resource = getClass().getResource("hero5walk.png");
		}
		else if (state == 1){
			resource = getClass().getResource("hero6walk.png");
		}
		else if (state == 1){
			resource = getClass().getResource("hero7walk.png");
		}
		else if (state == 2){
			resource = getClass().getResource("hero8walk.png");
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
		public void reloadImage2(){
        Thread thread = new Thread(new Runnable(){
            public void run(){
                for(int atkstate = 1;atkstate<6;atkstate++){
                    if(atkstate==6){
                        resource = getClass().getResource("hero5.png");
                    }

                    else{
                        resource = getClass().getResource("hero"+atkstate+".png");
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

        thread.start();
    }
    public void reloadImage3(){
        Thread thread1 = new Thread(new Runnable(){
            public void run(){
                for(int atkstate = 1;atkstate<4;atkstate++){
                    if(atkstate==4){
                        resource = getClass().getResource("herospear3.png");
                    }

                    else{
                        resource = getClass().getResource("herospear"+atkstate+".png");
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
	public void attack(){
		reloadImage2();
		repaint();
	}
	public void taunt(){
		reloadImage3();
		repaint();
	}

	public void paintComponent(Graphics g){
		g.drawImage(bground,0,0,this);
		g.drawImage(image,x,y,this);

	}
}