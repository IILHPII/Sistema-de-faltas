package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.border.LineBorder;

import configuration.Conexion;
import model.Persona;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Conexion carga=new Conexion();
	private Persona registroPersona=new Persona();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 597);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setFont(new Font("DialogInput", Font.PLAIN, 11));
		tabbedPane.setBounds(0, 0, 772, 560);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Add new user\r\n", new ImageIcon(Menu.class.getResource("/imgs/prueba2.png")), panel, null);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblCedulaDeIdentidad = new JLabel("Cedula de identidad");
		lblCedulaDeIdentidad.setBounds(33, 123, 159, 24);
		panel.add(lblCedulaDeIdentidad);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField.setOpaque(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("DialogInput", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(258, 119, 276, 30);
		panel.add(textField);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(258, 146, 276, 2);
		panel.add(separator);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				boolean mayusculas=caracter >= 65 && caracter<=90;
				boolean minusculas=caracter>=97 && caracter<=120;
				boolean espacio=caracter==32;
				if(!(mayusculas || minusculas || espacio)) {
					e.consume();
				}
			}
		});
		textField_1.setOpaque(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("DialogInput", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(258, 174, 276, 30);
		panel.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(258, 202, 276, 2);
		panel.add(separator_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(33, 178, 159, 24);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setOpaque(false);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("DialogInput", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(258, 228, 276, 30);
		panel.add(textField_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(258, 256, 276, 2);
		panel.add(separator_1_1);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(33, 234, 159, 24);
		panel.add(lblContrasea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(258, 305, 276, 24);
		panel.add(comboBox);
		for(String s : carga.llenarCombo()) {
			comboBox.addItem(s);
		}
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeUsuario.setBounds(33, 305, 159, 24);
		panel.add(lblTipoDeUsuario);
		
		JButton btnCargar = new JButton("");
		btnCargar.setBorderPainted(false);
		btnCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnCargar.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo111.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnCargar.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
			}
		});
		btnCargar.setIcon(new ImageIcon(Menu.class.getResource("/imgs/confirmo222.png")));
		btnCargar.setContentAreaFilled(false);
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String comboValor=comboBox.getSelectedItem().toString();
					if(textField_1.getText().equals("") || textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Registro invalido, intente nuevamente","Hey!",JOptionPane.ERROR_MESSAGE);
					}else {
						registroPersona=new Persona(Integer.parseInt(textField.getText()),textField_1.getText(),comboValor,textField_2.getText());
						carga.alta(registroPersona.getCi(), registroPersona.getNombre(), registroPersona.getRol(), registroPersona.getPassword());	
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						JOptionPane.showMessageDialog(null,"Registro exitoso!","Hey!",JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Registro invalido, intente nuevamente","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCargar.setBounds(348, 353, 91, 94);
		panel.add(btnCargar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imgs/fondoPrueba42.png")));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(0, 0, 765, 547);
		panel.add(lblNewLabel);
		this.setLocationRelativeTo(null);
		
	}
}