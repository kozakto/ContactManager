# ContactManager

Jednoduchá Spring Boot aplikace pro správu kontaktů (osob) s využitím JPA a jOOQ.

## Funkce
- Endpoint `/home` – jednoduchý uvítací text
- Endpoint `/addUser` – aktuálně testovací vytvoření jedné osoby (doporučeno změnit na POST + DTO)
- Endpoint `/contacts` – načtení všech záznamů z tabulky `person` pomocí jOOQ

## Technologie
- Java 17
- Spring Boot 3.2.11 (Web, Data JPA, Logging)
- Hibernate ORM
- jOOQ (generovaný kód v `com.example.jooq.generated`)
- PostgreSQL

## Build & Run (Windows)
```
gradlew.bat clean build
java -jar build\libs\ContactManager-0.0.1-SNAPSHOT.jar
```
Aplikace standardně běží na portu 8080.

## Konfigurace databáze
Nastav v prostředí (nedávej citlivé údaje přímo do `application.properties`):
```
set SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres
set SPRING_DATASOURCE_USERNAME=postgres
set SPRING_DATASOURCE_PASSWORD=heslo
```
Poté můžeš upravit `application.properties` tak, aby používal proměnné prostředí.

## Doporučení pro zlepšení bezpečnosti
1. Přidat Spring Security (ochrana endpointů, autentizace).
2. Změnit `/addUser` na POST a používat DTO + validace (`@Valid`).
3. Odebrat logování citlivých údajů (adresa, telefon) nebo je maskovat.
4. Nepoužívat hardcoded hesla – vše přes proměnné prostředí/Vault.
5. Nahradit ruční `DriverManager` injektovaným `DataSource` (poolování).
6. Přidat migrace (Flyway/Liquibase) místo `spring.jpa.hibernate.ddl-auto=update`.
7. Aktualizovat verze závislostí (PostgreSQL driver, jOOQ, Hibernate).

## Struktura projektu (hlavní části)
```
src/main/java/com/example/ContactManager/ContactManagerApplication.java
src/main/java/com/example/ContactManager/controller/*
src/main/java/com/example/ContactManager/entity/Person.java
src/main/java/com/example/ContactManager/repository/UserRepository.java
src/main/java/com/example/ContactManager/service/ContactService.java
```

## Další kroky (volitelné)
- Vytvořit `SECURITY.md` pro politiku bezpečnosti.
- Přidat testy pro kontrolery a service.
- Přidat CI workflow (GitHub Actions) pro build a test.

---
Pokud chceš README upravit nebo doplnit další sekci, napiš mi.
