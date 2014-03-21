package classes;

import java.util.Stack;
import java.util.EmptyStackException;

import javacc.Yaka;
import exceptions.*;
/**
 * Gestion du traitement des expressions
 * @author paulriviere
 *
 */


public class Expression {
	private Stack<Type> pile_type;
	private Stack<String> pile_op;
	private Ident variableAffectation = null;
	
	public Expression() {
		pile_type = new Stack<Type>();
		pile_op = new Stack<String>();
	}
	
	public void stockIdent(String s) {
		try {
			if(!Yaka.tabIdent.existeIdent(s))
				throw new NonDeclareeException(s + " : variable non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			variableAffectation = Yaka.tabIdent.chercheIdent(s);
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
			if(!Yaka.tabIdent.existeIdent(s)) {
				pile_type.add(Type.ERREUR);
				throw new NonDeclareeException(s+ " : variable ou constante non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			}
			Ident ident = Yaka.tabIdent.chercheIdent(s);
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
	
	public void verifBool(){
		try{
			Type type = pile_type.pop();
			if(type != Type.BOOLEEN && type != Type.ERREUR)
				throw new ExprNonBoolException("Booleen attendu ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
		}
		catch(EmptyStackException e){} 
		catch(ExprNonBoolException e2){
			System.out.println(e2.getMessage());
		}
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
			if(!Yaka.tabIdent.existeIdent(s))
				throw new NonDeclareeException(s + " : variable non declaree ligne : " + Yaka.token.beginLine + " colonne : " + Yaka.token.beginColumn);
			Ident ident = Yaka.tabIdent.chercheIdent(s);
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
