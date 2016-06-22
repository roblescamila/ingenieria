package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JLabel;

public class wizard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wizard frame = new wizard();
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
	public wizard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelNode = new JPanel();
		contentPane.add(panelNode);
		JPanel panelEdge = new JPanel();
		contentPane.add(panelEdge);
		JPanel panelAttributes = new JPanel();
		contentPane.add(panelAttributes);
		
		JLabel label = new JLabel("");
		panelNode.add(label);
		
		JPanel panelButtonNode = new JPanel();
		panelNode.add(panelButtonNode);
		JButton btnAn = new JButton("A nodo");
		panelButtonNode.add(btnAn);
		
		JButton btnBn = new JButton("M nodo");
		panelButtonNode.add(btnBn);
		
		JButton btnMn = new JButton("B nodo");
		panelButtonNode.add(btnMn);
		
		JPanel panelButtonAttribute = new JPanel();
		panelAttributes.add(panelButtonAttribute);
		JButton btnAn3 = new JButton("A atributo");
		panelButtonAttribute.add(btnAn3);
		
		JButton btnBn3 = new JButton("M atributo");
		panelButtonAttribute.add(btnBn3);
		
		JButton btnMn3 = new JButton("B atributo");
		panelButtonAttribute.add(btnMn3);
		
		JPanel panelButtonEdge = new JPanel();
		panelEdge.add(panelButtonEdge);
		JButton btnAn2 = new JButton("A arco");
		btnAn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelButtonEdge.add(btnAn2);
		
		JButton btnBn2 = new JButton("M arco");
		panelButtonEdge.add(btnBn2);
		
		JButton btnMn2 = new JButton("B arco");
		panelButtonEdge.add(btnMn2);
	}
	
	

}
