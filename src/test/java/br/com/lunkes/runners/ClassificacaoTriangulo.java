package br.com.lunkes.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue= {"br.com.lunkes.steps"}
)
public class ClassificacaoTriangulo {

}
