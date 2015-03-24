import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField hour;
	private JTextField minute;
	private JTextField currentTime;
	private JTextField alarmAt;
	private ClockLogic clock;

	public boolean alarm = false;

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
		setTitle("My Alarm Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHour = new JLabel("Hour:");
		lblHour.setBounds(6, 220, 61, 16);
		contentPane.add(lblHour);

		hour = new JTextField();
		hour.setBounds(48, 214, 43, 28);
		contentPane.add(hour);
		hour.setColumns(10);

		JLabel lblMinute = new JLabel("Minute:");
		lblMinute.setBounds(103, 220, 52, 16);
		contentPane.add(lblMinute);

		minute = new JTextField();
		minute.setBounds(155, 214, 52, 28);
		contentPane.add(minute);
		minute.setColumns(10);

		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String h = hour.getText();
				String m = minute.getText();

			
			int intHour = Integer.valueOf(h);
				int intMinute = Integer.valueOf(m);

				if (intHour >= 0 && intHour <= 23 && intMinute >= 0
						&& intMinute <= 59) {
					clock.setAlarm(intHour, intMinute);
					alarmAt.setText(h + ":" + m);
				} else {
					System.out
							.println("Timmar = 00-23, minuter = 0-59");

				}

			}
		});
		btnSetAlarm.setBounds(219, 215, 117, 29);
		contentPane.add(btnSetAlarm);

		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clock.clearAlarm();
				alarmAt.setText("");
				contentPane.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnClearAlarm.setBounds(348, 215, 117, 29);
		contentPane.add(btnClearAlarm);

		currentTime = new JTextField();
		currentTime.setOpaque(false);
		currentTime.setFont(new Font("Tahoma", Font.BOLD, 40));
		currentTime.setBounds(51, 45, 230, 113);
		contentPane.add(currentTime);
		currentTime.setColumns(10);

		JLabel lblAlarmAt = new JLabel("Alarm:");
		lblAlarmAt.setBounds(296, 97, 83, 28);
		contentPane.add(lblAlarmAt);

		alarmAt = new JTextField();
		alarmAt.setBounds(292, 130, 66, 28);
		contentPane.add(alarmAt);
		alarmAt.setColumns(10);

		clock = new ClockLogic(this);
	}

	// skriver current time
	public void setTimeOnLabel(String time) {
		currentTime.setText(time);
	}

	// kollar om alarmet ringer och ändrar bakgrund
	public void alarm(boolean isActive) {
		if (isActive) {
			alarm = true;
			System.out.println("Alarm is ringing");
			contentPane.setBackground(Color.RED);

		} else {
			alarm = false;
			contentPane.setBackground(Color.LIGHT_GRAY);

		}
	}
}
