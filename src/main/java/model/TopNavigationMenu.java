package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.PageObjectBase;

public class TopNavigationMenu extends PageObjectBase {
    @FindBy(css = ".login_links a.newUser")
    private WebElement btnJoinNow;

    public TopNavigationMenu(WebDriver driver) {
        super(driver);
    }

    public void openSignUpPage(){
        btnJoinNow.click();
    }
}
