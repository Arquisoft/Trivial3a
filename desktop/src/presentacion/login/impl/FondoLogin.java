package presentacion.login.impl;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoLogin extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FondoLogin() {
		setBounds(100, 100, 909, 682);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Dimension tam = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/presentacion/login/img/fondo.jpg"));
		g.drawImage(imagenFondo.getImage(), 0, 0, tam.width, tam.height, null);
		setOpaque(false);
		super.paintComponent(g);
		
	}

}
