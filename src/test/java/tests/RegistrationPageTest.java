package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.components.ResultTableCheck;
import pages.registrationpage.RegistrationPage;
import utils.FakeData;


public class RegistrationPageTest extends TestBase {
  RegistrationPage registrationPage = new RegistrationPage();
  FakeData fakeData = new FakeData();
  ResultTableCheck resultCheck = new ResultTableCheck();

  @Test
  @Tag("Full_registration_test")
  void registrationPageFullTest() {
    registrationPage.openPage()
      .closeBanner()
      .setFirstName(fakeData.getRandomFirstName())
      .setLastName(fakeData.getRandomLastName())
      .setEmail(fakeData.getRandomEmail())
      .setGender(fakeData.getRandomGender())
      .setUserNumber(fakeData.getRandomPhoneNumber())
      .setDateOfBirth(
        fakeData.getRandomDayOfBirth(),
        fakeData.getRandomMonthOfBirth(),
        fakeData.getRandomYearOfBirth()
      )
      .setSubjectInput(fakeData.getRandomSubject())
      .setHobbies(fakeData.getRandomHobbies())
      .selectUploadPicture(fakeData.getRandomPicture())
      .setAddress(fakeData.getRandomAddress())
      .setState(fakeData.getRandomState())
      .setCity(fakeData.getRandomCity())
      .clickSubmit();
    resultCheck.checkResult(
      "Student Name",
        fakeData.name + " " + fakeData.lastName
      )
      .checkResult("Student Email", fakeData.email)
      .checkResult("Gender", fakeData.gender)
      .checkResult("Mobile", fakeData.phoneNumber)
      .checkResult(
        "Date of Birth",
        fakeData.dayOfBirth +
          " " + fakeData.monthOfBirth +
          "," + fakeData.yearOfBirth
      )
      .checkResult("Subjects", fakeData.subject)
      .checkResult("Hobbies", fakeData.hobbies)
      .checkResult("Picture", fakeData.picture)
      .checkResult("Address", fakeData.address)
      .checkResult("State and City",
        fakeData.state + " " + fakeData.city
      );
  }

  @Test
  @Tag("Minimal_registration_test")
  void registrationPageMinimalTest() {
    registrationPage.openPage()
      .closeBanner()
      .setFirstName(fakeData.getRandomFirstName())
      .setLastName(fakeData.getRandomLastName())
      .setGender(fakeData.getRandomGender())
      .setUserNumber(fakeData.getRandomPhoneNumber())
      .clickSubmit();
    resultCheck.checkResult(
      "Student Name",
        fakeData.name + " " + fakeData.lastName
      )
      .checkResult("Gender", fakeData.gender)
      .checkResult("Mobile", fakeData.phoneNumber);
  }

  @Test
  @Tag("Negative_test")
  void negativeTest() {
    registrationPage.openPage()
      .closeBanner()
      .setFirstName("")
      .clickSubmit()
      .checkFirstNameColorInput();
  }
}
