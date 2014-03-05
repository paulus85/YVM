/**
* Gestion des declarations de variables et constantes (appels vers Ident, etc.)
* @author paulriviere
*
*/
public class Declaration {
	private String nom;
	private Boolean isInteger;	

	/**
	 * Methode pour sauvegarder le nom d'une constante
	 * @param nom le nom de la constante
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Methode pour enregistrer une constante avec valeur entiere dans tabIdent
	 * @param val valeur de la constante
	 */
	public void declConst(int val) {
		IdConst constante = new IdConst(Type.ENTIER, val);
		Yaka.tabIdent.rangeIdent(this.nom, constante);
	}

	/**
	 * Methode pour enregistrer une constante avec valeur booleenne dans tabIdent
	 * @param val valeur de la constante
	 */
	public void declConst(boolean val) {
		IdConst constante = new IdConst(Type.BOOLEEN, val);
		Yaka.tabIdent.rangeIdent(this.nom, constante);
	}
	
	/**
	 * Methode pour affecter une constante a une autre
	 * @param nom nom de la constante source
	 */
	public void declConst(String nomSource) {
		IdConst constante = (IdConst) Yaka.tabIdent.chercheIdent(nomSource);
		Yaka.tabIdent.rangeIdent(this.nom, constante);
	}

	/**
	 * Methode pour enregistrer le type de(s) la(les) variable(s) declaree(s) 
	 * @param b vrai si type entier, faux si type booleen
	 */
	public void setIsInteger(boolean b) {
		isInteger = b;
	}

	/**
	 * Methode pour enregistrer une variable tabIdent
	 * @param nom nom de la variable declaree
	 */
	public void declVar(String nom) {
		IdVar variable;
		Yaka.tabIdent.offset -= 2;
		if(isInteger) {
			variable = new IdVar(Type.ENTIER, Yaka.tabIdent.offset);			
		}
		else {
			variable = new IdVar(Type.BOOLEEN, Yaka.tabIdent.offset);
		}
		Yaka.tabIdent.rangeIdent(nom, variable);
	}
}