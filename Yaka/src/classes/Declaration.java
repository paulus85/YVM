package classes;
import java.util.ArrayList;

import javacc.Yaka;
import exceptions.DejaDeclareeException;
import exceptions.NonDeclareeException;

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
	private int offset = 0;
	private ArrayList<String> listeParams = new ArrayList<String>();

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
			if(Yaka.tabIdent.existeIdentLocal(this.nom))
				throw new DejaDeclareeException(this.nom + " : constante deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
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
			if(Yaka.tabIdent.existeIdentLocal(this.nom)) 
				throw new DejaDeclareeException(this.nom + " : constante deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
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
			if(!Yaka.tabIdent.existeIdentLocal(nomSource)) 
				throw new NonDeclareeException(nomSource + " : non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			if(Yaka.tabIdent.existeIdentLocal(this.nom))
				throw new DejaDeclareeException(this.nom + " : constante deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			IdConst constante = (IdConst) Yaka.tabIdent.chercheIdentLocal(nomSource);
			Yaka.tabIdent.rangeIdentLocal(this.nom, constante);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
		catch(NonDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Methode pour enregistrer le type de la variable ou le type d'un paramètre ou le type de retour de la fonction declaree
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
			if(Yaka.tabIdent.existeIdentLocal(nom))
				throw new DejaDeclareeException(nom + " : variable deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			IdVar variable;
			offset -= 2;
			if(isInteger)
				variable = new IdVar(Type.ENTIER, offset);			
			else
				variable = new IdVar(Type.BOOLEEN, offset);
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
	 * Methode pour ajouter le type du paramètre à la fonction (globaux) et pour ajouter l'IdParam dans une liste temporaire
	 * @param nom nom du paramètre declaree
	 */
	public void declParam(String nom) {
		try {
			if(Yaka.tabIdent.existeIdentLocal(nom))
				throw new DejaDeclareeException(nom + " : paramètre deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			IdParam idParam;
			if(isInteger) {
				idParam = new IdParam(Type.ENTIER, 0);
				fonction.addArg(Type.ENTIER);
				listeParams.add(nom);
			}
			else {
				idParam = new IdParam(Type.BOOLEEN, 0);
				fonction.addArg(Type.BOOLEEN);
				listeParams.add(nom);
			}
			Yaka.tabIdent.rangeIdentLocal(nom, idParam);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Methode pour calculer l'offset des paramètres
	 * @param nom nom du paramètre declaree
	 */
	public void calculOffset() {
		int i;
		String nom;
		int taille = listeParams.size();
		for(i=0;i<taille;i++) {
			nom = listeParams.get(i);
			((IdParam) Yaka.tabIdent.chercheIdentLocal(nom)).setOffset(taille*2 + 4 - (i+1) * 2);
		}
	}
	
	/**
	 * Methode pour enregistrer une fonction dans tabIdent
	 * 
	 */
	public void declFonc() {
		try {
			calculOffset();
			if(Yaka.tabIdent.existeIdentGlobal(nomFonc)) 
				throw new DejaDeclareeException(nomFonc + " : fonction deja declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			Yaka.tabIdent.rangeIdentGlobal(nomFonc, fonction);
		}
		catch (DejaDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * @return l'offset
	 */
	public int getOffset() {
		return offset;
	}
	
	/**
	 * @return nombre de parametre(s)
	 */
	public int getNbParams() {
		return listeParams.size();
	}
	
	/**
	 * @return nom de la fonction
	 */
	public String getNomFonc() {
		return nomFonc;
	}
	
	/**
	 * remise à zéro de l'offset et de la liste des paramètres
	 */
	public void clear() {
		nomFonc = null;
		offset = 0;
		listeParams.clear();
	}
}