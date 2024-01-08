@filters
Feature:Просмотр списка товаров в категории

  Scenario:Просмотр списка товаров в категории "Электроника"

    Given Пользователь открывает страницу "https://www.wildberries.ru/"

    When Пользователь нажимает на кнопку 'Фильтры'
    And Наводит курсор на нужную категорию "'Электроника'"
    And Нажимает на нужную подкатегорию "'Ноутбуки и компьютеры'"
    And Нажимает нa нужную подкатегорию 2 "'Ноутбуки'"
    Then Происходит переход на страницу с категорией "Ноутбуки"

    When Пользователь нажимает на кнопку 'Все фильтры'
    And Применяет фильтр для цены. От "100000" До "149000"
    And Применяет фильтр для срока доставки - "'до 3 дней'"
    And Применяет фильтр для бренда - "'Apple'"
    And Применяет фильтр для размера - "'13.3\"'"
    And Нажимает на кнопку показать
    Then Происходит переход на страницу с категорией "Ноутбуки и ультрабуки"
    And Появилась кнопка “Сбросить все”
    And Фильтры "до 3 дней Apple от 100 000 до 149 000 13.3\" Сбросить все" отображаются на странице
    And Кол-во товара на страница = количеству товара на странице