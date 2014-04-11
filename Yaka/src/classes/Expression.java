package classes;

import java.util.Stack;
import java.util.EmptyStackException;

import javacc.Yaka;
import javacc.YakaConstants;
import exceptions.*;
/**
 * Gestion du traitement des expressions
 * @author paulriviere
 *
 */


public class Expression {
	private Stack<Type> pile_type;
	private Stack<String> pile_op;
	private Stack<Integer> pile_NiveauTANTQUE;
	private Stack<Integer> pile_NiveauSI;
	private Stack<String> pile_fonction;
	private Stack<Integer> pile_nbParams;
	private Ident variableAffectation = null;
	private int numEtiqTantque = 0;
	private int numEtiqSi = 0;
	private boolean sinon = false;
	private boolean isOpNegBool;
	
	public Expression() {
		pile_type = new Stack<Type>();
		pile_op = new Stack<String>();
		pile_NiveauTANTQUE = new Stack<Integer>();
		pile_NiveauSI = new Stack<Integer>();
		pile_fonction = new Stack<String>();
		pile_nbParams = new Stack<Integer>();
	}
	
	/**
	 * Verifie que l'identifiant a deja ete declare et le stock en tant que variable d'affectation
	 * @param nom de l'identifiant
	 */
	public void stockIdent(String s) {
		try {
			// Erreur si l'identifiant n'existe pas
			if(!Yaka.tabIdent.existeIdentLocal(s))
				throw new NonDeclareeException(s + " : variable non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			
			// Stocke l'ident
			variableAffectation = Yaka.tabIdent.chercheIdentLocal(s);
			
			// Erreur si l'ident est une constante
			if(!(variableAffectation instanceof IdVar))
				throw new ModifConstanteException(s + " : Impossible de modifier une constante ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
		}
		catch(NonDeclareeException e) {
			System.out.println(e.getMessage());
		}
		catch(ModifConstanteException e2) {
			variableAffectation = null;
			System.out.println(e2.getMessage());
		}
	}
	
	/**
	 * Appelle l'instruction istore avec l'ident d'affectation actuel si il existe
	 */
	public void affect(){
		// Si un identifiant variable d'affectation a ete designe,
		if(variableAffectation != null) {
			// Appelle l'instruction istore
			Yaka.yvm.istore(((IdVar) variableAffectation).getOffset());
		
			// On depile le type de la variable affectation verifiee
			//pile_type.pop();
			if(variableAffectation.getType() != pile_type.peek() && pile_type.peek() != Type.ERREUR)
				System.out.println("Erreur de type sur l'affectation : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
		}
	}
	
	/**
	 * Ajoute le type entier dans la pile de types et appelle l'instruction iconst
	 * @param valeur de l'entier
	 */
	public void addEntier(int entier) {
		// Ajoute le type entier a la pile de types
		pile_type.add(Type.ENTIER);
		// Appelle l'instruction iconst
		Yaka.yvm.iconst(entier);
	}
	
	/**
	 * Si l'ident est present dans la table des idents locaux, ajoute le type de l'ident dans la pile de type et appelle l'instruction iconst
	 * Si il est present dans la table des idents globaux, on ajoute le type de retour de la fonction dans la pile de type pile_type et 
	 * enregistre le nom de la fonction dans pile_Fonc et initialise la pile_Param pour compter les parametres 
	 * @param nom de l'identifiant
	 */
	public void addIdent(String s) {
		try { 
			// Si l'ident existe dans la table des idents locaux,
			if(Yaka.tabIdent.existeIdentLocal(s)) {
				Ident ident = Yaka.tabIdent.chercheIdentLocal(s);
				// on ajoute son type a la pile des types
				pile_type.add(ident.getType());
				// Si il s'est une variable, on appelle l'instruction iload avec son offset
				if(ident instanceof IdVar)
					Yaka.yvm.iload(((IdVar) ident).getOffset());
				// Sinon (constante), on appelle l'instruction iconst avec la bonne valeur (selon entier ou booleen)
				else {
					if(ident.getType() == Type.ENTIER)
						Yaka.yvm.iconst(((IdConst) ident).getValInt());
					else
						Yaka.yvm.iconst(((IdConst) ident).getValBool());
				}
			}
			// Sinon, si l'ident existe dans la table des idents globaux (fonction)
			else if(Yaka.tabIdent.existeIdentGlobal(s)) {
				//on ajoute le type de retour de la fonction
				pile_type.add(Yaka.tabIdent.chercheIdentGlobal(s).getType());
				
				// on ajout son nom dans la pile des fonctions
				pile_fonction.add(s);
				// on initialise le compteur de parametres
				pile_nbParams.add(0);
			}
			// Si il n'existe dans aucune table, c'est une erreur
			else {
				// on ajoute le type erreur dans la pile des types pour pouvoir continuer les verifications
				pile_type.add(Type.ERREUR);
				// on genere un message d'erreur
				throw new NonDeclareeException(s + " : non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
		}
		catch(NonDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Ajoute le type booleen dans la pile de types et appelle l'instruction iconst
	 * @param valeur du booleen
	 */
	public void addEtat(boolean b) {
		// Ajoute le type booleen a la pile de types
		pile_type.add(Type.BOOLEEN);
		// Appelle l'instruction iconst
		Yaka.yvm.iconst(b);
	}
	
	/**
	 * Ajoute l'operateur dans la pile d'operateurs
	 * @param nom de l'operateur
	 */
	public void addOperateur(String s) {
		pile_op.add(s);
	}
	
	/**
	 * Appelle l'instruction ineg ou inot en fonction du type de l'expression correspondante
	 */
	public void neg() {
		Type type = Type.ERREUR;
		try{
			// On recupere le type de l'expression correspondant au neg
			type = pile_type.peek();
		} catch(EmptyStackException e) {} // (n'est pas cense arriver d'apres la grammaire)
		switch(type) {
			case ENTIER : 
				if(isOpNegBool)
					System.out.println("Erreur : operateur NON pour entier ligne :" + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
				// ineg pour les entiers
				Yaka.yvm.ineg();
				break;
			case BOOLEEN :
				if(!isOpNegBool)
					System.out.println("Erreur : operateur - pour booleen ligne :" + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
				// inot pour les booleens
				Yaka.yvm.inot();
				break;
			default:
				/// (il y a eu une erreur avant)
				break;
		}
	}	
	
	/**
	 * Verifie que la fonction a assez de parametres et appelle l'instruction call
	 */
	public void ecrireFonc() {
		try {
			// Recupere le nom de la fonction depuis la pile des fonctions
			String nomFonc = pile_fonction.pop();
			// Recupere le nom de parametres comptes pour la fonction
			int nbParams = pile_nbParams.pop();
			// Genere une erreur si le nombre de parametre n'est pas celui prevu pour la fonction
			if(nbParams < ((IdFonc) Yaka.tabIdent.chercheIdentGlobal(nomFonc)).nbArg()) {
				throw new TooFewArgumentsException("Pas assez de paramètres fonction " + nomFonc + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			// Appelle l'instruction call
			Yaka.yvm.call(nomFonc);
		}
		catch(TooFewArgumentsException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	/**
	 * Verifie que le parametre donnee pour l'etiquette (si ou tantque) est bien un booleen et appelle l'instruction avec la bonne etiquette
	 */
	public void verifBool(int etiquette){
		try{
			switch(etiquette){
				// Si l'etiquette est TANTQUE :
				case YakaConstants.TANTQUE :
					// Recupere le type du parametre
					Type type1 = pile_type.pop();
					// Si ce n'est ni un booleen, ni une erreur (due a une erreur precedente), on genere un message d'erreur
					if(type1 != Type.BOOLEEN && type1 != Type.ERREUR)
						throw new ExprNonBoolException("Booleen attendu ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					// Appelle l'instruction iffaux avec la bonne etiquette
					Yaka.yvm.iffaux("FAIT"+numEtiqTantque);break;
				
				// Si l'etiquette est SI :
				case YakaConstants.SI :
					// Recupere le type du parametre
					Type type2 = pile_type.pop();
					// Si ce n'est ni un booleen, ni une erreur (due a une erreur precedente), on genere un message d'erreur
					if(type2 != Type.BOOLEEN && type2 != Type.ERREUR)
						throw new ExprNonBoolException("Booleen attendu ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					// Appelle l'instruction iffaux avec la bonne etiquette
					Yaka.yvm.iffaux("SINON"+numEtiqSi);
					break;
			}	
		}
		catch(EmptyStackException e){} 
		catch(ExprNonBoolException e2){
			System.out.println(e2.getMessage());
		}
	}
	
	/**
	 * Ecrit l'etiquette et effetue d'autres operations en fonction de celle-ci
	 */
	public void ecrireEtiq(int etiquette){
		switch(etiquette){
			// Si l'etiquette est TANTQUE :
			case YakaConstants.TANTQUE :
				// Incremente le numero d'etiquette tantque
				numEtiqTantque++;
				// Ajoute le numero d'etiquette dans la pile de niveau de boucle tantque
				pile_NiveauTANTQUE.push(numEtiqTantque);
				// Ecrit l'etiquette FAIRE suivie du numero d'etiquette
				ecrireEtiq("FAIRE"+numEtiqTantque);
				break;
				
			// Si l'etiquette est FAIT :
			case YakaConstants.FAIT :
				// Appelle la methode gotoY en donnant le bon numero d'etiquette
				Yaka.yvm.gotoY("FAIRE"+pile_NiveauTANTQUE.peek());
				// Ecrit l'etiquette FAIT suivie du bon numero d'etiquette
				ecrireEtiq("FAIT"+pile_NiveauTANTQUE.pop());
				break;
				
			// Si l'etiquette est SI
			case YakaConstants.SI : 
				// Incremente le numero d'etiquette si
				numEtiqSi++;
				// Ajoute le numero d'etiquette dans la pile de niveau de si
				pile_NiveauSI.push(numEtiqSi);
				//Pas la peine d'ecrire l'etiquette SI ;)
				break;

			// Si l'etiquette est SINON
			case YakaConstants.SINON :
				// Appelle la methode gotoY en donnant le bon numero d'etiquette
				Yaka.yvm.gotoY("FSI"+pile_NiveauSI.peek());
				// Ecrit l'etiquette SINON suivie du bon numero d'etiquette
				ecrireEtiq("SINON"+pile_NiveauSI.peek());
				break;
				
			// Si l'etiquette est FSI
			case YakaConstants.FSI :
				// Ecrit l'etiquette FSI suivie du bon numero d'etiquette
				ecrireEtiq("FSI"+pile_NiveauSI.pop());
				break;
			default:
				break;
		}
	}
	
	/**
	 * Ecrit l'etiquette
	 * @param etiquette a ecrire
	 */
	public void ecrireEtiq(String s) {
		Yaka.yvm.ecrireEtiquette(s+":");
	}
	
	/**
	 * Verifie les types pour les operations et met a jour le type dans la pile des types
	 */
	public void generationCalcul() {		
		try{
			// Recupere l'operation
			String op = pile_op.pop();
			// Recupere les types des 2 operandes
			Type type1 = pile_type.pop();
			Type type2 = pile_type.pop();
			
			// Si les types des 2 operandes sont differents et aucun d'eux n'est ERREUR, alors on genere un message d'erreur
			if(type1 != type2 && type1 != Type.ERREUR && type2 != Type.ERREUR) {
				throw new TypesIncompatiblesException("Types incompatibles " + type1 + " et " + type2 + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}		
			switch(op) {
				case "=" : // operandes de type BOOLEEN ou ENTIER
					Yaka.yvm.iegal();
					pile_type.add(Type.BOOLEEN);
					break;
				case "<" : // operandes de type ENTIER
					Yaka.yvm.iinf();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case ">" : // operandes de type ENTIER
					Yaka.yvm.isup();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case "<=" : // operandes de type ENTIER
					Yaka.yvm.iinfegal();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case ">=" : // operandes de type ENTIER
					Yaka.yvm.isupegal();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case "<>" : // operandes de type ENTIER
					Yaka.yvm.idiff();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case "+" : // operandes de type ENTIER
					Yaka.yvm.iadd();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "-" : // operandes de type ENTIER
					Yaka.yvm.isub();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "OU" :  // operandes de type BOOLEEN
					Yaka.yvm.ior();
					if(type2 == Type.ENTIER){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "ET" :  // operandes de type BOOLEEN
					Yaka.yvm.iand();
					if(type2 == Type.ENTIER){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "*" : // operandes de type ENTIER
					Yaka.yvm.imul();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "/" : // operandes de type ENTIER
					Yaka.yvm.idiv();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				default:
					/// operateur non valide (n'arrive jamais)
					break;
			}
		} 
		catch(EmptyStackException e){} 
		catch(TypesIncompatiblesException e2){
			System.out.println(e2.getMessage());
		}
		
	}
	
	/**
	 * Ecrit la chaine de caractere
	 * @param chaine a ecrire
	 */
	public void ecrireChaine(String chaine){
		Yaka.yvm.ecrireChaine(chaine);
	}
	
	/**
	 * Appelle l'instruction ecrireEnt ou ecrireBool en fonction du type de l'expression correspondante
	 */
	public void ecrire() {
		Type type = Type.ERREUR;
		try {
			// On recupere le type de l'expression correspondant au ecrire
			type = pile_type.pop();
		} catch(EmptyStackException e){}
		switch(type) {
			case ENTIER : 				
				// ecrireEnt pour les entiers
				Yaka.yvm.ecrireEnt();
				break;
			case BOOLEEN :
				// ecrireBool pour les booleens
				Yaka.yvm.ecrireBool();
				break;
			default:
				break; /// si le type est ERREUR, on ne fait rien
		}
	}
	
	/**
	 * Appelle l'instruction retourLigne
	 */
	public void retourLigne() {
		Yaka.yvm.aLaLigne();
	}
	
	/**
	 * Permet de stocker la valeur tapee dans l'ident s
	 */
	public void lire(String s) {
		try {
			// Erreur si l'ident n'existe pas
			if(!Yaka.tabIdent.existeIdentLocal(s))
				throw new NonDeclareeException(s + " : variable non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			// On cherche l'ident dans la table des idents locaux
			Ident ident = Yaka.tabIdent.chercheIdentLocal(s);
			// Si l'ident n'est pas une variable, on genere un message d'erreur
			if(!(ident instanceof IdVar))
				throw new ModifConstanteException("Impossible de modifier une constante ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			else
				// Sinon, on appelle l'instruction lireEnt en donnant l'offset de l'ident
				Yaka.yvm.lireEnt(((IdVar) ident).getOffset());
		}
		catch(NonDeclareeException e) {
			System.out.println(e.getMessage());
		}
		catch(ModifConstanteException e2) {
			System.out.println(e2.getMessage());
			
		}
	}
	
	/**
	 * Verifie que la valeur de retour de la fonction est coherente avec sa declaration
	 * @param nom de la fonction
	 * */
	public void verifRetour(String s){
		try {
			if(s != null) {
				// Recupere le type de la valeur a retourner
				Type type = pile_type.pop();
				
				// Si il est different de celui definit par la fonction et qu'il n'est pas ERREUR, on genere un massage d'erreur
				if(type != Yaka.tabIdent.chercheIdentGlobal(s).getType() && type != Type.ERREUR) {
					throw new TypesIncompatiblesException("Type de retour incompatible fonction " + s + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
				}
			}
			else {
				System.out.println("RETOURNE non autorise dans programme principal ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
				
		}
		catch (TypesIncompatiblesException e) {
			System.out.println(e.getMessage());
		}
		catch(EmptyStackException e){
			System.out.println("Aucune valeur a retourner " + s + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
		}
	}
	
	/**
	 * Verifie que le type du parametre de la fonction est coherent avec sa declaration
	 * */
	public void verifTypeParam() {
		try {
			// Recupere le nom de la fonction
			String nomFonc = pile_fonction.peek();
			// Recupere le rang du parametre
			int rangParam = pile_nbParams.peek();
			// Recupere le type que le parametre devrait avoir
			Type typeParam = ((IdFonc) Yaka.tabIdent.chercheIdentGlobal(nomFonc)).getArg(rangParam);
			// Si il n'existe aucun type pour le rang du parametre (ie trop d'arguments donnes a la fonction), on genere un message d'erreur
			if(typeParam == null) 
				throw new TooManyArgumentsException("Trop de paramètres fonction " + nomFonc + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			// Sinon, si le type du parametre est different de celui qu'il devrait avoir, on genere un message d'erreur
			else if( pile_type.pop() != typeParam)
				throw new TypesIncompatiblesException("Type de paramètre incompatible fonction " + nomFonc +  " paramètre " + (rangParam+1) + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
		}
		catch (TypesIncompatiblesException e) {
			System.out.println(e.getMessage());
		} 
		catch (TooManyArgumentsException e2) {
			pile_type.add(Type.ERREUR);
			System.out.println(e2.getMessage());
		}
		// On incremente le rang de paramatre de 1
		pile_nbParams.add(pile_nbParams.pop()+1);
	}
	
	public void isOpNegBool(boolean b){
		isOpNegBool = b;
	}
	
}