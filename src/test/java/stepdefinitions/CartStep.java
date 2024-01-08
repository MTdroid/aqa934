package stepdefinitions;

import com.codeborne.selenide.Selenide;
import example.pages.SearchingResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;

public class CartStep {

    @Then("Текст и цена товара соответствует цене и названию товара со страницы результатов поиска")
    public void ProductNameAndPrice() {
        Selenide.sleep(500);
        Assertions.assertEquals(SearchingResultsPage.firstProductName.getText(), example.pages.CartPage.name.getText());}

    @And("“Итого” = сумме товара")
    public void totalPriceEqualProductPrice() {
        Selenide.sleep(500);
        Assertions.assertEquals(example.pages.CartPage.totalPrice.shouldBe(visible).getText(), (example.pages.CartPage.price.shouldBe(visible).getText()));}

    @And("Кнопка “Заказать” активна для нажатия")
    public void orderButtonIsEnabled() {
        Assertions.assertTrue(example.pages.CartPage.orderButton.isEnabled());
    }

}
