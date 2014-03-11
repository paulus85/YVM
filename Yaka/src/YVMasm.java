import java.io.OutputStream;


/**
 * Generation de code ASM
 * @author paulriviere
 *
 */
public class YVMasm extends YVM{
	
	private OutputStream out;
	
	public YVMasm() {
		super();
		out=Ecriture.ouvrir("ASM.asm");
		Ecriture.ecrireStringln(out,";*********CODE ASSEMBLEUR - COMPILATEUR YVM ***********");
	}

	void entete() {
		Ecriture.ecrireStringln(out,"extrn lirent:proc, ecrent:proc");
		Ecriture.ecrireStringln(out,"extrn ecrbool:proc");
		Ecriture.ecrireStringln(out,"extrn ecrch:proc, ligsuiv:proc");
		Ecriture.ecrireStringln(out,".model SMALL");
		Ecriture.ecrireStringln(out,".586");
		Ecriture.ecrireStringln(out,"\n.CODE");
		Ecriture.ecrireStringln(out,".debut : ");
		Ecriture.ecrireStringln(out,"STARTUPCODE");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ouvrePrinc (int nbr) {
		Ecriture.ecrireStringln(out,"mov bp,sp");
		Ecriture.ecrireStringln(out,"sub sp,"+nbr);
		Ecriture.ecrireStringln(out,"");
	}
	
	void enqueue() {
		Ecriture.ecrireStringln(out,"nop");
		Ecriture.ecrireStringln(out,"exitcode");
		Ecriture.ecrireStringln(out,"end debut");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iadd() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"add ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	void isub() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"sub ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	void imul() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"imul bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	void idiv() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cwd");
		Ecriture.ecrireStringln(out,"idiv bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ior() {
		Ecriture.ecrireStringln(out,"push bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"or ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
		
	}
	
	void iand() {
		Ecriture.ecrireStringln(out,"push bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"and ax,bx");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ineg() {
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"neg ax");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	void inot() {
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"not ax");
		Ecriture.ecrireStringln(out,"push ax");
		Ecriture.ecrireStringln(out,"");
	}

	void iinf() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jge $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	void isup() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jle $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iinfegal() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jg $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	void isupegal() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp bx,ax");
		Ecriture.ecrireStringln(out,"jg $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iegal() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"jne $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	void idiff() {
		Ecriture.ecrireStringln(out,"pop bx");
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"cmp ax,bx");
		Ecriture.ecrireStringln(out,"je $+6");
		Ecriture.ecrireStringln(out,"push -1");
		Ecriture.ecrireStringln(out,"jmp $+4");
		Ecriture.ecrireStringln(out,"push 0");
	}
	
	void iconst(int val) {
		Ecriture.ecrireStringln(out,"push "+val);
		Ecriture.ecrireStringln(out,"");
	}
	
	void iconst(boolean val) {
		if (val) Ecriture.ecrireStringln(out,"push -1");
		else Ecriture.ecrireStringln(out,"push 0");
		Ecriture.ecrireStringln(out,"");
	}
	
	void istore(int offset) {
		Ecriture.ecrireStringln(out,"pop ax");
		Ecriture.ecrireStringln(out,"mov word ptr[bp"+offset+"],ax");
		Ecriture.ecrireStringln(out,"");
	}
	
	void iload(int offset) {
		Ecriture.ecrireStringln(out,"push word ptr[bp"+offset+"]");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ecrireEnt(int i) {
		Ecriture.ecrireStringln(out,"call ecrent");
		Ecriture.ecrireStringln(out,"");
	}
	
	void ecrireChaine(String s) {
		
	}
	
	void ecrireBool(boolean bool) {
		Ecriture.ecrireStringln(out,"call ecrch");
		Ecriture.ecrireStringln(out,"");
	}
	
	void lireEnt(int offset) {
		
	}
	
	void aLaLigne () {
		Ecriture.ecrireStringln(out,"call ligsuiv");
		Ecriture.ecrireStringln(out,"");
	}
	
}
