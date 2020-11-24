package Mecanicos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import Proyecto.DAO_Cliente;
import Proyecto.DAO_Usuario;
import Proyecto.DAO_Vehiculo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_ComenzarTrabajo2 extends javax.swing.JFrame{

	private GUI_ComenzarTrabajo1 volverComenzar;
	private String NumIncidencia;
	private GUI_Mecanicos menu;
	private DefaultTableModel dm;
	private JFrame frame;
	private JTextField text_Marca;
	private JTextField text_Modelo;
	private JTextField text_Tipo;

	/**
	 * Create the application.
	 */
	public GUI_ComenzarTrabajo2(GUI_ComenzarTrabajo1 propuestaNombre, GUI_Mecanicos menu, String NumIncidencia) {
		initialize();
		this.volverComenzar = propuestaNombre;
		this.menu = menu;
		this.NumIncidencia = NumIncidencia;
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GUI_ComenzarTrabajo2() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Comenzar un trabajo");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		DAO_Cliente clienteDao = new DAO_Cliente();
		DAO_Vehiculo vehiculoDao = new DAO_Vehiculo();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 176, 443);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(".\\src\\images\\myLogo_Login.png"));
		lblNewLabel.setBounds(26, 48, 122, 55);
		panel.add(lblNewLabel);
		
		JLabel lbl_Nombre_Empleado = new JLabel("NOMBRE_EMPLEADO");
		DAO_Usuario usuarioDao = new DAO_Usuario();
		lbl_Nombre_Empleado.setText(usuarioDao.getName());
		lbl_Nombre_Empleado.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_Nombre_Empleado.setBounds(10, 126, 162, 14);
		panel.add(lbl_Nombre_Empleado);
		
		JLabel lbl_Ocupacion = new JLabel("OCUPACION");
		lbl_Ocupacion.setText(usuarioDao.getProfesion());
		lbl_Ocupacion.setFont(new Font("SansSerif", Font.BOLD, 18));
		lbl_Ocupacion.setBounds(10, 406, 162, 14);
		panel.add(lbl_Ocupacion);
		
		lbl_Nombre_Empleado.setHorizontalAlignment(lbl_Nombre_Empleado.CENTER);
		lbl_Ocupacion.setHorizontalAlignment(lbl_Ocupacion.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(175, 0, 476, 443);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVolver.setBounds(10, 381, 134, 46);
		panel_1.add(btnVolver);
		
		JButton btnTerminado = new JButton("Terminar");
		btnTerminado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				terminado();
			}
		});
		btnTerminado.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnTerminado.setBounds(332, 381, 134, 46);
		panel_1.add(btnTerminado);
		
		JLabel lbl_Suerte = new JLabel("Mucha suerte en la reparaci\u00F3n");
		lbl_Suerte.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_Suerte.setBounds(10, 11, 313, 29);
		panel_1.add(lbl_Suerte);
		
		JButton btnLlamar = new JButton("Llamar al cliente");
		btnLlamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				llamar();
			}
		});
		btnLlamar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnLlamar.setBounds(173, 381, 134, 46);
		panel_1.add(btnLlamar);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		volverComenzar.setVisible(true);
	}
	
	public void terminado() {
		int boton = JOptionPane.showConfirmDialog(null, "Confirmar la finalización", "Finalizar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(boton == JOptionPane.YES_OPTION) {
			//Quitarlo de la base de datos
			
			
			//Vuelve atrás
			
			this.setVisible(false);
			this.dispose();
			volverComenzar.setVisible(true);
		}
		if(boton == JOptionPane.NO_OPTION) {
			//no hacer nada
		}
	}
	
	public void llamar() {
		int boton = JOptionPane.showConfirmDialog(null, "¿Desea llamar al cliente?", "Llamar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(boton == JOptionPane.YES_OPTION) {			
			JOptionPane.showMessageDialog(null, "Llamando...");
		}
		if(boton == JOptionPane.NO_OPTION) {
		}
	}
}
