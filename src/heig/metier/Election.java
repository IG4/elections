package heig.metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class Election  {
	  private DataSource ds;

	  public Election(DataSource ds) {
	    this.ds = ds;
	  }

  public List<Electeur> getElecteurs() throws PersistException {
	  ArrayList<Electeur> electeurs = new ArrayList<Electeur>();
	    try {

	        Connection con = ds.getConnection();
	        Statement s = con.createStatement();
	        ResultSet rs = s.executeQuery("SELECT * FROM produits");

	        while (rs.next()) {
	          int id =  rs.getInt("id");
	          String nom = rs.getString("nom");
	          String prenom = rs.getString("prenom");
	          Electeur electeur = new Electeur(id, nom, prenom);
	          electeurs.add(electeur);
	        }

	        rs.close();
	        s.close();
	        con.close();
	      } catch (SQLException ex) {
	        ex.printStackTrace();
	        throw new PersistException();
	      }
	  return electeurs;
  }

  public void saveElecteur(Electeur electeur) throws DuplicateCodeException,PersistException {
	   try {
		      Connection connection = ds.getConnection();
		      Statement stmt = connection.createStatement();
		      String requete = "insert into electeurs values("
		    	  + electeur.getId() +","
		    	  + "'" + electeur.getNom() + "',"
		    	  + "'" + electeur.getPrenom() + "')";
		      System.out.println(requete);
		      stmt.executeUpdate(requete);
		      connection.close();
	   } catch (MySQLIntegrityConstraintViolationException ex) {
		   throw new DuplicateCodeException(electeur.getNom());
	   } catch (SQLException ex) {
		      ex.printStackTrace();
		      throw new PersistException();
	   }
  }

}
