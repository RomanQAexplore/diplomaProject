## Планирование автоматизации тестирования покупки тура ###

### Перечень автоматизируемых сценариев.
#### Сценарии аналогичны для случаев оплаты как с дебетовой, так и с кредитной карты.
#### Каждый тестовый сценарий для тестирования формы покупки подразумевает стандартный путь входа на страницу формы:
* Запустить приложение aqa-shop.jar в IDEA,
* Открыть страницу приложения в браузере: http://localhost:8080/
* Нажать на кнопку "Купить"- для по дебетовой карте.
* Нажать на кнопку "Купить в кредит"- для покупки по кредитной карте.
После этого неободимо заполнить поля ввода данными карты.
### Валидные значения при заполнении полей формы
* месяц - двузначное число в промежутке от 01 до 12
* год - двузначное число в промежутке от 23 до 29 (используются только десятки и единицы года в обозначении года)
* владелец карты - имя и фамилия, написанная латинскими заглавными буквами.
* CVC/CVV - трехзначное число в промежутке от 100 до 999

1. Позитивный сценарий покупки тура с использованием данных APPROVED карты.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелец  IVANOV IVAN, CVC 111,
* Оправить форму,


Ожидаемый результат: уведомление- "Успешно. Операция одобрена Банком".

* Выполнить запрос в базу данных, проверяющие корректность внесения информации приложением.


2. Негативный сценарий покупки тура с использованием данных DECLINED карты.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4442, срок действия 08/23, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: уведомление- "Ошибка! Банк отказал в проведении операции".

* Выполнить запрос в базу данных, проверяющие корректность внесения информации приложением.



3. Валидация полей формы. Номер карты.

   Шаги:

* Заполнить данные карты: номер: -, срок действия 08/24, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: уведомление- "Поле обязательно для заполнения".

4. Валидация полей формы. Номер карты.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 444, срок действия 08/24, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: уведомление- "Неверный формат ".

5. Валидация полей формы. Номер карты.

   Шаги:

* Заполнить данные карты: номер: 0000 0000 0000 0000, срок действия 08/24, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: уведомление- "Неверный формат ".


6. Валидация полей формы. Месяц.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 13/24, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "месяц". уведомление- "Неверно указан месяц".

7. Валидация полей формы. Месяц.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия -/24, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "месяц". Сообщение "Поле обязательно для заполнения".

8. Валидация полей формы. Месяц.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 00/24, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "месяц". Сообщение "Неверный формат ввода. Укажите данные как на карте".


9. Валидация полей формы. Год.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/20, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "год". Сообщение "истек срок действия карты".

10. Валидация полей формы. Год.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/-, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "год". Сообщение "неверный формат".

11. Валидация полей формы. Год.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/50, владелец IVANOV IVAN, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "год". Сообщение "Неверно указан срок действия карты".



12. Валидация полей формы. Владелец.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелец ИВАНОВ ИВАН, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "Владелец". Сообщение "Неверный формат "

13. Валидация полей формы. Владелец.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелец -, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "Владелец". Сообщение "Поле обязательно для заполнения"

14. Валидация полей формы. Владелец.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелец 12345, CVC 111,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "Владелец". Сообщение "Неверный формат "

15. Валидация полей формы. CVC/CVV.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелеца IVANOV IVAN , CVC 000,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "CVC/CVV". Сообщение "Неверный формат "


17. Валидация полей формы. CVC/CVV.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелеца IVANOV IVAN , CVC 1,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "CVC/CVV". Сообщение "Неверный формат ".

18. Валидация полей формы. CVC/CVV.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелеца IVANOV IVAN , CVC 11,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "CVC/CVV". Сообщение "Неверный формат ".

18. Валидация полей формы. CVC/CVV.

   Шаги:

* Заполнить данные карты: номер: 4444 4444 4444 4441, срок действия 08/24, владелеца IVANOV IVAN , CVC -,
* Оправить форму.


Ожидаемый результат: не проходит валидация поля "CVC/CVV". Сообщение "Неверный формат ввода. Укажите данные как на карте".

### API- тест покупки тура с использованием данных APPROVED карты.
* Удостоверяемся, что при обращении к URL-адресу http://localhost:8080/api/v1/pay (http://localhost:8080/api/v1/credit-для кредитной карты)мы получаем от сервера код 200 и банковская карта c  номером "4444 4444 4444 4441" имеет статус APPROVED.

### API- тест покупки тура с использованием данных DECLINED карты.
* Удостоверяемся, что при обращении к URL-адресу http://localhost:8080/api/v1/pay (http://localhost:8080/api/v1/credit-для кредитной карты) мы получаем от сервера код 200 и банковская карта с номером "4444 4444 4444 4442" имеет статус DECLINED.

   



## Перечень используемых инструментов:
1. Java 11 Универсальный язык, позволяющий работать на большинстве ОС и различном оборудовании.

2. IntelliJ IDEA Многофункциональная среда разработки, бесплатная. Хорошая интеграция в GitHub, широкая поддержка расширений и плагинов для тестирования.

3. Git Система контроля версий. Бесплатность, возможность параллельной разработки, хорошая интеграция с IntelliJ IDEA.

4. JUnit5 Тестовый фреймворк, совместимый с JVM и IntelliJ IDEA, содержит все необходимые аннотации.

5. Gradle Система сборки проекта. Имеет простой и понятный код, небольшого объема, в сравнении с Maven. Проще подключать внешние зависимости.

6. Lombok Плагин для создания аннотаций, заменяющих значительное количество однообразных конструкторов JAVA таких, как getters, setters и пр.

7. Selenide Фреймворк для автоматизированного тестирования веб-приложений на основе Selenium WebDriver. Подключение веб-драйвера происходит автоматически, простое написание кода тестов.

8. JavaFaker Плагин для генерации случайных данных для тестов. Большое количество настроек, бесплатный, достаточная локализация для России.

9. Appveyor Система CI. Непрерывный контроль интеграции кода. Простое подключение и настройка, удобная интеграция с GitHub.

10. Allure Report Система подготовки отчётов. Бесплатное решение. Хорошая информативная визуализация отчётов. Позволяет отслеживать данные на протяжении времени

## Возможные риски при автоматизации:
* При тестировании мы используем только данные карт, предоставленные разработчиками, что создает риск возникновения каких-либо ошибок при работе с реальными картами.
* При тестах используются, только номера карт, без остальных данных, т.е. симулятор банковских сервисов не проверяет возможные ошибки в прочих данных (написание ФИО, язык, формат даты).

## Интервальная оценка с учётом рисков (в часах)
60 часов

## План сдачи работ
### Автотесты
22 января
### Отчет по итогам тестирования
23 января
### Отчет по итогам автоматизации
23 января
