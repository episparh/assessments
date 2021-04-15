import model.SignUpPage;
import model.TopNavigationMenu;
import model.data.Identity;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpTest extends TestBase {
    TopNavigationMenu topNav;
    SignUpPage signUpPage;
    SoftAssertions softAssertions;


    @BeforeEach
    public void initializeTest() {
        topNav = new TopNavigationMenu(driver);
        signUpPage = new SignUpPage(driver);
        softAssertions = new SoftAssertions();
    }


    @Test
    public void verify_errorMessageIsDisplayed_ifMandatoryFieldIsEmpty() {
        Identity identity = new Identity("Mr",
                "TestFirstName",
                "TestLastName",
                null);

        topNav.openSignUpPage();
        signUpPage.populateIdentityData(identity);
        signUpPage.acceptTerms(true);
        signUpPage.submit();
        List<String> errors = signUpPage.getErrorMessages();
        softAssertions.assertThat(errors.size()).isEqualTo(17);
        softAssertions.assertThat(errors).allMatch(s -> s.contains("This field is required"));
        softAssertions.assertAll();
    }
}
