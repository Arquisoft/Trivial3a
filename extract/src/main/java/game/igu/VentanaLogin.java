package game.igu;

import game.acciones.impl.IniciarJuegoAction;
import game.acciones.impl.ValidarseAction;
import game.acciones.util.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JPanel pnPrincipal;
	private JPanel pnRegistro;
	private JPanel pnLogin;
	private JPanel pnListaJugadores;
	private JLabel lbJugadores;
	private JButton btIniciarJuego;
	private JScrollPane scrLista;
	private JList<String> listaJugadores;
	private JLabel lbRegistro;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JLabel lbEmail;
	private JTextField txEmail;
	private JPanel pnDatos;
	private JButton btRegistrarse;
	private JLabel lbEntrar;
	private JPanel pnDatosEntrar;
	private JLabel lbNombreEntrar;
	private JTextField txNombreEntrar;
	private JLabel lbPassword;
	private JButton btEntrar;
	private JPasswordField txPassword;
	private JLabel lbColor;
	private JComboBox<String> cbColor;
	private JPanel pnBoton;

	private DefaultListModel<String> modeloLista = null;
	private ValidarseAction valAction;
	private IniciarJuegoAction iniciarAction;
	private int cont = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setTitle("Trivial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/game/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 425);
		contentPane = new FondoLogin();
		contentPane.setBorder(new EmptyBorder(10, 80, 15, 40));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		contentPane.add(getPnTitulo(), BorderLayout.NORTH);
		contentPane.add(getPnPrincipal(), BorderLayout.CENTER);
		contentPane.add(getPnListaJugadores(), BorderLayout.EAST);
		contentPane.add(getPnBoton(), BorderLayout.SOUTH);
		setLocationRelativeTo(this);
		inicializarComboColor();
	}


	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setOpaque(false);
			pnTitulo.add(getLbTitulo());
		}
		return pnTitulo;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Trivial ");
			lbTitulo.setForeground(Color.WHITE);
			lbTitulo.setFont(new Font("Blackadder ITC", Font.ITALIC, 60));
		}
		return lbTitulo;
	}
	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setOpaque(false);
			pnPrincipal.setLayout(new GridLayout(0, 2, 10, 0));
			pnPrincipal.add(getPnRegistro());
			pnPrincipal.add(getPnLogin());
		}
		return pnPrincipal;
	}
	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setBorder(new EmptyBorder(10, 10, 10, 10));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(new BorderLayout(10, 10));
			pnRegistro.add(getLbRegistro(), BorderLayout.NORTH);
			pnRegistro.add(getPnDatos(), BorderLayout.CENTER);
			pnRegistro.add(getBtRegistrarse(), BorderLayout.SOUTH);
		}
		return pnRegistro;
	}
	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setBorder(new EmptyBorder(10, 10, 10, 10));
			pnLogin.setBackground(Color.WHITE);
			pnLogin.setLayout(new BorderLayout(0, 0));
			pnLogin.add(getLbEntrar(), BorderLayout.NORTH);
			pnLogin.add(getPnDatosEntrar(), BorderLayout.CENTER);
			pnLogin.add(getBtEntrar(), BorderLayout.SOUTH);
		}
		return pnLogin;
	}
	private JPanel getPnListaJugadores() {
		if (pnListaJugadores == null) {
			pnListaJugadores = new JPanel();
			pnListaJugadores.setBorder(new EmptyBorder(0, 30, 0, 0));
			pnListaJugadores.setPreferredSize(new Dimension(150, 30));
			pnListaJugadores.setOpaque(false);
			pnListaJugadores.setLayout(new BorderLayout(0, 10));
			pnListaJugadores.add(getLbJugadores(), BorderLayout.NORTH);
			pnListaJugadores.add(getScrLista(), BorderLayout.CENTER);
		}
		return pnListaJugadores;
	}
	private JLabel getLbJugadores() {
		if (lbJugadores == null) {
			lbJugadores = new JLabel("Jugadores:");
			lbJugadores.setHorizontalAlignment(SwingConstants.CENTER);
			lbJugadores.setForeground(Color.WHITE);
			lbJugadores.setFont(new Font("Blackadder ITC", Font.ITALIC, 30));
		}
		return lbJugadores;
	}
	private JButton getBtIniciarJuego() {
		if (btIniciarJuego == null) {
			btIniciarJuego = new JButton("Iniciar juego");
			btIniciarJuego.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarAction = new IniciarJuegoAction();
					iniciarAction.execute();
				}
			});
			btIniciarJuego.setForeground(Color.WHITE);
			btIniciarJuego.setBackground(Color.BLACK);
			btIniciarJuego.setMargin(new Insets(2, 50, 2, 50));
			btIniciarJuego.setHorizontalTextPosition(SwingConstants.CENTER);
			btIniciarJuego.setFont(new Font("Blackadder ITC", Font.ITALIC, 20));
		}
		return btIniciarJuego;
	}
	private JScrollPane getScrLista() {
		if (scrLista == null) {
			scrLista = new JScrollPane();
			scrLista.setViewportView(getListaJugadores());
		}
		return scrLista;
	}
	private JList<String> getListaJugadores() {
		if (listaJugadores == null) {
			modeloLista = new DefaultListModel<String>();
			listaJugadores = new JList<String>(modeloLista);
		}
		return listaJugadores;
	}
	private JLabel getLbRegistro() {
		if (lbRegistro == null) {
			lbRegistro = new JLabel("Registro");
			lbRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lbRegistro.setFont(new Font("Blackadder ITC", Font.ITALIC, 30));
		}
		return lbRegistro;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre usuario");
		}
		return lbNombre;
	}
	protected JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("Email");
		}
		return lbEmail;
	}
	protected JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setColumns(10);
		}
		return txEmail;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBorder(new EmptyBorder(15, 10, 15, 10));
			pnDatos.setOpaque(false);
			pnDatos.setForeground(Color.WHITE);
			pnDatos.setLayout(new GridLayout(2, 2, 0, 10));
			pnDatos.add(getLbNombre());
			pnDatos.add(getTxNombre());
			pnDatos.add(getLbEmail());
			pnDatos.add(getTxEmail());
		}
		return pnDatos;
	}
	private JButton getBtRegistrarse() {
		if (btRegistrarse == null) {
			btRegistrarse = new JButton("Registrarme");
			btRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!txNombre.getText().isEmpty() && !txEmail.getText().isEmpty()){
						mostrarVentanaRegistro();
					}
					else{
						JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
					}
				}
			});
			btRegistrarse.setForeground(Color.WHITE);
			btRegistrarse.setBackground(Color.BLACK);
			btRegistrarse.setFont(new Font("Blackadder ITC", Font.ITALIC, 20));
		}
		return btRegistrarse;
	}
	private JLabel getLbEntrar() {
		if (lbEntrar == null) {
			lbEntrar = new JLabel("Iniciar sesion");
			lbEntrar.setHorizontalAlignment(SwingConstants.CENTER);
			lbEntrar.setFont(new Font("Blackadder ITC", Font.ITALIC, 30));
		}
		return lbEntrar;
	}
	private JPanel getPnDatosEntrar() {
		if (pnDatosEntrar == null) {
			pnDatosEntrar = new JPanel();
			pnDatosEntrar.setBorder(new EmptyBorder(15, 10, 15, 10));
			pnDatosEntrar.setOpaque(false);
			pnDatosEntrar.setForeground(Color.WHITE);
			pnDatosEntrar.setLayout(new GridLayout(3, 2, 0, 0));
			pnDatosEntrar.add(getLbNombreEntrar());
			pnDatosEntrar.add(getTxNombreEntrar());
			pnDatosEntrar.add(getLbPassword());
			pnDatosEntrar.add(getTxPassword());
			pnDatosEntrar.add(getLbColor());
			pnDatosEntrar.add(getCbColor());
		}
		return pnDatosEntrar;
	}
	private JLabel getLbNombreEntrar() {
		if (lbNombreEntrar == null) {
			lbNombreEntrar = new JLabel("Nombre usuario");
		}
		return lbNombreEntrar;
	}
	private JTextField getTxNombreEntrar() {
		if (txNombreEntrar == null) {
			txNombreEntrar = new JTextField();
			txNombreEntrar.setColumns(10);
		}
		return txNombreEntrar;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Contrase\u00F1a");
		}
		return lbPassword;
	}
	private JButton getBtEntrar() {
		if (btEntrar == null) {
			btEntrar = new JButton("Iniciar sesion");
			btEntrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarse();
				}
			});
			btEntrar.setBackground(Color.BLACK);
			btEntrar.setForeground(Color.WHITE);
			btEntrar.setFont(new Font("Blackadder ITC", Font.ITALIC, 20));
		}
		return btEntrar;
	}
	
	private void validarse(){
		
		String login = txNombreEntrar.getText().toString();
		char[] password = txPassword.getPassword();
		String color = cbColor.getSelectedItem().toString();
		valAction = new ValidarseAction(login, transPassword(password), colorUsuario(color));
		if(valAction.isCorrecto()){
			valAction.execute();
			addJugador(cbColor.getSelectedItem().toString());
			inicializar();
		}
		else{
			JOptionPane.showMessageDialog(null, valAction.getMessage());
			inicializar();
		}
	}
	
	protected String transPassword(char[] p){
		String cadena = "";
		for(int i=0;i<p.length; i++){
			cadena += p[i];
		}
		return cadena;
	}
	
	private ColorEnum colorUsuario(String color){
		switch(color){
		case ("Marron"):	
			return  ColorEnum.MARRON;
		case ("Verde"):
			return ColorEnum.VERDE;
		case ("Amarillo"):
			return ColorEnum.AMARILLO;
		case ("Azul"):
			return ColorEnum.AZUL;
		case ("Rosa"):
			return ColorEnum.ROSA;
		case ("Naranja"):
			return ColorEnum.NARANJA;
		}
		return null;
	}
	private void addJugador( String color){
		
		String jugador = txNombreEntrar.getText().toString();
		switch(color){
		case ("Marron"):	
			getListaJugadores().setForeground(new Color(102,51,0));
			String.valueOf(cont++);
			modeloLista.addElement(String.valueOf(cont++)+". "+jugador);
		break;
		case ("Verde"):
			getListaJugadores().setForeground(Color.GREEN);
			modeloLista.addElement(String.valueOf(cont++)+". "+jugador);
		break;
		case ("Amarillo"):
			getListaJugadores().setForeground(Color.YELLOW);
			modeloLista.addElement(String.valueOf(cont++)+". "+jugador);
		break;
		case ("Azul"):
			getListaJugadores().setForeground(Color.BLUE);
			modeloLista.addElement(String.valueOf(cont++)+". "+jugador);
		break;
		case ("Rosa"):
			getListaJugadores().setForeground(Color.PINK);
			modeloLista.addElement(String.valueOf(cont++)+". "+jugador);
		break;
		case ("Naranja"):
			getListaJugadores().setForeground(Color.ORANGE);
			modeloLista.addElement(String.valueOf(cont++)+". "+jugador);
		break;
		
		}
	}
	private JPasswordField getTxPassword() {
		if (txPassword == null) {
			txPassword = new JPasswordField();
		}
		return txPassword;
	}
	private JLabel getLbColor() {
		if (lbColor == null) {
			lbColor = new JLabel("Color");
		}
		return lbColor;
	}
	private JComboBox<String> getCbColor() {
		if (cbColor == null) {
			cbColor = new JComboBox<String>();
		}
		return cbColor;
	}
	private JPanel getPnBoton() {
		if (pnBoton == null) {
			pnBoton = new JPanel();
			pnBoton.setOpaque(false);
			pnBoton.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			pnBoton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			pnBoton.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
			pnBoton.add(getBtIniciarJuego());
		}
		return pnBoton;
	}
	
	private void mostrarVentanaRegistro(){
		VentanaRegistro vR = new VentanaRegistro(this);
		vR.setLocationRelativeTo(this);
		vR.setVisible(true);		
	}
	
	private void inicializarComboColor(){
		String[] colores =  {"Marron","Verde","Amarillo","Azul","Rosa","Naranja"};
		for(int i=0; i<colores.length; i++){
			cbColor.addItem(colores[i]);
		}
	}
	
	protected void inicializar(){
		txEmail.setText("");
		txNombre.setText("");
		txNombreEntrar.setText("");
		txPassword.setText("");
		cbColor.getItemAt(0);
	}
	
}
