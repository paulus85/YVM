/**
 * Classe des constantes
 * @author paulriviere
 *
 */
public class IdConst extends Ident{

	private int value;

	

	/**
	 * Constructeur
	 * @param nom
	 * @param type
	 * @param value
	 */
	public IdConst(Type type, int value) {
		super(type);
		this.value = value;
	}
	
	
}