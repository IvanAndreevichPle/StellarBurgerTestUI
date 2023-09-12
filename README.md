# StellarBurgerTestUI

Этот проект содержит автотесты для веб-приложения Stellar Burger, компании Яндекс. Автотесты разработаны с использованием Java, Selenium и JUnit.

## Зависимости

Для сборки и запуска проекта вам понадобятся следующие зависимости:
- Java Development Kit (JDK) 8 или выше
- Maven
- Браузер (Chrome, Firefox, или Internet Explorer)

## Установка и запуск

1. Склонируйте репозиторий на свой локальный компьютер:
   [https://github.com/IvanAndreevichPle/StellarBurgerTestUI.git](https://github.com/IvanAndreevichPle/StellarBurgerTestUI.git)

2. Перейдите в папку проекта:
```bash
cd StellarBurgerTestUI
```

3. Запустите автотесты с помощью Maven, командой:
```bash
mvn test 
```

Вы также можете указать свой браузер, добавив системное свойство `browser` с соответствующим значением. Например, для запуска тестов в браузере Chrome:
```bash
mvn test -Dbrowser=cheome
```

Аналогично, для запуска теста с использованием Yandex:
```bash
mvn test -Dbrowser=yandex
```

Если свойство "browser" не указано, будет использоваться браузер Chrome.
```bash
mvn test
```

Для просмотра отчета о выполнении автотестов выполните команду из терминала:
```bash
mvn allure:serve
```

## Структура проекта

- `/src/main/java/config` - пакет c интерфейсом для работы с файлами *.properties
- `src/main/java/expansion` - пакет для класса фабрики WebDriver
- `src/main/java/generators` - пакет с генератором данных о пользователе
- `src/main/java/models` - пакет с моделями данных
- `src/main/java/pages` - пакет с pageobject
- `src/main/java/web_api_clients` - пакет с API для регистрации

## Ваш вклад

Если вы хотите внести вклад в проект, пожалуйста, создайте форк репозитория,
внесите свои изменения и отправьте пул-реквест. Мы будем рады
рассмотреть ваши предложения и улучшения.

