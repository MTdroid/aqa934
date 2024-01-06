@search
Feature: Поиск товара

  Scenario: Поиск товара "iPhone 13"

    Given Пользователь открывает страницу "https://www.wildberries.ru/"
    When Пользователь вводит "iPhone 13" в строку поиска
    And Нажимает на кнопку поиска
    Then Пользователь видит товар "iPhone 13" в результатах поиска