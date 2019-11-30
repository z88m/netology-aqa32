### Домашнее задание к занятию «3.2.1 SQL»
#### Задача №1 - Скоро deadline
Статус appveyor: [![Build status](https://ci.appveyor.com/api/projects/status/bs4eun699uewrosj/branch/master?svg=true)](https://ci.appveyor.com/project/z88m/netology-aqa32/branch/master)

- Из внутренностей app-deadline.jar узнал пароль
- Подключён MySQL с соответствующим паролем
- Задан пароль рута (нужен для удаления тестовых данных) 
- Сделан однократный тест логина для vasya
- Коды авторизации выбираются из базы

- (Для обхода бага инициализации) После тестов сделано удаление данных пользователей vasya и petya. Из-за этого перед каждым прогоном тестов нужно перезапускать app-deadline.jar

---
##### Инструкция по подготовке теста к первому запуску:
1. `git clone https://github.com/z88m/netology-aqa32.git`
2. `cd ./netology-aqa32/`
3. `docker pull mysql`
4. `docker-compose up -d` _(подождать_ _старт_ _базы)_
5. `cd ./artifacts/`
6. `java -jar ./app-deadline.jar`
7. Запустить тест
