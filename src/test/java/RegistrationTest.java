import com.github.javafaker.Faker;
import config.BaseConfig;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import pages.LoginPage;
import pages.RegistrationPage;
import web_api_clients.UserClient;
import java.time.Duration;

import static org.junit.Assert.*;

public class RegistrationTest extends BaseTest {

    public RegistrationPage registrationPage;
    private LoginPage loginPage;

    Faker faker = new Faker();
    BaseConfig config = ConfigFactory.create(BaseConfig.class);
    private final String REGISTRATION_URL = config.registrationURL();

    @Before
    public void setUp() {
        super.setup(REGISTRATION_URL);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Регистрация пользователя")
    public void registrationUser() {
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        boolean actual = loginPage.isTitleEnterDisplayed();
        assertTrue("Пользователь зарегистрирован", actual);

        UserClient userClient = new UserClient();
        ValidatableResponse responseLogin = userClient.login(user);
        String accessToken = responseLogin.extract().path("accessToken");
        userClient.delete(accessToken);
    }

    @Test
    @DisplayName("Регистрация пользователя c невалидным паролем")
    public void registrationUserWithInvalidPassword() {
        registrationPage.register(user.getName(), user.getEmail(), faker.internet().password(1,5));
        boolean actual = registrationPage.isMessageIncorrectPasswordDisplayed();
        assertTrue("Пользователь зарегистрирован", actual);
    }

    @After
    public void tearDown() {
        super.tearDown();
    }
}
