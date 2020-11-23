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
	private String DNI, Nombre, Marca, Modelo, Tipo, Fech_Entrada;
	private GUI_Mecanicos menu;
	private DefaultTableModel dm;
	private JFrame frame;
	private JTextField text_Marca;
	private JTextField text_Modelo;
	private JTextField text_Tipo;

	/**
	 * Create the application.
	 */
	public GUI_ComenzarTrabajo2(GUI_ComenzarTrabajo1 propuestaNombre, GUI_Mecanicos menu) {
		initialize();
		this.volverComenzar = propuestaNombre;
		this.menu = menu;
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
		lbl_Nombre_Empleado.setBounds(26, 126, 122, 14);
		panel.add(lbl_Nombre_Empleado);
		
		JLabel lbl_Ocupacion = new JLabel("OCUPACION");
		lbl_Ocupacion.setText(usuarioDao.getProfesion());
		lbl_Ocupacion.setFont(new Font("SansSerif", Font.BOLD, 18));
		lbl_Ocupacion.setBounds(52, 406, 122, 14);
		panel.add(lbl_Ocupacion);
		
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
		
		dm = new DefaultTableModel();
		String[]columns = {"N�mero Incidencia", "Problema", "Tiempo Estimado", "Piezas", "Tel�fono"};
		for ( int i=0; i<columns.length;i++){
            dm.addColumn(columns[i]);
        }
		Object[]data = new Object[5];
		for (int i = 0; i < clienteDao.recibirDatos().size();i++) {
			Object[] linea = clienteDao.recibirDatos().get(i).toString().split(";");
			data[0] = linea[0];
			data[1] = linea[1];
			data[2] = linea[2];
			data[3] = linea[3];
			data[4] = linea[4];
			dm.addRow(data);
		}
		
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
		int boton = JOptionPane.showConfirmDialog(null, "Confirmar la finalizaci�n", "Finalizar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(boton == JOptionPane.YES_OPTION) {
			//Quitarlo de la base de datos
			
			
			//Vuelve atr�s
			
			this.setVisible(false);
			this.dispose();
			volverComenzar.setVisible(true);
		}
		if(boton == JOptionPane.NO_OPTION) {
			//no hacer nada
		}
	}
	
	public void llamar() {
		
	}
}
