public class Declaration {
	private String nom;
	private Boolean isInteger;	

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//Constante entier
	public void declConst(Integer val) {
		Yaka.tabIdent.creationIdent(Nature.CONSTANTE,this.nom,Type.ENTIER,val);
	}

	//Constante booleen
	public void declConst(Boolean val) {
		Yaka.tabIdent.creationIdent(Nature.CONSTANTE,this.nom,Type.BOOLEEN,val);
	}

	//Entier ou booleen
	public void setIsInteger(Boolean b) {
		isInteger = b;
	}

	//Variable
	public void declVar(String nom) {
		if(isInteger) Yaka.tabIdent.creationIdent(Nature.VARIABLE,nom,Type.ENTIER,null);
		else Yaka.tabIdent.creationIdent(Nature.VARIABLE,nom,Type.BOOLEEN,null);
	}
}