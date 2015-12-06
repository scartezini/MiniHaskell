package br.unb.cic.poo.MiniHaskell;

public class ListaVazia<T extends Expressao> extends Lista<T> {

	public ListaVazia() {
		super(null);
		this.setAnterior(null);
		this.setProximo(null);
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
		return null;
	}

	@Override
	public void remover() {
		
		if(this.anterior() == null){
			try {
				this.finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
