package heig.actions;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

import heig.metier.Electeur;
import heig.metier.Election;

@SuppressWarnings("serial")
@Result(name="success", location="page.edit",type="tiles")
public class EditElecteurAction extends ActionSupport implements ServletContextAware, ServletRequestAware{
	private Electeur electeur;
	private HttpServletRequest request;
	private ServletContext servletContext;

	public String execute() {
		Election election = (Election) servletContext.getAttribute("election");
	    String electeurId = request.getParameter("electeurId");
		if (electeurId == null) {
			electeur = new Electeur();
		} else {    	
			//electeur = election.getElecteurs();
		}
		return SUCCESS;
	}
	
	

	public Electeur getElecteur() {
		return electeur;
	}



	public void setElecteur(Electeur electeur) {
		this.electeur = electeur;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
