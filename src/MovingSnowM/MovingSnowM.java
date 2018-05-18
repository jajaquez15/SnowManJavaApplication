package MovingSnowM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.text.Document;

import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.Canvas;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class MovingSnowM {
	public static String[][] screen =  new String[9][15];
	private JFrame frame;
	private JTextField SingleW;
	private JTextField SingleL;
	private JTextField MultiW;
	private JTextField MultiL;
	private JTextField Message1;
	private JTextField Message2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//Instance of Classes
				SnowMan n1 = new SnowMan();
				End en1 = new End();
				ScoreKeeper sk1 = new ScoreKeeper();
				Player2 player2 = new Player2();
				try {
					MovingSnowM window = new MovingSnowM();
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
	public MovingSnowM() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(333, 453, 123, 29);
		frame.getContentPane().add(textArea_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		textArea.setBounds(167, 67, 460, 332);
		frame.getContentPane().add(textArea);
		
		JLabel lblController = new JLabel("Controller 1");
		lblController.setForeground(UIManager.getColor("ComboBox.selectionBackground"));
		lblController.setBounds(198, 411, 78, 16);
		frame.getContentPane().add(lblController);
		Timer t1 = new Timer();
		
		
		JButton btnNewButton = new JButton("Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SnowMan.SnowY <= 0) {
					SnowMan.SnowY = 0;
					SnowMan.SnowBallY = 0;
					Display(textArea);
					
				}
				else {
				SnowMan.SnowY = SnowMan.SnowY -1;
				SnowMan.SnowBallY = SnowMan.SnowBallY -1;
				if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					ScoreKeeper.MultW = ScoreKeeper.MultW + 1;
					SingleL.setText(String.valueOf(ScoreKeeper.SingleL));
					MultiW.setText(String.valueOf(ScoreKeeper.MultW));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					Display(textArea);
					textArea_1.setText(null);
				}
				else {
					textArea.setText(null);
					Display(textArea);
				}
			}}
		});
		btnNewButton.setBounds(126, 453, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Left");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SnowMan.SnowX >= 14) {
					SnowMan.SnowX = 0;
					SnowMan.SnowBallX = 0;
					Display(textArea);
				}
				else {
				SnowMan.SnowX =SnowMan.SnowX -1;
				SnowMan.SnowBallX =SnowMan.SnowBallX -1;
				if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					ScoreKeeper.MultW = ScoreKeeper.MultW + 1;
					SingleL.setText("L: "+String.valueOf(ScoreKeeper.SingleL));
					MultiW.setText("W: "+String.valueOf(ScoreKeeper.MultW));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					Display(textArea);
					textArea_1.setText(null);
				}else {
				textArea.setText(null);
				Display(textArea);}
				}
			}
		});
		btnNewButton_1.setBounds(24, 494, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Down");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(SnowMan.SnowY >= 8) {
					SnowMan.SnowY = 0;
					SnowMan.SnowBallY = 0;
					Display(textArea);
					
				}
				else {
					SnowMan.SnowY =SnowMan.SnowY +1;
					SnowMan.SnowBallY =SnowMan.SnowBallY +1;
					if(SnowMan.SnowX == End.EndX && SnowMan.SnowY == End.EndY) {
					ScoreKeeper.SingleW = ScoreKeeper.SingleW + 1;
					SingleW.setText("W: "+String.valueOf(ScoreKeeper.SingleW));
					textArea_1.append("Player #1 won");
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					Display(textArea);
				}
				else if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					ScoreKeeper.MultW = ScoreKeeper.MultW + 1;
					
					SingleL.setText("L :"+String.valueOf(ScoreKeeper.SingleL));
					MultiW.setText("W :"+String.valueOf(ScoreKeeper.MultW));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					
					textArea.setText(null);
					Display(textArea);
				}else {
					textArea.setText(null);
					Display(textArea);
				}
			}}
		});
		btnNewButton_2.setBounds(126, 543, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Right");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SnowMan.SnowX = SnowMan.SnowX + 1;
				SnowMan.SnowBallX = SnowMan.SnowBallX + 1;
				
				if(SnowMan.SnowX == End.EndX && SnowMan.SnowY == End.EndY) {
					
					ScoreKeeper.SingleW = ScoreKeeper.SingleW + 1;
					SingleW.setText("W :"+String.valueOf(ScoreKeeper.SingleW));
					textArea_1.append("Player #1 won");
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					
					Display(textArea);
					textArea_1.setText(null);
				}
				else if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					SingleL.setText("L: "+String.valueOf(ScoreKeeper.SingleL));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					
					Display(textArea);
					textArea_1.setText(null);
				}
				else {
					textArea.setText(null);
					Display(textArea);
				}
			}
		});
		btnNewButton_3.setBounds(231, 494, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		Display(textArea);
		
		JLabel lblController_1 = new JLabel("Controller 2");
		lblController_1.setForeground(Color.RED);
		lblController_1.setBounds(543, 411, 84, 16);
		frame.getContentPane().add(lblController_1);
		
		JButton btnNewButton_4 = new JButton("Left");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player2.pX =Player2.pX -1;
				if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					ScoreKeeper.MultW = ScoreKeeper.MultW + 1;
					
					SingleL.setText("L: "+String.valueOf(ScoreKeeper.SingleL));
					MultiW.setText("W: "+String.valueOf(ScoreKeeper.MultW));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					
					Display(textArea);
					textArea_1.setText(null);
				}else {
				
				textArea.setText(null);
				Display(textArea);}
			}
		});
		btnNewButton_4.setBounds(449, 494, 117, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Up");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player2.pY =Player2.pY -1;
				if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					ScoreKeeper.MultW = ScoreKeeper.MultW + 1;
					
					SingleL.setText("L: "+String.valueOf(ScoreKeeper.SingleL));
					MultiW.setText("W: "+String.valueOf(ScoreKeeper.MultW));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					
					Display(textArea);
					textArea_1.setText(null);
				}else {
				textArea.setText(null);
				Display(textArea);}
			}});
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setBounds(558, 454, 117, 29);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Right");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player2.pX =Player2.pX +1;
				if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					ScoreKeeper.MultW = ScoreKeeper.MultW + 1;
					
					SingleL.setText("L: "+String.valueOf(ScoreKeeper.SingleL));
					MultiW.setText("W: "+String.valueOf(ScoreKeeper.MultW));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					
					Display(textArea);
					textArea_1.setText(null);
				}else {
				
				textArea.setText(null);
				Display(textArea);}
			}
		});
		btnNewButton_6.setBounds(657, 494, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Down");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player2.pY =Player2.pY +1;
				if(SnowMan.SnowX == Player2.pX && SnowMan.SnowY == Player2.pY) {
					ScoreKeeper.SingleL = ScoreKeeper.SingleL + 1;
					ScoreKeeper.MultW = ScoreKeeper.MultW + 1;
					
					SingleL.setText("L: "+String.valueOf(ScoreKeeper.SingleL));
					MultiW.setText("W: "+String.valueOf(ScoreKeeper.MultW));
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					
					Display(textArea);
					textArea_1.setText(null);
				}else {
				
				textArea.setText(null);
				Display(textArea);}
			}
		});
		btnNewButton_7.setBounds(565, 543, 117, 29);
		frame.getContentPane().add(btnNewButton_7);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(360, 406, 67, 188);
		frame.getContentPane().add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("SnowMan Game");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(333, 6, 169, 35);
		frame.getContentPane().add(lblNewLabel);
		
		SingleW = new JTextField();
		SingleW.setBounds(184, 10, 67, 26);
		frame.getContentPane().add(SingleW);
		SingleW.setColumns(10);
		
		SingleL = new JTextField();
		SingleL.setBounds(254, 10, 67, 26);
		frame.getContentPane().add(SingleL);
		SingleL.setColumns(10);
		
		MultiW = new JTextField();
		MultiW.setColumns(10);
		MultiW.setBounds(449, 10, 67, 26);
		frame.getContentPane().add(MultiW);
		
		MultiL = new JTextField();
		MultiL.setColumns(10);
		MultiL.setBounds(514, 10, 67, 26);
		frame.getContentPane().add(MultiL);
		
		
		
		
		
		
		JButton btnNewButton_8 = new JButton("Snow");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SnowMan.SnowBallX = SnowMan.SnowBallX + 2;
				if(SnowMan.SnowBallX == Player2.pX && SnowMan.SnowBallY == Player2.pY) {
					
					ScoreKeeper.SingleW = ScoreKeeper.SingleW + 1;
					SingleW.setText("W :"+String.valueOf(ScoreKeeper.SingleW));
					textArea_1.append("Player #1 won");
					textArea.setText(null);
					SnowMan.SnowX = SnowMan.SnowX - SnowMan.SnowX;
					SnowMan.SnowY = SnowMan.SnowY - SnowMan.SnowY;
					SnowMan.SnowBallX = SnowMan.SnowBallX - SnowMan.SnowBallX;
					SnowMan.SnowBallY = SnowMan.SnowBallY - SnowMan.SnowBallY;
					Display(textArea);
					textArea_1.setText(null);
				}
				
				else {
					SnowMan.SnowBallX = SnowMan.SnowBallX - 2;
					textArea.setText(null);
					Display(textArea);
				}
			}
		});
		btnNewButton_8.setBounds(148, 494, 71, 29);
		frame.getContentPane().add(btnNewButton_8);
		
	}
	public static void Display(JTextArea l) {
		for(int i=0; i < 9;i++) {
			for(int j=0; j < 15;j++) {
				screen[i][j] = "☁";
			}
		}
		screen[SnowMan.SnowBallY][SnowMan.SnowBallX] = SnowMan.SnowBallImg;
		screen[SnowMan.SnowY][SnowMan.SnowX]= "☃";
		
		screen[End.EndY][End.EndX] = "☂";
		screen[Player2.pY][Player2.pX] = "@";
		
		for(int i=0; i < 9;i++) {
			for(int j=0; j < 15;j++) {
				l.append(screen[i][j]);
			}
			l.append("\n");
		}
	}
}
