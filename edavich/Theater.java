import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class Theater {

	private JFrame frame;
	private JTextField txtChooseMode;
	private JPasswordField passwordField;
	private JTextField txtSelectMode;
	private JTextField textField_2;
	private JTextArea txtrChooseScreen;
	private JTextArea txtrSearch;

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
	 */
	public Theater() {
		initialize();
		//ownerMode();	
		//customerMode();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 675, 500);
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
				
			}
		});
		btnOwner.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnOwner.setBounds(437, 6, 82, 36);
		frame.getContentPane().add(btnOwner);
		
		JButton btnCustomer = new JButton("Customer");
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
		frame = new JFrame();
		frame.setBounds(150, 150, 675, 500);
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
				
			}
		});
		btnOwner.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnOwner.setBounds(437, 6, 82, 36);
		frame.getContentPane().add(btnOwner);
		
		JButton btnCustomer = new JButton("Customer");
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(435, 46, 208, 26);
		frame.getContentPane().add(passwordField);
		
		JTextField textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(241, 102, 159, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrEnterTheNumber = new JTextArea();
		txtrEnterTheNumber.setBackground(UIManager.getColor("ColorChooser.background"));
		txtrEnterTheNumber.setFont(new Font("Menlo", Font.BOLD, 13));
		txtrEnterTheNumber.setText("Enter the # of screens:");
		txtrEnterTheNumber.setBounds(21, 107, 231, 16);
		frame.getContentPane().add(txtrEnterTheNumber);
		
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
		textField_2.setBounds(105, 275, 295, 26);
		frame.getContentPane().add(textField_2);
		
		txtrChooseScreen = new JTextArea();
		txtrChooseScreen.setText("Choose screen # for movie:");
		txtrChooseScreen.setFont(new Font("Menlo", Font.BOLD, 13));
		txtrChooseScreen.setBackground(SystemColor.window);
		txtrChooseScreen.setBounds(21, 435, 208, 16);
		frame.getContentPane().add(txtrChooseScreen);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(241, 430, 159, 26);
		frame.getContentPane().add(textField_3);
		
		txtrSearch = new JTextArea();
		txtrSearch.setText("Search:");
		txtrSearch.setFont(new Font("Menlo", Font.BOLD, 13));
		txtrSearch.setBackground(SystemColor.window);
		txtrSearch.setBounds(21, 280, 82, 16);
		frame.getContentPane().add(txtrSearch);
		
		JRadioButton rdbtnName = new JRadioButton("Name");
		rdbtnName.setBounds(21, 202, 141, 23);
		frame.getContentPane().add(rdbtnName);
		
		JRadioButton rdbtnGenre = new JRadioButton("Genre");
		rdbtnGenre.setBounds(21, 237, 139, 23);
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
		txtrInTheatersNow.setForeground(UIManager.getColor("Desktop.background"));
		txtrInTheatersNow.setText("Now in Theaters:");
		txtrInTheatersNow.setFont(new Font("Menlo", Font.PLAIN, 20));
		txtrInTheatersNow.setBackground(SystemColor.window);
		txtrInTheatersNow.setBounds(463, 104, 192, 36);
		frame.getContentPane().add(txtrInTheatersNow);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("TextComponent.selectionBackgroundInactive"));
		textPane.setText("1. ");
		textPane.setBounds(463, 152, 190, 299);
		frame.getContentPane().add(textPane);
		
		JTextPane txtpnMoviesGoHere = new JTextPane();
		txtpnMoviesGoHere.setText("Movies go here");
		txtpnMoviesGoHere.setBackground(UIManager.getColor("ToolBar.background"));
		txtpnMoviesGoHere.setBounds(21, 318, 377, 100);
		frame.getContentPane().add(txtpnMoviesGoHere);
	}
	
	
	private void customerMode() {
		frame = new JFrame();
		frame.setBounds(150, 150, 675, 560);
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
				
			}
		});
		btnOwner.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnOwner.setBounds(437, 6, 82, 36);
		frame.getContentPane().add(btnOwner);
		
		JButton btnCustomer = new JButton("Customer");
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 105, 252, 26);
		frame.getContentPane().add(textField_2);
		
		txtrChooseScreen = new JTextArea();
		txtrChooseScreen.setText("Your Movie Selection:");
		txtrChooseScreen.setFont(new Font("Menlo", Font.BOLD, 16));
		txtrChooseScreen.setBackground(SystemColor.window);
		txtrChooseScreen.setBounds(21, 495, 224, 16);
		frame.getContentPane().add(txtrChooseScreen);
		
		txtrSearch = new JTextArea();
		txtrSearch.setText("Select movie:");
		txtrSearch.setFont(new Font("Menlo", Font.BOLD, 13));
		txtrSearch.setBackground(SystemColor.window);
		txtrSearch.setBounds(21, 110, 117, 16);
		frame.getContentPane().add(txtrSearch);
		
		JTextArea txtrInTheatersNow = new JTextArea();
		txtrInTheatersNow.setForeground(UIManager.getColor("Desktop.background"));
		txtrInTheatersNow.setText("Now in Theaters:");
		txtrInTheatersNow.setFont(new Font("Menlo", Font.PLAIN, 20));
		txtrInTheatersNow.setBackground(SystemColor.window);
		txtrInTheatersNow.setBounds(463, 104, 192, 36);
		frame.getContentPane().add(txtrInTheatersNow);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("TextComponent.selectionBackgroundInactive"));
		textPane.setText("1. ");
		textPane.setBounds(463, 152, 190, 299);
		frame.getContentPane().add(textPane);
		
		JTextPane txtpnMoviesGoHere = new JTextPane();
		txtpnMoviesGoHere.setText("Movie description goes here");
		txtpnMoviesGoHere.setBackground(UIManager.getColor("ToolBar.background"));
		txtpnMoviesGoHere.setBounds(21, 152, 377, 58);
		frame.getContentPane().add(txtpnMoviesGoHere);
		
		JPanel seatingPanel = new JPanel();
		seatingPanel.setBounds(21, 232, 401, 205);
		frame.getContentPane().add(seatingPanel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Menlo", Font.PLAIN, 16));
		btnSubmit.setBounds(306, 445, 121, 26);
		frame.getContentPane().add(btnSubmit);
		
		JTextArea txtrMovieName = new JTextArea();
		txtrMovieName.setText("Movie Name - Theater # - Seat #");
		txtrMovieName.setForeground(UIManager.getColor("Desktop.background"));
		txtrMovieName.setFont(new Font("Menlo", Font.PLAIN, 18));
		txtrMovieName.setBackground(SystemColor.window);
		txtrMovieName.setBounds(245, 493, 386, 36);
		frame.getContentPane().add(txtrMovieName);
	}
}
