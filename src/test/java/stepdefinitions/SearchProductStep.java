package stepdefinitions;

import example.pages.MainPage;
import example.pages.SearchingResultsPage;
import example.steps.WbSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProductStep {

@When("Пользователь вводит {string} в строку поиска")
    public void searchProduct(String text){
        WbSteps.sendKeys(MainPage.searchLine,text);}

    @And("Нажимает на кнопку поиска")
    public void searchButtonClick(){
        WbSteps.click(MainPage.searchButton);}

    @Then("Пользователь видит товар {string} в результатах поиска")
    public void confirmTitle(String element){
        SearchingResultsPage.title.getText().contains(element);}

}
