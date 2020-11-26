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
import Proyecto.DAO_Vehiculo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUI_VerVehiculos extends javax.swing.JFrame{

	private int Num_Serie;
	private DefaultTableModel dm;
	private GUI_Ventas menu;
	private JFrame frame;
	private JTable table;
	private JTextField text_Marca;
	private JTextField text_Modelo;
	private JTextField text_Precio;
	private JTextField textAnyo;
	private JTextField textKilometros;
	private JComboBox comboCombustible;

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
		setBounds(100, 100, 856, 482);
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
		panel_1.setBounds(175, 0, 665, 443);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DAO_Vehiculo vehiculosDao = new DAO_Vehiculo();
				Object[]data = new Object[9];
				String anyo = textAnyo.getText();
				String kilometros = textKilometros.getText();
				String precio = text_Precio.getText();
				String modelo = text_Modelo.getText();
				String marca = text_Marca.getText();
				String combustible = comboCombustible.getSelectedItem().toString();
				if((text_Modelo.getText().equals(""))&&(text_Marca.getText().equals(""))&&(text_Precio.getText().equals(""))&&(textAnyo.getText().equals(""))&&(textKilometros.getText().equals(""))&&(comboCombustible.getSelectedItem().equals(""))) {
					vehiculoDao.recibirDatos();
				}else
				if(!textAnyo.getText().equals("")) {
					vehiculosDao.buscarVehiculosAnyo(anyo);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosAnyo(anyo).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosAnyo(anyo).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						data[7] = linea[7];
						data[8] = linea[8];
						dm.addRow(data);
					}
				}else
				if(!textKilometros.getText().equals("")) {
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosKilometros(kilometros).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosKilometros(kilometros).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						data[7] = linea[7];
						data[8] = linea[8];
						dm.addRow(data);
					}
				}else
				if(!text_Precio.getText().equals("")) {
					vehiculosDao.buscarVehiculosPrecio(precio);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosPrecio(precio).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosPrecio(precio).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						data[7] = linea[7];
						data[8] = linea[8];
						dm.addRow(data);
					}
				}else
				if(!text_Modelo.getText().equals("")) {
					vehiculosDao.buscarVehiculosModelo(modelo);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosModelo(modelo).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosModelo(modelo).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						data[7] = linea[7];
						data[8] = linea[8];
						dm.addRow(data);
					}
				}else
				if(!text_Marca.getText().equals("")) {
					vehiculosDao.buscarVehiculosMarca(marca);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosMarca(marca).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosMarca(marca).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						data[7] = linea[7];
						data[8] = linea[8];
						dm.addRow(data);
					}
				}else
				if(!comboCombustible.getSelectedItem().equals("")) {
					vehiculosDao.buscarVehiculosCombustible(combustible);
					dm.setRowCount(0);
					for(int i = 0; i < vehiculosDao.buscarVehiculosCombustible(combustible).size();i++) {
						Object[]linea = vehiculosDao.buscarVehiculosCombustible(combustible).get(i).toString().split(";");
						data[0] = linea[0];
						data[1] = linea[1];
						data[2] = linea[2];
						data[3] = linea[3];
						data[4] = linea[4];
						data[5] = linea[5];
						data[6] = linea[6];
						data[7] = linea[7];
						data[8] = linea[8];
						dm.addRow(data);
					}
				}
			}
		});
		btnBuscar.setBounds(421, 378, 89, 23);
		panel_1.add(btnBuscar);
		
		JButton btnReset = new JButton("Resetear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text_Precio.setText("");
				text_Modelo.setText("");
				text_Marca.setText("");
				textAnyo.setText("");
				textKilometros.setText("");
				comboCombustible.setSelectedIndex(0);
				dm.setRowCount(0);
				vehiculoDao.recibirDatos();
				Object[]data = new Object[9];
				for(int i = 0; i < vehiculoDao.recibirDatos().size();i++) {
					Object[]linea = vehiculoDao.recibirDatos().get(i).toString().split(";");
					data[0] = linea[0];
					data[1] = linea[1];
					data[2] = linea[2];
					data[3] = linea[3];
					data[4] = linea[4];
					data[5] = linea[5];
					data[6] = linea[6];
					data[7] = linea[7];
					data[8] = linea[8];
					dm.addRow(data);
				}
			}
		});
		btnReset.setBounds(421, 401, 89, 23);
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
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setBackground(Color.yellow);
		table.getTableHeader().setBackground(Color.orange);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		JScrollPane scrollPane= new  JScrollPane(table);
		scrollPane.setLocation(10, 104);
		scrollPane.setSize(645, 256);
		String[]columns = {"Número Serie", "Modelo", "Marca", "Tipo", "Precio", "Fecha Entrada", "Año", "Kilómetros", "Combustible"};
		for ( int i=0; i<columns.length;i++){
            dm.addColumn(columns[i]);
        }
		Object[]data = new Object[9];
		for (int i = 0; i < vehiculoDao.recibirDatos().size();i++) {
			Object[] linea = vehiculoDao.recibirDatos().get(i).toString().split(";");
			data[0] = linea[0];
			data[1] = linea[1];
			data[2] = linea[2];
			data[3] = linea[3];
			data[4] = linea[4];
			data[5] = linea[5];
			data[6] = linea[6];
			data[7] = linea[7];
			data[8] = linea[8];
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
					data[6] = linea[6];
					data[7] = linea[7];
					data[8] = linea[8];
					dm.addRow(data);
				}
			}
		});
		btnModificar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnModificar.setBounds(521, 378, 134, 46);
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
		
		JLabel lbl_Anyo = new JLabel("A\u00F1o");
		lbl_Anyo.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Anyo.setBounds(234, 52, 43, 14);
		panel_1.add(lbl_Anyo);
		
		textAnyo = new JTextField();
		textAnyo.setColumns(10);
		textAnyo.setBounds(287, 50, 120, 20);
		panel_1.add(textAnyo);
		
		JLabel lbl_Kilometros = new JLabel("Kilometros");
		lbl_Kilometros.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Kilometros.setBounds(453, 13, 63, 14);
		panel_1.add(lbl_Kilometros);
		
		textKilometros = new JTextField();
		textKilometros.setColumns(10);
		textKilometros.setBounds(535, 11, 120, 20);
		panel_1.add(textKilometros);
		
		JLabel lbl_Combustible = new JLabel("Combustible");
		lbl_Combustible.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		lbl_Combustible.setBounds(453, 51, 72, 14);
		panel_1.add(lbl_Combustible);
		
		String combustibles[] = {
				"",
				"Diésel",
				"Gasolina",
				"Híbrido",
				"Eléctrico"
		};
		
		comboCombustible = new JComboBox(combustibles);
		comboCombustible.setBounds(535, 47, 120, 22);
		panel_1.add(comboCombustible);
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		menu.setVisible(true);
	}
	
	public void modificar() {
		try {
			int selectedRow = table.getSelectedRow();
			Object[]datos = new Object[6];
			datos[0] = text_Marca.getText();
			datos[1] = text_Modelo.getText();
			datos[2] = Integer.parseInt(text_Precio.getText());
			datos[3] = Integer.parseInt(textAnyo.getText());
			datos[4] = Integer.parseInt(textKilometros.getText());
			datos[5] = comboCombustible.getSelectedItem();
			DAO_Vehiculo vehiculoDao = new DAO_Vehiculo();
			vehiculoDao.modificarDatos(Num_Serie, datos);
		}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Comprueba que los campos 'Precio', 'Año' y 'Kilometros' estén bien escritos");
		}
	}
	
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {  
		int selectedRow = table.getSelectedRow();
		Num_Serie = Integer.parseInt(dm.getValueAt(selectedRow, 0).toString());
		text_Modelo.setText(dm.getValueAt(selectedRow, 1).toString());
        text_Marca.setText(dm.getValueAt(selectedRow, 2).toString());
        text_Precio.setText(dm.getValueAt(selectedRow, 4).toString());
        textAnyo.setText(dm.getValueAt(selectedRow, 6).toString());
        textKilometros.setText(dm.getValueAt(selectedRow, 7).toString());
        comboCombustible.setSelectedItem(dm.getValueAt(selectedRow, 8).toString());
    }
}
