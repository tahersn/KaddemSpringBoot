package Configuration;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI(){
        return new Info()
                .title("SpringDoc-Demo")
                .description("TP étude de cas").
                contact(contactAPI());
    }
    public Contact contactAPI(){
        Contact contact = new Contact()

                .name("ntore equipe")
                .email("notreEquipe@esprit.tn");
         return contact ;
    }
    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()

                .group("Only Product Management API")

                                .pathsToMatch("/product/**")
                                .pathsToExclude("**")
                                .build();

    }
}
