package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OutputFormComponent {

    public void checkField(String key, String value) {
        $("#output" + " #" + key).shouldHave(text(value));
    }

}
