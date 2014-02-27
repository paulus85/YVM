/**
* Gestion des declarations de variables et constantes (appels vers Ident, etc.)
* @author paulriviere
*
*/
public class Declaration {
	private String nom;
	private Boolean isInteger;	

	/**
	 * Méthode pour sauvegarder le nom d'une constante
	 * @param nom le nom de la constante
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Méthode pour enregistrer une constante avec valeur entière dans tabIdent
	 * @param val valeur de la constante
	 */
	public void declConst(Integer val) {
		Yaka.tabIdent.creationIdent(Nature.CONSTANTE, this.nom, Type.ENTIER,val);
	}

	/**
	 * Méthode pour enregistrer une constante avec valeur booléenne dans tabIdent
	 * @param val valeur de la constante
	 */
	public void declConst(Boolean val) {
		Yaka.tabIdent.creationIdent(Nature.CONSTANTE, this.nom, Type.BOOLEEN,val);
	}

	/**
	 * Méthode pour enregistrer le type de(s) la(les) variable(s) déclarée(s) 
	 * @param b vrai si type entier, faux si type booléen
	 */
	public void setIsInteger(Boolean b) {
		isInteger = b;
	}

	/**
	 * Méthode pour enregistrer une variable tabIdent
	 * @param nom nom de la variable déclarée
	 */
	public void declVar(String nom) {
		if(isInteger) Yaka.tabIdent.creationIdent(Nature.VARIABLE, nom, Type.ENTIER,null);
		else Yaka.tabIdent.creationIdent(Nature.VARIABLE, nom, Type.BOOLEEN,null);
	}
}