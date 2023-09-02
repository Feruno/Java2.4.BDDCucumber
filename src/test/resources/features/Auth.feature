#language:ru
Функциональность: Аторизация

  Сценарий: : Авторизация в лк (позитивный)
    Пусть открыта страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    И пользователь вводит проверочный код 'из смс' "12345"
    Тогда происходит успешная авторизацияи пользоваетль попадает на страницу выбора карт
    И выбирает пополнить 0 карту
      # 0 - первая карта из списка
      # 1 - вторая карти из списка и т.д.
    Когда пользователь переводит "5000" рублей с карты с номером "5559 0000 0000 0002" на свою первую карту с главной страницы
    Тогда баланс его 0 карты из списка на главной странице должен стать 15000 рублей.
      # 0 - первая карта из списка
      # 1 - вторая карти из списка и т.д.

  Сценарий: : Авторизация в лк (позитивный)
    Пусть открыта страница с формой авторизации "http://localhost:9999"
    Когда пользователь пытается авторизоваться с именем "vasya" и паролем "qwerty123"
    И пользователь вводит проверочный код 'из смс' "12345"
    Тогда происходит успешная авторизацияи пользоваетль попадает на страницу выбора карт
    И выбирает пополнить 1 карту
      # 0 - первая карта из списка
      # 1 - вторая карти из списка и т.д.
    Когда пользователь переводит "8000" рублей с карты с номером "5559 0000 0000 0001" на свою первую карту с главной страницы
    Тогда баланс его 1 карты из списка на главной странице должен стать 13000 рублей.
      # 0 - первая карта из списка
      # 1 - вторая карти из списка и т.д.

