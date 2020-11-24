package Mecanicos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import Proyecto.DAO_Usuario;
import Proyecto.GUI_Login;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Mecanicos extends javax.swing.JFrame{

	private String nombre;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Ventas window = new GUI_Ventas();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public GUI_Mecanicos(GUI_Login login) {
		initialize();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GUI_Mecanicos(String nombre, String usuario) {
		this.nombre = nombre;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setTitle("Menú Principal");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		lbl_Ocupacion.setBounds(52, 406, 122, 14);
		panel.add(lbl_Ocupacion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(175, 0, 476, 443);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_Bienvenida = new JLabel("Bienvenid@ ^^ \u00A1Que tengas un buen dia!");
		lbl_Bienvenida.setFont(new Font("SansSerif", Font.BOLD, 16));
		lbl_Bienvenida.setBounds(10, 11, 313, 29);
		panel_1.add(lbl_Bienvenida);
		
		JLabel lbl_Comenzar = new JLabel("COMENZAR un TRABAJO");
		lbl_Comenzar.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		lbl_Comenzar.setBounds(10, 82, 179, 14);
		panel_1.add(lbl_Comenzar);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnComenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comenzarTrabajos();
			}
		});
		btnComenzar.setBounds(33, 107, 124, 46);
		panel_1.add(btnComenzar);
		
		JLabel lbl_Ver = new JLabel("MIS TRABAJOS");
		lbl_Ver.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		lbl_Ver.setBounds(308, 82, 110, 14);
		panel_1.add(lbl_Ver);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verTrabajos();
			}
		});
		btnVer.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnVer.setBounds(296, 107, 124, 46);
		panel_1.add(btnVer);
		
		
		//if(usuarioDao.getProfesion().equals("mecánico_jefe")) {
			JButton btnAnyadir = new JButton("A\u00F1adir");
			btnAnyadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					anyadirTrabajo();
				}
			});
			btnAnyadir.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnAnyadir.setBounds(166, 240, 124, 46);
			panel_1.add(btnAnyadir);
			
			JLabel lbl_Anyadir = new JLabel("A\u00D1ADIR un TRABAJO");
			lbl_Anyadir.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
			lbl_Anyadir.setBounds(154, 215, 147, 14);
			panel_1.add(lbl_Anyadir);
		//}
	}
	
	public void comenzarTrabajos() {
		GUI_ComenzarTrabajo1 comenzar = new GUI_ComenzarTrabajo1(this);
		this.setVisible(false);
	}
	
	public void verTrabajos() {
		GUI_VerTrabajos ver = new GUI_VerTrabajos(this);
		this.setVisible(false);
	}
	
	public void anyadirTrabajo() {
		GUI_AnyadirTrabajos1 anyadir = new GUI_AnyadirTrabajos1(this);
		this.setVisible(false);
	}
}

