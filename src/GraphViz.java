public class GraphViz{	
	private String format;
	
	public GraphViz(String dotPath, String exportPath, String form){
		format = form;
		draw(dotPath, exportPath, format);
		
	}
	
	public void setFormat(String form){
		format = form;
	}
	
	public String getFormat(){
		return format;
	}
	
	public void draw(String dotPath, String exportPath, String format){
		try
		{       
			ProcessBuilder pbuilder;
		    
			/*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
			 */
			pbuilder = new ProcessBuilder("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "-T" + format, "-o", exportPath, dotPath);
			pbuilder.redirectErrorStream(true);
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
	}
}