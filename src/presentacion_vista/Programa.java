package presentacion_vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

public class Programa extends JPanel {
	
	public Programa() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(71, 42, 232, 168);
		add(list);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(81, 221, 214, 33);
		add(btnNewButton);

	}
}
