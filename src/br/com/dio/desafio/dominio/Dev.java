package br.com.dio.desafio.dominio;

import java.util.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Dev {
	private static int SEQUENCIAL = 1;
	private int id;
    private String nome;
    private Set<Bootcamp> bootcampsInscritos = new LinkedHashSet<>();
    private Set<Bootcamp> bootcampsConcluidos = new LinkedHashSet<>();
    private Map<String, Set<Conteudo>> conteudosInscritos = new HashMap<>();
    private Map<String, Set<Conteudo>> conteudosConcluidos = new HashMap<>();
    
    public Dev(String nome) {
    	this.id = SEQUENCIAL ++;
    	this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
    	this.bootcampsInscritos.add(bootcamp);
        this.conteudosInscritos.putIfAbsent(bootcamp.getNome(), new LinkedHashSet<Conteudo>(bootcamp.getConteudos()));
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(Bootcamp bootcamp) {
    	if (this.bootcampsInscritos.contains(bootcamp)) {
	    	String key = bootcamp.getNome();
	        Set<Conteudo> conteudos = this.conteudosInscritos.get(key);
	        Optional<Conteudo> conteudo = conteudos.stream().findFirst();
	        if(conteudo.isPresent() && conteudos.stream().count() == 1){
	        	this.conteudosConcluidos.get(key).add(conteudo.get());
	        	this.conteudosInscritos.remove(key);
	        	
	        	this.bootcampsConcluidos.add(bootcamp);
	        	this.bootcampsInscritos.remove(bootcamp);
	    	}else if(conteudo.isPresent()) {
	    		if (this.conteudosConcluidos.get(key) != null) {
	    			this.conteudosConcluidos.get(key).add(conteudo.get());
	    			this.conteudosInscritos.get(key).remove(conteudo.get());
	    		} else {
	    			Set<Conteudo> novaLista = new LinkedHashSet<>();
	    			this.conteudosConcluidos.put(key, novaLista);
	    			this.conteudosConcluidos.get(key).add(conteudo.get());
	    			this.conteudosInscritos.get(key).remove(conteudo.get());
	    		}
	        } else {
	            System.err.println("Você não está matriculado em nenhum conteúdo!");
	        }
    	} else {
    		System.out.println(this.getNome() + " já concluiu o bootcamp " + bootcamp.getNome() + ". Para evoluir, progrida em outro bootcamp.");
    	}
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.values()
                .stream()
                .flatMap(Set::stream)
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }


    
}
