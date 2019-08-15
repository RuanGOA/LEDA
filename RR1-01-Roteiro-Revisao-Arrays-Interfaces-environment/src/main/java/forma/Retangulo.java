package forma;

public class Retangulo implements Forma{
	
	protected double altura;
	protected double base;
	
	public Retangulo(double altura, double base) {
		super();
		this.altura = altura;
		this.base = base;
	}
	
	@Override
	public double area() {
		return base * altura;
	}

}
