package classes;
import io.Ecriture;

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

	public void entete() {
		Ecriture.ecrireStringln(out,"entete");
	}
	
	public void ouvrePrinc (int nbr) {
		Ecriture.ecrireStringln(out,"ouvrePrinc "+nbr);
	}
	
	public void enqueue() {
		Ecriture.ecrireStringln(out,"queue");
	}
	
	public void iadd() {
		Ecriture.ecrireStringln(out,"iadd");
	}
	
	public void isub() {
		Ecriture.ecrireStringln(out,"isub");
	}
	
	public void imul() {
		Ecriture.ecrireStringln(out,"imul");
	}
	
	public void idiv() {
		Ecriture.ecrireStringln(out,"idiv");
	}
	
	public void ineg() {
		Ecriture.ecrireStringln(out,"ineg");
	}
	
	public void inot() {
		Ecriture.ecrireStringln(out,"inot");
	}
	
	public void ior() {
		Ecriture.ecrireStringln(out,"ior");
	}
	
	public void iand() {
		Ecriture.ecrireStringln(out,"iand");
	}
	
	public void iinf() {
		Ecriture.ecrireStringln(out,"iinf");
	}
	
	public void isup() {
		Ecriture.ecrireStringln(out,"isup");
	}
	
	public void iinfegal() {
		Ecriture.ecrireStringln(out,"iinfegal");
	}
	
	public void isupegal() {
		Ecriture.ecrireStringln(out,"isupegal");
	}
	
	public void iegal() {
		Ecriture.ecrireStringln(out,"iegal");	
	}
	
	public void idiff() {
		Ecriture.ecrireStringln(out,"idiff");
	}
	
	public void iconst(int val) {
		Ecriture.ecrireStringln(out,"iconst "+val);
	}
	
	public void iconst(boolean val) {
		if (val) Ecriture.ecrireStringln(out,"iconst -1");
		else Ecriture.ecrireStringln(out,"iconst 0");
	}
	
	public void istore(int offset) {
		Ecriture.ecrireStringln(out,"istore "+offset);
	}
	
	public void iload(int offset) {
		Ecriture.ecrireStringln(out,"iload "+offset);
	}
	
	public void ecrireEnt() {
		Ecriture.ecrireStringln(out,"ecrireEnt");
	}
	
	public void ecrireChaine(String s) {
		Ecriture.ecrireStringln(out,"ecrireChaine "+s);
	}
	
	public void ecrireBool() {
		Ecriture.ecrireStringln(out,"ecrireBool");
	}
	
	public void lireEnt(int offset) {
		Ecriture.ecrireStringln(out,"lireEnt "+offset);
	}
	
	public void aLaLigne () {
		Ecriture.ecrireStringln(out,"aLaLigne");
	}
	
	public void iffaux (String s) {
		Ecriture.ecrireStringln(out,"iffaux "+s);
	}
	
	public void gotoY(String s) {
		Ecriture.ecrireStringln(out,"goto "+s);
	}
	
	public void ecrireEtiquette (String s) {
		Ecriture.ecrireStringln(out,s+":");
	}
	
	public void ireturn (int offset) {
		Ecriture.ecrireStringln(out, "ireturn " + offset);
	}
	
	public void reserveRetour () {
		Ecriture.ecrireStringln(out, "reserveRetour");
	}
	
	public void ouvBloc (int v) {
		Ecriture.ecrireStringln(out, "ouvbloc " + v);
	}
	
	public void fermeBloc (int v) {
		Ecriture.ecrireStringln(out, "fermebloc " + v);
	}
	
	public void call (String s) {
		Ecriture.ecrireStringln(out, "call " + s);
	}
}