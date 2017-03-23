package Memory;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import guiPractice.components.Visible;

public class TobyGraphic implements Visible {

	
	//fields
	private int x;
	private int y;
	private BufferedImage image;
	private boolean loadedImages;
	
	public TobyGraphic(int x, int y, double scale, String imageLocation){
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, scale);
	}
	
	public TobyGraphic(int x, int y, String imageLocation){
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, 0, 0);
	}
	
	public TobyGraphic(int x, int y, int w, int h, String imageLocation){
		this.x = x;
		this.y = y;
		loadedImages = false;
		loadImages(imageLocation, w, h);
	}
	
	public void loadImages(String imageLocation, int w, int h) {
		try{
			ImageIcon icon = new ImageIcon(imageLocation);
			
			if(w == 0 && h == 0){
				//use original scale
				image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
				//draw icon into image
				Graphics2D g = image.createGraphics();
				g.drawImage(icon.getImage(), 0, 0 , null);
			}else{
				//use custom size
				image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = image.createGraphics();
				//select coordinates of top left rectangle within image
				//then select width and height to display graphic
				//then of the icon you want to display, select x,y coordinates and width height
				//this can split an image into parts
				g.drawImage(icon.getImage(),0,0,w,h,0,0,icon.getIconWidth(),icon.getIconHeight(),null);
			}
			loadedImages = true;
		}catch(Exception e){
			//in case file is not found
			e.printStackTrace();
		}
	}

	public void loadImages(String imageLocation, double scale) {
		try{
			//get the image from file(FULL SCALE)
			ImageIcon icon = new ImageIcon(imageLocation);
			
			int newWidth = (int)(icon.getIconWidth()*scale);
			int newHeight = (int)(icon.getIconHeight()*scale);
			image = new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(icon.getImage(),0,0,newWidth,newHeight,0,0,icon.getIconWidth(),icon.getIconHeight(),null);
			loadedImages = true;
		}catch(Exception e){
			//in case file is not found
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}

	public boolean isAnimated() {
		return false;
	}

	public void update() {
		//does nothing, image never changes
	}

}