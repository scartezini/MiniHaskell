package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.AplicacaoDeFuncao;
import br.unb.cic.poo.MiniHaskell.ExpRef;
import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoMaiorOuIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMenorOuIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMult;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.Lista;
import br.unb.cic.poo.MiniHaskell.ListaVazia;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
import br.unb.cic.poo.MiniHaskell.ValorInteiro;

public class PrettyPrinter implements Visitor {

	String res = "";
	
	public String getRes() {
		return res;
	}
	
	public void visitar(ValorInteiro exp) {
		res += exp.getValor();
	}

	public void visitar(ValorBooleano exp) {
		res += exp.getValor();
	}

	public void visitar(ExpressaoSoma exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " + ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(IfThenElse exp) {
		res += "if(";
		exp.condicao().aceitar(this);
		res += ")";
		res += " then {";
		exp.expThen().aceitar(this);
		res += " } else {";
		exp.expElse().aceitar(this);
		res += "}";
	}

	public void init() {
		res = "";
	}

	public void visitar(ExpressaoLet exp) {
		res += "let ";
		res += exp.getId();
		res += " = ";
		exp.atribuicao().aceitar(this);
		res += " in ";
		exp.corpo().aceitar(this);
		
	}

	public void visitar(Lista<?> exp) {
		
		Lista<?> aux = exp;
		
		while(!(aux instanceof ListaVazia<?>)){
			aux.recuperar().aceitar(this);
			res += " -> ";
			aux = aux.proximo();
		}
		res += "null";
	}

	public void visitar(ExpressaoMult exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " * ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(ExpRef exp) {
		res += exp.getId();
	}

	public void visitar(ExpressaoMaiorOuIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " >= ";
		exp.rhs().aceitar(this);
		res += ")";
		
	}

	public void visitar(ExpressaoMenorOuIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " <= ";
		exp.rhs().aceitar(this);
		res += ")";
		
	}

	public void visitar(AplicacaoDeFuncao exp) {
		// TODO Auto-generated method stub
		
	}

}
