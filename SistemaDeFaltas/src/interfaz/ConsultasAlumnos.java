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
import java.util.ArrayList;

import model.Docente;
import model.Registros;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import configuration.CrudDBAlumno;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ConsultasAlumnos extends JFrame {
	

	private JPanel contentPane;
	private Docente docente=new Docente();
	private Registros registro=new Registros();
	private static JTable miTabla1;
	private static JScrollPane miBarra1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private CrudDBAlumno alumno=new CrudDBAlumno();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultasAlumnos frame = new ConsultasAlumnos();
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
	public ConsultasAlumnos() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeFalta = new JLabel("Consultas de Alumnos");
		lblRegistroDeFalta.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegistroDeFalta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeFalta.setBounds(319, 12, 227, 30);
		contentPane.add(lblRegistroDeFalta);
		
		
		miBarra1=new JScrollPane();
		miBarra1.setEnabled(false);
		miBarra1.setBounds(137,39,600,360);
		getContentPane().add(miBarra1);
		
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
		textField.setBounds(360, 422, 162, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula del alumno");
		lblCedula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedula.setBounds(197, 429, 131, 15);
		contentPane.add(lblCedula);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					alumno.setCedula(Integer.parseInt(textField.getText()));
					if(alumno.consulta()==false) {
						JOptionPane.showMessageDialog(null,"El Alumno no esta registrado!","Hey!",JOptionPane.INFORMATION_MESSAGE);
					}else if(alumno.consulta()==true) {
						String grupo=alumno.getGrupoFromDB();
						registro.setNombreGrupo(grupo);
						construirTablaGrupo();
					}	
				}catch(java.lang.NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Valores ingresados nulos o incorrectos","Hey!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(549, 424, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_4_1_1 = new JButton("");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(ConsultasAlumnos.class.getResource("/imgs/exit22.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnNewButton_4_1_1.setIcon(new ImageIcon(ConsultasAlumnos.class.getResource("/imgs/exit.png")));
			}
		});
		
		btnNewButton_4_1_1.setIcon(new ImageIcon(ConsultasAlumnos.class.getResource("/imgs/exit.png")));
		btnNewButton_4_1_1.setContentAreaFilled(false);
		btnNewButton_4_1_1.setBorderPainted(false);
		btnNewButton_4_1_1.setBounds(824, 516, 63, 59);
		contentPane.add(btnNewButton_4_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsultasAlumnos.class.getResource("/imgs/fondoMenu23.png")));
		
		lblNewLabel.setBounds(0, 0, 904, 600);
		contentPane.add(lblNewLabel);
	
		construirTablaGrupo();
	}
	

	public void construirTablaGrupo() {
		String titulos[]= {"Cedula Docente","Cedula Usuario","Fecha Inicial","Fecha Final","Grupo","Motivo"};
		String informacion[][]=obtenerMatrizGrupo();
		miTabla1=new JTable(informacion,titulos);
		miTabla1.setEnabled(false);
		miBarra1.setViewportView(miTabla1);
	}
	
	private String[][] obtenerMatrizGrupo(){
		ArrayList<Registros>miLista=registro.llenarDatosSegunGrupo();
		String matrizInfo[][]=new String[miLista.size()][6];
		for(int i =0;i<miLista.size();i++) {
			matrizInfo[i][0]=miLista.get(i).getCedulaDocente()+"";
			matrizInfo[i][1]=miLista.get(i).getCedulaUsuario()+"";
			matrizInfo[i][2]=miLista.get(i).getFechaInicial()+"";
			matrizInfo[i][3]=miLista.get(i).getFechaFinal()+"";
			matrizInfo[i][4]=miLista.get(i).getNombreGrupo()+"";
			matrizInfo[i][5]=miLista.get(i).getMotivo()+"";
		}
		return matrizInfo;
	}
}


