package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"featureFile/1Testbook_login.feature","featureFile/3Testbook_getpass.feature"
				,"featureFile/4Testbook_logout.feature"} // which feature files to run
		,glue={"stepDefinition","base"}				                                                //package names having the scripts for the feature file &base for junit sirf ff for testng
		,tags= {"@Login, @Valid, @Testbook_3, @Testbook_4"}			                // the tags to run.... which are in feature file		
		)

public class testRunner1 extends AbstractTestNGCucumberTests {} 

/*"featureFile/1Testbook_login.feature","featureFile/2Testbook_liveclass.feature",
"featureFile/3Testbook_getpass.feature","featureFile/4Testbook_logout.feature"
 
@Login, @Valid, @Testbook_2, @Testbook_3, @Testbook_4*/