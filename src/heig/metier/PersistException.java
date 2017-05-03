package heig.metier;
@SuppressWarnings("serial")
public class PersistException extends Exception {
  public PersistException() {
    super("Pb d'accès à la base de donnée");
  }
}
