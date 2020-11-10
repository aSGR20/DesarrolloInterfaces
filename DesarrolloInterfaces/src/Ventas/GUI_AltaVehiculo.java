package Ventas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import Proyecto.DAO_Vehiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_AltaVehiculo extends javax.swing.JFrame{

	private GUI_Ventas menu;
	private JFrame frame;
	private JTextField text_NumSerie;
	private JTextField text_Modelo;
	private JTextField text_Marca;
	private JTextField text_Tipo;
	private JTextField text_Precio;
	private JTextField text_FechEntrada;
	private JTextField text_InfAdicional;

	/**
	 * Create the application.
	 */	
	public GUI_AltaVehiculo(GUI_Ventas menu) {
		initialize();
		setLocationRelativeTo(null);
		this.menu = menu;
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Alta de Vehiculo");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 176, 443);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sebas\\eclipse-workspace\\DesarrolloInterfaces\\src\\images\\myLogo_Login.png"));
		lblNewLabel.setBounds(26, 48, 122, 55);
		panel.add(lblNewLabel);
		
		JLabel lbl_Nombre_Empleado = new JLabel("NOMBRE_EMPLEADO");
		lbl_Nombre_Empleado.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Nombre_Empleado.setBounds(26, 126, 122, 14);
		panel.add(lbl_Nombre_Empleado);
		
		JLabel lbl_Ocupacion = new JLabel("OCUPACION");
		lbl_Ocupacion.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Ocupacion.setBounds(52, 406, 69, 14);
		panel.add(lbl_Ocupacion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(175, 0, 476, 443);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_NumSerie = new JLabel("*Num. Serie:");
		lbl_NumSerie.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_NumSerie.setBounds(22, 39, 140, 14);
		panel_1.add(lbl_NumSerie);
		
		text_NumSerie = new JTextField();
		text_NumSerie.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_NumSerie.setBounds(22, 64, 184, 20);
		panel_1.add(text_NumSerie);
		text_NumSerie.setColumns(10);
		
		JLabel lbl_Modelo = new JLabel("*Modelo:");
		lbl_Modelo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Modelo.setBounds(259, 39, 140, 14);
		panel_1.add(lbl_Modelo);
		
		text_Modelo = new JTextField();
		text_Modelo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Modelo.setColumns(10);
		text_Modelo.setBounds(259, 64, 184, 20);
		panel_1.add(text_Modelo);
		
		text_Marca = new JTextField();
		text_Marca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Marca.setColumns(10);
		text_Marca.setBounds(22, 153, 184, 20);
		panel_1.add(text_Marca);
		
		JLabel lbl_Marca = new JLabel("*Marca:");
		lbl_Marca.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Marca.setBounds(22, 128, 140, 14);
		panel_1.add(lbl_Marca);
		
		text_Tipo = new JTextField();
		text_Tipo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Tipo.setColumns(10);
		text_Tipo.setBounds(259, 153, 184, 20);
		panel_1.add(text_Tipo);
		
		JLabel lbl_Tipo = new JLabel("*Tipo:");
		lbl_Tipo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Tipo.setBounds(259, 128, 140, 14);
		panel_1.add(lbl_Tipo);
		
		text_Precio = new JTextField();
		text_Precio.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_Precio.setColumns(10);
		text_Precio.setBounds(22, 251, 184, 20);
		panel_1.add(text_Precio);
		
		JLabel lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPrecio.setBounds(22, 226, 140, 14);
		panel_1.add(lblPrecio);
		
		text_FechEntrada = new JTextField();
		text_FechEntrada.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_FechEntrada.setColumns(10);
		text_FechEntrada.setBounds(259, 251, 184, 20);
		panel_1.add(text_FechEntrada);
		
		JLabel lbl_FechEntrada = new JLabel("*Fecha Entrada:");
		lbl_FechEntrada.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_FechEntrada.setBounds(259, 226, 140, 14);
		panel_1.add(lbl_FechEntrada);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVolver.setBounds(54, 367, 107, 42);
		panel_1.add(btnVolver);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aceptar();
			}
		});
		btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAceptar.setBounds(292, 367, 107, 42);
		panel_1.add(btnAceptar);
		
		JLabel lbl_InfAdicional = new JLabel("Informaci\u00F3n Adicional:");
		lbl_InfAdicional.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_InfAdicional.setBounds(173, 297, 140, 14);
		panel_1.add(lbl_InfAdicional);
		
		text_InfAdicional = new JTextField();
		text_InfAdicional.setFont(new Font("SansSerif", Font.PLAIN, 12));
		text_InfAdicional.setColumns(10);
		text_InfAdicional.setBounds(125, 322, 214, 35);
		panel_1.add(text_InfAdicional);
	}
	
	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void aceptar() {
		try {
			
		if((text_Marca.getText().equals(""))||(text_NumSerie.getText().equals(""))||(text_Modelo.getText().equals(""))||(text_Precio.getText().equals(""))||(text_Tipo.getText().equals(""))||(text_NumSerie.getText().equals(""))||(text_FechEntrada.getText().equals(""))) {
			JOptionPane.showInternalMessageDialog(null, "Te faltan campos por rellenar");
		}else
		if (text_InfAdicional.getText().equals("")){
			Object[]datos = new Object[6];
			datos[0] = Integer.parseInt(text_NumSerie.getText());
			datos[1] = text_Modelo.getText();
			datos[2] = text_Marca.getText();
			datos[3] = text_Tipo.getText();
			datos[4] = Integer.parseInt(text_Precio.getText());
			datos[5] = text_FechEntrada.getText();
			DAO_Vehiculo vehiculoDao = new DAO_Vehiculo();
			vehiculoDao.agregarDatos(datos);
			this.setVisible(false);
			this.dispose();
			menu.setVisible(true);
		}else {
			Object[]datos = new Object[7];
			datos[0] = Integer.parseInt(text_NumSerie.getText());
			datos[1] = text_Modelo.getText();
			datos[2] = text_Marca.getText();
			datos[3] = text_Tipo.getText();
			datos[4] = Integer.parseInt(text_Precio.getText());
			datos[5] = text_FechEntrada.getText();
			datos[6] = text_InfAdicional.getText();
			DAO_Vehiculo vehiculoDao = new DAO_Vehiculo();
			vehiculoDao.agregarDatos(datos);
			this.setVisible(false);
			this.dispose();
			menu.setVisible(true);
		}
		}catch(NumberFormatException nfe) {
			JOptionPane.showInternalMessageDialog(null, "El Número de Serie o el Precio está mal escrito");
		}
	}
}
