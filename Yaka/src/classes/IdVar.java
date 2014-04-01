package classes;

/**
 * Classe IdVar : specialisation de la classe Ident pour les variables
 * @author paulriviere
 * 
 *
 */
public class IdVar extends Ident{

	private static int offset;
	

	/**
	 * @return the offset
	 */
	public static int getOffset() {
		return offset;
	}


	public static void setOffset(int offset) {
		offset = offset;
	}


	/**
	 * Constructeur de la classe 
	 * @param nom
	 * @param type
	 * @param offset
	 */
	public IdVar(Type type, int offset) {
		super(type);
		this.offset = offset;
	}
	
	
	

	
}