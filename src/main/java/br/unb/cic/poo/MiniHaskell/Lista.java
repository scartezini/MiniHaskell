package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public abstract class Lista<T extends Expressao> implements Expressao{
	
	private T elemento;
	private Lista<T> proximo;
	private Lista<T> anterior;
	
	public abstract Lista<T> adicionar(T elemento);
	public abstract T recuperar();
	public abstract void remover();
	
	public int size(){
		int size = 0;
		Lista<?> aux = this;
		
		while(!(aux instanceof ListaVazia<?>)){
			size++;
			aux = aux.getProximo();
		}
		
		return size;		
	}
	
	
	
	
	
	protected Lista(T elemento) {
		this.elemento = elemento;
	}
	
	protected T getElemento() {
		return elemento;
	}
	protected void setElemento(T elemento) {
		this.elemento = elemento;
	}
	
	protected Lista<T> getProximo() {
		return proximo;
	}
	
	protected void setProximo(Lista<T> proximo) {
		this.proximo = proximo;
	}
		
	
	protected Lista<T> getAnterior() {
		return anterior;
	}
	protected void setAnterior(Lista<T> anterior) {
		this.anterior = anterior;
	}
	
	
	
	
	public Lista<T> proximo(){
		return getProximo();
	}
	
	public Lista<T> anterior(){
		return getAnterior();
	}

	
	
	
	public Valor avaliar() {
		return elemento.avaliar();
	}
	
	public boolean checarTipo() {
		return elemento.checarTipo();
	}
	public Tipo tipo() {
		return elemento.tipo();
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
}
