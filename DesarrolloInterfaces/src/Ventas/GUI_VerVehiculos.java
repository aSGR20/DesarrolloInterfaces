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
import Proyecto.DAO_Vehiculo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_VerVehiculos extends javax.swing.JFrame{

	private int Num_Serie;
	private DefaultTableModel dm;
	private GUI_Ventas menu;
	private JFrame frame;
	private JTable table;
	private JTextField text_Marca;
	private JTextField text_Modelo;
	private JTextField text_Precio;

	/**
	 * Create the application.
	 */
	public GUI_VerVehiculos(GUI_Ventas menu) {
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
		setTitle("Lista de Vehículos");
		setBounds(100, 100, 667, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		DAO_Vehiculo vehiculoDao = new DAO_Vehiculo();
		
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
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[]datos = new Object[3];
				if((text_Modelo.getText().equals(""))&&(text_Marca.getText().equals(""))&&(text_Precio.getText().equals(""))) {
					vehiculoDao.recibirDatos();
				}
				if(!text_Precio.getText().equals("")) {
					DAO_Vehiculo vehiculosDao = new DAO_Vehiculo();
					String tipo = text_Precio.getText();
					vehiculosDao.buscarVehiculosTipos(tipo);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosTipos(tipo).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosTipos(tipo).toString().split(";");
						Object[]data = new Object[7];
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						dm.addRow(data);
					}
				}
				if(!text_Modelo.getText().equals("")) {
					DAO_Vehiculo vehiculosDao = new DAO_Vehiculo();
					String modelo = text_Modelo.getText();
					vehiculosDao.buscarVehiculosModelo(modelo);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosModelo(modelo).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosModelo(modelo).toString().split(";");
						Object[]data = new Object[7];
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						dm.addRow(data);
					}
				}
				if(!text_Marca.getText().equals("")) {
					DAO_Vehiculo vehiculosDao = new DAO_Vehiculo();
					String marca = text_Marca.getText();
					vehiculosDao.buscarVehiculosMarca(marca);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosMarca(marca).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosMarca(marca).toString().split(";");
						Object[]data = new Object[7];
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						dm.addRow(data);
					}
				}
			}
		});
		btnBuscar.setBounds(336, 50, 89, 23);
		panel_1.add(btnBuscar);
		
		JButton btnReset = new JButton("Resetear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text_Precio.setText("");
				text_Modelo.setText("");
				text_Marca.setText("");
				dm.setRowCount(0);
				vehiculoDao.recibirDatos();
				Object[]data = new Object[6];
				for(int i = 0; i < vehiculoDao.recibirDatos().size();i++) {
					Object[]linea = vehiculoDao.recibirDatos().get(i).toString().split(";");
					data[0] = linea[0];
					data[1] = linea[1];
					data[2] = linea[2];
					data[3] = linea[3];
					data[4] = linea[4];
					data[5] = linea[5];
					dm.addRow(data);
				}
			}
		});
		btnReset.setBounds(236, 50, 89, 23);
		panel_1.add(btnReset);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				volver();
			}
		});
		btnVolver.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVolver.setBounds(10, 378, 134, 46);
		panel_1.add(btnVolver);
		
		dm = new DefaultTableModel();
		table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 104);
		scrollPane.setSize(456, 256);
		String[]columns = {"Número Serie", "Modelo", "Marca", "Tipo", "Precio", "Fecha Entrada"};
		for ( int i=0; i<columns.length;i++){
            dm.addColumn(columns[i]);
        }
		Object[]data = new Object[6];
		for (int i = 0; i < vehiculoDao.recibirDatos().size();i++) {
			Object[] linea = vehiculoDao.recibirDatos().get(i).toString().split(";");
			data[0] = linea[0];
			data[1] = linea[1];
			data[2] = linea[2];
			data[3] = linea[3];
			data[4] = linea[4];
			data[5] = linea[5];
			dm.addRow(data);
		}
		table.setModel(dm);

		table.setBounds(20, 70, 446, 305);
		panel_1.add(scrollPane);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
				dm.setRowCount(0);
				for (int i = 0; i < vehiculoDao.recibirDatos().size();i++) {
					Object[] linea = vehiculoDao.recibirDatos().get(i).toString().split(";");
					data[0] = linea[0];
					data[1] = linea[1];
					data[2] = linea[2];
					data[3] = linea[3];
					data[4] = linea[4];
					data[5] = linea[5];
					dm.addRow(data);
				}
			}
		});
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setBounds(332, 378, 134, 46);
		panel_1.add(btnModificar);
		
		JLabel lbl_Marca = new JLabel("Marca");
		lbl_Marca.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Marca.setBounds(10, 55, 43, 14);
		panel_1.add(lbl_Marca);
		
		text_Marca = new JTextField();
		text_Marca.setBounds(63, 53, 120, 20);
		panel_1.add(text_Marca);
		text_Marca.setColumns(10);
		
		JLabel lbl_Marca_1 = new JLabel("Modelo");
		lbl_Marca_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Marca_1.setBounds(10, 13, 43, 14);
		panel_1.add(lbl_Marca_1);
		
		text_Modelo = new JTextField();
		text_Modelo.setColumns(10);
		text_Modelo.setBounds(63, 11, 120, 20);
		panel_1.add(text_Modelo);
		
		text_Precio = new JTextField();
		text_Precio.setColumns(10);
		text_Precio.setBounds(287, 11, 120, 20);
		panel_1.add(text_Precio);
		
		JLabel lbl_Precio = new JLabel("Precio");
		lbl_Precio.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Precio.setBounds(234, 13, 43, 14);
		panel_1.add(lbl_Precio);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void modificar() {
		try {
			Object[]datos = new Object[3];
			datos[0] = text_Marca.getText();
			datos[1] = text_Modelo.getText();
			datos[2] = Integer.parseInt(text_Precio.getText());
				DAO_Vehiculo vehiculoDao = new DAO_Vehiculo();
				vehiculoDao.modificarDatos(Num_Serie, datos);
				dm.addRow(datos);
		}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Precio mal escrito");
			}
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		Num_Serie = Integer.parseInt(dm.getValueAt(selectedRow, 0).toString());
        text_Marca.setText(dm.getValueAt(selectedRow, 2).toString());
        text_Modelo.setText(dm.getValueAt(selectedRow, 1).toString());
        text_Precio.setText(dm.getValueAt(selectedRow, 4).toString());
    } 
}
