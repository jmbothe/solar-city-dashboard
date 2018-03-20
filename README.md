# Solar City Commercial Project Manager Dashboard

## Proposal

### Client Problem Statement

Solar City is the world's largest and fastest-growing solar panel installation company, with their commercial construction division showing the largest strides in growth over the past few years. As demand for larger and larger solar infrastructure projects grows, project managers are faced with a proportional increase in work load and complexity. At present, Solar City's commercial division has no organized system for project managers to track and update information relevant to the work under their purview. Instead, the tools currently available are distributed, incompatable, and outdated.

### Proposed Solution and Technical Requirements

The distributed nature of the current system is an artifact of the shape of underlying data. For instance, project data is owned and maintained by a different company department than employee data. To tackle the current problem and begin to pay off Solar City's resulting technical debt, it is recommended to create a system that provides centralized endpoints to access and modify data, updating the current systems and standardizing their I/O, while honoring the autonomy and modularity of these databases. The first phase of the project entails building a Java Spring Boot microservices environment to map the different data domains. Each domain will be encapsulated in an API and exposed to the environment through limited, standardized, well-documented routes. The system as a whole will be managed via an API gateway and and a service registry. ALl of these systems will be containerized and deployed to an elastic cloud computing service.

### In Defense of Microservices

Solar City's situation presents a perfect case for the implementation of microservices architecture. While it may seem counter intuitive to propose keeping the databases modular, in the realm of microservices, a single monolithic database is considered an anti-pattern. In the quotes below, Netflix Director of Web Engineering Adrian Cockcroft describes the best practice for handling data stores in a microservices environment.

>If you have a bunch of small, specialized services but still have to update them together, they’re not microservices because they’re not loosely coupled. One kind of coupling that people tend to overlook as they transition to a microservices architecture is database coupling, where all services talk to the same database and updating a service means changing the schema. You need to split the database up and denormalize it.
>
>With a single data store it’s too easy for microservices written by different teams to share database structures, perhaps in the name of reducing duplication of work. You end up with the situation where if one team updates a database structure, other services that also use that structure have to be changed too.

## Install and Testdrive

This project depends upon node.js, docker, and docker-compose. Make sure you have all of these dependencies installed before you proceed.

1. Clone this repo to your local machine.
2. From the comman line, from the `dashboard` directory, run `npm install` to setup the React frontend.
3. In a separate comman line window, from the top-level project directory run `docker-compose up`.
4. Back in the first command line window, from the `dashboard` directory, run `npm start`.
5. A new browser window should automatically open, but if it doesn't, navigate to `http://localhost:3000` in your browser and enjoy the app!