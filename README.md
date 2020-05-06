# SpringCloud_Microservices
Configure management, Hystrix, Feign Client, Ribbon, Eureka Naming Server, Zuul API Gateway

Microservices with Spring Cloud
Implementing Microservices using Spring Cloud Project (Spring.io)
Challenges in Microservices:
1.	Configuration Management
2.	Zuul API Gateway
3.	Ribbon (Client Side Load Balancing)
4.	Eureka Naming Server
5.	Feign Client
6.	Hystrix (Fault Tolerance)
7.	Distributed tracing (Zipkin, RabbitMQ) – Facing problem while implementing.
All the above issues are identified and resolved using the Spring cloud project.

Limits Service	8080, 8081, ...
Spring Cloud Config Server	8888
Currency Exchange Service	8000, 8001, 8002, ..
Currency Conversion Service	8100, 8101, 8102, ...
Netflix Eureka Naming Server	8761
Netflix Zuul API Gateway Server	8765
Zipkin Distributed Tracing Server	9411

API Gateway
http://localhost:8765/currency-conversion-service/currency-converter-feign/from/AUD/to/INR/quantity/1000

Eureka Server
http://localhost:8761/


