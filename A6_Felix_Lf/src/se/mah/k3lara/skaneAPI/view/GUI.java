package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.JourneysThread;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.model.StationsThread;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class GUI extends JFrame {

	public JPanel contentPane;
	public JTextField searchbox;
	public ArrayList<Station> searchStations;
	public JTextField from;
	public JTextField to;
	public JTextArea textArea = new JTextArea();
	public JTextArea results = new JTextArea();
	

	
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 275, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		searchbox = new JTextField();
		searchbox.setBounds(6, 6, 134, 28);
		panel.add(searchbox);
		searchbox.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 46, 263, 248);
		panel.add(scrollPane);

		
		scrollPane.setViewportView(results);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(293, 6, 539, 300);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(6, 12, 61, 16);
		panel_1.add(lblFrom);

		from = new JTextField();
		from.setBounds(55, 6, 134, 28);
		panel_1.add(from);
		from.setColumns(10);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(204, 12, 61, 16);
		panel_1.add(lblTo);

		to = new JTextField();
		to.setBounds(235, 6, 134, 28);
		panel_1.add(to);
		to.setColumns(10);

		
		textArea.setBounds(6, 43, 480, 251);
		panel_1.add(textArea);

		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread tJ = new JourneysThread(GUI.this);
				tJ.start();
			}
		});
		btnSearch_1.setBounds(373, 7, 117, 29);
		panel_1.add(btnSearch_1);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread tS = new StationsThread(GUI.this);
				tS.start();
			}
		});
		btnSearch.setBounds(152, 7, 117, 29);
		panel.add(btnSearch);

	}
}
