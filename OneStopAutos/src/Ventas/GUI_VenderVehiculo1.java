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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Proyecto.DAO_Usuario;
import Proyecto.DAO_Vehiculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_VenderVehiculo1 extends javax.swing.JFrame{

	public static int numSerie, precio;
	public static String marca, modelo, tipo;
	private DefaultTableModel dm;
	private GUI_Ventas menu;
	private JFrame frame;
	private JTable table;
	private JTextField text_Marca;
	private JTextField text_Modelo;
	private JTextField text_Tipo;

	/**
	 * Create the application.
	 */
	public GUI_VenderVehiculo1(GUI_Ventas menu) {
		initialize();
		this.menu = menu;
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GUI_VenderVehiculo1() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Venta de vehículos");
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
		
		dm = new DefaultTableModel();
		table = new JTable(dm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBackground(Color.yellow);
		table.getTableHeader().setBackground(Color.orange);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 95);
		scrollPane.setSize(456, 265);
		String[]columns= {"Número Serie", "Modelo", "Marca", "Tipo", "Precio", "Fecha Entrada"};
		for(int i = 0; i < columns.length;i++) {
			dm.addColumn(columns[i]);
		}
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
		table.setModel(dm);
		
		table.setBounds(20, 70, 446, 305);
		panel_1.add(scrollPane);
		
		JLabel lbl_Marca = new JLabel("Marca");
		lbl_Marca.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Marca.setBounds(10, 15, 43, 14);
		panel_1.add(lbl_Marca);
		
		JLabel lbl_Modelo = new JLabel("Modelo");
		lbl_Modelo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Modelo.setBounds(10, 55, 55, 14);
		panel_1.add(lbl_Modelo);
		
		text_Marca = new JTextField();
		text_Marca.setFont(new Font("SansSerif", Font.PLAIN, 14));
		text_Marca.setBounds(74, 12, 134, 20);
		panel_1.add(text_Marca);
		text_Marca.setColumns(10);
		
		text_Modelo = new JTextField();
		text_Modelo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		text_Modelo.setColumns(10);
		text_Modelo.setBounds(74, 52, 134, 20);
		panel_1.add(text_Modelo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[]datos = new Object[3];
				if((text_Modelo.getText().equals(""))&&(text_Marca.getText().equals(""))&&(text_Tipo.getText().equals(""))) {
					vehiculoDao.recibirDatos();
				}
				if(!text_Tipo.getText().equals("")) {
					DAO_Vehiculo vehiculosDao = new DAO_Vehiculo();
					String tipo = text_Tipo.getText();
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
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				siguienteVenta();
			}
		});
		btnSiguiente.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSiguiente.setBounds(332, 381, 134, 46);
		panel_1.add(btnSiguiente);
		
		JLabel lbl_Tipo = new JLabel("Tipo");
		lbl_Tipo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lbl_Tipo.setBounds(252, 12, 30, 20);
		panel_1.add(lbl_Tipo);
		
		text_Tipo = new JTextField();
		text_Tipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		text_Tipo.setColumns(10);
		text_Tipo.setBounds(292, 12, 134, 20);
		panel_1.add(text_Tipo);
		
		JButton btnReset = new JButton("Resetear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text_Tipo.setText("");
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
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void siguienteVenta() {
		int selectedRow = table.getSelectedRow();
		marca = dm.getValueAt(selectedRow, 2).toString();
		modelo = dm.getValueAt(selectedRow, 1).toString();
		tipo = dm.getValueAt(selectedRow, 3).toString();
		precio = Integer.parseInt(dm.getValueAt(selectedRow, 4).toString());
		GUI_VenderVehiculo2 propuestaSiguiente = new GUI_VenderVehiculo2(this, menu);
		this.setVisible(false);
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		numSerie = Integer.parseInt(dm.getValueAt(selectedRow, 0).toString());
        text_Marca.setText(dm.getValueAt(selectedRow, 2).toString());
        text_Modelo.setText(dm.getValueAt(selectedRow, 1).toString());
        text_Tipo.setText(dm.getValueAt(selectedRow, 3).toString());
    }
	
	public int getNumSerie() {
		return numSerie;
	}

	public static int getPrecio() {
		return precio;
	}

	public static String getMarca() {
		return marca;
	}

	public static String getModelo() {
		return modelo;
	}

	public static String getTipo() {
		return tipo;
	}
}
