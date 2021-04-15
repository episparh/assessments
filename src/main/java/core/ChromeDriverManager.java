package core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {

        ChromeOptions capabilities = new ChromeOptions();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type", "start-maximized", "no-default-browser-check");
        // the next one prevents popping up the developer mode extension
        options.addArguments("chrome.switches", "--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        this.driver = new ChromeDriver(options);
    }
}
