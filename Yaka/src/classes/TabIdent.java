package classes;
import java.util.HashMap;

/**
 * Table des idents
 * @author paulriviere
 *
 */
public class TabIdent {

	private HashMap<String,Ident> locaux;
	private HashMap<String,IdFonc> globaux;
	
	
	/**
	 * Constructeur
	 * 
	 */
	public TabIdent () {
		locaux = new HashMap<String,Ident> ();
		globaux = new HashMap<String,IdFonc> ();
	}

	/**
	 * donne l'ident associe a une clef dans la HashMap GLOBAUX
	 * @param clef
	 * @return l'ident associe a la clef
	 */
	public Ident chercheIdentGlobal(String clef) {
		return globaux.get(clef);
	}
	
	/**
	 * donne l'ident associe a une clef dans la HashMap LOCAUX
	 * @param clef
	 * @return l'ident associe a la clef
	 */
	public Ident chercheIdentLocal(String clef) {
		return locaux.get(clef);
	}

	/**
	 * @param clef
	 * @return TRUE si l'ident existe dans la table, FALSE sinon
	 */
	public boolean existeIdentGlobal (String clef) {
		return globaux.containsKey(clef);
	}
	
	/**
	 * @param clef
	 * @return TRUE si l'ident existe dans la table, FALSE sinon
	 */
	public boolean existeIdentLocal (String clef) {
		return locaux.containsKey(clef);
	}

	/**
	 * Ajout d'un nouvel ident dans la table
	 * @param clef
	 * @param id
	 */
	public void rangeIdentLocal (String clef, Ident id) {
		locaux.put(clef,id);

	}
	
	/**
	 * Ajout d'un nouvel ident dans la table
	 * @param clef
	 * @param id
	 */
	public void rangeIdentGlobal (String clef, IdFonc id) {
		globaux.put(clef,id);

	}

	
}
