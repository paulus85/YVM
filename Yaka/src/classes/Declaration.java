package classes;
import javacc.Yaka;
import exceptions.DejaDeclareeException;

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
		try {
			if(Yaka.tabIdent.existeIdent(this.nom)) {
				throw new DejaDeclareeException(this.nom + " : constante déjà déclarée ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdConst constante = new IdConst(Type.ENTIER, val);
			Yaka.tabIdent.rangeIdent(this.nom, constante);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Methode pour enregistrer une constante avec valeur booleenne dans tabIdent
	 * @param val valeur de la constante
	 */
	public void declConst(boolean val) {
		try {
			if(Yaka.tabIdent.existeIdent(this.nom)) {
				throw new DejaDeclareeException(this.nom + " : constante déjà déclarée ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdConst constante = new IdConst(Type.BOOLEEN, val);
			Yaka.tabIdent.rangeIdent(this.nom, constante);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Methode pour affecter une constante a une autre
	 * @param nom nom de la constante source
	 */
	public void declConst(String nomSource) {
		try {
			if(Yaka.tabIdent.existeIdent(this.nom)) {
				throw new DejaDeclareeException(this.nom + " : constante déjà déclarée ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdConst constante = (IdConst) Yaka.tabIdent.chercheIdent(nomSource);
			Yaka.tabIdent.rangeIdent(this.nom, constante);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
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
		try {
			if(Yaka.tabIdent.existeIdent(nom)) {
				throw new DejaDeclareeException(nom + " : variable déjà déclarée ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
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
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
}