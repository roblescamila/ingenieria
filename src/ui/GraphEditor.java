/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;



import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import core.Graph;
import core.GraphManagement;

public class GraphEditor extends javax.swing.JFrame {
	private ProyectTree projects;
    private GraphManagement gm;
    private Wizard w;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7412994067181639826L;
	public GraphEditor() {
        initComponents();
        init();
    }

    private void init(){ 
        
        //Getting all projects in database.
    	projects = ProyectTree.getInstance();
    	this.gm = projects.getManagement();
        this.scrollProyectsPanel.setViewportView(projects.getProyectTreeComponent());
        GraphDrawer graphDrawer = new GraphDrawer(this.graphPanel);
        projects.setDrawer(graphDrawer);
      
    }
   
    private void newGraph(){
        //Not implemented method.
        System.out.println("New Graph..");     
        Graph aux = gm.createGraph(JOptionPane.showInputDialog("Enter name: "));
        projects.addGraph(aux);
    }
    
    private void importGraph(){
        //Not implemented method.
    	String out = "";
    	JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("."));
		fc.showSaveDialog(this); 
		File f = new File(fc.getSelectedFile().getAbsolutePath());
        try {
            byte[] bytes = Files.readAllBytes(f.toPath());
             out = new String(bytes,"UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        Graph aux = null;
        if(!out.isEmpty())
        	aux = this.gm.importJSON(out);
        this.detailsLabel.setText("Import Graph..");
        projects.addGraph(aux);
    }
    
    private void exportPDF(){
        System.out.println("Export PDF..");
        
        Graph g = projects.getCurrent();
        
        String dotFormat = ExportGraph.toDotFormat(g);
        ExportGraph.createDotGraph(dotFormat, "New_Graph");
    	
        this.detailsLabel.setText("Exported to PDF..");
        
    }
    
    private void exportJSON(){
        //Not implemented method.
    	PrintWriter writer = null;
		try {
			writer = new PrintWriter(JOptionPane.showInputDialog("Enter output name: ")+".json", "UTF-8");
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	writer.println(this.projects.getCurrent().toJSON());
    	writer.close();
         
        this.detailsLabel.setText("Exported to JSON..");
    }
    
    private void closeWindow(){
        //Not implemented method.
        //Ask if want save;
        System.out.println("Close window");
        this.detailsLabel.setText("Save? and Close..");
    }
    
    private void removeGraph(){
        //Not implemented method.
    	gm.removeGraph(projects.getCurrent());
        System.out.println("Remove graph");
    }
    
    private void showAbout(){
        //Not implemented method.
        System.out.println("Show about");
    }
    
    private void editGraph(){
        w = new Wizard(projects.getCurrent(), this);
        w.setVisible(true);
        System.out.println("Edit Graph");
    }
    
    public void closeEdit(){
        w.setVisible(false);
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        graphPanel = new javax.swing.JScrollPane();
        scrollProyectsPanel = new javax.swing.JScrollPane();
        detailsLabel = new javax.swing.JLabel();
        editGraphButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNewItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuImportItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuPDFItem = new javax.swing.JMenuItem();
        menuGAXPPItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuExitItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAboutItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        jPanel2.getAccessibleContext().setAccessibleName("editPanel");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editGraphButton.setText("Edit Graph");
        editGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGraphButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editGraphButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollProyectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(graphPanel)))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProyectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(graphPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editGraphButton)
                        .addComponent(removeButton))))
        );

        graphPanel.getAccessibleContext().setAccessibleName("graphPanel");

        jMenu1.setText("File");

        menuNewItem.setText("New");
        menuNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewItemActionPerformed(evt);
            }
        });
        jMenu1.add(menuNewItem);
        jMenu1.add(jSeparator1);

        menuImportItem.setText("Import");
        menuImportItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuImportItemActionPerformed(evt);
            }
        });
        jMenu1.add(menuImportItem);

        jMenu3.setText("Export as");

        menuPDFItem.setText("PDF");
        menuPDFItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPDFItemActionPerformed(evt);
            }
        });
        jMenu3.add(menuPDFItem);

        menuGAXPPItem.setText("json");
        menuGAXPPItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGAXPPItemActionPerformed(evt);
            }
        });
        jMenu3.add(menuGAXPPItem);

        jMenu1.add(jMenu3);
        jMenu1.add(jSeparator2);

        menuExitItem.setText("Exit");
        menuExitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitItemActionPerformed(evt);
            }
        });
        jMenu1.add(menuExitItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        menuAboutItem.setText("About");
        menuAboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutItemActionPerformed(evt);
            }
        });
        jMenu2.add(menuAboutItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("contentPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewItemActionPerformed
        this.newGraph();
    }//GEN-LAST:event_menuNewItemActionPerformed

    private void menuImportItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuImportItemActionPerformed
        this.importGraph();
    }//GEN-LAST:event_menuImportItemActionPerformed

    private void menuPDFItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPDFItemActionPerformed
        this.exportPDF();
    }//GEN-LAST:event_menuPDFItemActionPerformed

    private void menuGAXPPItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGAXPPItemActionPerformed
        this.exportJSON();
    }//GEN-LAST:event_menuGAXPPItemActionPerformed

    private void menuExitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitItemActionPerformed
        this.closeWindow();
    }//GEN-LAST:event_menuExitItemActionPerformed

    private void menuAboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutItemActionPerformed
        this.showAbout();
    }//GEN-LAST:event_menuAboutItemActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        this.removeGraph();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void editGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGraphButtonActionPerformed
      this.editGraph();
    }//GEN-LAST:event_editGraphButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JButton editGraphButton;
    private javax.swing.JScrollPane graphPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem menuAboutItem;
    private javax.swing.JMenuItem menuExitItem;
    private javax.swing.JMenuItem menuGAXPPItem;
    private javax.swing.JMenuItem menuImportItem;
    private javax.swing.JMenuItem menuNewItem;
    private javax.swing.JMenuItem menuPDFItem;
    private javax.swing.JButton removeButton;
    private javax.swing.JScrollPane scrollProyectsPanel;
    // End of variables declaration//GEN-END:variables

}
