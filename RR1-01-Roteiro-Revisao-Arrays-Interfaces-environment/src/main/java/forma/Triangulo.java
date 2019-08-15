package forma;

public class Triangulo implements Forma{
	
	private double altura;
	private double base;
	
	public void Triangulo(double altura, double base) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double area() {
		return (this.base * this.altura)/2;
	}
}
