import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Ball implements Runnable  {
	private int x,y;
	private Color color;
	private int size ;
	private Rectangle rect;	
	private boolean incX,incY;
	private int speed ;
	
	public Ball(int x, int y, Color color, int size, Rectangle container,int speed) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.rect = container;
		this.color = color;
		this.speed = speed ;
	}


//	public void draw(Graphics g){
//		g.setColor(color);
//		g.fillOval((int)x,(int) y, size, size);
//		g.drawString("x: "+ x + " y: "+ y,10,15);
//		
//		move();
//	}
	
	private void move(){	
		checkTouch();
		this.x = incX ? this.x + 1 : this .x -1 ;
		this.y = incY ? this.y + 1 : this .y -1 ;
		this.doDraw();
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public int getSize() {
		return size;
	}


	public abstract void doDraw();
	
	private void checkTouch() {
		
		if(this.x <= 0){
			this.incX = true;
		} else if((this.x + size) >= this.rect.width){
			this.incX = false;
		}
		
		if(this.y <= 0){
			this.incY = true;
		} else if((this.y + size) >= this.rect.height){
			this.incY = false;
		}
	
	}


	@Override
	public void run() {
		while (true) {
			move();
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public Color getColor(){
		return this.color;
	}


}
