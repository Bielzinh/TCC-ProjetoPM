package modelo.dominio;

 
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import modelo.dao.HistoricoDAO;
 
@ManagedBean(name= "markersView")
public class MarkersView implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapModel simpleModel;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
		HistoricoDAO dao = new HistoricoDAO();
		
		
	    String[] separated = dao.obterMarket().getLatLon().split(",");
	    String lat = separated[0];
	    String lon = separated[1];
	    
	    LatLng coord1 = new LatLng(Double.valueOf(lat),Double.valueOf(lon));
	      
	    simpleModel.addOverlay(new Marker(coord1, "Pacote Armamento FAKE"));
          
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}