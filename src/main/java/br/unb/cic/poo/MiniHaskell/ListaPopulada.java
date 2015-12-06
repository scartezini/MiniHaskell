package br.unb.cic.poo.MiniHaskell;



public class ListaPopulada<T extends Expressao> extends Lista<T> {
	
	
	protected ListaPopulada(T elemento) {
		super(elemento);
	}

	@Override
	public Lista<T> adicionar(T elemento) {
		Lista<T> nova = new ListaPopulada<T>(elemento);
		nova.setAnterior(null);
		nova.setProximo(this);
		this.setAnterior(nova);
		return nova;
	}

	@Override
	public T recuperar() {
		return this.getElemento();
	}

	@Override
	public void remover() {
		if(this.anterior() != null){
			this.anterior().setProximo(this.proximo());
		}
		
		this.proximo().setAnterior(this.anterior());
		
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	
}
