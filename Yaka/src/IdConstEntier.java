/**
 * Classe des constantes
 * @author paulriviere
 *
 */
public class IdConstEntier extends Ident {
	private int val;
	
	/**
	 * Constructeur constante entière
	 * @param nom
	 * @param type
	 * @param value
	 */
	public IdConstEntier(Type type, int val) {
		super(type);
		this.val = val;
	}

	/**
	 * @return the value
	 */
	public int getVal() {
		return val;
	}
}
