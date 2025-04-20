package properties.tests;


import org.junit.jupiter.api.Test;

public class JenkinsProperties {

  @Test
  void getJenkinsPropertiesTest() {
    System.out.println("Browser: " + System.getProperty("browser", "chrome"));
    System.out.println("Browser version: " + System.getProperty("browserVersion", "128.0"));
    System.out.println("Browser size: " + System.getProperty("browserSize", "1920x1080"));
    System.out.println("Remote URL: " + System.getProperty("remoteUrl"));
  }
}