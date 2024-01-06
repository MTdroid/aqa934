package stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import example.pages.MainPage;
import example.pages.SearchingResultsPage;
import example.steps.WbSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;

public class CheckProductListUsingFiltersStep {

    @When("Пользователь нажимает на кнопку 'Фильтры'")
    public void filterButton() {
        WbSteps.click(MainPage.filters);}

    @And("Нажимает на нужную категорию {string}")
    public void chooseCategory(String element) {
        SelenideElement category = $x("//ul[@class='menu-burger__main-list']//a[text()=" + element + "]");
        WbSteps.click(category);}

    @Then("Title содержит название выбранной категории {string}")
    public void confirmCategory(String element) {
        SearchingResultsPage.title.getText().contains(element);}

}
