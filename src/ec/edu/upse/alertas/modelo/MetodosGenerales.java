package ec.edu.upse.alertas.modelo;

public class MetodosGenerales {

	public MetodosGenerales(){}
	
	public String ArrayJson(String json, String etiqueta){
		json = "{\"" + etiqueta + "\":" + json + "}";
		return json;
	}
}
