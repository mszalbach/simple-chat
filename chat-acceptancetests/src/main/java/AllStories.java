import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by foobar on 15.05.15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        tags = {"~@Ignore"} //so @Ignore can be used to disable Scenarios
)

public class AllStories {
}
