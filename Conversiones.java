package Calculadora;

public class Conversiones {
	private int tipoConversiones;
	private double numero1;
	private double f;
	private double k;
	private double p;
	public Conversiones(int tipoConversiones, double numero1) {
		this.tipoConversiones = tipoConversiones;
		this.numero1 = numero1;
	}
	switch (tipoConversiones) {
	case1:
		 f = numero1 * Math.PI / 180;
		System.out.println(f);
	break;
		
	case2:
		k = (int) numero1;
	System.out.println(k);
	break;
	case3:
		p = Math.toDegrees(numero1);
	System.out.println(p);
	
	}
	
}
