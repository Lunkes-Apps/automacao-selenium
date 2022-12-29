package br.com.lunkes.steps;

import br.com.lunkes.pages.TrianguloPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ClassificacaoTrianguloSteps {

    private TrianguloPage trianguloPage = new TrianguloPage();

    @Given("que estou na tela principal")
    public void que_estou_na_tela_principal() {
        trianguloPage.vaiParaPaginaTriangulo();
    }

    @When("informo os vértices {string}, {string} e {string}")
    public void informo_os_vertices(String verticeUm, String verticeDois, String verticeTres) {
        trianguloPage.inserirVerticeUm(verticeUm)
                .inserirVerticeDois(verticeDois)
                .inserirVerticeTres(verticeTres);
    }

    @When("clico no botao identificar")
    public void clico_no_botao_identificar() {
        trianguloPage.clicarNoBotaoIdentificar();
    }

    @Then("é informado que se trata de um triângulo {string}")
    public void e_informado_que_se_trata_de_um_triangulo(String tipoTriangulo) {
        String resposta = trianguloPage.respostaTipoTriangulo();
        Assert.assertEquals(tipoTriangulo, resposta);
    }

    @Then("deve ser informado que o triangulo não é possível")
    public void deve_ser_informado_que_o_triangulo_não_é_possível() {
        String resposta = trianguloPage.respostaTipoTriangulo();
        Assert.assertEquals("Triângulo não é possível", resposta);
    }


}
