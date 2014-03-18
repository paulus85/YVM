package classes;
import java.io.OutputStream;


/**
 * Generation de code Yaka Virtual Machine
 * @author paulriviere
 *
 */
public class YVM {
	private OutputStream out;
	public YVMasm asm;
	
	public YVM() {
		out = Ecriture.ouvrir("YVM.yvm");
		Ecriture.ecrireStringln(out,";*********CODE YVM - COMPILATEUR YVM ***********");
	}

	void entete() {
		Ecriture.ecrireStringln(out,"entete");
	}
	
	void ouvrePrinc (int nbr) {
		Ecriture.ecrireStringln(out,"ouvrePrinc "+nbr);
	}
	
	void enqueue() {
		Ecriture.ecrireStringln(out,"queue");
	}
	
	void iadd() {
		Ecriture.ecrireStringln(out,"iadd");
	}
	
	void isub() {
		Ecriture.ecrireStringln(out,"isub");
	}
	
	void imul() {
		Ecriture.ecrireStringln(out,"imul");
	}
	
	void idiv() {
		Ecriture.ecrireStringln(out,"idiv");
	}
	
	void ineg() {
		Ecriture.ecrireStringln(out,"ineg");
	}
	
	void inot() {
		Ecriture.ecrireStringln(out,"inot");
	}
	
	void ior() {
		Ecriture.ecrireStringln(out,"ior");
	}
	
	void iand() {
		Ecriture.ecrireStringln(out,"iand");
	}
	
	void iinf() {
		Ecriture.ecrireStringln(out,"iinf");
	}
	
	void isup() {
		Ecriture.ecrireStringln(out,"isup");
	}
	
	void iinfegal() {
		Ecriture.ecrireStringln(out,"iinfegal");
	}
	
	void isupegal() {
		Ecriture.ecrireStringln(out,"isupegal");
	}
	
	void iegal() {
		Ecriture.ecrireStringln(out,"iegal");	
	}
	
	void idiff() {
		Ecriture.ecrireStringln(out,"idiff");
	}
	
	void iconst(int val) {
		Ecriture.ecrireStringln(out,"iconst "+val);
	}
	
	void iconst(boolean val) {
		if (val) Ecriture.ecrireStringln(out,"iconst -1");
		else Ecriture.ecrireStringln(out,"iconst 0");
	}
	
	void istore(int offset) {
		Ecriture.ecrireStringln(out,"istore "+offset);
	}
	
	void iload(int offset) {
		Ecriture.ecrireStringln(out,"iload "+offset);
	}
	
	void ecrireEnt() {
		Ecriture.ecrireStringln(out,"ecrireEnt");
	}
	
	void ecrireChaine(String s) {
		Ecriture.ecrireStringln(out,"ecrireChaine "+s);
	}
	
	void ecrireBool() {
		Ecriture.ecrireStringln(out,"ecrireBool");
	}
	
	void lireEnt(int offset) {
		Ecriture.ecrireStringln(out,"lireEnt "+offset);
	}
	
	void aLaLigne () {
		Ecriture.ecrireStringln(out,"aLaLigne");
	}
}