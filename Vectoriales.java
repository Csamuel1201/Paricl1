package Calculadora;
import java.util.Vector;
public class Vectoriales {
	private int[] vector1 = {};
    private int[] vector2 = {};
    
	public int[] sumarVectores(int[] vector1, int[] vector2) {
        int longitud = Math.min(vector1.length, vector2.length);
        int[] resultado = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            resultado[i] = vector1[i] + vector2[i];
        }

        return resultado;
    }
	 public  Vector<Double> subtractVectors(Vector<Double> vector1, Vector<Double> vector2) {
	        if (vector1.size() != vector2.size()) {
	            throw new IllegalArgumentException("Both vectors must have the same size");
	        }

	        Vector<Double> result = new Vector<Double>(vector1.size());
	        for (int i = 0; i < vector1.size(); i++) {
	            result.add(vector1.get(i) - vector2.get(i));
	        }

	        return result;
	    }
	 public  double dotProduct(Vector<Double> vector1, Vector<Double> vector2) {
	        if (vector1.size() != vector2.size()) {
	            throw new IllegalArgumentException("Both vectors must have the same size");
	        }

	        double result = 0.0;
	        for (int i = 0; i < vector1.size(); i++) {
	            result += vector1.get(i) * vector2.get(i);
	        }

	        return result;
	    }
	 public  Vector<Double> crossProduct(Vector<Double> vector1, Vector<Double> vector2) {
	        if (vector1.size() != 3 || vector2.size() != 3) {
	            throw new IllegalArgumentException("Both vectors must be 3D");
	        }

	        Vector<Double> result = new Vector<Double>(3);
	        result.add(vector1.get(1) * vector2.get(2) - vector1.get(2) * vector2.get(1));
	        result.add(vector1.get(2) * vector2.get(0) - vector1.get(0) * vector2.get(2));
	        result.add(vector1.get(0) * vector2.get(1) - vector1.get(1) * vector2.get(0));

	        return result;
	    }
	 public static Vector<Double> projection(Vector<Double> vector1, Vector<Double> vector2) {
	        if (vector1.size() != vector2.size()) {
	            throw new IllegalArgumentException("Both vectors must have the same size");
	        }

	        double dotProduct = 0.0;
	        for (int i = 0; i < vector1.size(); i++) {
	            dotProduct += vector1.get(i) * vector2.get(i);
	        }

	        double magnitudeSquared = 0.0;
	        for (int i = 0; i < vector2.size(); i++) {
	            magnitudeSquared += vector2.get(i) * vector2.get(i);
	        }

	        double magnitude = Math.sqrt(magnitudeSquared);

	        Vector<Double> result = new Vector<Double>(vector1.size());
	        for (int i = 0; i < vector1.size(); i++) {
	            result.add(dotProduct * vector2.get(i) / magnitudeSquared);
	        }

	        return result;
	    }
	 
	public int[] getVector1() {
		return vector1;
	}

	public int[] getVector2() {
		return vector2;
	} 

}
