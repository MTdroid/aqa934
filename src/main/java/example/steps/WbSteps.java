
package example.steps;
import com.codeborne.selenide.SelenideElement;
import example.pages.CityChangePage;

import static com.codeborne.selenide.Condition.*;


public class WbSteps {

    public static void click(SelenideElement element) {

        element.shouldBe(visible,enabled,interactable).click();
    }
    public static void sendKeys(SelenideElement element, String text) {

        element.shouldBe(editable).sendKeys(text);
    }
    public static void hover(SelenideElement element) {

        element.shouldBe(visible,enabled).hover();
    }
    public static void clear(SelenideElement element) {

        element.clear();
    }

}
