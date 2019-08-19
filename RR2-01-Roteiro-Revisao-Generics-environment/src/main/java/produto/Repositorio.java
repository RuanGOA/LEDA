package produto;

public interface Repositorio <T extends Produto>{
	
	public abstract boolean existe(int codigo);
	
	public abstract void inserir(T Produto);
	
	public abstract void atualizar(T Produto);
	
	public abstract void remover(int codigo);
	
	public abstract T procurar(int codigo);
	
}
