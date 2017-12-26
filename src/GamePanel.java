import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class GamePanel extends JPanel  {

	private static final long serialVersionUID = 1L;
	private List<Ball> balls = new ArrayList<Ball>() ;
	private Random rdn = new Random();

	public GamePanel() {
		setBorder(new LineBorder(Color.BLUE));
	}

	public void addBall(){
		Ball b = new Ball(rdn.nextInt(getWidth()),rdn.nextInt(getHeight()),new Color(rdn.nextInt(255), rdn.nextInt(255), rdn.nextInt(255)),
				20,new Rectangle(getWidth(), getHeight()),10 + rdn.nextInt(20)) {
			
			@Override
			public void doDraw() {
				GamePanel.this.repaint();				
			}
		};
		
		this.balls.add(b) ;
		new Thread(b).start();

	}


	@Override
	protected void paintComponent(Graphics g) {		
		super.paintComponent(g);

		for (Ball ball : balls) {
			g.setColor(ball.getColor());
			g.fillOval(ball.getX(),ball.getY(), ball.getSize(), ball.getSize());
//			g.drawString("x: "+ ball.getX() + " y: "+ ball.getY(),10,15);
		}

	}
}
