package com.pulsar.finalnaa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class Garazaa {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/garaza"
			+ "?useUnicode=yes&characterEncoding=UTF-8";

	static final String USER = "root";
	static final String PASS = "";

	private JFrame frmGaraza;
	
	private JTable table;
	private Connection con = null;
	private JScrollPane jsp;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Garazaa window = new Garazaa();
					window.frmGaraza.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Garazaa() {
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			Class.forName(JDBC_DRIVER);
			this.con = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch (Exception e) {
			System.out.println("Se pojavi nekoja greska od bazata");
		}
		
		frmGaraza = new JFrame();
		frmGaraza.setFont(new Font("Dialog", Font.BOLD, 13));
		frmGaraza.setTitle("Garaza");
		frmGaraza.getContentPane().setBackground(Color.BLACK);
		frmGaraza.setBounds(100, 100, 679, 367);
		frmGaraza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGaraza.getContentPane().setLayout(null);
		
		
		JButton btnOpcii = new JButton("Opcii");
		btnOpcii.setSelected(true);
		btnOpcii.setToolTipText("");
		btnOpcii.setForeground(Color.BLACK);
		btnOpcii.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Opcii opcii = new Opcii(con);
				opcii.setVisible(true);
			}
		});
		btnOpcii.setBounds(10, 11, 89, 23);
		frmGaraza.getContentPane().add(btnOpcii);
		
		JButton btnVlez = new JButton("Vlez");
		btnVlez.setForeground(Color.BLACK);
		btnVlez.setSelected(true);
		btnVlez.setBackground(Color.GREEN);
		btnVlez.setBounds(564, 11, 89, 23);
		frmGaraza.getContentPane().add(btnVlez);
		frmGaraza.getContentPane().add(btnVlez);
		btnVlez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vlez vlez = new Vlez(con);
				vlez.setVisible(true);
				loadData();
				
			{;
		}
	}});
	
		JButton btnIzlez = new JButton("Izlez");
		btnIzlez.setSelected(true);
		btnIzlez.setBackground(Color.RED);
		btnIzlez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		
		frmGaraza.getContentPane().add(btnIzlez);
		btnIzlez.setBounds(564, 283, 89, 23);
		
		
		JLabel lblMaksimumSlobodniMesta = new JLabel("Maksimum slobodni mesta 0 od 10");
		lblMaksimumSlobodniMesta.setForeground(Color.YELLOW);
		lblMaksimumSlobodniMesta.setBounds(10, 292, 261, 14);
		frmGaraza.getContentPane().add(lblMaksimumSlobodniMesta);
		frmGaraza.getComponentCount();
		
		
			loadData();
		}	
		private void loadData() {
			
			try {
				Statement stmt = this.con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM informacii");
				
				ResultSetMetaData rsms = rs.getMetaData();
				Vector<String> columns = new Vector<String>();
		
				
				Integer numberOfColumns = rsms.getColumnCount();
				for(int i = 1; i <= numberOfColumns; i++) {
					columns.addElement(rsms.getColumnName(i));
				}
				
				Vector<Object> rows = new Vector<Object>();
				while(rs.next()) {
					Vector<Object> row = new Vector<Object>();
					row.add(rs.getString("Marka"));
					row.add(rs.getString("Model"));
					row.add(rs.getString("Registracija"));
					row.add(rs.getString("Status"));
					row.add(rs.getString("Vreme_Na_Vlez"));
					row.add(rs.getString("Vreme_Na_Izlez"));
					rows.add(row);
						
				}
				
				stmt.close();
				
				if(jsp != null) {
					frmGaraza.getContentPane().remove(jsp);
				}
				table = new JTable(rows, columns);
				jsp = new JScrollPane(table);  
				jsp.setBounds(10, 45, 643, 227);
				frmGaraza.getContentPane().add(jsp);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			}


