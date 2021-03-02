package my.compary.service;

import com.github.javafaker.Faker;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.ACCEPTED;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

@QuarkusTest
class PessoaControllerTest {

    private Faker faker;

    @BeforeEach
    public void setUp() {
        this.faker = new Faker();
    }

    @Test
    public void shouldInsert() {
        Pessoa pessoa = getPessoa();
        pessoa.persist();
        Assertions.assertNotNull(pessoa);
    }



    private Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.nome = (faker.name().firstName());
        pessoa.email = faker.bothify("????##@gmail.com");
        pessoa.telefone = faker.phoneNumber().cellPhone();
        pessoa.endereco = faker.address().cityName();
        pessoa.senha = faker.number().digits(3);
        return pessoa;
    }
}