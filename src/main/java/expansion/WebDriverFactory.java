package expansion;

import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverFactory {

    public static WebDriver get() {
        BaseConfig config = ConfigFactory.create(BaseConfig.class);
        final int WAIT_SECONDS_TIMEOUT = config.waitSecondsTimeOut();

        String browserName = System.getProperty("browser").toLowerCase();
        if (browserName == null) {
            browserName = "chrome";
        }

        WebDriver driver;
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "yandex":
                driver = createYandexDriver();
                break;
            default:
                throw new RuntimeException("Браузера " + browserName + " не существует");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
        return driver;
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        return new ChromeDriver(options);
    }
}
