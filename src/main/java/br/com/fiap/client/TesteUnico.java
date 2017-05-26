package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class TesteUnico {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ExemploJersey").path("alunos").path("unico").path("1");
		
		Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		
		javax.ws.rs.core.Response response = invocationBuilder.get();
		
		Aluno a = response.readEntity(Aluno.class);
		
		
		System.out.println("Nome: "+a.getNome());
		System.out.println("Turma: "+a.getTurma());
		System.out.println("Média: "+a.getMedia());
		System.out.println("-----------");		

	}

}
