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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import Proyecto.DAO_Cliente;
import Proyecto.DAO_Usuario;
import Proyecto.DAO_Cliente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_PropuestaVehiculo1 extends javax.swing.JFrame{

	private GUI_Ventas menu;
	private String DNI, Nombre;
	private DefaultTableModel dm;
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
		DAO_Cliente clienteDao = new DAO_Cliente();
		GUI_PropuestaVehiculo2 propuesta = new GUI_PropuestaVehiculo2();
		
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
		
		dm = new DefaultTableModel();
		table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 95);
		scrollPane.setSize(456, 265);
		String[]columns = {"DNI", "Nombre", "Apellidos", "Telefono", "Domicilio"};
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
		table.setModel(dm);
		
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
				buscar();
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
		try {
			int selectedRow = table.getSelectedRow();
			DNI = dm.getValueAt(selectedRow, 0).toString();
			Nombre = dm.getValueAt(selectedRow, 1).toString();
			GUI_PropuestaVehiculo2 propuestaSiguiente = new GUI_PropuestaVehiculo2(this, menu);
			propuestaSiguiente.guardarPropuesta1(DNI, Nombre);
			this.setVisible(false);
		}catch(ArrayIndexOutOfBoundsException aiooe) {
			JOptionPane.showMessageDialog(null, "Señala la persona a quien le vas a proponer el vehículo");
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "Señala la persona a quien le vas a proponer el vehículo");
		}
		
		
	}
	
	public void buscar() {
		if(text_DNI.getText().length()!=0 && text_Nombre.getText().length()!=0) {
			Object[]datos = new Object[2];
			datos[0] = text_DNI.getText().toString();
			datos[1] = text_Nombre.getText().toString();
			DAO_Cliente clienteDao = new DAO_Cliente();
			clienteDao.buscarDatos(datos);
			dm.setRowCount(0);
			for (int i = 0; i < clienteDao.buscarDatos(datos).size();i++) {
				Object[]linea = clienteDao.buscarDatos(datos).toString().split(";");
				Object[]data = new Object[6];
				data[0] = linea[0];
				data[1] = linea[1];
				data[2] = linea[2];
				data[3] = linea[3];
				data[4] = linea[4];
				data[5] = linea[5];
				dm.addRow(data);
			}
		}else if(text_DNI.getText().length()!=0 && text_Nombre.getText().length()==0) {
			String dni = text_DNI.getText();
			DAO_Cliente clienteDao = new DAO_Cliente();
			clienteDao.buscarDatosDni(dni);
			dm.setRowCount(0);
			for (int i = 0; i < clienteDao.buscarDatosDni(dni).size();i++) {
				Object[]linea = clienteDao.buscarDatosDni(dni).toString().split(";");
				Object[]data = new Object[6];
				data[0] = linea[0];
				data[1] = linea[1];
				data[2] = linea[2];
				data[3] = linea[3];
				data[4] = linea[4];
				data[5] = linea[5];
				dm.addRow(data);
			}
		}else if (text_Nombre.getText().length()!=0 && text_DNI.getText().length()==0) {
			String nombre = text_Nombre.getText();
			DAO_Cliente clienteDao = new DAO_Cliente();
			clienteDao.buscarDatosNombre(nombre);
			dm.setRowCount(0);
			for (int i = 0; i < clienteDao.buscarDatosNombre(nombre).size();i++) {
				Object[]linea = clienteDao.buscarDatosNombre(nombre).toString().split(";");
				Object[]data = new Object[6];
				data[0] = linea[0];
				data[1] = linea[1];
				data[2] = linea[2];
				data[3] = linea[3];
				data[4] = linea[4];
				data[5] = linea[5];
				dm.addRow(data);
			}
		}else {
			dm.setRowCount(0);
			DAO_Cliente clienteDao = new DAO_Cliente();
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
		}
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		text_DNI.setText(dm.getValueAt(selectedRow, 0).toString());
        text_Nombre.setText(dm.getValueAt(selectedRow, 1).toString());
    }  
}
