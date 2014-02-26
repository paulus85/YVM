/**
 * Classe des idents
 * @author paulriviere
 *
 */
public class Ident {

	private String nom;

	private Enum.Type type;

	/**
	 * Constructeur
	 * @param nom
	 * @param type
	 */
	public Ident (String nom,Enum.Type type) {
		this.nom=nom;
		this.type=type;
	}
}