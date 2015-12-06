package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ListaTeste extends TestCase{
	
	public void testeAdicionar(){
		Lista<ValorInteiro> lista = new ListaVazia<ValorInteiro>();
		
		Lista<ValorInteiro> list2 = lista.adicionar(new ValorInteiro(3));
		
		ValorInteiro res = list2.recuperar();
		assertEquals(new Integer(3), res.getValor());
		
		list2 = list2.adicionar(new ValorInteiro(5));
		
		res = list2.recuperar();
		assertEquals(new Integer(5), res.getValor());
		
		res = list2.proximo().recuperar();
		assertEquals(new Integer(3), res.getValor());
		
		res = (ValorInteiro)list2.proximo().proximo().recuperar();
		assertEquals(null, res);
		
	}
	
	public void testeListaExpressao(){
		
		Lista<ExpressaoSoma> lista = new ListaVazia<ExpressaoSoma>();
		
		ExpressaoSoma soma = new ExpressaoSoma(new ValorInteiro(3), new ValorInteiro(5));
		
		Lista<ExpressaoSoma> list2 = lista.adicionar(soma);
		
		ExpressaoSoma rec = list2.recuperar();
		ValorInteiro resp = (ValorInteiro) list2.avaliar();
		
		assertEquals(soma, rec);
		assertEquals(new Integer(8), resp.getValor());
		
		
		ExpressaoSoma soma2 = new ExpressaoSoma(new ValorInteiro(10), new ValorInteiro(21));
		list2 = list2.adicionar(soma2);
		
		rec = list2.recuperar();
		resp = (ValorInteiro) list2.avaliar();
		
		assertEquals(soma2, rec);
		assertEquals(new Integer(31), resp.getValor());
		
		
		
		rec = list2.proximo().recuperar();
		resp = (ValorInteiro) list2.proximo().avaliar();
		
		assertEquals(soma, rec);
		assertEquals(new Integer(8), resp.getValor());
		
		assertEquals(2, list2.size());
	}
	
	
	public void testeRemover(){
		Lista<ValorInteiro> lista = new ListaVazia<ValorInteiro>();
		Lista<ValorInteiro> lista2 = lista.adicionar(new ValorInteiro(2));
		Lista<ValorInteiro> lista3 = lista2.adicionar(new ValorInteiro(3));
		Lista<ValorInteiro> lista4 = lista3.adicionar(new ValorInteiro(4));
		
		
		assertEquals(lista, lista4.proximo().proximo().proximo());
		
		lista.remover();
		assertEquals(lista, lista4.proximo().proximo().proximo());
		assertEquals(lista3, lista2.anterior());
		
		lista3.remover();
		assertEquals(lista2, lista4.proximo());
		assertEquals(lista4, lista2.anterior());
		
		lista4.remover();
		assertNull(lista2.anterior());
		
		lista2.remover();
		assertNull(lista.anterior());
		
		lista.remover();
		
	}

}
