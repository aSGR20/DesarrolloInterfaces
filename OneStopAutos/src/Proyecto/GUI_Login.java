package Proyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;

import Mecanicos.GUI_Mecanicos;
import Ventas.GUI_PropuestaVehiculo1;
import Ventas.GUI_Ventas;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

public class GUI_Login extends javax.swing.JFrame{

	private JFrame frame;
	private JTextField text_User;
	private JPasswordField text_Passwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Login window = new GUI_Login();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Login() {
		initialize();
		setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		setTitle("Login");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(100, 94, 58, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(73, 130, 85, 14);
		panel.add(lblNewLabel_1);
		
		text_User = new JTextField();
		text_User.setFont(new Font("SansSerif", Font.PLAIN, 14));
		text_User.setBounds(164, 93, 148, 20);
		panel.add(text_User);
		text_User.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
		            loggear();
		        }
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loggear();
			}
		});
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnLogin.setBounds(164, 179, 89, 23);
		panel.add(btnLogin);
		
		text_Passwd = new JPasswordField();
		text_Passwd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
		            loggear();
		        }
			}
		});
		text_Passwd.setFont(new Font("SansSerif", Font.PLAIN, 14));
		text_Passwd.setBounds(164, 129, 148, 20);
		panel.add(text_Passwd);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(".\\src\\images\\myLogo_Login.png"));
		lblNewLabel_2.setBounds(149, 23, 122, 55);
		panel.add(lblNewLabel_2);
		
		BufferedImage myLogo;
		try {
			myLogo = ImageIO.read(new File(".\\src\\images\\myLogo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loggear() {
		String username;
		String password;
		username = text_User.getText();
		password = text_Passwd.getText();
		UsuarioLogin usuario = new UsuarioLogin(username, password);
		DAO_Usuario comprobacion = new DAO_Usuario();
		if(comprobacion.comprobarUsuario(usuario)) {
			if(comprobacion.profesion(usuario).equals("ventas")) {
				GUI_Ventas interfazVentas = new GUI_Ventas(this);
				this.setVisible(false);
			}else
				if(comprobacion.profesion(usuario).equals("mec�nico")||comprobacion.profesion(usuario).equals("mec�nico_jefe")) {
					GUI_Mecanicos interfazMecanicos = new GUI_Mecanicos(this);
					this.setVisible(false);
				}else
					if(comprobacion.profesion(usuario).equals("jefe")) {
						JOptionPane.showMessageDialog(null, "EN CONSTRUCCI�N");
					}
		}else {
			JOptionPane.showMessageDialog(null, "Usuario y/o Contrase�a incorrectos");
		}
	}
}
