@cart @purchase
Feature:Просмотр списка товаров в категории

  Scenario:Просмотр списка товаров в категории "Электроника"

    Given Пользователь открывает страницу "https://www.wildberries.ru/"

    When Пользователь нажимает на кнопку 'Фильтры'
    And Наводит курсор на нужную категорию "'Бытовая техника'"
    And Нажимает на нужную подкатегорию "'Техника для дома'"
    And Нажимает на нужную подкатегорию 2 "'Пылесосы и пароочистители'"
    And Нажимает на нужную подкатегорию 3 "'Пылесосы и пароочистители'"

    Then Происходит переход на страницу с категорией "Пылесосы и пароочистители"
    And Путь фильтра - "Главная-Бытовая техника-Техника для дома-Пылесосы и пароочистители"

    When Пользователь нажимает на кнопку 'В корзину'
    Then В правом верхнем углу над логотипом “Корзина” появилась красная цифра “1”

    When Пользователь нажимает на кнопку “Корзина”
    Then Текст и цена товара соответствует цене и названию товара со страницы результатов поиска
    And “Итого” = сумме товара
    And Кнопка “Заказать” активна для нажатия