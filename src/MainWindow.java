import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;
//	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setLocationRelativeTo(null);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}







	public MainWindow() {
		setTitle("Bounce Ball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		gamePanel = new GamePanel();
		getContentPane().add(gamePanel,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel,BorderLayout.SOUTH);
		
		JButton btnAddBall = new JButton("Add Ball");
		btnAddBall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.this.gamePanel.addBall();
			}
		});
		panel.add(btnAddBall);
		
//		new Thread(g).start();
	}

	

}
