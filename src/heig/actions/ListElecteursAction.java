package heig.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

import heig.metier.Electeur;
import heig.metier.Election;
import heig.metier.PersistException;


@SuppressWarnings("serial")
@Result(name="success", location="page.list",type="tiles")
public class ListElecteursAction extends ActionSupport implements ServletContextAware{
	
	private List<Electeur> electeurs;
	private ServletContext servletContext;
	
	

	public List<Electeur> getElecteurs() {
		return electeurs;
	}

	public void setElecteurs(List<Electeur> electeurs) {
		this.electeurs = electeurs;
	}

	public String execute() {
		Election election = (Election) servletContext.getAttribute("election");
	    try {
	      electeurs = election.getElecteurs();
	    } catch (PersistException e) {
	      e.printStackTrace();
	    }
		return SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}