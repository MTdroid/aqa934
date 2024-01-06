package stepdefinitions;

import example.pages.CartPage;
import example.pages.MainPage;
import example.pages.SearchingResultsPage;
import example.steps.WbSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddToCartStep {

    @And("Добавляет первый товар в корзину")
public void addToCart() {
    WbSteps.hover(SearchingResultsPage.firstProduct);
    WbSteps.click(SearchingResultsPage.firstProductAddToCart);
    WbSteps.click(MainPage.cart);}

    @And("Переходит в корзину")
    public void goToCart() {
        WbSteps.click(MainPage.cart);
    }

    @Then("В корзине находится товар {string}")
    public void confirmProduct(String text) {
        CartPage.name.getText().contains(text);
    }

}
