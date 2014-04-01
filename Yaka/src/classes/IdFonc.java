package classes;

import java.util.ArrayList;

public class IdFonc extends Ident{
	
	private ArrayList<Type> tabArg;

	/**
	 * @param type Type de sortie de la fonction
	 */
	public IdFonc(Type type) {
		super(type);
		ArrayList<Type> tabArg = new ArrayList<Type>(0);
		
	}
	
	/**
	 * Permet l'ajout d'argument à la fonction
	 * @param type Type de l'argument
	 */
	public void addArg(Type type) {
		tabArg.add(type);
	}
	
	/**
	 * @return le nombre d'arugment de la fonction
	 */
	public int nbArg() {
		return this.tabArg.size();
	}
	
	public Type getArg(int n){
		Type res = null;
		if (n <= tabArg.size()) return res=this.tabArg.get(n);
		return res;
		
	}
	
	

}
