package core;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        this.driver = new FirefoxDriver();
    }
}
