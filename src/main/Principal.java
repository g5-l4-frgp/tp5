package main;

import java.awt.EventQueue;

import presentacion_vista.Ventana_principal;

public class Principal {
	
	Ventana_principal vn = new Ventana_principal();

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_principal vn = new Ventana_principal();
				
					vn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
