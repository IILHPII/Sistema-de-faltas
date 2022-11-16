package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import configuration.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private Conexion conexion=new Conexion();
	Menu menu=new Menu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 597);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imgs/fondoDerecha.jpg")));
		lblNewLabel.setBounds(514, 0, 258, 597);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imgs/logoLogin.png")));
		lblNewLabel_1.setBounds(187, 11, 141, 133);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("DialogInput", Font.PLAIN, 18));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBounds(99, 189, 322, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 222, 322, 2);
		contentPane.add(separator);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("DialogInput", Font.PLAIN, 18));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setOpaque(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(99, 294, 322, 33);
		contentPane.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(99, 325, 322, 2);
		contentPane.add(separator_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexion.setCi(Integer.parseInt(textField.getText()));
					conexion.setPassword(String.valueOf(textField_1.getPassword()));
				}catch(java.lang.NumberFormatException ex) {}
				
				if(conexion.consulta()==true) {
						menu.setVisible(true);
						dispose();
				}else {
					JOptionPane.showMessageDialog(null,"User or password wrong","Hey!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/imgs/botonLogin1.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/imgs/botonLogin2.png")));
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/imgs/botonLogin2.png")));
		btnNewButton.setBounds(187, 379, 141, 133);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setOpaque(false);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}