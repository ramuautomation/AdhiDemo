package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="StepDefinition",
monochrome=true,tags="@Order",plugin={"html:target/index.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	

}
