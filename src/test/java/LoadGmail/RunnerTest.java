package LoadGmail;

import org.junit.runner.RunWith;
//import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources"}
		, glue = {"Definitions"}
		)
public class RunnerTest {

}
