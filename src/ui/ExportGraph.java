package ui;
import java.io.File;

public class ExportGraph {
	
	public ExportGraph(){}
	
	/***
	 * 
	 *  Para llamarlo desde el evento de export:
	 *  String dotFormat = "1->2;1->3;1->4;4->5;4->6;6->7;5->7;3->8;3->6;8->7;2->8;2->5;";
        createDotGraph(dotFormat, "DotGraph");
	 * @param dotFormat
	 * @param fileName
	 */
	
	public static void createDotGraph(String dotFormat, String fileName)
	{
	    GraphViz gv = new GraphViz();
	    gv.addln(gv.start_graph());
	    gv.add(dotFormat);
	    gv.addln(gv.end_graph());
	    // String type = "gif";
	    String type = "pdf";
	    // gv.increaseDpi();
	    gv.decreaseDpi();
	    gv.decreaseDpi();
	    File out = new File(fileName + "." + type); 
	    gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
	}

	public static String toDotFormat() {
		
		return null;
	}
}