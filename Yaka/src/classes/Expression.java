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
	private Stack<String> pile_FONCTION;
	private Ident variableAffectation = null;
	private int numEtiqTantque = 0;
	private int numEtiqSi = 0;
	
	public Expression() {
		pile_type = new Stack<Type>();
		pile_op = new Stack<String>();
		pile_NiveauTANTQUE = new Stack<Integer>();
		pile_NiveauSI = new Stack<Integer>();
		pile_FONCTION = new Stack<String>();
	}
	
	public void stockIdent(String s) {
		try {
			if(!Yaka.tabIdent.existeIdentLocal(s))
				throw new NonDeclareeException(s + " : variable non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			variableAffectation = Yaka.tabIdent.chercheIdentLocal(s);
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
	
	public void affect(){
		if(variableAffectation != null)
			Yaka.yvm.istore(((IdVar) variableAffectation).getOffset());
	}
	
	public void addEntier(int entier) {
		pile_type.add(Type.ENTIER);
		Yaka.yvm.iconst(entier);
	}
	
	public void addIdent(String s) {
		try { 
			if(!Yaka.tabIdent.existeIdentLocal(s)) {
				pile_type.add(Type.ERREUR);
				throw new NonDeclareeException(s+ " : variable ou constante non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			Ident ident = Yaka.tabIdent.chercheIdentLocal(s);
			pile_type.add(ident.getType());
			if(ident instanceof IdVar)
				Yaka.yvm.iload(((IdVar) ident).getOffset());
			else {
				if(ident.getType() == Type.ENTIER)
					Yaka.yvm.iconst(((IdConst) ident).getValInt());
				else
					Yaka.yvm.iconst(((IdConst) ident).getValBool());
			}
		}
		catch(NonDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addEtat(boolean b) {
		pile_type.add(Type.BOOLEEN);
		Yaka.yvm.iconst(b);
	}

	public void addOperateur(String s) {
		pile_op.add(s);
	}

	public void neg() {
		Type type = Type.ERREUR;
		try{
			type = pile_type.peek();
		} catch(EmptyStackException e) {}
		switch(type) {
			case ENTIER : 
				Yaka.yvm.ineg();
				break;
			case BOOLEEN :
				Yaka.yvm.inot();
				break;
			default:
				/// (il y a eu une erreur avant)
				break;
		}
	}	
	
	public void addFonct(String s) {
		try {
			if(!Yaka.tabIdent.existeIdentGlobal(s))
				throw new NonDeclareeException(s + " : fonction non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			pile_FONCTION.add(s);
		}
		catch(NonDeclareeException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void ecrireFonc() {
		try {
			Yaka.yvm.call(pile_FONCTION.pop());
		}
		catch(EmptyStackException e){} 
	}
	
	
	public void verifBool(int etiquette){
		try{
			switch(etiquette){
				case YakaConstants.TANTQUE :
					Type type1 = pile_type.pop();
					if(type1 != Type.BOOLEEN && type1 != Type.ERREUR)
						throw new ExprNonBoolException("Booleen attendu ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					Yaka.yvm.iffaux("FAIT"+numEtiqTantque);break;
					
				case YakaConstants.SI :
					Type type2 = pile_type.pop();
					if(type2 != Type.BOOLEEN && type2 != Type.ERREUR)
						throw new ExprNonBoolException("Booleen attendu ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					Yaka.yvm.iffaux("SINON"+numEtiqSi);break;
			}	
		}
		catch(EmptyStackException e){} 
		catch(ExprNonBoolException e2){
			System.out.println(e2.getMessage());
		}
	}
	
	public void ecrireEtiq(int etiquette){
		switch(etiquette){
			case YakaConstants.TANTQUE :
				numEtiqTantque++;
				pile_NiveauTANTQUE.push(numEtiqTantque);
				Yaka.yvm.ecrireEtiquette ("FAIRE"+numEtiqTantque+":");
				break;
				
			case YakaConstants.FAIT :
				Yaka.yvm.gotoY("FAIRE"+pile_NiveauTANTQUE.peek());
				Yaka.yvm.ecrireEtiquette ("FAIT"+pile_NiveauTANTQUE.pop()+":");
				break;
				
			case YakaConstants.SI : 
				numEtiqSi++;
				pile_NiveauSI.push(numEtiqSi);
				//Pas la peine d'�crire l'�tiquette SI ;)
				break;
			
			case YakaConstants.SINON :
				Yaka.yvm.gotoY("FSI"+numEtiqSi);
				Yaka.yvm.ecrireEtiquette ("SINON"+numEtiqSi+":");
				break;
				
			case YakaConstants.FSI :
				Yaka.yvm.ecrireEtiquette ("FSI"+pile_NiveauSI.pop()+":");
				break;
			default:
				break;
		}
	}
	
	public void ecrireEtiq(String s) {
		Yaka.yvm.ecrireEtiquette(s+":");
	}
	
	public void generationCalcul() {		
		
		try{
			String op = pile_op.pop();
			Type type1 = pile_type.pop();
			Type type2 = pile_type.pop();
			
			if(type1 != type2 && type1 != Type.ERREUR && type2 != Type.ERREUR) {
				throw new TypesIncompatiblesException("Types incompatibles " + type1 + " et " + type2 + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}		
			switch(op) {
				case "=" : 
					Yaka.yvm.iegal();
					pile_type.add(Type.BOOLEEN);
					break;
				case "<" : 
					Yaka.yvm.iinf();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case ">" : 
					Yaka.yvm.isup();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case "<=" : 
					Yaka.yvm.iinfegal();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case ">=" : 
					Yaka.yvm.isupegal();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case "<>" : 
					Yaka.yvm.idiff();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(Type.BOOLEEN);
					break;
				case "+" : 
					Yaka.yvm.iadd();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "-" : 
					Yaka.yvm.isub();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "OU" : 
					Yaka.yvm.ior();
					if(type2 == Type.ENTIER){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "ET" : 
					Yaka.yvm.iand();
					if(type2 == Type.ENTIER){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "*" : 
					Yaka.yvm.imul();
					if(type2 == Type.BOOLEEN){
						throw new TypesIncompatiblesException("Type " + type2 + " incompatible avec l'operation " + op + " ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
					}
					pile_type.add(type2);
					break;
				case "/" : 
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
	
	public void ecrireChaine(String chaine){
		Yaka.yvm.ecrireChaine(chaine);
	}
	
	public void ecrire() {
		Type type = Type.ERREUR;
		try {
			type = pile_type.pop();
		} catch(EmptyStackException e){}
		switch(type) {
			case ENTIER : 
				Yaka.yvm.ecrireEnt();
				break;
			case BOOLEEN :
				Yaka.yvm.ecrireBool();
				break;
			default:
				break; ///erreur
		}
	}
	
	public void retourLigne() {
		Yaka.yvm.aLaLigne();
	}
	
	public void lire(String s) {
		try {
			if(!Yaka.tabIdent.existeIdentLocal(s))
				throw new NonDeclareeException(s + " : variable non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			Ident ident = Yaka.tabIdent.chercheIdentLocal(s);
			if(!(ident instanceof IdVar))
				throw new ModifConstanteException("Impossible de modifier une constante ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			else
				Yaka.yvm.lireEnt(((IdVar) ident).getOffset());
		}
		catch(NonDeclareeException e) {
			System.out.println(e.getMessage());
		}
		catch(ModifConstanteException e2) {
			System.out.println(e2.getMessage());
		}
	}
}
