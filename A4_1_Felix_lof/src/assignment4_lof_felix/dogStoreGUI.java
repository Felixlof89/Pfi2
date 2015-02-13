package assignment4_lof_felix;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dogStoreGUI extends JFrame {

	private Human human;
	private Dog dog;
	
	private JPanel contentPane;
	private JTextField textFieldHuman;
	private JTextField textFieldDog;
	private JButton btnHuman;
	private JButton btnDog;
	private JButton btnInfo;
	private JTextArea textAreaError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dogStoreGUI frame = new dogStoreGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dogStoreGUI() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//error msg
		textAreaError = new JTextArea();
		textAreaError.setBounds(25, 371, 482, 87);
		contentPane.add(textAreaError);
		
		textFieldHuman = new JTextField();
		textFieldHuman.setBounds(100, 62, 146, 26);
		contentPane.add(textFieldHuman);
		textFieldHuman.setColumns(10);
		
		textFieldDog = new JTextField();
		textFieldDog.setColumns(10);
		textFieldDog.setBounds(100, 125, 146, 26);
		contentPane.add(textFieldDog);
		
		final JTextArea textAreaInfo = new JTextArea();
		textAreaInfo.setBounds(15, 278, 492, 77);
		contentPane.add(textAreaInfo);
		
		//Human Knapp
		btnHuman = new JButton("Human");
		btnHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (textFieldHuman.getText().length() < 3){
					textAreaError.setText("Ett namn ska ha tre boksäver");
					
				} else {
					human = new Human (textFieldHuman.getText());
					textFieldHuman.setText("");
				}
				
							
										
			
					
			}
		});
		
		//Human Knapp ?
		btnHuman.setBounds(350, 61, 115, 29);
		contentPane.add(btnHuman);
		
		//Dog Knapp
		btnDog = new JButton("Dog");
		btnDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//om textfieldhuman innehåller en human så skriv dog
				
				textFieldHuman.getText();
				if (human == null){
					textAreaError.setText ("Hunden måste ha en ägare. ");
				} else{
					dog = new Dog(textFieldDog.getText());
					human.buyDog(dog);
					
				}
				
				
				
			}
		});
		btnDog.setBounds(350, 124, 115, 29);
		contentPane.add(btnDog);
		
		//Info Knapp
		btnInfo = new JButton("Show Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreaInfo.setText(human.getInfo());
				textFieldDog.getText();
			}
		});
		btnInfo.setBounds(350, 192, 115, 29);
		contentPane.add(btnInfo);
		
		
	}

}
