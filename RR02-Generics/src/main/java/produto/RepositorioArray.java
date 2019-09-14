package produto;

public abstract class RepositorioArray implements Repositorio <Produto>{
	private Produto[] produtos;
	private int index = -1;
	
	public RepositorioArray(int size) {
		this.produtos = new ProdutoNaoPerecivel[size];
	}
	
	public int procurarIndice(int codigo) {
		int index = -1;
		for(int i = 0; i < this.produtos.length && index == -1; i++) {
			if(this.produtos[i].getCodigo() == codigo) index = i;
		}
		
		return index;
	}
	
	public boolean existe(int codigo) {
		if(procurarIndice(codigo) == -1) return false;
		else return true;
		
	}

	public void inserir(Produto produto) {
		index++;
		if(produto instanceof Produto && index < this.produtos.length) {
			this.produtos[index] = produto;
		} else throw new ArrayIndexOutOfBoundsException();
	}

	public void atualizar(Produto produto) {
		if(produto instanceof Produto) {
			int i = 0; boolean flag = false;
			while(i < this.produtos.length && !flag) {
				if(this.produtos[i].getCodigo() == produto.getCodigo()) {
					this.produtos[i] = produto;
					flag = true;
				}
				
				i++;
			}
				
				if(!flag) throw new NullPointerException("Produto nao existe.");
		} else throw new IllegalArgumentException("Nao eh um produto.");
	}

	public void remover(int codigo) {
		int i = this.procurarIndice(codigo);
		if (i != -1) {
			produtos[i] = produtos[index];
			produtos[index] = null;
			index--;
		} else {
			throw new RuntimeException("Produto nao existe.");
		}
	}

	public Produto procurar(int codigo) {
		int ind = this.procurarIndice(codigo);
		
		Produto produto = null;
		
		if(index != -1) {
			produto = this.produtos[ind];
		} else throw new NullPointerException("Produto nao existe.");
			
			return produto;	
		}
}
