package co.eduardoFuentes.swing1.ventana;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaLogin extends JFrame{
	
	private JButton boton1;
	private JButton boton2;
	public VentanaLogin() {
		
		super("APP ventas");
		
		this.setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		this.boton1 = new JButton("Saludar");
		this.boton1.setSize(100,100);
		
		this.boton2 = new JButton("Despedirse");
		
		this.getContentPane().add(boton1);
		this.getContentPane().add(boton2);
		
		
		setVisible(true);
		
	}
	
	
}
