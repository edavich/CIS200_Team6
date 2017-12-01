import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class TheaterSeats {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheaterSeats window = new TheaterSeats();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TheaterSeats() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int seatsx=10;
		int seatsy=5;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBounds(68, 16, 300, 212);
		panel.setLayout(new GridLayout(seatsx, seatsy, 0, 0));
		
		int seatASCII = 65;
		int seatNum = 1;
		char seatLetter = (char)seatASCII;
		
		for(int i=0; i<seatsx;i++) {
			for(int j = 0; j<seatsy;j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(seatLetter);
				sb.append(seatNum);
				panel.add(new JButton(sb.toString()));
				seatNum++;
			}
			seatNum = 1;
			seatASCII++;
			seatLetter = (char)seatASCII;
		}
		
		
		
	}
}
