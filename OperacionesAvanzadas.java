package Calculadora;

public class OperacionesAvanzadas {
	private double num1;
    private double num2;
    private int exponente;
    public OperacionesAvanzadas(double num1, double num2) {
    	this.num1 = num1;
    	this.num2 = num2;
    }
    public double raizCuadrada(double num1) {
    	return Math.sqrt(num1);
    	
    }
    public double potencia(double num1) {
    	return Math.pow(num1, exponente);
    }
    public double logaritmo(double num1) {
    	return Math.log10(num1);
    }
    public  double derivada(String polynomial, double x) {
        String[] terms = polynomial.split(" \\+ ");
        double derivative = 0.0;

        for (String term : terms) {
            String[] parts = term.split("x\\^");
            double coefficient = Double.parseDouble(parts[0]);
            int exponent = parts.length == 2? Integer.parseInt(parts[1]) : 1;

            if (exponent > 0) {
                derivative += coefficient * exponent * Math.pow(x, exponent - 1);
            }
        }

        return derivative;
    }
	public double getNum1() {
		return num1;
	}
	public double getNum2() {
		return num2;
	}
	public int getExponente() {
		return exponente;
	}
    
}
