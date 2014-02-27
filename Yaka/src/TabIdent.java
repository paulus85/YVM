import java.util.HashMap;

/**
 * Table des idents
 * @author paulriviere
 *
 */
public class TabIdent {

	private HashMap<String,Ident> table;
	private int offsetEnCours=0;

	/**
	 * Constructeur
	 * @param taille
	 */
	public TabIdent (int taille) {
		table = new HashMap<String,Ident> ();
	}

	/**
	 * donne l'ident associe a une clef
	 * @param clef
	 * @return l'ident associe a la clef
	 */
	public Ident chercheIdent(String clef) {
		return table.get(clef);

	}

	/**
	 * @param clef
	 * @return TRUE si l'ident existe dans la table, FALSE sinon
	 */
	public boolean existeIdent (String clef) {
		return table.containsKey(clef);
	}

	/**
	 * Ajout d'un nouvel ident dans la table
	 * @param clef
	 * @param id
	 */
	public void rangeIdent (String clef, Ident id) {
		table.put(clef,id);

	}

	/* Methodes de creation d'ident : gestion interne des valeurs et offset */
	/**
	 * Creation et ajout d'un ident dans une meme fonction
	 * @param nature
	 * @param clef
	 * @param type
	 * @param valeur
	 */
	public void creationIdent (Nature nature, String clef, Type type, int valeur) {
		if (nature == Nature.VARIABLE) {
			//Dans le cas ou on a une variable, gestion de l'offset
			offsetEnCours = offsetEnCours +2;
			IdVar var = new IdVar(type, offsetEnCours);
			rangeIdent(clef,var);
		} else if (nature == Nature.CONSTANTE) {
			IdConst cons = new IdConst (type, valeur) ;
			rangeIdent (clef,cons);
		}
		
	}
}
