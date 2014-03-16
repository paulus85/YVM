/**
 * Classe des constantes
 * @author paulriviere
 *
 */
public class IdConst extends Ident{
	private int valInt;
	private boolean valBool;
	
	/**
	 * Constructeur constante entière
	 * @param nom
	 * @param type
	 * @param value
	 */
	public IdConst(Type type, int val) {
		super(type);
		this.valInt = val;
	}



	/**
	 * @return the value
	 */
	public int getValInt() {
		return valInt;
	}
	
	/**
	 * @return the value
	 */
	public boolean getValBool() {
		return valBool;
	}

	
	/**
	 * Constructeur constante booléenne
	 * @param nom
	 * @param type
	 * @param value
	 */
	public IdConst(Type type, boolean val) {
		super(type);
		this.valBool = val;
	}
}
