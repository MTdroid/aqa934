package example.pages;

import com.codeborne.selenide.SelenideElement;
import example.steps.WbSteps;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class CityChangePage {

    public static SelenideElement searchLine = $x("//input[@class='ymaps-2-1-79-searchbox-input__input']");
    public static SelenideElement pickAddress = $x("//span[@class='address-item__name-text'][1]");
    public static SelenideElement searchButton = $x("//ymaps[@class='ymaps-2-1-79-searchbox-button-text']");
    public static SelenideElement pick = $x("//button[@data-link='{on ~root.settings.onPooSelect #data}disabled{:~root.settings.currentAddressId == id}']");
    public static SelenideElement pickPointInfo = $x("//h3[@class='details-self__title']");

    public CityChangePage changeCity(String value) {

        WbSteps.sendKeys(searchLine, value);
        WbSteps.click(searchButton);
        pickAddress.shouldHave(text(value));
        WbSteps.click(pickAddress);

        return this;
    }

    public CityChangePage pickAddress() {

        WbSteps.click(pick);

        return this;
    }
    public String getAddress() {
        return CityChangePage.pickAddress.text();
    }
}

