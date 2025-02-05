
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

## Testing screenshoot
<img width="638" alt="product" src="https://github.com/user-attachments/assets/a4b76f67-a852-4ac5-a537-dd3c273a0712" />

<img width="627" alt="order" src="https://github.com/user-attachments/assets/3832274b-5dbe-494f-8ba9-f2880a6c6b3d" />



