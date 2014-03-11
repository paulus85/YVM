
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
	
	Expression(){
		Stack<Type> pile_type = new Stack<Type>();
		Stack<String> pile_op = new Stack<String>();
	}
	
	
	public void addEntier(int entier){
		pile_type.add(Type.ENTIER);
		Yaka.yvm.iconst(entier);
	}
	
	public void addIdent(String s){
		if(!Yaka.tabident.existeIdent(s)){
			/// Identifiant n'a pas ete ajoute a la table
		}
		pile_type.add(Yaka.tabident.chercheIdent(s).getType());
		Yaka.tabident.chercheIdent(s).
		Yaka.yvm.iload(Yaka.tabident.chercheIdent(s).getOffset());
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
		String op;
		
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
			break;
		case "<" : 
			Yaka.yvm.iinf();
			break;
		case ">" : 
			Yaka.yvm.isup();
			break;
		case "<=" : 
			Yaka.yvm.iinfegal();
			break;
		case ">=" : 
			Yaka.yvm.isupegal();
			break;
		case "<>" : 
			Yaka.yvm.idiff();
			break;
		case "+" : 
			Yaka.yvm.iadd();
			break;
		case "-" : 
			Yaka.yvm.isub();
			break;
		case "OU" : 
			Yaka.yvm.ior();
			break;
		case "ET" : 
			Yaka.yvm.iand();
			break;
		case "*" : 
			Yaka.yvm.imul();
			break;
		case "/" : 
			Yaka.yvm.idiv();
			break;
		default:
			/// operateur non valide (n'arrive jamais)
			;
		}
		
		pile_type.add(type2);
	}
}
