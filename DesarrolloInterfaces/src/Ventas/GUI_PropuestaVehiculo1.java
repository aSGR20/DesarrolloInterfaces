package Ventas;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_PropuestaVehiculo1 extends javax.swing.JFrame{

	private GUI_Ventas menu;
	private JFrame frame;
	private JTable table;
	private JTextField text_DNI;
	private JTextField text_Nombre;

	/**
	 * Create the application.
	 */
	public GUI_PropuestaVehiculo1(GUI_Ventas menu) {
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
		setTitle("Propuesta de vehículos");
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
		
		table = new JTable();
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 95);
		scrollPane.setSize(456, 265);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellidos", "Telefono", "Domicilio"
			}
		));
		table.setBounds(20, 70, 446, 305);
		panel_1.add(scrollPane);
		
		JLabel lbl_DNI = new JLabel("DNI");
		lbl_DNI.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_DNI.setBounds(8, 43, 24, 14);
		panel_1.add(lbl_DNI);
		
		JLabel lbl_Nombre = new JLabel("Nombre");
		lbl_Nombre.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Nombre.setBounds(176, 43, 55, 14);
		panel_1.add(lbl_Nombre);
		
		text_DNI = new JTextField();
		text_DNI.setFont(new Font("SansSerif", Font.PLAIN, 14));
		text_DNI.setBounds(34, 40, 134, 20);
		panel_1.add(text_DNI);
		text_DNI.setColumns(10);
		
		text_Nombre = new JTextField();
		text_Nombre.setFont(new Font("SansSerif", Font.PLAIN, 14));
		text_Nombre.setColumns(10);
		text_Nombre.setBounds(233, 40, 134, 20);
		panel_1.add(text_Nombre);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnBuscar.setBounds(377, 39, 89, 23);
		panel_1.add(btnBuscar);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				siguientePropuesta();
			}
		});
		btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSiguiente.setBounds(332, 381, 134, 46);
		panel_1.add(btnSiguiente);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void siguientePropuesta() {
		GUI_PropuestaVehiculo2 propuestaSiguiente = new GUI_PropuestaVehiculo2(this, menu);
		this.setVisible(false);
	}
}
