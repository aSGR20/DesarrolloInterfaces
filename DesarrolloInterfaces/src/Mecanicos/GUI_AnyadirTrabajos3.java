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
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Proyecto.DAO_Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_AnyadirTrabajos3 extends javax.swing.JFrame{

	private String problema, tiempoEstimado, piezas;
	private JFrame frame;
	private GUI_AnyadirTrabajos2 menu;
	private JTextField textProblema;
	private JTextField textPiezas;
	private JTextField textTiempo;

	/**
	 * Create the application.
	 */
	public GUI_AnyadirTrabajos3(GUI_AnyadirTrabajos2 menu) {
		initialize();
		this.menu = menu;
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Añadir trabajo");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
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
		lbl_Ocupacion.setBounds(52, 406, 69, 14);
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
		
		JLabel lbl_Problema = new JLabel("Problema");
		lbl_Problema.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Problema.setBounds(108, 44, 73, 14);
		panel_1.add(lbl_Problema);
		
		JLabel lbl_Tiempo = new JLabel("Tiempo Estimado");
		lbl_Tiempo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Tiempo.setBounds(110, 243, 128, 14);
		panel_1.add(lbl_Tiempo);
		
		JButton btnAnyadir = new JButton("A\u00D1ADIR");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnAnyadir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAnyadir.setBounds(332, 381, 134, 46);
		panel_1.add(btnAnyadir);
		
		JLabel lbl_Piezas = new JLabel("Piezas");
		lbl_Piezas.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Piezas.setBounds(110, 146, 73, 14);
		panel_1.add(lbl_Piezas);
		
		textProblema = new JTextField();
		textProblema.setBounds(118, 66, 224, 46);
		panel_1.add(textProblema);
		textProblema.setColumns(10);
		
		textPiezas = new JTextField();
		textPiezas.setColumns(10);
		textPiezas.setBounds(118, 169, 224, 46);
		panel_1.add(textPiezas);
		
		textTiempo = new JTextField();
		textTiempo.setColumns(10);
		textTiempo.setBounds(118, 268, 224, 46);
		panel_1.add(textTiempo);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void guardar() {
		problema = textProblema.getText();
		tiempoEstimado = textTiempo.getText();
		piezas = textPiezas.getText();
		//AGREGAR TODOS LOS DATOS SELECCIONADOS Y ESCRITOS A LA BASE DE DATOS
		
		this.setVisible(false);
		this.dispose();
	}
}
