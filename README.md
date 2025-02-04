
# Product AND Order REST-API




## Tech Stack

Java 21+

Spring Boot 3+

Spring Data MongoDB

Spring Web (REST APIs)

Spring REST-Template (Service Communication)

Lombok

Postman (For API Testing)




## Services Overview

1. Product Service

Manages product information (ID, name, price, stock, etc.)

Stores data in MongoDB

Provides REST APIs to create, fetch, update, and delete products

2. Order Service

Manages customer orders

Calls Product Service to validate product availability before placing an order

Stores order details in MongoDB

Provides REST APIs to place, fetch, and cancel orders


