package ui;

import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;


import core.Edge;
import core.Graph;
import core.Node;

import java.util.ArrayList;

import java.util.HashMap;


import javax.swing.JScrollPane;


public class GraphDrawer {

    
    private javax.swing.JScrollPane graphPanel;

    
    private mxGraph graph;
    private mxGraphComponent graphComponent;
    private mxGraphLayout layout;
    
    
    public GraphDrawer(JScrollPane graphPanel){
        this.graphPanel = graphPanel;        
    }
    
   

    public void drawGraph(Graph  g){
        buildGraph(g);
        this.graphComponent = new mxGraphComponent(graph);
        this.graphComponent.setEnabled(false);
        this.graphPanel.setViewportView(this.graphComponent);
        layoutGraph();
    }
    
    
    public void buildGraph(Graph g){
    	
    	this.graph = new mxGraph();
        
    	if (g==null)return;
        
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try
        { 
        	
        	ArrayList<Edge> edges = new ArrayList(g.getEdges());
        	ArrayList<Node> nodes = new ArrayList(g.getNodes());
        	
        	HashMap n = new HashMap();
        	
        	for(int i=0; i<nodes.size();i++){
        		System.out.println("NODE: " + nodes.get(i).getLabel());
        		n.put(nodes.get(i).getLabel(),graph.insertVertex(parent, null, nodes.get(i).getLabel(), 20, 20, 80, 30));
        	}
        	
        	for(int i=0; i<edges.size(); i++){
        		System.out.println("EDGE: " + edges.get(i).getOne().getLabel() +" -> " + edges.get(i).getTwo().getLabel());
        		graph.insertEdge(parent, null, "",n.get(edges.get(i).getOne().getLabel()),n.get(edges.get(i).getTwo().getLabel()));
        	} 
        	     
          
           
        }
        finally
        {
            graph.getModel().endUpdate();
        }     
    
    }
    
    private void layoutGraph() {
		this.layout = new mxHierarchicalLayout(graph);
		Object cell = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try {
			layout.execute(cell);
		} finally {
			graph.getModel().endUpdate();
		}
	}
    
    public void clear(){
    	this.drawGraph(null);
    }
    

}
