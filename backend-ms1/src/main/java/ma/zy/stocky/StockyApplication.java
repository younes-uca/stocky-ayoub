package  ma.zy.stocky;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;
import com.fasterxml.jackson.databind.SerializationFeature;


import ma.zy.stocky.zynerator.security.common.AuthoritiesConstants;
import ma.zy.stocky.zynerator.security.bean.User;
import ma.zy.stocky.zynerator.security.bean.Permission;
import ma.zy.stocky.zynerator.security.bean.Role;
import ma.zy.stocky.zynerator.security.service.facade.UserService;
import ma.zy.stocky.zynerator.security.service.facade.RoleService;

//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableElasticsearchRepositories("ma.zy.stocky.dao")
//@EnableFeignClients("ma.zy.stocky.required.facade")
public class StockyApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(StockyApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("CategorieProduit.edit"));
        permissions.add(new Permission("CategorieProduit.list"));
        permissions.add(new Permission("CategorieProduit.view"));
        permissions.add(new Permission("CategorieProduit.add"));
        permissions.add(new Permission("CategorieProduit.delete"));
        permissions.add(new Permission("Marque.edit"));
        permissions.add(new Permission("Marque.list"));
        permissions.add(new Permission("Marque.view"));
        permissions.add(new Permission("Marque.add"));
        permissions.add(new Permission("Marque.delete"));
        permissions.add(new Permission("InventaireItem.edit"));
        permissions.add(new Permission("InventaireItem.list"));
        permissions.add(new Permission("InventaireItem.view"));
        permissions.add(new Permission("InventaireItem.add"));
        permissions.add(new Permission("InventaireItem.delete"));
        permissions.add(new Permission("Collaborateur.edit"));
        permissions.add(new Permission("Collaborateur.list"));
        permissions.add(new Permission("Collaborateur.view"));
        permissions.add(new Permission("Collaborateur.add"));
        permissions.add(new Permission("Collaborateur.delete"));
        permissions.add(new Permission("EntreeProduit.edit"));
        permissions.add(new Permission("EntreeProduit.list"));
        permissions.add(new Permission("EntreeProduit.view"));
        permissions.add(new Permission("EntreeProduit.add"));
        permissions.add(new Permission("EntreeProduit.delete"));
        permissions.add(new Permission("EntreeProduitItem.edit"));
        permissions.add(new Permission("EntreeProduitItem.list"));
        permissions.add(new Permission("EntreeProduitItem.view"));
        permissions.add(new Permission("EntreeProduitItem.add"));
        permissions.add(new Permission("EntreeProduitItem.delete"));
        permissions.add(new Permission("SortieProduitItem.edit"));
        permissions.add(new Permission("SortieProduitItem.list"));
        permissions.add(new Permission("SortieProduitItem.view"));
        permissions.add(new Permission("SortieProduitItem.add"));
        permissions.add(new Permission("SortieProduitItem.delete"));
        permissions.add(new Permission("Fournisseur.edit"));
        permissions.add(new Permission("Fournisseur.list"));
        permissions.add(new Permission("Fournisseur.view"));
        permissions.add(new Permission("Fournisseur.add"));
        permissions.add(new Permission("Fournisseur.delete"));
        permissions.add(new Permission("Depot.edit"));
        permissions.add(new Permission("Depot.list"));
        permissions.add(new Permission("Depot.view"));
        permissions.add(new Permission("Depot.add"));
        permissions.add(new Permission("Depot.delete"));
        permissions.add(new Permission("Produit.edit"));
        permissions.add(new Permission("Produit.list"));
        permissions.add(new Permission("Produit.view"));
        permissions.add(new Permission("Produit.add"));
        permissions.add(new Permission("Produit.delete"));
        permissions.add(new Permission("Stock.edit"));
        permissions.add(new Permission("Stock.list"));
        permissions.add(new Permission("Stock.view"));
        permissions.add(new Permission("Stock.add"));
        permissions.add(new Permission("Stock.delete"));
        permissions.add(new Permission("Inventaire.edit"));
        permissions.add(new Permission("Inventaire.list"));
        permissions.add(new Permission("Inventaire.view"));
        permissions.add(new Permission("Inventaire.add"));
        permissions.add(new Permission("Inventaire.delete"));
        permissions.add(new Permission("SortieProduit.edit"));
        permissions.add(new Permission("SortieProduit.list"));
        permissions.add(new Permission("SortieProduit.view"));
        permissions.add(new Permission("SortieProduit.add"));
        permissions.add(new Permission("SortieProduit.delete"));
    }

}


