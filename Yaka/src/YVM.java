import java.io.OutputStream;


/**
 * Generation de code Yaka Virtual Machine
 * @author paulriviere
 *
 */
public class YVM {
	private OutputStream out;
	
	public YVM() {
		out = Ecriture.ouvrir("YVM.yvm");
		Ecriture.ecrireStringln(out,";*********CODE YVM - COMPILATEUR YVM ***********");
	}

	void entete() {
		Ecriture.ecrireStringln(out,"entete");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ouvrePrinc (int nbr) {
		Ecriture.ecrireStringln(out,"ouvrePrinc "+nbr);
		Ecriture.ecrireStringln(out,"");
	}
	
	void enqueue() {
		Ecriture.ecrireStringln(out,"queue");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iadd() {
		Ecriture.ecrireStringln(out,"iadd");
		Ecriture.ecrireStringln(out,"");
	}
	
	void isub() {
		Ecriture.ecrireStringln(out,"isub");
		Ecriture.ecrireStringln(out,"");
	}
	
	void imul() {
		Ecriture.ecrireStringln(out,"imul");
		Ecriture.ecrireStringln(out,"");
	}
	
	void idiv() {
		Ecriture.ecrireStringln(out,"idiv");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ineg() {
		Ecriture.ecrireStringln(out,"ineg");
		Ecriture.ecrireStringln(out,"");
	}
	
	void inot() {
		Ecriture.ecrireStringln(out,"inot");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ior() {
		Ecriture.ecrireStringln(out,"ior");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iand() {
		Ecriture.ecrireStringln(out,"iand");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iinf() {
		Ecriture.ecrireStringln(out,"iinf");
		Ecriture.ecrireStringln(out,"");
	}
	
	void isup() {
		Ecriture.ecrireStringln(out,"isup");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iinfegal() {
		Ecriture.ecrireStringln(out,"iinfegal");
		Ecriture.ecrireStringln(out,"");
	}
	
	void isupegal() {
		Ecriture.ecrireStringln(out,"isupegal");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iegal() {
		Ecriture.ecrireStringln(out,"iegal");
		Ecriture.ecrireStringln(out,"");
	}
	
	void idiff() {
		Ecriture.ecrireStringln(out,"idiff");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iconst(int val) {
		Ecriture.ecrireStringln(out,"iconst "+val);
		Ecriture.ecrireStringln(out,"");
	}
	
	void iconst(boolean val) {
		if (val) Ecriture.ecrireStringln(out,"iconst -1");
		else Ecriture.ecrireStringln(out,"iconst 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	void istore(int offset) {
		Ecriture.ecrireStringln(out,"istore "+offset);
		Ecriture.ecrireStringln(out,"");
	}
	
	void iload(int offset) {
		Ecriture.ecrireStringln(out,"iload "+offset);
		Ecriture.ecrireStringln(out,"");
	}
}
