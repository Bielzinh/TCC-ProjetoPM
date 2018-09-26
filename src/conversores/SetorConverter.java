package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.SetorDAO;
import modelo.dominio.Setor;

@FacesConverter(value="set-converter", forClass=Setor.class)
public class SetorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Setor set = null;
		Integer codigo;
		
		try {
			codigo = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			codigo = null;
		}
		
		SetorDAO dao = new SetorDAO();
		if (codigo != null)
			set = dao.lerPorId(codigo);
		
		return set;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value instanceof Setor)
		{
			Setor set = (Setor) value;
			return set.getId().toString();
		}
		
		return null;
	}

}
