/*
 * Esta clase se encarga de configurar la documentacion interactiva OpenAPI 3 (Swagger UI) para la API REST del sistema VetTurno.
 * Los datos provienen de los controladores y DTOs expuestos y van hacia la interfaz web de Swagger UI.
 */
package com.veterinaria.vetturno.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI personalizarOpenAPI() {
        final String securitySchemeName = "BearerAuth";

        return new OpenAPI()
                .info(new Info()
                        .title("VetTurno - Veterinaria Huellitas")
                        .description("API REST para la gestion y agendamiento de citas sin cruces de horario.")
                        .version("1.0.0")
                )
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                );
    }
}
