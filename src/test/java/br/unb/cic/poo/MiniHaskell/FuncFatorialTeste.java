package br.unb.cic.poo.MiniHaskell;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class FuncFatorialTeste extends TestCase {
	public void setUp() {
		
		String nome = "fatorial";
		List<String> argumentos = new ArrayList<String>();
		argumentos.add("x");
		
		List<Expressao> argumentos2 = new ArrayList<Expressao>();
		argumentos2.add(new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(-1)));
		
		Expressao corpo = new IfThenElse(
				new ExpressaoMaiorOuIgual(new ExpRef("x"), new ValorInteiro(1))
				, new AplicacaoDeFuncao("fatorial", argumentos2)
				, new ExpressaoMult(new ExpRef("x"), new ValorInteiro(1)));
	
		
		
		DecFuncao dec = new DecFuncao(nome, argumentos, corpo);
		
		AmbienteExecucao.getInstance().declaraFuncao(dec);
	}
	public void testeFuncFataorial(){
		List<Expressao> argumentos = new ArrayList<Expressao>();
		
		argumentos.add(new ValorInteiro(4));
		AplicacaoDeFuncao aplicacaoDeFuncao = new AplicacaoDeFuncao("fatorial", argumentos);
		
		assertTrue(aplicacaoDeFuncao.checarTipo());
		assertEquals(Tipo.INTEIRO, aplicacaoDeFuncao.tipo());
		
		ValorInteiro valor = (ValorInteiro) aplicacaoDeFuncao.avaliar();
		System.out.println(valor.getValor());
		
	}

}
