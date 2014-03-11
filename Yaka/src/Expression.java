
import java.util.Stack;
import java.util.EmptyStackException;
/**
 * Gestion du traitement des expressions
 * @author paulriviere
 *
 */


public class Expression {
	private Stack<Type> pile_type;
	private Stack<String> pile_op;
	private Ident variableAffectation;
	
	public Expression() {
		pile_type = new Stack<Type>();
		pile_op = new Stack<String>();
	}
	
	public void stockIdent(String s){
		if(!Yaka.tabIdent.existeIdent(s)){
			/// Identifiant n'a pas ete ajoute a la table
		}
		variableAffectation = Yaka.tabIdent.chercheIdent(s);
	}
	
	public void affect(){
		if(variableAffectation == NULL){
			/// error
		}else{
			istore(((IdVar)Ident).getOffset());
		}
	}
	
	public void addEntier(int entier){
		pile_type.add(Type.ENTIER);
		Yaka.yvm.iconst(entier);
	}
	
	public void addIdent(String s){
		if(!Yaka.tabIdent.existeIdent(s)){
			/// Identifiant n'a pas ete ajoute a la table
		}
		Ident ident = Yaka.tabIdent.chercheIdent(s);
		pile_type.add(ident.getType());
		System.out.println(ident.getClass());
		if(ident instanceof IdVar)
			Yaka.yvm.iload(((IdVar) ident).getOffset());
		else
			if(ident.getType() == Type.ENTIER)
				Yaka.yvm.iconst(((IdConst) ident).getValInt());
			else
				Yaka.yvm.iconst(((IdConst) ident).getValBool());
	}
	
	public void addEtat(String s){
		if(s.equals("VRAI")){
			pile_type.add(Type.BOOLEEN);
			Yaka.yvm.iconst(true);
		}
		if(s.equals("FAUX")){
			pile_type.add(Type.BOOLEEN);
			Yaka.yvm.iconst(false);
			
		}
	}

	public void addOperateur(String s){
		pile_op.add(s);
	}

	public void neg(){
		Type type = Type.ERREUR;
		try{
			type = pile_type.pop();
		} catch(EmptyStackException e){
			/// Pile des types vide
		}
		
		switch(type){
			case ENTIER : 
				Yaka.yvm.ineg();
				break;
			case BOOLEEN :
				Yaka.yvm.inot();
				break;
			default:
				/// (il y a eu une erreur avant)
				;
		}
	}	
	
	
	public void generationCalcul(){
		Type type2 = Type.ERREUR;
		String op = null;
		
		try{
			op = pile_op.pop();
		} catch(EmptyStackException e){
			/// Pile des operateurs vide : pas d'operateur
		}
		
		try{
			Type type1 = pile_type.pop();
			type2 = pile_type.pop();
			if(type1 != type2){
				/// Type different : calcul incompatible 
			}
		} catch(EmptyStackException e){
			/// Pile des types vide
		}
		
		switch(op){
		case "=" : 
			Yaka.yvm.iegal();
			pile_type.add(Type.BOOLEEN);
			break;
		case "<" : 
			Yaka.yvm.iinf();
			pile_type.add(Type.BOOLEEN);
			break;
		case ">" : 
			Yaka.yvm.isup();
			pile_type.add(Type.BOOLEEN);
			break;
		case "<=" : 
			Yaka.yvm.iinfegal();
			pile_type.add(Type.BOOLEEN);
			break;
		case ">=" : 
			Yaka.yvm.isupegal();
			pile_type.add(Type.BOOLEEN);
			break;
		case "<>" : 
			Yaka.yvm.idiff();
			pile_type.add(Type.BOOLEEN);
			break;
		case "+" : 
			Yaka.yvm.iadd();
			if(type2 != Type.ENTIER){
				///error
			}
			pile_type.add(type2);
			break;
		case "-" : 
			Yaka.yvm.isub();
			if(type2 != Type.ENTIER){
				///error
			}
			pile_type.add(type2);
			break;
		case "OU" : 
			Yaka.yvm.ior();
			if(type2 != Type.BOOLEEN){
				///error
			}
			pile_type.add(type2);
			break;
		case "ET" : 
			Yaka.yvm.iand();
			if(type2 != Type.BOOLEEN){
				///error
			}
			pile_type.add(type2);
			break;
		case "*" : 
			Yaka.yvm.imul();
			if(type2 != Type.ENTIER){
				///error
			}
			pile_type.add(type2);
			break;
		case "/" : 
			Yaka.yvm.idiv();
			if(type2 != Type.ENTIER){
				///error
			}
			pile_type.add(type2);
			break;
		default:
			/// operateur non valide (n'arrive jamais)
			;
		}
		
	}
}
