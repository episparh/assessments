import core.DriverManagerFactory;
import core.DriverType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class TestBase {
    public static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = DriverManagerFactory.getDriverManager(DriverType.CHROME).getWebDriver();
        driver.get("https://moneygaming.qa.gameaccount.com");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    public static class SignUpTest extends TestBase {
    }
}
