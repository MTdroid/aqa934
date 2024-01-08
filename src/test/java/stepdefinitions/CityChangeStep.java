package stepdefinitions;


import example.pages.CityChangePage;
import example.pages.MainPage;
import example.steps.WbSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;

public class CityChangeStep {


    @And("Вводит {string} в поисковую строку")
    public void inputAddress(String city) {
        WbSteps.sendKeys(CityChangePage.searchLine, city);}

    @And("Нажимает кнопку  “Найти”")
    public void searchButtonClick() {
        WbSteps.click(CityChangePage.searchButton);
    }

    @And("Выбирает первый адрес из списка адресов")
    public  void pickFirstAddress() {
        CityChangePage.pickAddress.shouldHave(text("Санкт-Петербург"));
        WbSteps.click(CityChangePage.pickAddress);}

    @Then("Открывается информация о пункте выдачи")
    public void confirmTitle() {
        Assertions.assertTrue(CityChangePage.pickPointInfo.isDisplayed());
    }

    @And("Адрес пункта выдачи совпадает с адресом {string}")
    public void addressConfirm(String element) {
        CityChangePage.pickAddress.shouldHave(text(element));}

    @When("Пользователь нажимает на кнопку “Выбрать”")
    public void pickAddress() {
        WbSteps.click(CityChangePage.pick);
    }

    @And("Отображается адрес пункта выдачи из предыдущего шага")
    public void mainPageAddressIsEquals() {
        Assertions.assertTrue(MainPage.cityChange.getText().contains("Санкт-Петербург"));}

}
