package br.unb.cic.poo.MiniHaskell;

import java.util.List;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class AplicacaoDeFuncao implements Expressao{

	private String nome; 
	private List<Expressao> argumentos;
	
	
	public AplicacaoDeFuncao(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.argumentos = argumentos;
	}



	public Valor avaliar() {
		if(checarTipo()) {
			//primeiro passo: empilha um novo ambiente 
			//de execucao. Isso deve ser suficiente para 
			//implementar uma nocao de escopo aninhado. 
			
			
			DecFuncao dec = AmbienteExecucao.getInstance().consultaFuncao(nome);
			
			atualizaAmbiente(dec);
			
			//avaliamos o corpo da funcao no ambiente atual.
			Valor retorno = dec.getCorpo().avaliar(); 
			
			//desempilhamos e retornamos o valor resultante da avaliacao. 
			
			AmbienteExecucao.getInstance().pop();
			
			return retorno;
		}
		else {
			throw new RuntimeException("Erro de tipo");
		}
	}

	
	
	public boolean checarTipo() {
		DecFuncao dec = AmbienteExecucao.getInstance().consultaFuncao(nome);
		
		if(dec == null){
			return false;
		}
		
		atualizaAmbiente(dec);
		
		if(dec.getArgumentos().size() != argumentos.size()){
			return false;
		}
		
		boolean res = dec.getCorpo().checarTipo();
		
		AmbienteExecucao.getInstance().pop();
		
		return res;
	}

	public Tipo tipo() {
		if(checarTipo()){
			DecFuncao dec = AmbienteExecucao.getInstance().consultaFuncao(nome);
			atualizaAmbiente(dec);
			Tipo tipo = dec.getCorpo().tipo();
			AmbienteExecucao.getInstance().pop();
			return tipo;
		}
		
		return Tipo.ERROR;
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
	
	private void atualizaAmbiente(DecFuncao dec) {
		AmbienteExecucao.getInstance().push();
		 
		int i = 0; 
		for(String arg: dec.getArgumentos()) {
			AmbienteExecucao.getInstance().declaraVariavel(arg, argumentos.get(i++));
		}
	}

}
