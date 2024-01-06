package stepdefinitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class OpenBrowser {

    @Given("Пользователь открывает страницу {string}")
    public void openURL(String url) {
        Selenide.open(url);
        Selenide.sleep(300);}

}
