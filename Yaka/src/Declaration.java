/**
* Gestion des declarations de variables et constantes (appels vers Ident, etc.)
* @author paulriviere
*
*/
public class Declaration {
	private String nom;
	private Boolean isInteger;	

	/**
	 * M�thode pour sauvegarder le nom d'une constante
	 * @param nom le nom de la constante
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * M�thode pour enregistrer une constante avec valeur enti�re dans tabIdent
	 * @param val valeur de la constante
	 */
	public void declConst(int val) {
		IdConst constante = new IdConst(Type.ENTIER, val);
		Yaka.tabIdent.rangeIdent(this.nom, constante);
	}

	/**
	 * M�thode pour enregistrer une constante avec valeur bool�enne dans tabIdent
	 * @param val valeur de la constante
	 */
	public void declConst(boolean val) {
		IdConst constante = new IdConst(Type.ENTIER, val);
		Yaka.tabIdent.rangeIdent(this.nom, constante);
	}

	/**
	 * M�thode pour enregistrer le type de(s) la(les) variable(s) d�clar�e(s) 
	 * @param b vrai si type entier, faux si type bool�en
	 */
	public void setIsInteger(boolean b) {
		isInteger = b;
	}

	/**
	 * M�thode pour enregistrer une variable tabIdent
	 * @param nom nom de la variable d�clar�e
	 */
	public void declVar(String nom) {
		IdVar variable;
		int offset = Yaka.tabIdent.offset;
		if(isInteger) {
			variable = new IdVar(Type.ENTIER, offset);
			
		}
		else {
			variable = new IdVar(Type.BOOLEEN, offset);
		}
		Yaka.tabIdent.rangeIdent(nom, variable);
		Yaka.tabIdent.offset += 2;
	}
}