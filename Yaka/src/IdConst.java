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
	public IdConst(String nom, Enum.Type type, int value) {
		super(nom, type);
		this.value = value;
	}

	
	
}