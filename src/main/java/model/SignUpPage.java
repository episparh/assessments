package model;

import model.data.Identity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import web.PageObjectBase;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage extends PageObjectBase {
    @FindBy(css = "input#form")
    private WebElement btnJoinUs;

    @FindBy(css = "select[name='map(title)']")
    private WebElement selectTitle;

    @FindBy(css = "input[name='map(firstName)']")
    private WebElement inputFirstName;

    @FindBy(css = "input[name='map(lastName)']")
    private WebElement inputLastName;

    @FindBy(css = "select[name='map(dobDay)']")
    private WebElement selectDobDay;

    @FindBy(css = "select[name='map(dobMonth)']")
    private WebElement selectDobMonth;

    @FindBy(css = "select[name='map(dobYear)']")
    private WebElement getSelectDobYear;

    @FindBy(css = "input[name='map(terms)']")
    private WebElement chkTerms;

    @FindBy(css = "label.error")
    private List<WebElement> labelsError;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void populateIdentityData(Identity identity) {
        selectValueInSelectList(selectTitle, identity.getTitle());
        inputFirstName.sendKeys(identity.getFirstName());
        inputLastName.sendKeys(identity.getLastName());
        populateDateOfBirth(identity.getDateOfBirth());
    }

    public void populateDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null) {
            selectValueInSelectList(selectDobDay,
                    String.valueOf(dateOfBirth.getDayOfMonth()));
            selectValueInSelectList(selectDobMonth,
                    capitalizeMonth(String.valueOf(dateOfBirth.getMonth())));
            selectValueInSelectList(getSelectDobYear,
                    String.valueOf(dateOfBirth.getYear()));
        }
    }

    public void acceptTerms(boolean isAccepted){
        if (isAccepted != chkTerms.isSelected()){
            chkTerms.click();
        }
    }
    public void submit() {
        btnJoinUs.click();
    }

    public List<String> getErrorMessages() {
       return  labelsError.stream()
                .map(e -> String.format("Field: %s throw Error: %s",
                        e.getAttribute("for"),
                        e.getText()))
                .collect(Collectors.toList());
    }

    private void selectValueInSelectList(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    private String capitalizeMonth(String month) {
        return month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
    }

}
