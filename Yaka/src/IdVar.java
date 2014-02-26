
/**
 * Classe IdVar : specialisation de la classe Ident pour les variables
 * @author paulriviere
 * 
 *
 */
public class IdVar extends Ident{

	private int offset;
	

	/**
	 * Constructeur de la classe 
	 * @param nom
	 * @param type
	 * @param offset
	 */
	public IdVar(String nom, Enum.Type type, int offset) {
		super(nom, type);
		this.offset = offset;
	}
	
	
	

	
}