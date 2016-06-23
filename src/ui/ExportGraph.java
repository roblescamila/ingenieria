package ui;

import java.io.File;
import java.util.Set;

import java.util.Iterator;
import core.Edge;
import core.Graph;

public class ExportGraph {
	
	public ExportGraph(){}
	
	public static void createDotGraph(String dotFormat, String fileName)
	{
	    GraphViz gv = new GraphViz();
	    gv.addln(gv.start_graph());
	    gv.add(dotFormat);
	    gv.addln(gv.end_graph());
	    String type = "pdf";
	    gv.decreaseDpi();
	    gv.decreaseDpi();
	    File out = new File(fileName + "." + type); 
	    gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
	}

	public static String toDotFormat(Graph graph) {
		String out = "";
		Set<Edge> edges = graph.getEdges();
		for (Iterator<Edge> it = edges.iterator(); it.hasNext(); ) {
			Edge e = it.next();
			String from = e.getOne().getLabel();
			String to = e.getTwo().getLabel();
			out = out + from + "->" + to + ";";			
		}
		System.out.println("OUT: " + out);
		return out;
	}
}