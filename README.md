# book-soap

Book library SOAP service: Spring Boot 3, Spring Data JPA, PostgreSQL,
JAX-WS (`jakarta.xml.ws`) published on port 8081.

## Run

PostgreSQL (example with Docker):

    docker run --name book-pg -e POSTGRES_PASSWORD=pass -p 5432:5432 -d postgres:16

Application:

    DB_PASSWORD=pass ./mvnw spring-boot:run

Settings (environment variables): `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`
(required), `SOAP_ADDRESS` (default `http://localhost:8081/ws/books`).

Tables are created automatically (`ddl-auto=update`) and start empty:
insert books into `book_library`, `book_credential`, `book_status` to get
non-empty answers.

## Use

WSDL: http://localhost:8081/ws/books?wsdl

Ready-made SOAP requests (POST to `/ws/books`, `Content-Type: text/xml`)
are in `soap-requests.txt`.

## Test

    ./mvnw test

Tests use an in-memory H2 database (profile `test`), no PostgreSQL needed.
