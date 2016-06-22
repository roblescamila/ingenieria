package ui;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import javax.swing.JScrollPane;


public class GraphDrawer {

    
    private javax.swing.JScrollPane graphPanel;

    
    private mxGraph graph;
    private mxGraphComponent graphComponent;
    
    
    public GraphDrawer(JScrollPane graphPanel){
        this.graphPanel = graphPanel;
        drawGraph("s"); //NO SE POR QU� EL STRING
    }
    
   
    //Change type of parameter as Graph
    //This method performs mapping from "model graph" to "view graph".
    public void drawGraph(String graph){
        //Not implemented method.
        //Generate a mxGraphComponent from Graph.
        forDebug(graph);      
    }
    
    public void forDebug(String name){
        //Delete this.
        this.graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try
        { 
            //Discuss how set the x and y to each vertex.
            if (name == "Correlativas"){                
                Object v1 = graph.insertVertex(parent, null, "Diseño",
                    20, 20, 80,30);
                
                Object v2 = graph.insertVertex(parent, null, "Ingeniería",
                            220, 150, 80, 30);

                graph.insertEdge(parent, null, "", v1, v2);  
            }else{
                Object v1 = graph.insertVertex(parent, null, "OPD",
                    20, 20, 80,30);
                
                Object v2 = graph.insertVertex(parent, null, "OPF",
                            220, 150, 80, 30);

                graph.insertEdge(parent, null, "", v1, v2);          
            
            }
          
           
        }
        finally
        {
            graph.getModel().endUpdate();
        }
        
        this.graphComponent = new mxGraphComponent(graph);
        this.graphComponent.setEnabled(false);
        this.graphPanel.setViewportView(this.graphComponent);
    }
    
    
    
}
