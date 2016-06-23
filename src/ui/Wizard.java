package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import core.Edge;
import core.Graph;
import core.Node;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField textDescEdge;
	private JTextField textNode;
	private JTextField textAttNode;
	private JTextField textAttEdge;
	private JComboBox comboBoxEdgeOrg;
	private final JComboBox comboBoxAttEdge;
	
	public Wizard(final Graph g, final GraphEditor ge) {
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
				Node n = searchNode((String)comboBoxNodo.getSelectedItem());
				if(n!=null){
					HashMap<String, String> aux = n.getAttributes();
					Set<String> keys = aux.keySet();
					comboBoxAttNodo.removeAllItems();
					for(String s:keys)
						comboBoxAttNodo.addItem(s);
					textFieldAttNodo.setText(aux.get((String)comboBoxAttNodo.getSelectedItem()));
				}
			}
		});
		comboBoxNodo.setBounds(65, 45, 121, 20);
		contentPane.add(comboBoxNodo);
		
		comboBoxAttNodo = new JComboBox();
		comboBoxAttNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node n = searchNode((String)comboBoxNodo.getSelectedItem());
				if(n!=null){
					HashMap<String, String> aux = n.getAttributes();
					textFieldAttNodo.setText(aux.get((String)comboBoxAttNodo.getSelectedItem()));
				}
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
		
		comboBoxAttEdge = new JComboBox();
		comboBoxAttEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Edge e = searchEdge((String)comboBoxEdgeOrg.getSelectedItem());
				if(e!=null){
					HashMap<String, String> aux = e.getAttributes();
					textDescEdge.setText(aux.get((String)comboBoxAttEdge.getSelectedItem()));
				}
				
			}
		});
		comboBoxAttEdge.setBounds(231, 162, 121, 20);
		contentPane.add(comboBoxAttEdge);		
		
		comboBoxEdgeOrg = new JComboBox();
		comboBoxEdgeOrg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Edge e = searchEdge((String)comboBoxEdgeOrg.getSelectedItem());
				if(e!=null){
					HashMap<String, String> aux = e.getAttributes();
					Set<String> keys = aux.keySet();
					comboBoxAttEdge.removeAllItems();
					for(String s:keys)
						comboBoxAttEdge.addItem(s);
					textDescEdge.setText(aux.get((String)comboBoxAttEdge.getSelectedItem()));
				}
			}
		});
		comboBoxEdgeOrg.setBounds(65, 162, 121, 20);
		contentPane.add(comboBoxEdgeOrg);
		
		
		JLabel lblAtributo_1 = new JLabel("Atributo");
		lblAtributo_1.setBounds(231, 136, 46, 14);
		contentPane.add(lblAtributo_1);
		
		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setBounds(397, 136, 46, 14);
		contentPane.add(lblValor_1);
		
		JButton btnNuevoNodo = new JButton("Nuevo Nodo");
		btnNuevoNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node n = new Node(JOptionPane.showInputDialog("Enter output name: "));
				g.addNode(n, true);
				initCombos();
			}
		});
		btnNuevoNodo.setBounds(65, 281, 121, 23);
		contentPane.add(btnNuevoNodo);
		
		JButton btnNewEdge = new JButton("Nuevo Arco");
		btnNewEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node a = searchNode(JOptionPane.showInputDialog("Enter source name: "));
				Node b = searchNode(JOptionPane.showInputDialog("Enter target name: "));
				g.addEdge(a, b);
				initCombos();
			}
		});
		btnNewEdge.setBounds(231, 281, 121, 23);
		contentPane.add(btnNewEdge);
		
		JButton btnNuevoAtributoNodo = new JButton("Nuevo Atributo");
		btnNuevoAtributoNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node n = searchNode((String)comboBoxNodo.getSelectedItem());
				if(n!=null){
					n.setAttribute(JOptionPane.showInputDialog("Enter atttribute name: "), JOptionPane.showInputDialog("Enter attribute description: "));
				}
				initCombos();
			}
		});
		btnNuevoAtributoNodo.setBounds(231, 102, 121, 23);
		contentPane.add(btnNuevoAtributoNodo);
		
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
		
		textDescEdge = new JTextField();
		textDescEdge.setBounds(397, 162, 121, 20);
		contentPane.add(textDescEdge);
		textDescEdge.setColumns(10);
		
		textNode = new JTextField();
		textNode.setBounds(65, 76, 121, 20);
		contentPane.add(textNode);
		textNode.setColumns(10);
		
		textAttNode = new JTextField();
		textAttNode.setBounds(231, 76, 121, 20);
		contentPane.add(textAttNode);
		textAttNode.setColumns(10);
		
		textAttEdge = new JTextField();
		textAttEdge.setBounds(231, 193, 121, 20);
		contentPane.add(textAttEdge);
		textAttEdge.setColumns(10);
		
		JButton btnNuevoAtributo_1 = new JButton("Nuevo Atributo");
		btnNuevoAtributo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Edge e = searchEdge((String)comboBoxEdgeOrg.getSelectedItem());
				if(e!=null){
					e.addAttribute(JOptionPane.showInputDialog("Enter atttribute name: "), JOptionPane.showInputDialog("Enter attribute description: "));
				}
				initCombos();
			}
		});
		btnNuevoAtributo_1.setBounds(397, 193, 121, 23);
		contentPane.add(btnNuevoAtributo_1);
		
		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node n = searchNode((String)comboBoxNodo.getSelectedItem());
				if(n!=null){
					if(!textNode.getText().isEmpty()){
						g.changeNodeLabel((String)comboBoxNodo.getSelectedItem(), textNode.getText());
						textNode.setText("");
					}
					if(!textAttNode.getText().isEmpty())
						n.changeKey((String)comboBoxAttNodo.getSelectedItem(), textAttNode.getText());
					if(!textFieldAttNodo.getText().isEmpty()){
						if(textAttNode.getText().isEmpty())
							n.changeAtt((String)comboBoxAttNodo.getSelectedItem(), textFieldAttNodo.getText());
						else {
							n.changeAtt(textAttNode.getText(), textFieldAttNodo.getText());
							textAttNode.setText("");
						}
					}
				}
				Edge e = searchEdge((String)comboBoxEdgeOrg.getSelectedItem());
				if(e!=null){
					if(!textAttEdge.getText().isEmpty())
						e.changeAttribute((String)comboBoxAttEdge.getSelectedItem(), textAttEdge.getText());
					if(!textDescEdge.getText().isEmpty())
						if(!textAttEdge.getText().isEmpty()){
							e.changeDescription(textAttEdge.getText(), textDescEdge.getText());
							textAttEdge.setText("");
						}
						else e.changeDescription((String)comboBoxAttEdge.getSelectedItem(), textDescEdge.getText());
				}
				initCombos();
			}
		});
		btnGuardar.setBounds(397, 281, 121, 57);
		contentPane.add(btnGuardar);
		
		JButton btnEliminarAtributoNodo = new JButton("Eliminar Atributo");
		btnEliminarAtributoNodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Node n = searchNode((String)comboBoxNodo.getSelectedItem());
				if(n!=null){
					n.removeAttribute((String)comboBoxAttNodo.getSelectedItem());
				}
				initCombos();
			}
		});
		btnEliminarAtributoNodo.setBounds(397, 102, 121, 23);
		contentPane.add(btnEliminarAtributoNodo);
		
		JButton btnNewButton_2 = new JButton("Eliminar Nodo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.removeNode((String)comboBoxNodo.getSelectedItem());
				initCombos();
			}
		});
		btnNewButton_2.setBounds(65, 315, 121, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnRemoveEdge = new JButton("Eliminar Arco");
		btnRemoveEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.removeEdge(searchEdge((String)comboBoxEdgeOrg.getSelectedItem()));
				initCombos();
			}
		});
		btnRemoveEdge.setBounds(231, 315, 121, 23);
		contentPane.add(btnRemoveEdge);
		
		JButton btnNewButton = new JButton("Eliminar Atributo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Edge e = searchEdge((String)comboBoxEdgeOrg.getSelectedItem());
				if(e!=null){
					e.removeAttribute((String)comboBoxAttEdge.getSelectedItem());
				}
				initCombos();
			}
		});
		btnNewButton.setBounds(397, 227, 121, 23);
		contentPane.add(btnNewButton);
		
		this.initCombos();
	}
	
	private Node searchNode(String s){
		for(Node n:g.getNodes())
			if(n.getLabel().equals(s))
				return n;
		return null;
	}
	
	private Edge searchEdge(String org){
		Edge out = null;
		for(Edge e:g.getEdges()){
			if(org !=null && e.getOne()!=null && e.getTwo()!=null && org.equals(e.getOne().getLabel()+"->"+e.getTwo().getLabel()))
				out = e;
		}
		return out;
	}
	
	public void initCombos(){
		comboBoxNodo.removeAllItems();
		comboBoxAttNodo.removeAllItems();
		for(Node n:g.getNodes())
			comboBoxNodo.addItem(n.getLabel());
		
		comboBoxEdgeOrg.removeAllItems();
		comboBoxAttEdge.removeAllItems();
		for(Edge e:g.getEdges()){
			comboBoxEdgeOrg.addItem(e.getOne().getLabel()+"->"+e.getTwo().getLabel());
		}
			
	}
}
