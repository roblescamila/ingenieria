package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import core.Graph;
import core.Node;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JTextField;

public class Wizard extends JFrame {

	private JPanel contentPane;
	private Graph g;
	final private GraphEditor ge;
	private JComboBox comboBoxNodo;
	private JComboBox comboBoxAttNodo;
	private JTextField textFieldAttNodo;
	private JTextField textField_1;
	private JTextField testNode;
	private JTextField textAttNode;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public Wizard(Graph g, final GraphEditor ge) {
		this.ge = ge;
		this.g = g;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxNodo = new JComboBox();
		comboBoxNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testNode.setText((String)comboBoxNodo.getSelectedItem());
				HashMap<String, String> aux = searchNode((String)comboBoxNodo.getSelectedItem()).getAttributes();
				Set<String> keys = aux.keySet();
				comboBoxAttNodo.removeAllItems();
				for(String s:keys)
					comboBoxAttNodo.addItem(s);
				textFieldAttNodo.setText(aux.get((String)comboBoxAttNodo.getSelectedItem()));
			}
		});
		comboBoxNodo.setBounds(65, 45, 121, 20);
		contentPane.add(comboBoxNodo);
		
		comboBoxAttNodo = new JComboBox();
		comboBoxAttNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAttNode.setText((String)comboBoxAttNodo.getSelectedItem());
				HashMap<String, String> aux = searchNode((String)comboBoxNodo.getSelectedItem()).getAttributes();
				Set<String> keys = aux.keySet();
				textFieldAttNodo.setText(aux.get((String)comboBoxAttNodo.getSelectedItem()));
			}
		});
		comboBoxAttNodo.setBounds(231, 45, 121, 20);
		contentPane.add(comboBoxAttNodo);
		
		JLabel lblNodo = new JLabel("Nodo");
		lblNodo.setBounds(65, 11, 46, 14);
		contentPane.add(lblNodo);
		
		JLabel lblAtributo = new JLabel("Atributo");
		lblAtributo.setBounds(231, 11, 46, 14);
		contentPane.add(lblAtributo);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(397, 11, 46, 14);
		contentPane.add(lblValor);
		
		JLabel lblArco = new JLabel("Arco");
		lblArco.setBounds(65, 136, 46, 14);
		contentPane.add(lblArco);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(65, 162, 121, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(65, 219, 121, 20);
		contentPane.add(comboBox_4);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(10, 165, 46, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(10, 222, 46, 14);
		contentPane.add(lblDestino);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(231, 162, 121, 20);
		contentPane.add(comboBox_5);
		
		JLabel lblAtributo_1 = new JLabel("Atributo");
		lblAtributo_1.setBounds(231, 136, 46, 14);
		contentPane.add(lblAtributo_1);
		
		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setBounds(397, 136, 46, 14);
		contentPane.add(lblValor_1);
		
		JButton btnNuevoNodo = new JButton("Nuevo Nodo");
		btnNuevoNodo.setBounds(65, 315, 121, 23);
		contentPane.add(btnNuevoNodo);
		
		JButton btnNewButton = new JButton("Nuevo Arco");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(231, 315, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNuevoAtributo = new JButton("Nuevo Atributo");
		btnNuevoAtributo.setBounds(397, 76, 121, 23);
		contentPane.add(btnNuevoAtributo);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ge.closeEdit();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(62, 362, 456, 23);
		contentPane.add(btnNewButton_1);
		
		textFieldAttNodo = new JTextField();
		textFieldAttNodo.setBounds(397, 45, 121, 20);
		contentPane.add(textFieldAttNodo);
		textFieldAttNodo.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(397, 162, 121, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		testNode = new JTextField();
		testNode.setBounds(65, 76, 121, 20);
		contentPane.add(testNode);
		testNode.setColumns(10);
		
		textAttNode = new JTextField();
		textAttNode.setBounds(231, 76, 121, 20);
		contentPane.add(textAttNode);
		textAttNode.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(65, 193, 121, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(65, 250, 121, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(231, 193, 121, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNuevoAtributo_1 = new JButton("Nuevo Atributo");
		btnNuevoAtributo_1.setBounds(397, 193, 121, 23);
		contentPane.add(btnNuevoAtributo_1);
		
		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(397, 315, 121, 23);
		contentPane.add(btnGuardar);
		
		this.initCombos();
	}
	
	private Node searchNode(String s){
		for(Node n:g.getNodes())
			if(n.getLabel().equals(s))
				return n;
		return null;
	}
	
	private void initCombos(){
		for(Node n:g.getNodes())
			comboBoxNodo.addItem(n.getLabel());	
	}
	
	
}
