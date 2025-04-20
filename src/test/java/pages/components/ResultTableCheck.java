package pages.components;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class ResultTableCheck {
    private final SelenideElement results = $(".table-responsive");

    public ResultTableCheck checkResult(String key, String value) {
        results.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }


}
