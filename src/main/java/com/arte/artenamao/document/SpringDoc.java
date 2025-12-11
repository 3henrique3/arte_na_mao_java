package com.arte.artenamao.document;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDoc {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("API da Arte na Mão")
                        .description("""
                                A API de Arte na Mão oferece um conjunto abrangente de funcionalidades para 
                                o gerenciamento de do sistema, autores, editoras e resumos. O sistema permite 
                                cadastro, atualização, listagem, busca por IDs e exclusão de registros.
                                """)
                        .contact(new Contact()
                                .name("Equipe de Desenvolvimento – Eduardo Henrique, Pedro Henrique e Wyldson Marllon.")
                                .email("suporte@artenamao.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://artenamao.com/api/licenca"))
                )
                .components(new Components());
    }
}

