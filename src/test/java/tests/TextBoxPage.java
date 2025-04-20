package tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit"),
            output = $("#output");

    public TextBoxPage openPage(){
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");//Закрывают баннеры
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public TextBoxPage setUserName(String value){
        userNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAdres(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage setPermamentAdres(String value){
        permanentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage outputCheck (String value){
        output.shouldHave(text(value));
        return this;
    }
    public void submit(){
        submit.click();
    }


}
