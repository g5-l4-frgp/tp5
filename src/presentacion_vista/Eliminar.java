package presentacion_vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eliminar extends JPanel {

	/**
	 * Create the panel.
	 */
	public Eliminar() {
		setLayout(null);
		
		JLabel lblEliminar = new JLabel("Eliminar usuarios");
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEliminar.setBounds(144, 33, 111, 14);
		add(lblEliminar);
		
		JList list = new JList();
		list.setBounds(89, 54, 222, 188);
		add(list);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(129, 253, 126, 30);
		add(btnNewButton);

	}

}
