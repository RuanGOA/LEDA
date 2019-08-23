package forma;

public class Circulo implements Forma{
	private double raio;
		
	public void Circulo(double raio) {
		this.raio = raio;
	}
	
	@Override
	public double area() {
		return this.raio * this.raio * Math.PI;
	}
	
}
