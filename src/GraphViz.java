public class GraphViz{	

	public GraphViz(String dotPath, String exportPath){
		draw(dotPath, exportPath);
	}
	
	public void draw(String dotPath, String exportPath){
		try
		{       
			ProcessBuilder pbuilder;
		    
			/*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
			 */
			pbuilder = new ProcessBuilder("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "-Tpng", "-o", exportPath, dotPath);
			pbuilder.redirectErrorStream(true);
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
	}
}