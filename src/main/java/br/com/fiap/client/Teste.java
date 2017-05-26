package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


public class Teste {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ExemploJersey").path("exemplows");
		
		Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);
		
		javax.ws.rs.core.Response response = invocationBuilder.get();
		
		String retorno = response.readEntity(String.class);
		
		System.out.println(retorno);

	}

}
