package classes;
import java.io.OutputStream;


/**
 * Generation de code ASM
 * @author paulriviere
 *
 */
public class YVMasm extends YVM{
	
	private OutputStream out;
	private int indexVar;
	
	public YVMasm() {
		super();
		out = Ecriture.ouvrir("ASM.asm");
		Ecriture.ecrireStringln(out,";*********CODE ASSEMBLEUR - COMPILATEUR YVM ***********");
		indexVar=0;
	}

	public void entete() {
		Ecriture.ecrireStringln(out,";entete");
		Ecriture.ecrireStringln(out,"extrn lirent:proc, ecrent:proc");
		Ecriture.ecrireStringln(out,"extrn ecrbool:proc");
		Ecriture.ecrireStringln(out,"extrn ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(out,".model SMALL");
		Ecriture.ecrireStringln(out,".586");
		Ecriture.ecrireStringln(out,"\n.CODE");
		Ecriture.ecrireStringln(out,"debut : ");
		Ecriture.ecrireStringln(out,"STARTUPCODE");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void ouvrePrinc (int nbr) {
		Ecriture.ecrireStringln(out,";ouvrePrinc "+nbr);
		Ecriture.ecrireStringln(out,"mov bp,sp");
		Ecriture.ecrireStringln(out,"sub sp,"+nbr);
		Ecriture.ecrireStringln(out,"");
	}
	
	public void enqueue() {
		Ecriture.ecrireStringln(out,";queue");
		Ecriture.ecrireStringln(out,"nop");
		Ecriture.ecrireStringln(out,"EXITCODE");
		Ecriture.ecrireStringln(out,"end debut");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void iadd() {
		Ecriture.ecrireStringln(out,";iadd");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"add ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void isub() {
		Ecriture.ecrireStringln(out,";isub");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"sub ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void imul() {
		Ecriture.ecrireStringln(out,";imul");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"imul bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void idiv() {
		Ecriture.ecrireStringln(out,";idiv");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cwd");
		Ecriture.ecrireStringln(out,"idiv bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void ior() {
		Ecriture.ecrireStringln(out,";ior");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"or ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
		
	}
	
	public void iand() {
		Ecriture.ecrireStringln(out,";iand");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"and ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void ineg() {
		Ecriture.ecrireStringln(out,";ineg");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"neg ax");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void inot() {
		Ecriture.ecrireStringln(out,";inot");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"not ax");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}

	public void iinf() {
		Ecriture.ecrireStringln(out,";iinf");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jge $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void isup() {
		Ecriture.ecrireStringln(out,";isup");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jle $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void iinfegal() {
		Ecriture.ecrireStringln(out,";iinfegal");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jg $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void isupegal() {
		Ecriture.ecrireStringln(out,";isupegal");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp bx,ax");
		Ecriture.ecrireStringln(out,"jg $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void iegal() {
		Ecriture.ecrireStringln(out,";iegal");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jne $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void idiff() {
		Ecriture.ecrireStringln(out,";idiff");
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"je $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
	}
	
	public void iconst(int val) {
		Ecriture.ecrireStringln(out,";iconst "+val);
		Ecriture.ecrireStringln(out,"push word ptr "+val);
		Ecriture.ecrireStringln(out,"");
	}
	
	public void iconst(boolean val) {
		Ecriture.ecrireStringln(out,";iconst "+val);
		if (val) Ecriture.ecrireStringln(out,"push -1");
		else Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void istore(int offset) {
		Ecriture.ecrireStringln(out,";istore "+offset);
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"mov word ptr[bp"+offset+"],ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void iload(int offset) {
		Ecriture.ecrireStringln(out,";iload "+offset);
		Ecriture.ecrireStringln(out,"push word ptr[bp"+offset+"]");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void ecrireEnt() {
		Ecriture.ecrireStringln(out,";ecrireEnt");
		Ecriture.ecrireStringln(out,"call ecrent");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void ecrireChaine(String s) {
		Ecriture.ecrireStringln(out,";ecrireChaine "+s);
		Ecriture.ecrireStringln(out,".DATA");
		Ecriture.ecrireStringln(out,"mess"+indexVar+" DB "+s.substring(0, s.length() -1)+"$\"");
		Ecriture.ecrireStringln(out,".CODE");
		Ecriture.ecrireStringln(out,"lea dx,mess"+indexVar);
		Ecriture.ecrireStringln(out,"push dx");
		Ecriture.ecrireStringln(out,"call ecrch");
		Ecriture.ecrireStringln(out,"");
		indexVar++;
	}
	
	public void ecrireBool(boolean bool) {
		Ecriture.ecrireStringln(out,";ecrireBool");
		Ecriture.ecrireStringln(out,"call ecrch");
		Ecriture.ecrireStringln(out,"");
	}
	
	/* (non-Javadoc)
	 * @see YVM#lireEnt(int)
	 * ATTENTION : entier est n�gatif !
	 */
	public void lireEnt(int entier) {
		Ecriture.ecrireStringln(out,";lireEnt "+entier);
		Ecriture.ecrireStringln(out,"lea dx,[bp"+entier+"]");
		Ecriture.ecrireStringln(out,"push dx");
		Ecriture.ecrireStringln(out,"call lirent");
		Ecriture.ecrireStringln(out,"");
	}
	
	public void aLaLigne () {
		Ecriture.ecrireStringln(out,";alaligne");
		Ecriture.ecrireStringln(out,"call ligsuiv");
		Ecriture.ecrireStringln(out,"");
	}
	
}
