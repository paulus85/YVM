package classes;
/**
 * Classe des idents
 * @author paulriviere
 *
 */
public class Ident {


	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	private Type type;

	/**
	 * Constructeur
	 * @param nom
	 * @param type
	 */
	public Ident (Type type) {
		this.type=type;
	}
}