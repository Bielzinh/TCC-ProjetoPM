package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.MaterialbelicoDAO;
import modelo.dominio.Materialbelico;

@FacesConverter(value="mat-converter", forClass=Materialbelico.class)
public class MaterialbelicoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Materialbelico mat = null;
		Integer codigo;
		
		try {
			codigo = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			codigo = null;
		}
		
		MaterialbelicoDAO dao = new MaterialbelicoDAO();
		if (codigo != null)
			mat = dao.lerPorId(codigo);
		
		return mat;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value instanceof Materialbelico)
		{
			Materialbelico mat = (Materialbelico) value;
			return mat.getId().toString();
		}
		
		return null;
	}

}
