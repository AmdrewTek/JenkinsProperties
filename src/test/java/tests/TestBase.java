package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

  @BeforeAll
  static void beforeAll() {
    Configuration.pageLoadStrategy = "eager";
    Configuration.browser = System.getProperty("browser", "chrome");
    Configuration.browserVersion = System.getProperty("browserVersion", "latest");
    Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
    Configuration.baseUrl = "https://demoqa.com";
    //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    Configuration.remote = System.getProperty("remoteUrl");
    Configuration.timeout = 10000;

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
      "enableVNC", true,
      "enableVideo", true
    ));
    Configuration.browserCapabilities = capabilities;

    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();

    WebDriverRunner.closeWebDriver();
  }

}



