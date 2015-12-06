package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public abstract class ExpressaoBinBoo extends ExpressaoBin{

	public ExpressaoBinBoo(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	public Valor avaliar() {
		Valor x = lhs.avaliar();
		Valor y = rhs.avaliar();
		if ((x instanceof ValorBooleano) && (y instanceof ValorBooleano)) {

			boolean x1 = ((ValorBooleano) x).getValor();
			boolean y1 = ((ValorBooleano) y).getValor();

			return avaliar(x1, y1);
		} else {
			throw new RuntimeException("erro de tipos");
		}
	}

	public boolean checarTipo() {
		if(lhs.tipo().equals(Tipo.BOOL) && rhs.tipo().equals(Tipo.BOOL)) {
			return true;
		}
		return false;
	}

	public Tipo tipo() {
		if(checarTipo()) {
			return Tipo.BOOL;
		}
		return Tipo.ERROR;
	}

	public void aceitar(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
	public abstract Valor avaliar(boolean x, boolean y);
	

}
