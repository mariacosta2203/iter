package com.generation.iter.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	
	 @Bean
	    public OpenAPI springIterOpenAPI() {
	        return new OpenAPI()
	            .info(new Info()
	                .title("Iter")
	                .description("Iter - Generation Brasil")
	                .version("v0.0.1")
	                .license(new License()
	                    .name("Grupo 03 - Turma 79")
	                    .url("https://brazil.generation.org/"))
	                .contact(new Contact()
	                    .name("Grupo 03 - Turma 79")
	                    .url("https://github.com/mariacosta2203/iter.git")
	                    .email("Adelina Santos / adevitoria.m09@gmail.com "
	                    		+ " Maria Oliveira / maria.oliveiracosta13@gmaill.com"
	                    		+ "Beatriz Borges / bia4sb4@gmail.com "
	                    		+ "Otavio Ferreira / otavinhosilva321@gmail.com"
	                    		+ "Denner dos Anjos denner.a.moura.s@gmail.com"
	                    		+ "Lucas Pimentel - lucaspimentel760@gmail.com")))
	            .externalDocs(new ExternalDocumentation()
	                .description("Github")
	                .url("https://github.com/mariacosta2203/iter.git"));
	    }
	    
	    @Bean
	    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
	        return openApi -> {
	            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations()
	                .forEach(operation -> {
	                    ApiResponses apiResponses = operation.getResponses();
	                    apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
	                    apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
	                    apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
	                    apiResponses.addApiResponse("400", createApiResponse("Erro Na Requisição!"));
	                    apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
	                    apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
	                    apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
	                    apiResponses.addApiResponse("500", createApiResponse("Erro Na Aplicação!"));
	                }));
	        };
	    }

	    private ApiResponse createApiResponse(String message) {
	        return new ApiResponse().description(message);
	    }


}
