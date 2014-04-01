package classes;
import java.util.HashMap;

import javacc.Yaka;
import exceptions.DejaDeclareeException;

/**
* Gestion des declarations de variables et constantes (appels vers Ident, etc.)
* @author paulriviere
*
*/
public class Declaration {
	private String nom;
	private String nomFonc;
	private Boolean isInteger;
	private IdFonc fonction;

	/**
	 * Methode pour sauvegarder le nom d'une constante
	 * @param nom le nom de la constante ou de la fonction
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
			if(Yaka.tabIdent.existeIdentLocal(this.nom)) {
				throw new DejaDeclareeException(this.nom + " : constante deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdConst constante = new IdConst(Type.ENTIER, val);
			Yaka.tabIdent.rangeIdentLocal(this.nom, constante);
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
			if(Yaka.tabIdent.existeIdentLocal(this.nom)) {
				throw new DejaDeclareeException(this.nom + " : constante deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdConst constante = new IdConst(Type.BOOLEEN, val);
			Yaka.tabIdent.rangeIdentLocal(this.nom, constante);
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
			if(Yaka.tabIdent.existeIdentLocal(this.nom)) {
				throw new DejaDeclareeException(this.nom + " : constante deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdConst constante = (IdConst) Yaka.tabIdent.chercheIdentLocal(nomSource);
			Yaka.tabIdent.rangeIdentLocal(this.nom, constante);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Methode pour enregistrer le type de la variable ou le type d'un param�tre ou le type de retour de la fonction declaree
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
			if(Yaka.tabIdent.existeIdentLocal(nom)) {
				throw new DejaDeclareeException(nom + " : variable deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdVar variable;
			IdVar.setOffset(IdVar.getOffset() - 2);
			if(isInteger) {
				variable = new IdVar(Type.ENTIER, IdVar.getOffset());			
			}
			else {
				variable = new IdVar(Type.BOOLEEN, IdVar.getOffset());
			}
			Yaka.tabIdent.rangeIdentLocal(nom, variable);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Methode pour sauvegarder le nom d'une d'une fonction
	 * @param nom le nom de la constante ou de la fonction
	 */
	public void setNomFonc(String nom) {
		nomFonc = nom;
		if(isInteger) 
			fonction = new IdFonc(Type.ENTIER);
		else 
			fonction = new IdFonc(Type.BOOLEEN);
	}
	
	/**
	 * Methode pour ajouter un type d'un param�tre de la fonction
	 * @param type le type du param�tre
	 */
	public void addTypeParam(Type type) {
		this.fonction.addArg(type);
	}
	
	/**
	 * Methode pour enregistrer un param�tre tabIdent
	 * @param nom nom du param�tre declaree
	 */
	public void declParam(String nom) {
		try {
			if(Yaka.tabIdent.existeIdentLocal(nom)) {
				throw new DejaDeclareeException(nom + " : param�tre deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			IdParam idParam;
			if(isInteger) {
				idParam = new IdParam(Type.ENTIER, 0);
				addTypeParam(Type.ENTIER);
			}
			else {
				idParam = new IdParam(Type.BOOLEEN, 0);
				addTypeParam(Type.BOOLEEN);
			}
			Yaka.tabIdent.rangeIdentLocal(nom, idParam);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Methode pour calculer l'offset des param�tres
	 * @param nom nom du param�tre declaree
	 */
	public void calculOffset(String nom) {
		HashMap<String,Ident> locaux = Yaka.tabIdent.getLocaux();
	}
	
	/**
	 * Methode pour enregistrer une fonction dans tabIdent
	 * 
	 */
	public void declFonc() {
		try {
			if(Yaka.tabIdent.existeIdentGlobal(nomFonc)) {
				throw new DejaDeclareeException(nomFonc + " : fonction deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			Yaka.tabIdent.rangeIdentGlobal(nomFonc, fonction);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
}