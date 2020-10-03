package presentacion_vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class Modificar extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	
	public Modificar() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 11, 380, 187);
		add(list);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(280, 220, 107, 29);
		add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 220, 80, 24);
		add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 220, 80, 24);
		add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(190, 220, 80, 24);
		add(textField_2);

	}

}
