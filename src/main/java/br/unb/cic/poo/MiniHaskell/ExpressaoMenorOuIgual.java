package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ExpressaoMenorOuIgual extends ExpressaoBinInt{

	public ExpressaoMenorOuIgual(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public Valor avaliar(Integer x, Integer y) {
		return new ValorBooleano(x <= y);
	}
	
	

}
