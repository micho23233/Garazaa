package com.pulsar.finalnaa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

public class Opcii extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtImeNaGaraza;
	private JTextField txtMaksimumBrojNa;
	private JButton btnDodaj;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Opcii dialog = new Opcii(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Opcii(Connection con) {
		setName("Opcii");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtImeNaGaraza = new JTextField();
		txtImeNaGaraza.setText("Ime na garaza");
		txtImeNaGaraza.setBounds(28, 37, 212, 23);
		contentPanel.add(txtImeNaGaraza);
		txtImeNaGaraza.setColumns(10);
		super.setTitle(getName());
		
		txtMaksimumBrojNa = new JTextField();
		txtMaksimumBrojNa.setText("Maksimum broj na slobodni mesta");
		txtMaksimumBrojNa.setBounds(28, 86, 212, 23);
		contentPanel.add(txtMaksimumBrojNa);
		txtMaksimumBrojNa.setColumns(10);
		maksimumBrojNaSlobodniMesta();
		
		btnDodaj = new JButton("Zacuvaj");
		btnDodaj.setBackground(new Color(0, 255, 0));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			super.getClass();
			}
		});
		btnDodaj.setBounds(335, 228, 89, 23);
		contentPanel.add(btnDodaj);
	}
	
	private String maksimumBrojNaSlobodniMesta() {
		int i = 10;
		if(10 != i) {
			txtMaksimumBrojNa.setToolTipText("Nema povejke slobodno mesto mesto");
			txtMaksimumBrojNa.getColumns();
			System.out.println("Slobodni mesta" + i);
		}
		return null;

	}
	}

