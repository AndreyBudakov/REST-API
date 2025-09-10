Pet Rest API

Учебный pet-проект на Java, реализующий REST API 
для управления сотрудниками (Employee), менеджерами (Manager) 
и стажёрами (Intern). Проект создан для практики работы с 
Spring Boot, JPA и PostgreSQL.

Используемые технологии:
- Java 17
- Spring Boot (Web, Data JPA, Test)
- Unit + MockMvc для тестирования контроллеров
- Postman для ручного тестирования запросов
- pgAdmin для работы с базой

Тело запроса:
- Создание сотрудника:
  {"name": "Андрей","age": 26,"salary": 80000,
  "specialty": "Java","fullTime": true}
- Создание менеджера:
  {"name": "Андрей","age": 26,"salary": 80000,
  "specialty": "Управление","teamSize": 10,"department": "IT"}
- Создание стажёра:
  {"name": "Андрей","age": 26,"salary": 80000,"specialty": "Тестирование",
  "internshipDuration": 6,"mentor": "Аркадий"}
