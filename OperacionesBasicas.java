package Calculadora;

public class OperacionesBasicas {
	private double num1;
    private double num2;
  
    public OperacionesBasicas(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double suma() {
        return num1 + num2;
    }

    public double resta() {
        return num1 - num2;
    }

    public double multiplicacion() {
        return num1 * num2;
    }

    public double divicion() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("No se puede dividir entre cero.");
            return Double.NaN; // Devuelve NaN (Not a Number) para indicar una división por cero
        }
    }
   

	public double getNum1() {
		return num1;
	}

	public double getNum2() {
		return num2;
	}

	
    
}
