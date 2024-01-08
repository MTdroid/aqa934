package stepdefinitions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import example.pages.SearchingResultsPage;
import example.steps.WbSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class FiltersStep {
    @And("Наводит курсор на нужную категорию {string}")
    public void chooseCategory(String element) {
        Selenide.sleep(500);
        SelenideElement category = $x("//ul[@class='menu-burger__main-list']//a[text()=" + element + "]");
        WbSteps.hover(category);}

    @And("Нажимает на нужную подкатегорию {string}")
    public void chooseCategory2(String element) {
        SelenideElement category = $x("//span[@class=\"menu-burger__link menu-burger__link--next j-menu-drop-open\"][text()=" + element + "]");
        WbSteps.click(category);}

    @And("Нажимает на нужную подкатегорию 2 {string}")
    public void chooseCategory3(String element) {
        SelenideElement category = $x("//span[@class=\"menu-burger__link menu-burger__link--next j-menu-drop-open\"][text()=" + element + "]");
        WbSteps.click(category);}

    @And("Нажимает на нужную подкатегорию 3 {string}")
    public void chooseCategory4(String element) {
        SelenideElement category = $x("//a[@class=\"menu-burger__title-link j-menu-drop-link\"][text()=" + element + "]");
        WbSteps.click(category);}

    @And("Нажимает нa нужную подкатегорию 2 {string}")
    public void chooseCategory5(String element) {
        SelenideElement category = $x("//a[@class=\"menu-burger__link j-menu-drop-link\"][text()=" + element + "]");
        WbSteps.click(category);}

    @Then("Происходит переход на страницу с категорией {string}")
    public void confirmCategory(String element) {
        Assertions.assertTrue(SearchingResultsPage.title.getText().contains(element));}
}
