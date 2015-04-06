package game.igu;

import game.acciones.impl.RegistrarseAction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VentanaLogin vL;
	private JLabel lbTitulo;
	private JPanel pnInfoRegistro;
	private JPanel pnBotonRegistro;
	private JButton btRegistrarme;
	private JLabel lbUsuario;
	private JTextField txUsuario;
	private JTextField txNombre;
	private JLabel lbApellidos;
	private JTextField txApellidos;
	private JLabel lbEmail;
	private JTextField txEmail;
	private JLabel lbPassword;
	private JPasswordField txPasswordUno;
	private JLabel lbPasswordDos;
	private JPasswordField txPasswordDos;
	private JLabel lbEdad;
	private JComboBox<Integer> cbEdad;
	private JLabel lbNombre;
	
	private RegistrarseAction regAction;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(VentanaLogin vL) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/game/img/logo.png")));
		setTitle("Ventana de registro");
		this.setvL(vL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 10));
		setContentPane(contentPane);
		contentPane.add(getLbTitulo(), BorderLayout.NORTH);
		contentPane.add(getPnInfoRegistro(), BorderLayout.CENTER);
		contentPane.add(getPnBotonRegistro(), BorderLayout.SOUTH);
		inicializarComboEdad();
	}

	public VentanaLogin getvL() {
		return vL;
	}

	public void setvL(VentanaLogin vL) {
		this.vL = vL;
	}

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Registro");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Blackadder ITC", Font.ITALIC, 25));
		}
		return lbTitulo;
	}
	private JPanel getPnInfoRegistro() {
		if (pnInfoRegistro == null) {
			pnInfoRegistro = new JPanel();
			pnInfoRegistro.setBorder(new EmptyBorder(0, 50, 0, 0));
			pnInfoRegistro.setOpaque(false);
			pnInfoRegistro.setLayout(new GridLayout(7, 2, 0, 5));
			pnInfoRegistro.add(getLbUsuario());
			pnInfoRegistro.add(getTxUsuario());
			pnInfoRegistro.add(getLbNombre());
			pnInfoRegistro.add(getTxNombre());
			pnInfoRegistro.add(getLbApellidos());
			pnInfoRegistro.add(getTxApellidos());
			pnInfoRegistro.add(getLbEmail());
			pnInfoRegistro.add(getTxEmail());
			pnInfoRegistro.add(getLbPassword());
			pnInfoRegistro.add(getTxPasswordUno());
			pnInfoRegistro.add(getLbPasswordDos());
			pnInfoRegistro.add(getTxPasswordDos());
			pnInfoRegistro.add(getLbEdad());
			pnInfoRegistro.add(getCbEdad());
		}
		return pnInfoRegistro;
	}
	private JPanel getPnBotonRegistro() {
		if (pnBotonRegistro == null) {
			pnBotonRegistro = new JPanel();
			pnBotonRegistro.setOpaque(false);
			pnBotonRegistro.add(getBtRegistrarme());
		}
		return pnBotonRegistro;
	}
	private JButton getBtRegistrarme() {
		if (btRegistrarme == null) {
			btRegistrarme = new JButton("Registrarme");
			btRegistrarme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registrarse();
				}
			});
			btRegistrarme.setForeground(Color.WHITE);
			btRegistrarme.setBackground(Color.BLACK);
		}
		return btRegistrarme;
	}
	
	private void registrarse(){
		
		String login = txUsuario.getText().toString();
		char[] password = txPasswordUno.getPassword();
		String nombre = txNombre.getText().toString();
		String apellidos = txApellidos.getText().toString();
		String email = txEmail.getText().toString();
		int edad = Integer.valueOf(cbEdad.getSelectedItem().toString());
		if(login.isEmpty() || getvL().transPassword(password).isEmpty() || nombre.isEmpty() 
				|| apellidos.isEmpty() || email.isEmpty())
			JOptionPane.showMessageDialog(null,"Rellene todo los campos.");

		else if(!getvL().transPassword(password).equals(getvL().transPassword(txPasswordDos.getPassword()))){
			JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden.");
			txPasswordUno.setText("");
			txPasswordDos.setText("");
		}
		else{
			regAction = new RegistrarseAction(login, getvL().transPassword(password), nombre, apellidos, email, edad);
			JOptionPane.showMessageDialog(null,regAction.execute());
			this.dispose();
			getvL().inicializar();
		}
		
	}
	
	private JLabel getLbUsuario() {
		if (lbUsuario == null) {
			lbUsuario = new JLabel("Usuario");
		}
		return lbUsuario;
	}
	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setEditable(false);
			txUsuario.setColumns(10);
			txUsuario.setText(getvL().getTxNombre().getText());
		}
		return txUsuario;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos");
		}
		return lbApellidos;
	}
	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setColumns(10);
		}
		return txApellidos;
	}
	private JLabel getLbEmail() {
		if (lbEmail == null) {
			lbEmail = new JLabel("Email");
		}
		return lbEmail;
	}
	private JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setEditable(false);
			txEmail.setColumns(10);
			txEmail.setText(getvL().getTxEmail().getText());
		}
		return txEmail;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Contraseï¿½a");
		}
		return lbPassword;
	}
	private JPasswordField getTxPasswordUno() {
		if (txPasswordUno == null) {
			txPasswordUno = new JPasswordField();
		}
		return txPasswordUno;
	}
	
	private JLabel getLbPasswordDos() {
		if (lbPasswordDos == null) {
			lbPasswordDos = new JLabel("Repetir contrase\u00F1a");
		}
		return lbPasswordDos;
	}
	private JPasswordField getTxPasswordDos() {
		if (txPasswordDos == null) {
			txPasswordDos = new JPasswordField();
		}
		return txPasswordDos;
	}
	private JLabel getLbEdad() {
		if (lbEdad == null) {
			lbEdad = new JLabel("Edad");
		}
		return lbEdad;
	}
	private JComboBox<Integer> getCbEdad() {
		if (cbEdad == null) {
			cbEdad = new JComboBox<Integer>();
			cbEdad.setBorder(new EmptyBorder(0, 90, 0, 0));
			cbEdad.setPreferredSize(new Dimension(18, 20));
		}
		return cbEdad;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre");
		}
		return lbNombre;
	}
	
	private void inicializarComboEdad(){
		for(int i=7; i<100; i++){
			cbEdad.addItem(i);
		}
	}
}
