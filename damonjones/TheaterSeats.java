import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JList;

public class SeatsAgain {

	private JFrame frame;
	ArrayList<String>selectedSeats = new ArrayList<String>();
	ArrayList<JButton>b = new ArrayList<JButton>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatsAgain window = new SeatsAgain();
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
	public SeatsAgain() {
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
		panel.setBounds(15, 16, 296, 174);
		panel.setLayout(new GridLayout(seatsx, seatsy, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(208, 190, 103, 38);
		frame.getContentPane().add(panel_1);
		
		int seatASCII = 65;
		int seatNum = 1;
		char seatLetter = (char)seatASCII;
		//JButton[][] b = new JButton[seatsx][seatsy];
		int num = 0;
		
		for(int i=0; i<seatsx;i++) {
			for(int j = 0; j<seatsy;j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(seatLetter);
				sb.append(seatNum);
				b.add(new JButton(sb.toString()));
				b.get(num).setBackground(Color.gray);
				b.get(num).addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(((JButton)e.getSource()).getBackground()==Color.gray) {
							((JButton)e.getSource()).setBackground(Color.green);
						} else {
							((JButton)e.getSource()).setBackground(Color.gray);
						}
					}
				});
				panel.add(b.get(num));
				seatNum++;
				num++;
			}
			seatNum = 1;
			seatASCII++;
			seatLetter = (char)seatASCII;
		}
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i<b.size();i++) {
					if(b.get(i).getBackground()==Color.green) {
						selectedSeats.add(b.get(i).getText());
						System.out.println(b.get(i).getText());
					}
				}
			}
		});
		panel_1.add(btnsubmit);
		
		/*
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(326, 16, 78, 174);
		frame.getContentPane().add(panel_2);
		
		
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<selectedSeats.size(); i++) {
			sb.append(selectedSeats.get(i)+" ");
		}
		panel_2.add(new JLabel(sb.toString()));
		*/
		
	}
}
