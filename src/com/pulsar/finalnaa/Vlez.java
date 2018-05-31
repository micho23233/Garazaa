package com.pulsar.finalnaa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Vlez extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean Status;
	

	private JTextField txtMarka;
	private JTextField txtModel;
	private JTextField txtRegistracija;
	private Connection con = null;
	private JButton btnDodaj;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vlez dialog = new Vlez(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vlez(Connection con) {
		setTitle("Vlez");
		this.con = con;
		getContentPane().setLayout(null);
	
		setBounds(100, 100, 485, 314);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getContentPane().setBackground(Color.BLACK);
		contentPanel.setLayout(null);
		
			txtMarka = new JTextField();
			txtMarka.setText("Marka");
			txtMarka.setBounds(26, 43, 125, 30);
			contentPanel.add(txtMarka);
			txtMarka.setColumns(10);
	
		
			txtModel = new JTextField();
			txtModel.setText("Model");
			txtModel.setBounds(26, 102, 125, 30);
			contentPanel.add(txtModel);
			txtModel.setColumns(10);
		
		
			txtRegistracija = new JTextField();
			txtRegistracija.setText("Registracija");
			txtRegistracija.setBounds(26, 156, 125, 30);
			contentPanel.add(txtRegistracija);
			txtRegistracija.setColumns(10);
		
		
			btnDodaj = new JButton("Dodaj");
			btnDodaj.setBackground(new Color(0, 255, 0));
			
			btnDodaj.setBounds(189, 213, 89, 23);
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dataVlez();
				}
			});
			btnDodaj.setVisible(true);
			contentPanel.add(btnDodaj);
		}
	
	
				public void dataVlez() {
					try{	
						
						String model = txtModel.getText();
						String marka = txtMarka.getText();
						String registracija = txtRegistracija.getText();
						txtRegistracija.getVerifyInputWhenFocusTarget();
						String Status = "izleze";
						String Vreme_Na_Vlez = (SimpleDateFormat());
						String Vreme_Na_Izlez = ( SimpleDateFormat());
						Statement stmt = con.createStatement();
						stmt.executeUpdate("INSERT INTO informacii (Marka,Model,Registracija,Status,Vreme_Na_Vlez,Vreme_Na_Izlez)VALUES ('"+marka+"','"+model+"','"+registracija+"','"+Status+"','"+Vreme_Na_Vlez+"','"+Vreme_Na_Izlez+"')");
						dispose();
						stmt.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				private String SimpleDateFormat() {
				try {
					final SimpleDateFormat f = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
					f.setTimeZone(TimeZone.getDefault());
					System.out.println(f.format(new Date()));
				}catch (Exception e) {
					e.printStackTrace();
				}
				return null;
									
				}
				{;
				//}
				//private String Status() {
				//if (Status != true) {
				//	System.out.println("Vo Garaza");
				//}
				//return null ;
			}
				
		
		
	

	public JTextField getTxtMarka() {
		return txtMarka;
	}

	public void setTxtMarka(JTextField txtMarka) {
		this.txtMarka = txtMarka;
	}

	public JTextField getTxtModel() {
		return txtModel;
	}

	public void setTxtModel(JTextField txtModel) {
		this.txtModel = txtModel;
	}

	public JTextField getTxtRegistracija() {
		return txtRegistracija;
	}

	public void setTxtRegistracija(JTextField txtRegistracija) {
		this.txtRegistracija = txtRegistracija;
	}
	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}
}
		
		
			
			
	

