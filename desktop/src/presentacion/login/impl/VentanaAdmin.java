package presentacion.login.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.usuario.Usuario;
import business.game.login.acciones.impl.EstadisticasAction;

public class VentanaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel pnNorte;
	private JPanel pnUsuarios;
	private JPanel pnEstadisticas;
	private JPanel pnBoton;
	private JPanel pnFiltro;
	private JComboBox<String> cbFiltrar;
	private JTextField txFiltrar;
	private JButton btFiltrar;
	private JScrollPane scrUsuarios;
	private JTable tbInfoUsuarios;
	private JButton btAtras;
	private JLabel lbTitulo;
	
	private ModeloNoEditable modeloTabla;
	private EstadisticasAction est; 
	private VentanaLogin vL;
	private JLabel lbEstadisticas;
	private JPanel pnDatos;
	private JLabel lbPartidasJugadas;
	private JTextField txPartidasjugadas;
	private JLabel lbPartidasGanadas;
	private JTextField txPartidasGanadas;
	private JLabel lbPreguntasJugadas;
	private JTextField txPreguntasJugadas;
	private JLabel lbPreguntasAcertadas;
	private JTextField txPreguntasAcertadas;

	/**
	 * Create the frame.
	 */
	public VentanaAdmin(VentanaLogin vL) {
		setTitle("Trivial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/presentacion/login/img/logo.png")));
		this.vL = vL;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 425);
		contentPane = new FondoLogin();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnUsuarios(), BorderLayout.CENTER);
		contentPane.add(getPnEstadisticas(), BorderLayout.EAST);
		contentPane.add(getPnBoton(), BorderLayout.SOUTH);
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setOpaque(false);
			pnNorte.setLayout(new GridLayout(0, 2, 0, 0));
			pnNorte.add(getLbTitulo());
			pnNorte.add(getPnFiltro());
		}
		return pnNorte;
	}
	private JPanel getPnUsuarios() {
		if (pnUsuarios == null) {
			pnUsuarios = new JPanel();
			pnUsuarios.setBorder(new EmptyBorder(10, 10, 10, 10));
			pnUsuarios.setOpaque(false);
			pnUsuarios.setLayout(new BorderLayout(0, 0));
			pnUsuarios.add(getScrUsuarios());
		}
		return pnUsuarios;
	}
	private JPanel getPnEstadisticas() {
		if (pnEstadisticas == null) {
			pnEstadisticas = new JPanel();
			pnEstadisticas.setOpaque(false);
			pnEstadisticas.setLayout(new BorderLayout(0, 0));
			pnEstadisticas.add(getPnDatos(), BorderLayout.CENTER);
			pnEstadisticas.add(getLbEstadisticas(), BorderLayout.NORTH);
		}
		return pnEstadisticas;
	}
	private JPanel getPnBoton() {
		if (pnBoton == null) {
			pnBoton = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBoton.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBoton.setOpaque(false);
			pnBoton.add(getBtAtras());
		}
		return pnBoton;
	}
	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setOpaque(false);
			pnFiltro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnFiltro.add(getCbFiltrar());
			pnFiltro.add(getTxFiltrar());
			pnFiltro.add(getBtFiltrar());
		}
		return pnFiltro;
	}
	private JComboBox<String> getCbFiltrar() {
		if (cbFiltrar == null) {
			cbFiltrar = new JComboBox<String>();
			cbFiltrar.setOpaque(false);
			cbFiltrar.setPreferredSize(new Dimension(100, 30));
			inicializarCombo();
		}
		return cbFiltrar;
	}
	private void inicializarCombo(){
		String[] paraFiltrar = new String[]{"login","nombre","apellidos","email"};
		for(int i=0; i<paraFiltrar.length;i++){
			cbFiltrar.addItem(paraFiltrar[i]);
		}
	}
	private JTextField getTxFiltrar() {
		if (txFiltrar == null) {
			txFiltrar = new JTextField();
			txFiltrar.setPreferredSize(new Dimension(150, 30));
			txFiltrar.setColumns(10);
		}
		return txFiltrar;
	}
	private JButton getBtFiltrar() {
		if (btFiltrar == null) {
			btFiltrar = new JButton("Buscar");
			btFiltrar.setBackground(Color.BLACK);
			btFiltrar.setForeground(Color.WHITE);
			btFiltrar.setFont(new Font("Blackadder ITC", Font.ITALIC, 20));
			btFiltrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					añadirFilas();
				}
			});
		}
		return btFiltrar;
	}
	private JScrollPane getScrUsuarios() {
		if (scrUsuarios == null) {
			scrUsuarios = new JScrollPane();
			scrUsuarios.setViewportView(getTbInfoUsuarios());
		}
		return scrUsuarios;
	}
	private JTable getTbInfoUsuarios() {
		if (tbInfoUsuarios == null) {
			String[] nombreColumna = {"Login","Nombre","Apellidos","Edad","Email"};
			modeloTabla = new ModeloNoEditable(nombreColumna, 0);
			tbInfoUsuarios = new JTable(modeloTabla);
			tbInfoUsuarios.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String login = (String) tbInfoUsuarios.getValueAt(tbInfoUsuarios.getSelectedRow(), 0);
					List<Usuario> usuarios = est.execute();
					for(int i=0; i < usuarios.size(); i++){
						if(usuarios.get(i).getLogin().equals(login)){
							txPartidasjugadas.setText(String.valueOf(usuarios.get(i).getNumJugadas()));
							txPartidasGanadas.setText(String.valueOf(usuarios.get(i).getNumGanadas()));
							txPreguntasJugadas.setText(String.valueOf(usuarios.get(i).getRespuestasJugadas()));
							txPreguntasAcertadas.setText(String.valueOf(usuarios.get(i).getRespuestasAcertadas()));
						}
					}
				}
			});
			tbInfoUsuarios.setBackground(Color.WHITE);
			int[] tamaños = {20,20,20,20,30};
			for(int i = 0; i < tbInfoUsuarios.getColumnCount(); i++){
				tbInfoUsuarios.getColumnModel().getColumn(i).setPreferredWidth(tamaños[i]);
			}	
		}
		return tbInfoUsuarios;
	}
	
	private void añadirFilas(){
		modeloTabla.getDataVector().clear();
		
		String campo = cbFiltrar.getSelectedItem().toString();
		String valor = txFiltrar.getText();
		Object[] nuevaFila = new Object[5];
		est = new EstadisticasAction(campo, valor);
		List<Usuario> usuarios = est.execute();
	
		for(int i = 0; i < usuarios.size(); i++){
			nuevaFila[0] = usuarios.get(i).getLogin();
			nuevaFila[1] = usuarios.get(i).getNombre();
			nuevaFila[2] = usuarios.get(i).getApellidos();
			nuevaFila[3] = usuarios.get(i).getEdad();
			nuevaFila[4] = usuarios.get(i).getEmail();
			modeloTabla.addRow(nuevaFila);
		}
	
		modeloTabla.fireTableDataChanged();
	}
	
	private JButton getBtAtras() {
		if (btAtras == null) {
			btAtras = new JButton("Volver al menu");
			btAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					vL.inicializar();
					vL.setVisible(true);
				}
			});
			btAtras.setBackground(Color.BLACK);
			btAtras.setForeground(Color.WHITE);
			btAtras.setFont(new Font("Blackadder ITC", Font.ITALIC, 20));
		}
		return btAtras;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setIcon(new ImageIcon(VentanaAdmin.class.getResource("/presentacion/login/img/estadisiticas.png")));
		}
		return lbTitulo;
	}
	


	private JLabel getLbEstadisticas() {
		if (lbEstadisticas == null) {
			lbEstadisticas = new JLabel("Total estad\u00EDsticas");
			lbEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
			lbEstadisticas.setForeground(Color.WHITE);
			lbEstadisticas.setFont(new Font("Blackadder ITC", Font.ITALIC, 35));
		}
		return lbEstadisticas;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBackground(Color.WHITE);
			pnDatos.setLayout(new GridLayout(0, 2, 0, 15));
			pnDatos.add(getLbPartidasJugadas());
			pnDatos.add(getTxPartidasjugadas());
			pnDatos.add(getLbPartidasGanadas());
			pnDatos.add(getTxPartidasGanadas());
			pnDatos.add(getLbPreguntasJugadas());
			pnDatos.add(getTxPreguntasJugadas());
			pnDatos.add(getLbPreguntasAcertadas());
			pnDatos.add(getTxPreguntasAcertadas());
		}
		return pnDatos;
	}
	private JLabel getLbPartidasJugadas() {
		if (lbPartidasJugadas == null) {
			lbPartidasJugadas = new JLabel("Partidas jugadas:");
			lbPartidasJugadas.setFont(new Font("Blackadder ITC", Font.BOLD, 20));
		}
		return lbPartidasJugadas;
	}
	private JTextField getTxPartidasjugadas() {
		if (txPartidasjugadas == null) {
			txPartidasjugadas = new JTextField();
			txPartidasjugadas.setBorder(new EmptyBorder(0, 20, 0, 0));
			txPartidasjugadas.setEditable(false);
			txPartidasjugadas.setColumns(10);
		}
		return txPartidasjugadas;
	}
	private JLabel getLbPartidasGanadas() {
		if (lbPartidasGanadas == null) {
			lbPartidasGanadas = new JLabel("Partidas ganadas:");
			lbPartidasGanadas.setFont(new Font("Blackadder ITC", Font.BOLD, 20));
		}
		return lbPartidasGanadas;
	}
	private JTextField getTxPartidasGanadas() {
		if (txPartidasGanadas == null) {
			txPartidasGanadas = new JTextField();
			txPartidasGanadas.setBorder(new EmptyBorder(0, 20, 0, 0));
			txPartidasGanadas.setEditable(false);
			txPartidasGanadas.setText("");
			txPartidasGanadas.setColumns(10);
		}
		return txPartidasGanadas;
	}
	private JLabel getLbPreguntasJugadas() {
		if (lbPreguntasJugadas == null) {
			lbPreguntasJugadas = new JLabel("Preguntas jugadas:");
			lbPreguntasJugadas.setFont(new Font("Blackadder ITC", Font.BOLD, 20));
		}
		return lbPreguntasJugadas;
	}
	private JTextField getTxPreguntasJugadas() {
		if (txPreguntasJugadas == null) {
			txPreguntasJugadas = new JTextField();
			txPreguntasJugadas.setBorder(new EmptyBorder(0, 20, 0, 0));
			txPreguntasJugadas.setEditable(false);
			txPreguntasJugadas.setColumns(10);
		}
		return txPreguntasJugadas;
	}
	private JLabel getLbPreguntasAcertadas() {
		if (lbPreguntasAcertadas == null) {
			lbPreguntasAcertadas = new JLabel("Preguntas acertadas:");
			lbPreguntasAcertadas.setFont(new Font("Blackadder ITC", Font.BOLD, 20));
		}
		return lbPreguntasAcertadas;
	}
	private JTextField getTxPreguntasAcertadas() {
		if (txPreguntasAcertadas == null) {
			txPreguntasAcertadas = new JTextField();
			txPreguntasAcertadas.setBorder(new EmptyBorder(0, 20, 0, 0));
			txPreguntasAcertadas.setEditable(false);
			txPreguntasAcertadas.setColumns(10);
		}
		return txPreguntasAcertadas;
	}
}
