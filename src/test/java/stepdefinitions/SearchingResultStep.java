package stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import example.pages.SearchingResultsPage;
import example.steps.WbSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.Integer.parseInt;

public class SearchingResultStep {

    @And("Первый фильтр - {string}")
    public void confirmBurgerFilter(String element) {
        Assertions.assertTrue(SearchingResultsPage.burgerFilter.getText().contains(element));}

    @And("Применен фильтр {string}")
    public void confirmSortFilter(String element) {
        Assertions.assertTrue(SearchingResultsPage.sortFilter.getText().contains(element));}

    @And("У первого устройства из списка бренд - {string}")
    public void confirmFirstProductBrand(String element) {
        Assertions.assertTrue(SearchingResultsPage.brand.getText().contains(element));}

    @And("Путь фильтра - {string}")
    public void filterPath(String element) {
        Assertions.assertTrue(SearchingResultsPage.pagePath.getText().replaceAll("\n","-").contains(element));}

    @When("Пользователь нажимает на кнопку 'В корзину'")
    public void addProductToCart() {
        WbSteps.hover(SearchingResultsPage.firstProduct);
        WbSteps.click(SearchingResultsPage.firstProductAddToCart);}

    @When("Пользователь нажимает на кнопку 'Все фильтры'")
    public void clickDropdownFilter() {
        WbSteps.click(SearchingResultsPage.dropDownFilterButton);
    }

    @And("Применяет фильтр для цены. От {string} До {string}")
    public void setPrice(String sPrice, String ePrice) {
        WbSteps.clear(SearchingResultsPage.startPrice);
        WbSteps.sendKeys(SearchingResultsPage.startPrice,sPrice);
        WbSteps.clear(SearchingResultsPage.endPrice);
        WbSteps.sendKeys(SearchingResultsPage.endPrice,ePrice);}

    @And("Применяет фильтр для срока доставки - {string}")
    public void setDeliveryDate(String day) {
        SelenideElement element = $x("//span[@class='radio-with-text__text'][text()=" + day + "]");
        WbSteps.click(element);}

    @And("Применяет фильтр для бренда - {string}")
    public void setBrand(String brand) {
        SelenideElement element = $x("//span[@class='checkbox-with-text__text'][text()=" + brand + "]");
        WbSteps.click(element);}

    @And("Применяет фильтр для размера - {string}")
    public void setSize(String size) {
        SelenideElement element = $x("//span[@class='checkbox-with-text__text'][text()=" + size +" ]");
        WbSteps.click(element);}

    @And("Нажимает на кнопку показать")
    public void showAll() {
        WbSteps.click(SearchingResultsPage.showAll);}

    @Then("Фильтры {string} отображаются на странице")
    public void filterConfirm(String text) {
        Assertions.assertEquals(SearchingResultsPage.choiseList.shouldBe(visible).getText().replaceAll("\n"," "), text);}

    @And("Появилась кнопка “Сбросить все”")
    public void dropAllIsDisplayed() {
        Assertions.assertTrue(SearchingResultsPage.dropAll.isDisplayed());}

    @And("Кол-во товара на страница = количеству товара на странице")
    public void ItemSize() {
        Assertions.assertEquals(parseInt(SearchingResultsPage.totalItems.getText()),SearchingResultsPage.checkSize.size());}

    @Then("Пользователь видит текст {string}")
    public void confirmTitle(String element) {
        Assertions.assertTrue(SearchingResultsPage.title.getText().contains(element));}
}
