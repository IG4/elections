package heig.metier;
@SuppressWarnings("serial")
public class PersistException extends Exception {
  public PersistException() {
    super("Pb d'acc�s � la base de donn�e");
  }
}
