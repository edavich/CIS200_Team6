import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Theater {
	
	private ArrayList<String>selectedSeats = new ArrayList<String>();
	private ArrayList<JButton>b = new ArrayList<JButton>();
	private JFrame frame;
	private JTextField txtChooseMode;
	private JPasswordField passwordField;
	private JTextField txtSelectMode;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextArea txtrChooseScreen;
	private JTextArea txtrSearch;
	private Screen[] finalMovies;
	private int screenAmount;
	private JTextPane txtpnMoviesGoHere;
	private ArrayList<Movie> nowPlaying;
	private int userResponse;
	private JTextField textField_4;
	private movieList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Theater window = new Theater();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public Theater() throws FileNotFoundException {
		this.list =  new movieList();
		initialize();
		//ownerMode();	
		//customerMode();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 675, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFormattedTextField frmtdtxtfldMovieTheaterApplication = new JFormattedTextField();
		frmtdtxtfldMovieTheaterApplication.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldMovieTheaterApplication.setFont(new Font("Menlo", Font.PLAIN, 16));
		frmtdtxtfldMovieTheaterApplication.setBackground(Color.LIGHT_GRAY);
		frmtdtxtfldMovieTheaterApplication.setText("Movie Theater Application");
		frmtdtxtfldMovieTheaterApplication.setBounds(21, 6, 273, 66);
		frame.getContentPane().add(frmtdtxtfldMovieTheaterApplication);
		
		JButton btnOwner = new JButton("Owner");
		btnOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(passwordField.getPassword()).equals("ownerpassword")) {
				ownerMode();
				frame.setBounds(150, 150, 675, 601);
				frame.setBounds(150, 150, 675, 600);
				}
			}
		});
		btnOwner.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnOwner.setBounds(437, 6, 82, 36);
		frame.getContentPane().add(btnOwner);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerMode();
				frame.setBounds(150, 150, 675, 601);
				frame.setBounds(150, 150, 675, 600);
			}
		});
		btnCustomer.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnCustomer.setBounds(531, 6, 112, 36);
		frame.getContentPane().add(btnCustomer);
		
		txtChooseMode = new JTextField();
		txtChooseMode.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtChooseMode.setHorizontalAlignment(SwingConstants.CENTER);
		txtChooseMode.setBackground(UIManager.getColor("ComboBox.background"));
		txtChooseMode.setText("Password:");
		txtChooseMode.setBounds(306, 43, 117, 29);
		frame.getContentPane().add(txtChooseMode);
		txtChooseMode.setColumns(10);
		
		txtSelectMode = new JTextField();
		txtSelectMode.setText("Select mode:");
		txtSelectMode.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectMode.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtSelectMode.setColumns(10);
		txtSelectMode.setBackground(SystemColor.window);
		txtSelectMode.setBounds(306, 7, 117, 35);
		frame.getContentPane().add(txtSelectMode);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 73, 666, 12);
		frame.getContentPane().add(separator);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(435, 46, 208, 26);
		frame.getContentPane().add(passwordField);
		
	}// end initialize
	
	
	private void ownerMode() {
			frame.getContentPane().removeAll();
			frame.setBounds(150, 150, 675, 600);
			JTextField textField = new JTextField();
			textField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			textField.setBounds(166, 105, 159, 26);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			//static text
			JFormattedTextField frmtdtxtfldMovieTheaterApplication = new JFormattedTextField();
			frmtdtxtfldMovieTheaterApplication.setHorizontalAlignment(SwingConstants.CENTER);
			frmtdtxtfldMovieTheaterApplication.setFont(new Font("Menlo", Font.PLAIN, 16));
			frmtdtxtfldMovieTheaterApplication.setBackground(Color.LIGHT_GRAY);
			frmtdtxtfldMovieTheaterApplication.setText("Movie Theater Application");
			frmtdtxtfldMovieTheaterApplication.setBounds(21, 6, 273, 66);
			frame.getContentPane().add(frmtdtxtfldMovieTheaterApplication);
			
			//owner button
			JButton btnOwner = new JButton("Owner");
			btnOwner.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (new String(passwordField.getPassword()).equals("ownerpassword")) {
						ownerMode();
						frame.setBounds(150, 150, 675, 601);
						frame.setBounds(150, 150, 675, 600);
						}
				}
			});
			
			btnOwner.setFont(new Font("Menlo", Font.PLAIN, 16));
			btnOwner.setBounds(437, 6, 82, 36);
			frame.getContentPane().add(btnOwner);
			
			//customer button
			JButton btnCustomer = new JButton("Customer");
			btnCustomer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					customerMode();
					frame.setBounds(150, 150, 675, 600);
					frame.setBounds(150, 150, 675, 601);
					if (returnScreenAmount() == returnSize().length) {
						btnOwner.setEnabled(false);
					}
				}
			});
			
			btnCustomer.setFont(new Font("Menlo", Font.PLAIN, 16));
			btnCustomer.setBounds(531, 6, 112, 36);
			frame.getContentPane().add(btnCustomer);
			
			//static text
			txtChooseMode = new JTextField();
			txtChooseMode.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			txtChooseMode.setHorizontalAlignment(SwingConstants.CENTER);
			txtChooseMode.setBackground(UIManager.getColor("ComboBox.background"));
			txtChooseMode.setText("Password:");
			txtChooseMode.setBounds(306, 43, 117, 29);
			frame.getContentPane().add(txtChooseMode);
			txtChooseMode.setColumns(10);
			
			//password field
			passwordField = new JPasswordField();
			passwordField.setBounds(435, 46, 208, 26);
			frame.getContentPane().add(passwordField);
			
			//static text
			JTextArea txtrEnterTheNumber = new JTextArea();
			txtrEnterTheNumber.setBackground(UIManager.getColor("ColorChooser.background"));
			txtrEnterTheNumber.setFont(new Font("Menlo", Font.BOLD, 13));
			txtrEnterTheNumber.setText("Enter the # of screens:");
			txtrEnterTheNumber.setBounds(21, 107, 231, 16);
			frame.getContentPane().add(txtrEnterTheNumber);
			
			//static text
			JTextArea txtrSearchForMovie = new JTextArea();
			txtrSearchForMovie.setBackground(UIManager.getColor("ColorChooser.background"));
			txtrSearchForMovie.setText("Search for movie by:");
			txtrSearchForMovie.setFont(new Font("Menlo", Font.BOLD, 13));
			txtrSearchForMovie.setBounds(21, 174, 159, 16);
			frame.getContentPane().add(txtrSearchForMovie);
			
			txtSelectMode = new JTextField();
			txtSelectMode.setText("Select mode:");
			txtSelectMode.setHorizontalAlignment(SwingConstants.CENTER);
			txtSelectMode.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			txtSelectMode.setColumns(10);
			txtSelectMode.setBackground(SystemColor.window);
			txtSelectMode.setBounds(306, 7, 117, 35);
			frame.getContentPane().add(txtSelectMode);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(6, 73, 666, 12);
			frame.getContentPane().add(separator);
			
			JTextArea txtrnameactorsgenresreleaseDaterating = new JTextArea();
			txtrnameactorsgenresreleaseDaterating.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
			txtrnameactorsgenresreleaseDaterating.setBackground(UIManager.getColor("ColorChooser.background"));
			txtrnameactorsgenresreleaseDaterating.setText("Search by name, actors, genres, release date, or rating.");
			txtrnameactorsgenresreleaseDaterating.setBounds(21, 146, 352, 16);
			frame.getContentPane().add(txtrnameactorsgenresreleaseDaterating);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(105, 275, 192, 26);
			frame.getContentPane().add(textField_2);
			
			txtrChooseScreen = new JTextArea();
			txtrChooseScreen.setText("Choose movie #:");
			txtrChooseScreen.setFont(new Font("Menlo", Font.BOLD, 13));
			txtrChooseScreen.setBackground(SystemColor.window);
			txtrChooseScreen.setBounds(21, 435, 208, 16);
			frame.getContentPane().add(txtrChooseScreen);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(241, 430, 100, 26);
			frame.getContentPane().add(textField_3);
			
			txtrSearch = new JTextArea();
			txtrSearch.setText("Search:");
			txtrSearch.setFont(new Font("Menlo", Font.BOLD, 13));
			txtrSearch.setBackground(SystemColor.window);
			txtrSearch.setBounds(21, 280, 82, 16);
			frame.getContentPane().add(txtrSearch);
			
			JRadioButton rdbtnName = new JRadioButton("Name");
			rdbtnName.setBounds(21, 202, 100, 23);
			frame.getContentPane().add(rdbtnName);
			
			JRadioButton rdbtnGenre = new JRadioButton("Genre");
			rdbtnGenre.setBounds(21, 237, 112, 23);
			frame.getContentPane().add(rdbtnGenre);
			
			JRadioButton rdbtnRating = new JRadioButton("Rating");
			rdbtnRating.setBounds(142, 202, 141, 23);
			frame.getContentPane().add(rdbtnRating);
			
			JRadioButton rdbtnActorsactresses = new JRadioButton("Actors/Actresses");
			rdbtnActorsactresses.setBounds(282, 202, 141, 23);
			frame.getContentPane().add(rdbtnActorsactresses);
			
			JRadioButton rdbtnRunTime = new JRadioButton("Run time");
			rdbtnRunTime.setBounds(142, 237, 141, 23);
			frame.getContentPane().add(rdbtnRunTime);
			
			JRadioButton rdbtnReleaseDate = new JRadioButton("Release date");
			rdbtnReleaseDate.setBounds(282, 237, 141, 23);
			frame.getContentPane().add(rdbtnReleaseDate);
			
			JTextArea txtrInTheatersNow = new JTextArea();
			txtrInTheatersNow.setForeground(Color.BLACK);
			txtrInTheatersNow.setText("Now in Theaters:");
			txtrInTheatersNow.setFont(new Font("Menlo", Font.PLAIN, 20));
			txtrInTheatersNow.setBackground(SystemColor.window);
			txtrInTheatersNow.setBounds(463, 104, 192, 36);
			frame.getContentPane().add(txtrInTheatersNow);
			
			JTextPane textPane = new JTextPane();
			textPane.setBackground(UIManager.getColor("TextComponent.selectionBackgroundInactive"));
			if (this.finalMovies == null) {
				textPane.setText("");
			}
			else {
				textPane.setText(displayMovies());
			}
			textPane.setBounds(463, 152, 190, 299);
			frame.getContentPane().add(textPane);
			
			this.txtpnMoviesGoHere = new JTextPane();
			this.txtpnMoviesGoHere.setText("");
			this.txtpnMoviesGoHere.setBackground(UIManager.getColor("ToolBar.background"));
			this.txtpnMoviesGoHere.setBounds(21, 318, 377, 100);
			frame.getContentPane().add(txtpnMoviesGoHere);
			
			//(Name), (Stars), (Genres), (Release Date), (Rating), (Run Time), (Score)
			JButton btnCreateShowing = new JButton("Search");
			btnCreateShowing.addActionListener(new ActionListener() {
				private int count = 1;
				public void actionPerformed(ActionEvent arg0) {
					//for (int i = 0; i < Integer.parseInt(textField.getText()); i++) {
					try {
						screenAdd(count, rdbtnName.isSelected(), rdbtnActorsactresses.isSelected(),
							rdbtnGenre.isSelected(), rdbtnReleaseDate.isSelected(), false,
							rdbtnRunTime.isSelected(), rdbtnRating.isSelected());
						this.count++;
					} catch (Exception e) {
						int test = 0;
					}
					
					//}
				}
					
			});
			btnCreateShowing.setBounds(306, 276, 97, 25);
			frame.getContentPane().add(btnCreateShowing);

			JButton selectMovie = new JButton("Select");
			selectMovie.addActionListener(new ActionListener() {
				private int count = 0;
				public void actionPerformed(ActionEvent arg0) {
					if (count <= Integer.parseInt(textField.getText())-1) {
						setMovie(Integer.parseInt(textField_3.getText()), count);
						count++;
						textPane.setText(displayMovies());
						frame.setBounds(150, 150, 675, 600);
					} else {
						textField.setEnabled(false);
						textField_2.setEnabled(false);
						textField_3.setEnabled(false);
						textPane.setText(displayMovies());
					}
				}});
			selectMovie.setBounds(354, 431, 97, 25);
			frame.getContentPane().add(selectMovie);
			
			JButton btnConfirm = new JButton("Confirm");
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setFinalSize(Integer.parseInt(textField.getText()));
					//textField.setText("Screen amount confirmed");
					textField.setEnabled(false);
					setScreenAmount(Integer.parseInt(textField.getText()));
					if (returnScreenAmount() == returnSize().length) {
						btnOwner.setEnabled(false);
					}
				}});
			btnConfirm.setBounds(337, 106, 97, 25);
			frame.getContentPane().add(btnConfirm);
			
			textField_4 = new JTextField();
			textField_4.setBounds(166, 518, 116, 22);
			frame.getContentPane().add(textField_4);
			textField_4.setColumns(10);
			
			JButton btnAddMovie = new JButton("Add Movie");
			btnAddMovie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						try {
						addMovies(textField_4.getText());
						textField_4.setText("");
						} catch (Exception e) {
							int catchMe = 0;
							textField_4.setText("not working");
						}
					}
				});
			btnAddMovie.setBounds(301, 517, 97, 25);
			frame.getContentPane().add(btnAddMovie);
			
			JTextPane txtpnEnterMovieUrl = new JTextPane();
			txtpnEnterMovieUrl.setText("Enter movie URL to add to search list:");
			txtpnEnterMovieUrl.setBounds(166, 480, 231, 22);
			frame.getContentPane().add(txtpnEnterMovieUrl);
			
//			if (this.finalMovies.length > 0) {
//				textPane.setText(displayMovies());
//			}
	}
	
	
	private void customerMode() {
		//frame = new JFrame();
		frame.getContentPane().removeAll();
		frame.setBounds(150, 150, 675, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int seatsx=10;
		int seatsy=5;
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBounds(15, 240, 296, 174);
		panel.setLayout(new GridLayout(seatsx, seatsy, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(310, 255, 103, 38);
		frame.getContentPane().add(panel_1);
		
		int seatASCII = 65;
		int seatNum = 1;
		char seatLetter = (char)seatASCII;
		//JButton[][] b = new JButton[seatsx][seatsy];
		int num = 0;
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerMode();
				frame.setBounds(150, 150, 675, 601);
				frame.setBounds(150, 150, 675, 600);

			}
		});
		btnCustomer.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnCustomer.setBounds(531, 6, 112, 36);
		frame.getContentPane().add(btnCustomer);
		
		JTextPane txtpnMoviesGoHere = new JTextPane();
		txtpnMoviesGoHere.setText("");
		txtpnMoviesGoHere.setBackground(UIManager.getColor("ToolBar.background"));
		txtpnMoviesGoHere.setBounds(21, 152, 377, 58);
		frame.getContentPane().add(txtpnMoviesGoHere);
		
		JScrollPane scroll = new JScrollPane(txtpnMoviesGoHere, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setSize(347, 90);
		scroll.setLocation(15, 137);
		frame.getContentPane().add(scroll);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(150, 110, 103, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (returnSize() == null) { 
					txtpnMoviesGoHere.setText("");
				}
				else {
				//System.out.println(returnSize()[0].getMovie().getName());
				txtpnMoviesGoHere.setText(getDescription(Integer.parseInt(textField_1.getText())-1));
				setCustomerResponse(Integer.parseInt(textField_1.getText())-1);
				btnCustomer.setEnabled(false);
				}
			}
		});
		btnSelect.setBounds(265, 109, 97, 25);
		frame.getContentPane().add(btnSelect);
		
		JFormattedTextField frmtdtxtfldMovieTheaterApplication = new JFormattedTextField();
		frmtdtxtfldMovieTheaterApplication.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldMovieTheaterApplication.setFont(new Font("Menlo", Font.PLAIN, 16));
		frmtdtxtfldMovieTheaterApplication.setBackground(Color.LIGHT_GRAY);
		frmtdtxtfldMovieTheaterApplication.setText("Movie Theater Application");
		frmtdtxtfldMovieTheaterApplication.setBounds(21, 6, 273, 66);
		frame.getContentPane().add(frmtdtxtfldMovieTheaterApplication);
		
		JButton btnOwner = new JButton("Owner");
		btnOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(passwordField.getPassword()).equals("ownerpassword")) {
				ownerMode();
				frame.setBounds(150, 150, 675, 601);
				frame.setBounds(150, 150, 675, 600);
				}
			}
		});
		btnOwner.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnOwner.setBounds(437, 6, 82, 36);
		frame.getContentPane().add(btnOwner);
		
		if (returnSize() != null) {
			if (returnScreenAmount() == returnSize().length) {
				btnOwner.setEnabled(false);
			}
		}
		
		txtChooseMode = new JTextField();
		txtChooseMode.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtChooseMode.setHorizontalAlignment(SwingConstants.CENTER);
		txtChooseMode.setBackground(UIManager.getColor("ComboBox.background"));
		txtChooseMode.setText("Password:");
		txtChooseMode.setBounds(306, 43, 117, 29);
		frame.getContentPane().add(txtChooseMode);
		txtChooseMode.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(435, 46, 208, 26);
		frame.getContentPane().add(passwordField);
		
		txtSelectMode = new JTextField();
		txtSelectMode.setText("Select mode:");
		txtSelectMode.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectMode.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtSelectMode.setColumns(10);
		txtSelectMode.setBackground(SystemColor.window);
		txtSelectMode.setBounds(306, 7, 117, 35);
		frame.getContentPane().add(txtSelectMode);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 73, 666, 12);
		frame.getContentPane().add(separator);
		
//		textField_2 = new JTextField();
//		textField_2.setColumns(10);
//		textField_2.setBounds(105, 275, 192, 26);
//		frame.getContentPane().add(textField_2);
		
		txtrChooseScreen = new JTextArea();
		txtrChooseScreen.setText("Your Movie Selection:");
		txtrChooseScreen.setFont(new Font("Menlo", Font.BOLD, 16));
		txtrChooseScreen.setBackground(SystemColor.window);
		txtrChooseScreen.setBounds(21, 553, 224, 16);
		frame.getContentPane().add(txtrChooseScreen);
		
		txtrSearch = new JTextArea();
		txtrSearch.setText("Select movie:");
		txtrSearch.setFont(new Font("Menlo", Font.BOLD, 13));
		txtrSearch.setBackground(SystemColor.window);
		txtrSearch.setBounds(21, 110, 117, 16);
		frame.getContentPane().add(txtrSearch);
		
		JTextArea txtrInTheatersNow = new JTextArea();
		txtrInTheatersNow.setForeground(Color.BLACK);
		txtrInTheatersNow.setText("Now in Theaters:");
		txtrInTheatersNow.setFont(new Font("Menlo", Font.PLAIN, 20));
		txtrInTheatersNow.setBackground(SystemColor.window);
		txtrInTheatersNow.setBounds(463, 104, 192, 36);
		frame.getContentPane().add(txtrInTheatersNow);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("TextComponent.selectionBackgroundInactive"));
		if (this.finalMovies == null) {
			textPane.setText("");
		} else {
			String displayMe = displayMovies();
			textPane.setText(displayMe);
		}
		textPane.setBounds(463, 152, 190, 265);
		frame.getContentPane().add(textPane);
		
		JPanel seatingPanel = new JPanel();
		seatingPanel.setBounds(21, 232, 401, 205);
		frame.getContentPane().add(seatingPanel);
		
		JTextArea txtrMovieName = new JTextArea();
		txtrMovieName.setText("Movie Name - Theater # - Seat #");
		txtrMovieName.setForeground(UIManager.getColor("Desktop.background"));
		txtrMovieName.setFont(new Font("Menlo", Font.PLAIN, 18));
		txtrMovieName.setBackground(SystemColor.window);
		txtrMovieName.setBounds(228, 551, 386, 36);
		frame.getContentPane().add(txtrMovieName);

		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 425, 613, 115);
		frame.getContentPane().add(panel_2);
		
		JTextArea customerSeats = new JTextArea();
		//customerSeats.setForeground(Color.GRAY);
		customerSeats.setBounds(30, 425, 613, 115);
		customerSeats.setBackground(UIManager.getColor("ToolBar.background"));
		customerSeats.setLineWrap(true);
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEnabled(false);
				btnSelect.setEnabled(false);
				for(int i = 0; i<b.size();i++) {
					if(b.get(i).getBackground()==Color.green) {
						selectedSeats.add(b.get(i).getText());
						//System.out.println(b.get(i).getText());
						
					}
				}
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i<selectedSeats.size(); i++) {
					sb.append(selectedSeats.get(i)+"  ");
				}
				String customerFinal = "Your movie: " + returnSize()[returnCustomerResonse()].getMovie().getName() + " | Theater #"
				+ (returnCustomerResonse()+1) + " | Seats: " + sb.toString();
				customerSeats.setText(customerFinal);
				JButton jb = (JButton)e.getSource();
				jb.setEnabled(false);
				for(int i = 0; i<b.size();i++) {
					b.get(i).setEnabled(false);
				}
				
				
			}
		});
		
		panel_1.add(btnsubmit);
		panel_2.add(customerSeats);
		
		

		
		//SeatsAgain seatsAgain = new SeatsAgain();
		
			}
	
	private void addMovies(String s) throws IOException {
		this.list.addMovie(s);
	}
	
	private void screenAdd(int movieNumber, boolean name, boolean star, boolean genre, boolean rd, boolean rating, boolean runtime, boolean score) throws FileNotFoundException {
			Scanner s = new Scanner(System.in);
			ArrayList<Movie> movies = list.getMovieList();
			//System.out.println("Welcome to Owner Mode!");
			//System.out.print("How many screens are in the theater?: ");
			//int screenAmount = 1;
			ArrayList<Movie> returnMe= new ArrayList<>();
			
				//System.out.println("Search for a movie to run on Screen #" + (i+1) + ": ");
				//Movie movie = null;
				//while (movie == null) {
					//System.out.print("What do you want to search by? (Name), (Stars), (Genres), (Release Date), (Rating), (Run Time), (Score): ");
					
					//String response = textField.getText().toLowerCase();
					if (name == true) {
						//System.out.print("Enter in the name of the movie: ");
						String movieName = textField_2.getText();
						returnMe = list.search(movieName, null, null, null, null, null, -1);
						if (returnMe.size() == 0) {
							txtpnMoviesGoHere.setText("No movies found.");;
						}
						else {
							String text = "Movies found:\n";
							//System.out.println("Movies found:");
							int display = 0;
							for (int z = 0; z < returnMe.size(); z++) {
								text = text + ("(" + z + ")" + returnMe.get(z).getName() + "\t");
								display++;
								if (display == 5) {
									text = text + ("");
									display = 0;
								}
							} // end of displaying movies
							txtpnMoviesGoHere.setText(text);
//							System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
//							int movieNum = Integer.parseInt(s.nextLine());
//							System.out.print("How many seats are in this Screen?: ");
//							int seatsSize = 50;
//							int [] screenSeats = new int[seatsSize];
//							movie = temp.get(movieNum);
//							screens[movieNumber] = new Screen(movie, screenSeats);
						} // end of if/else chain
					} // end of if name
					else if (star == true) {
						//System.out.print("Enter in the star of the movie: ");
						String starName = textField_2.getText();
						String[] starray = new String[1];
						starray[0] = starName;
						returnMe = list.search(null, starray, null, null, null, null, -1);
						if (returnMe.size() == 0) {
							txtpnMoviesGoHere.setText("No movies found.");;
						}
						else {
							String text = "Movies found:\n";
							//System.out.println("Movies found:");
							int display = 0;
							for (int z = 0; z < returnMe.size(); z++) {
								text = text + ("(" + z + ")" + returnMe.get(z).getName() + "\t");
								display++;
								if (display == 5) {
									text = text + ("");
									display = 0;
								}
							} // end of displaying movies
							txtpnMoviesGoHere.setText(text);
//							System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
//							int movieNum = Integer.parseInt(s.nextLine());
//							System.out.print("How many seats are in this Screen?: ");
//							int seatsSize = 50;
//							int [] screenSeats = new int[seatsSize];
//							movie = temp.get(movieNum);
//							screens[movieNumber] = new Screen(movie, screenSeats);
						} // end of if/else chain
					}
					else if (genre == true) {
						//System.out.print("Enter in the genre of the movie: ");
						String genreName = textField_2.getText();
						String[] genreArr = new String[1];
						genreArr[0] = genreName;
						returnMe = list.search(null, null, genreArr, null, null, null, -1);
						if (returnMe.size() == 0) {
							txtpnMoviesGoHere.setText("No movies found.");;
						}
						else {
							String text = "Movies found:\n";
							//System.out.println("Movies found:");
							int display = 0;
							for (int z = 0; z < returnMe.size(); z++) {
								text = text + ("(" + z + ")" + returnMe.get(z).getName() + "\t");
								display++;
								if (display == 5) {
									text = text + ("");
									display = 0;
								}
							} // end of displaying movies
							txtpnMoviesGoHere.setText(text);
//							System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
//							int movieNum = Integer.parseInt(s.nextLine());
//							System.out.print("How many seats are in this Screen?: ");
//							int seatsSize = 50;
//							int [] screenSeats = new int[seatsSize];
//							movie = temp.get(movieNum);
//							screens[movieNumber] = new Screen(movie, screenSeats);
						} // end of if/else chain
					}
					else if (rd == true) {
						//System.out.print("Enter in the release date of the movie: ");
						String releaseDate = textField_2.getText();
						returnMe = list.search(null, null, null, releaseDate, null, null, -1);
						if (returnMe.size() == 0) {
							txtpnMoviesGoHere.setText("No movies found.");;
						}
						else {
							String text = "Movies found:\n";
							//System.out.println("Movies found:");
							int display = 0;
							for (int z = 0; z < returnMe.size(); z++) {
								text = text + ("(" + z + ")" + returnMe.get(z).getName() + "\t");
								display++;
								if (display == 5) {
									text = text + ("");
									display = 0;
								}
							} // end of displaying movies
							txtpnMoviesGoHere.setText(text);
//							System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
//							int movieNum = Integer.parseInt(s.nextLine());
//							System.out.print("How many seats are in this Screen?: ");
//							int seatsSize = 50;
//							int [] screenSeats = new int[seatsSize];
//							movie = temp.get(movieNum);
//							screens[movieNumber] = new Screen(movie, screenSeats);
						} // end of if/else chain
					}
					else if (rating == true) {
						//System.out.print("Enter in the rating of the movie: ");
						String rating1 = textField_2.getText();
						returnMe = list.search(null, null, null, null, rating1, null, -1);
						if (returnMe.size() == 0) {
							txtpnMoviesGoHere.setText("No movies found.");;
						}
						else {
							String text = "Movies found:\n";
							//System.out.println("Movies found:");
							int display = 0;
							for (int z = 0; z < returnMe.size(); z++) {
								text = text + ("(" + z + ")" + returnMe.get(z).getName() + "\t");
								display++;
								if (display == 5) {
									text = text + ("");
									display = 0;
								}
							} // end of displaying movies
							txtpnMoviesGoHere.setText(text);
//							System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
//							int movieNum = Integer.parseInt(s.nextLine());
//							System.out.print("How many seats are in this Screen?: ");
//							int seatsSize = 50;
//							int [] screenSeats = new int[seatsSize];
//							movie = temp.get(movieNum);
//							screens[movieNumber] = new Screen(movie, screenSeats);
						} // end of if/else chain
					}
					else if (runtime == true) {
						//System.out.print("Enter in the run time of the movie: ");
						String runTime = textField_2.getText();
						returnMe = list.search(null, null, null, null, null, runTime, -1);
						if (returnMe.size() == 0) {
							txtpnMoviesGoHere.setText("No movies found.");;
						}
						else {
							String text = "Movies found:\n";
							//System.out.println("Movies found:");
							int display = 0;
							for (int z = 0; z < returnMe.size(); z++) {
								text = text + ("(" + z + ")" + returnMe.get(z).getName() + "\t");
								display++;
								if (display == 5) {
									text = text + ("");
									display = 0;
								}
							} // end of displaying movies
							txtpnMoviesGoHere.setText(text);
//							System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
//							int movieNum = Integer.parseInt(s.nextLine());
//							System.out.print("How many seats are in this Screen?: ");
//							int seatsSize = 50;
//							int [] screenSeats = new int[seatsSize];
//							movie = temp.get(movieNum);
//							screens[movieNumber] = new Screen(movie, screenSeats);
						} // end of if/else chain
					}
					else if (score == true) {
						//System.out.print("Enter in the score of the movie: ");
						double score1 = Double.parseDouble(textField_2.getText());
						returnMe = list.search(null, null, null, null, null, null, score1);
						if (returnMe.size() == 0) {
							txtpnMoviesGoHere.setText("No movies found.");
						}
						else {
							String text = "Movies found:\n";
							//System.out.println("Movies found:");
							int display = 0;
							for (int z = 0; z < returnMe.size(); z++) {
								text = text + ("(" + z + ")" + returnMe.get(z).getName() + "\t");
								display++;
								if (display == 5) {
									text = text + ("");
									display = 0;
								}
							} // end of displaying movies
							txtpnMoviesGoHere.setText(text);
							//System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
//							int movieNum = Integer.parseInt(s.nextLine());
//							System.out.print("How many seats are in this Screen?: ");
//							int seatsSize = 50;
//							int [] screenSeats = new int[seatsSize];
//							movie = temp.get(movieNum);
//							screens[movieNumber] = new Screen(movie, screenSeats);
						} // end of if/else chain
					}
					else {
						//System.out.println("No movies found.");
					} // if/else if chain for search result
				//} // while chain for selecting movie
			 // end of search
				//ownerMode();
				this.nowPlaying = returnMe;
	}
	
	private void setMovie(int movieArrayList, int index) {
		int [] seats = new int [50];
		this.finalMovies[index] = new Screen(nowPlaying.get(movieArrayList), seats);
	}
	
	private Screen[] returnSize () {
		return this.finalMovies;
	}
	
	private void setFinalSize (int i) {
		this.finalMovies = new Screen[i];
	}
	
	private String displayMovies () {
		String showMovies = "";
		Screen[] screens = returnSize();
		for (int i = 0; i < screens.length; i++) {
			if (screens[i] != null) {
				showMovies = showMovies +  (i+1) + ". " + screens[i].getMovie().getName() + "\n";
			}
		}
		return showMovies;
	}
	
	private String getDescription (int i) {
		return (this.finalMovies[i].getMovie().getName() + " | " + this.finalMovies[i].getMovie().getSummary() + " | " +
				this.finalMovies[i].getMovie().getRating() + " | " + this.finalMovies[i].getMovie().getRunTime());
	}
	
	private void setScreenAmount (int i) {
		this.screenAmount = i;
	}
	
	private int returnScreenAmount () {
		return this.screenAmount;
	}
	
	private void setCustomerResponse(int i) {
		this.userResponse = i;
	}
	
	private int returnCustomerResonse() {
		return this.userResponse;
	}
}
