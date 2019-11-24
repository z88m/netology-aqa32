### Домашнее задание к занятию «3.2.1 SQL»
#### Задача №1 - Скоро deadline
Статус appveyor: [![Build status](https://ci.appveyor.com/api/projects/status/bs4eun699uewrosj/branch/master?svg=true)](https://ci.appveyor.com/project/z88m/netology-aqa32/branch/master)

- Из внутренностей app-deadline.jar узнал пароль
- Подключён MySQL с соответствующим паролем 
- Сделан однократный тест логина для vasya
- Коды авторизации выбираются из базы

- (Для обхода бага инициализации) После тестов сделано удаление данных пользователей vasya и petya. Из-за этого перед каждым прогоном тестов нужно перезапускать app-deadline.jar