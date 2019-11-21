package com.jsystems.qa.qugui.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;

@Tag("FrontTest")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", //scenariusze
        glue = "classpath:com.jsystems.qa.qugui.cucumber", //gdzie jest steps
        plugin = {"html:target/cucumber-html-report","rerun:target/target.txt"}, //pluginy do raportowania
        tags = { //tagi ze scenariuszami z pliku testloginscenario.feature
                "@wordpress"
                //"@login",
                //"@userprofile"
        }
)
public class RunTest {

}
