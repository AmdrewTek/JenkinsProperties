package tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextBoxTest extends TestBase {
  private static final Logger log = LoggerFactory.getLogger(TextBoxTest.class);
  TextBoxPage textBoxPage = new TextBoxPage();

  @Test
  void textBoxTest() {
    textBoxPage.openPage()
      .setUserName("Andrew")
      .setEmail("123@g.com")
      .setCurrentAdres("Moscow")
      .setPermamentAdres("Moscow")
      .submit();
    textBoxPage.outputCheck("Name:Andrew")
      .outputCheck("Email:123@g.com")
      .outputCheck("Current Address :Moscow")
      .outputCheck("Permananet Address :Moscow");

  }


}
