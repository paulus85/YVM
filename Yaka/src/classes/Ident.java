package classes;
/**
 * Classe des idents
 * @author paulriviere
 *
 */
public class Ident {

	/**
	 * Type de la variable ou de la constante
	 * Pour les fonctions : correspond au type de retour
	 */
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