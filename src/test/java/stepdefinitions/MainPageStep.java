package stepdefinitions;

import example.pages.MainPage;
import example.steps.WbSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MainPageStep {
    @When("Пользователь вводит {string} в строку поиска")
    public void searchProduct(String text) {
        WbSteps.sendKeys(MainPage.searchLine, text);
    }

    @And("Нажимает на кнопку поиска")
    public void searchButtonClick() {
        WbSteps.click(MainPage.searchButton);
    }

    @When("Пользователь нажимает на кнопку 'Фильтры'")
    public void filterButton() {
        WbSteps.click(MainPage.filters);}

    @When("Пользователь нажимает на кнопку “Смена города”")
    public void cityChange() {
        WbSteps.click(MainPage.cityChange);}

    @Then("Проиcходит переход на главную страницу WB")
    public void mainPageIsOpen() {
        Assertions.assertTrue(MainPage.filters.isDisplayed());}

    @Then("В правом верхнем углу над логотипом “Корзина” появилась красная цифра “1”")
    public void cartCounter() {
        Assertions.assertTrue(MainPage.cart.getText().contains("1"));
    }

    @When("Пользователь нажимает на кнопку “Корзина”")
    public void goToCart() {
        WbSteps.click(MainPage.cart);
    }

    @When("Пользователь нажимает на крестик")
    public void clearSearchLine() {
        WbSteps.click(MainPage.clearSearchLine);
    }

    @Then("Поисковая строка становится пустой")
    public void searchLineIsEmpty() {
        Assertions.assertTrue(MainPage.searchLine.getText().isEmpty());
    }

}
