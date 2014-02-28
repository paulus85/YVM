
/**
 * Classe IdVar : specialisation de la classe Ident pour les variables
 * @author paulriviere
 * 
 *
 */
public class IdVar extends Ident{

	private int offset;
	

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
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