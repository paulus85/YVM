package classes;
/**
 * Classe des idents
 * @author paulriviere
 *
 */
public class Ident {

	private Type type;
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}


	/**
	 * Constructeur
	 * @param nom
	 * @param type
	 */
	public Ident (Type type) {
		this.type=type;
	}
}