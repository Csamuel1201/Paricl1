package Calculadora;

public class Trigonometricas {
	private double num1;
	
	public Trigonometricas(double num1) {
		this.num1 = num1;
	}
	public double seno(double num1) {
		return Math.sin(num1);
	}
	public double coseno(double num1) {
		return Math.cos(num1);
	}
	public double tangente(double num1) {
		return Math.tan(num1);
	}
	public double secante(double num1) {
		return 1/Math.cos(num1);
	}
	public double hiperbole(double num1) {
		return Math.tanh(num1);
	}
	public double getNum1() {
		return num1;
	}
	

}
