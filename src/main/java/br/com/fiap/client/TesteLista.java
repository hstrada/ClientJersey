package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.filter.HttpBasicAuthFilter;


public class TesteLista {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		client.register(new HttpBasicAuthFilter("fabio", "123"));
		
		WebTarget webTarget = client.target("http://localhost:8080/ExemploJersey").path("alunos");
		
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		
		javax.ws.rs.core.Response response = invocationBuilder.get();
		
		Aluno[] alunos = response.readEntity(Aluno[].class);
		
		for(Aluno a: alunos){
			System.out.println("Nome: "+a.getNome());
			System.out.println("Turma: "+a.getTurma());
			System.out.println("Média: "+a.getMedia());
			System.out.println("-----------");
		}

	}

}
