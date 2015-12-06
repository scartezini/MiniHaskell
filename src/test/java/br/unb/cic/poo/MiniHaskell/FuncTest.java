package br.unb.cic.poo.MiniHaskell;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class FuncTest extends TestCase {
	public void setUp() {
		/* 
		 * antes da chamada de cada metodo, inicializa as 
		 * declaracoes de funcoes. para os testes, apenas 
		 * a declaracao da seguinte funcao eh implementada:
		 *  inc :: Int -> Int
		 *  inc x = x + 1
		 *  
		 *  ou, em uma linguagem imperativa int inc(int x) { return x + 1; }
		 *  
		 * essa declaracao instancia uma funcao de nome "inc", com um 
		 * argumento "x" de tipo Inteiro e um corpo como uma Expressao 
		 * do tipo Soma, cujo primeiro componente eh uma referencia a "x" e 
		 * o segundo eh o valor inteiro.
		 */
		String nome = "inc";
		List<String> argumentos = new ArrayList<String>();
		argumentos.add("x");
		
		Expressao corpo = new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(1));
		DecFuncao dec = new DecFuncao(nome, argumentos, corpo);
		
		AmbienteExecucao.getInstance().declaraFuncao(dec);
	}
	
	public void testeFuncaoInc() {
		List<Expressao> argumentos = new ArrayList<Expressao>();
		
		argumentos.add(new ValorInteiro(5));
		AplicacaoDeFuncao aplicacaoDeFuncao = new AplicacaoDeFuncao("inc", argumentos);
		
		assertTrue(aplicacaoDeFuncao.checarTipo());
		assertEquals(Tipo.INTEIRO, aplicacaoDeFuncao.tipo());
		
		ValorInteiro valor = (ValorInteiro) aplicacaoDeFuncao.avaliar();
		
		assertEquals(new Integer(6), valor.getValor());
	}
	
	public void testeFuncaoNaoDeclarada(){
		List<Expressao> argumentos = new ArrayList<Expressao>();
		
		argumentos.add(new ValorInteiro(5));
		argumentos.add(new ExpressaoSoma(new ValorInteiro(5), new ValorInteiro(3)));
		
		AplicacaoDeFuncao aplicacaoDeFuncao = new AplicacaoDeFuncao("f", argumentos);
		
		assertFalse(aplicacaoDeFuncao.checarTipo());
		assertEquals(Tipo.ERROR, aplicacaoDeFuncao.tipo());
	}
}
