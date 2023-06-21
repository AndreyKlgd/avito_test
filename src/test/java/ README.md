[AnimalsTests.java]
1) testAdDetailsPage
 добавляем в избранное первое объявление
 переходим на страницу избранного
 проверяем во вкладке "Все" что там значение 1

2) testDogs
   переход на страницу с собаками
   вывод в консоль имя первого питомца в объявлении

3) testCats
   клик на фильтр с разделом "Кошки"
   вывод в консоль кол-во объявлений

4) testBirds
   клик на раздел "Птицы"
   выставить фильтр по стоимости как самые дорогие
   вывести в консоль стоимость первого объявления

[AvitoTest.java]
1) testStatusCode
   статус код 200 проверка

2) testPageLoadTime
   время загрузки страницы

3) testGeoLocation
   вывод в консоль города по геолокации

4) testSearchMaxLength
   максимальная длина символов в поиске
[CarTests.java]
1) testPageTitle
   Ищет элемент "Транспорт и запчасти"

2) testPageTitleCountAuto
   проверяем количество всех моделей авто в категории "Автомобили"

3) testAll
   Проверяем кол-во элементов на вкладке "Все" в категории авто

4) testSearch
   проверка ввода в поиск текста "BMW" и проверка результата по ключевому слому "BMW"

5) testSortByPrice
   сортирует список авто на "Дорогие" и выводит в консоль название и цену из первого объявления

[RealEstateTests.java]
1) testRealEstate
   клик на иконку недвижимости и вывод в консоль результата

2) testPageTitleCountRealEstate
   клик на элемент "показать 12тыс.объявлений"
   и проверка что произошел переход на страницу, где указана "Продажа квартир в Калининграде"
   вывод в консоль кол-ва объявлений

3) selectTestJK
   клик на иконку Выбрать ЖК в каталоге,
   дальше подтверждение страницы элементом с названием "Новостройки (ЖК) в Калининграде"
   и вывод кол-ва объявлений в консоль

4) LongTermTest
   клик на иконку "Снять жилье на долгий срок",
   дальше подтверждение страницы элементом с названием "Аренда квартир на длительный срок в Калининграде"
   и вывод кол-ва объявлений в консоль

[SparePartsTests.java]
1) sparePartsTest
   Тест открывает главную страницу по заданной ссылке
   кликает на кнопку "Запчасти и аксессуары".
   После этого происходит проверка, что заголовок страницы содержит текст "Запчасти и аксессуары для машин и мотоциклов"

2) mercedesBenzTest
   клик на "показать объявления"
   выводит название страницы и кол-во объявлений в консоль
3) discsTest
   открывает страницу по заданной ссылке,
   кликает на кнопку фильтра для выбора дисков,
   после чего кликает на объявление о продаже дисков и собирает наименование объявления и цену
   выводит в консоль



