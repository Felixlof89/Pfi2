import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class animalStore extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					animalStore frame = new animalStore();
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
	public animalStore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 490, 279);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		ArrayList<Animal> animalStore = new ArrayList<Animal>();
		animalStore.add (new Dog("Dog", 6,true, "Fido")); 
		animalStore.add (new Cat("Cat", 3, 9));
		Cat cat = new Cat("cat", 3, 9);
		cat.setFriendlyName("misse");
		animalStore.add(cat);
		animalStore.add (new Snake("Snakus Poisonus", true));
		animalStore.add (new Snake("Snakus Poisonus", false));
		
		for (Animal animal : animalStore){
			textArea.append (animal.getInfo() + "\n");
	}
	
	}
}
