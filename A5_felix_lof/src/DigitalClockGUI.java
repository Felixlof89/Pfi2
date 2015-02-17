import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;


public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.setBounds(190, 377, 115, 29);
		contentPane.add(btnSetAlarm);
		
		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.setBounds(320, 377, 115, 29);
		contentPane.add(btnClearAlarm);
		
		textField = new JTextField();
		textField.setBounds(129, 378, 46, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(64, 378, 46, 26);
		contentPane.add(textField_1);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(15, 381, 69, 20);
		contentPane.add(lblTime);
		
		JLabel label = new JLabel(":");
		label.setBounds(114, 381, 69, 20);
		contentPane.add(label);
		
		JLabel lblTimeSet = new JLabel("Time set:");
		lblTimeSet.setBounds(450, 381, 69, 20);
		contentPane.add(lblTimeSet);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(534, 379, 151, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 65, 685, 213);
		contentPane.add(lblNewLabel_1);
		
		//Här börjar konstruktorn
		
	}
	
	public setTimeOnLabel (String time){
		
	}
	public alarm (boolean actrivate){
		
	}
}
