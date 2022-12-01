package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import configuration.CombosConexion;
import configuration.Conexion;
import configuration.CrudDBDocente;
import model.Docente;
import model.Persona;
import model.Registros;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;

public class RegistroDeFaltas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Docente docente=new Docente();
	private CrudDBDocente carga=new CrudDBDocente();
	private CombosConexion cargarCombo=new CombosConexion();
	private JTextField textField_2;
	private Conexion con=new Conexion();
	private Registros actualizacion1=new Registros();
	private Consultas actualizacion2=new Consultas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDeFaltas frame = new RegistroDeFaltas();
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
	public RegistroDeFaltas() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeFalta = new JLabel("Registro de falta");
		lblRegistroDeFalta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegistroDeFalta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeFalta.setBounds(352, 12, 188, 30);
		contentPane.add(lblRegistroDeFalta);
		
		JLabel lblCedulaDelDocente = new JLabel("Cedula del docente");
		lblCedulaDelDocente.setBounds(171, 93, 137, 15);
		contentPane.add(lblCedulaDelDocente);
		
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
		textField.setBounds(341, 86, 199, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(341, 151, 199, 30);
		contentPane.add(textField_1);
		
		JLabel lblCedulaDelDocente_1 = new JLabel("Grupo");
		lblCedulaDelDocente_1.setBounds(254, 224, 54, 15);
		contentPane.add(lblCedulaDelDocente_1);
		
		JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setBounds(254, 158, 54, 15);
		contentPane.add(lblMotivo);
		
		JLabel lblFechasDeAusencias = new JLabel("Fechas de ausencias");
		lblFechasDeAusencias.setBounds(377, 345, 152, 15);
		contentPane.add(lblFechasDeAusencias);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(298, 412, 110, 19);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(468, 412, 110, 19);
		contentPane.add(dateChooser_1);
		
		JLabel lblFechasDeInicio = new JLabel("Fecha de inicio");
		lblFechasDeInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechasDeInicio.setFont(new Font("Dialog", Font.BOLD, 10));
		lblFechasDeInicio.setBounds(298, 385, 110, 15);
		contentPane.add(lblFechasDeInicio);
		
		JLabel lblFechasDeFin = new JLabel("Fecha de fin");
		lblFechasDeFin.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechasDeFin.setFont(new Font("Dialog", Font.BOLD, 10));
		lblFechasDeFin.setBounds(468, 385, 110, 15);
		contentPane.add(lblFechasDeFin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(341, 216, 199, 30);
		contentPane.add(comboBox);
		for(String s : cargarCombo.llenarComboGrupos()) {
			comboBox.addItem(s);
		}
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try {
							carga.setCiD(Integer.parseInt(textField.getText()));
							carga.setCiU(Integer.parseInt(textField_2.getText()));
							String fechaInicial=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
							carga.setFechaInicial(fechaInicial);
							String fechaFinal=((JTextField)dateChooser_1.getDateEditor().getUiComponent()).getText();
							carga.setFechaFinal(fechaFinal);
							carga.setGrupo(comboBox.getSelectedItem().toString());
							carga.setMotivo(textField_1.getText());
							if(carga.consulta()==true && con.consultaCiURegistro(carga.getCiU())==true) {
								if(carga.getFechaFinal().after(carga.getFechaInicial()) || carga.getFechaFinal().equals(carga.getFechaInicial())) {
									carga.altaAusencia();
									actualizacion1.llenarDatos();
									actualizacion2.actualizar();
									JOptionPane.showMessageDialog(null,"La ausencia se registro correctamente!","Hey!",JOptionPane.INFORMATION_MESSAGE); 
								}else {
									JOptionPane.showMessageDialog(null,"La fecha de inicio no puede ser mayor a la final!","Hey!",JOptionPane.ERROR_MESSAGE);
								}	
							}else {
								JOptionPane.showMessageDialog(null,"El usuario o docente no esta registrado!","Hey!",JOptionPane.ERROR_MESSAGE);
							}
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null,"No puedes dejar las fechas vacias!","Hey!",JOptionPane.ERROR_MESSAGE);
						}catch(java.lang.NumberFormatException ex) {
							JOptionPane.showMessageDialog(null,"No puedes dejar campos vacios!","Hey!",JOptionPane.ERROR_MESSAGE);
						}
			}
		});
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'0' || caracter>'9' && caracter!='\b') {
					e.consume();
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(341, 291, 199, 30);
		contentPane.add(textField_2);
		btnNewButton_1_1.setIcon(new ImageIcon(RegistroDeFaltas.class.getResource("/imgs/submit1.png")));
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(377, 494, 124, 27);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblCedulaDelDocente_1_1 = new JLabel("Cedula del funcionario");
		lblCedulaDelDocente_1_1.setBounds(149, 298, 159, 15);
		contentPane.add(lblCedulaDelDocente_1_1);
		
		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(RegistroDeFaltas.class.getResource("/imgs/exit22.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(RegistroDeFaltas.class.getResource("/imgs/exit.png")));
			}
		});
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4_1_1.setIcon(new ImageIcon(RegistroDeFaltas.class.getResource("/imgs/exit.png")));
		btnNewButton_4_1_1.setContentAreaFilled(false);
		btnNewButton_4_1_1.setBorderPainted(false);
		btnNewButton_4_1_1.setBounds(824, 516, 63, 59);
		contentPane.add(btnNewButton_4_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegistroDeFaltas.class.getResource("/imgs/fondoMenu23.png")));
		lblNewLabel.setBounds(0, 0, 904, 600);
		contentPane.add(lblNewLabel);
	}
}
