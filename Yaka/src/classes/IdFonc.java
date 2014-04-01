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
	
	public void addArg(Type type) {
		tabArg.add(type);
	}
	
	

}
