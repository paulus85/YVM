package classes;

import java.util.ArrayList;

public class IdFonc extends Ident{
	
	/**
	 * Liste des types d'arguments de la fonction
	 */
	private ArrayList<Type> tabArg;

	
	/**
	 * @param type Type de sortie de la fonction
	 */
	public IdFonc(Type type) {
		super(type);
		//Par défaut taille ArrayList = 10 fonctions max dans le programme
		tabArg = new ArrayList<Type>();
		
	}
	
	/**
	 * Permet l'ajout d'argument a la fonction
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
	
	/**
	 * @param n le numero de l'argument 
	 * @return le type de l'argument dont le numero est n
	 */
	public Type getArg(int n){
		Type res = null;
		if (n <= tabArg.size()) return res=this.tabArg.get(n);
		return res;
		
	}
	
	

}
