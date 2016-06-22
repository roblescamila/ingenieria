package ui;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import core.Graph;
import core.GraphManagement;


/**
 * This class initializes all projects and
 * is responsible management of the current graph being edited. 
 */

public class ProyectTree{
    
    private static ProyectTree instance = null;
   
    private DefaultMutableTreeNode root;
    private JTree projectTree ;
    private final DefaultTreeModel model;
    private GraphDrawer drawer;
    private GraphManagement gm;
    //private Graph current;
    //This is the graph that will be modified and possibly removed.
    
    
    private ProyectTree(){
        this.init();
        System.out.println("Init...");
        this.model = (DefaultTreeModel)projectTree.getModel();
    }
    
    public GraphManagement getManagement(){
    	return this.gm;
    }
    
    public static ProyectTree getInstance(){
        if(instance==null){
            instance = new ProyectTree();
        }
        return instance;
    }
    
    public JTree getProyectTreeComponent(){
        return this.projectTree;
    }
    
    //Initialize database and generate tree.
    private void init(){
        //Not implemented correctly.     
        this.gm = new GraphManagement(); 
        gm.loadGraphs();
        this.initProyects(); //Delete this.
        projectTree = new JTree(root);
       
        //Listener for when a item of project tree was clicked.
        projectTree.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                       projectTree.getLastSelectedPathComponent();
                if (node == null) return;
                Object nodeInfo = node.getUserObject();
                if (nodeInfo.toString() == "Proyects") return;
                    loadProject(nodeInfo.toString());
               }
            }        
        });
    
        }
    
    public void setDrawer(GraphDrawer drawer){
        this.drawer = drawer;
    }
    
    //To create a new project, but only one preview no insert into database.
    public void newProject(String name){
        //Discuss about this method.
        
        /* add new node in tree.
        
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(name);        
        root.insert(newNode, 0);
        model.reload();
        */
    }
    
    //Delete current project (graph) to database and tree proyects. 
    public void deleteProject(){
        //Not implemented method.
        //GraphManagement.deleteGraph(current);        
        
    }
    
    //Save current project to database.
    public void saveProject(){
        //Not implemented method.
        //GraphManagement.inserGraph(current);        
    }
    
    //Search graph and pass to drawer.  
    private void loadProject(String name){
        //Not implemented method.
        //GraphManagement.getGraph(name);
        //Set current graph
        
        
        this.drawer.drawGraph(this.gm.getGraph(name));
    }
    
    public void addGraph(Graph g){
    	DefaultMutableTreeNode g2 = new DefaultMutableTreeNode(g.getName());
    	root.add(g2);
    	this.model.reload();
    }
    
    
    private void initProyects(){
        //Delete this..
        List<String> a = this.gm.getAllProyects();
        root = new DefaultMutableTreeNode("Proyects"); 
        for(String s:a){
        	DefaultMutableTreeNode g2 = new DefaultMutableTreeNode(s);
        	root.add(g2);
        }
        
    }

    
    
}
                
