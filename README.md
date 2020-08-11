**SAGA Pattern with Event Based Micro service**

A sample Order Management Application implemented with inspiration to build a scalable distributed micro service leveraging the SAGA pattern injecting with CQRS and Event Sourcing fundamentals.

The  **Saga Pattern**  is as microservices architectural  **pattern**  to implement a transaction that spans multiple services. A  **saga**  is a sequence of local transactions. Each service in a  **saga**  performs its own transaction and publishes an event. The other services listen to that event and perform the next local transaction.In other words, **Saga** is a type of **database-per-service** design pattern. In such type of design each service is having their own respective persistent layer and are responsible for their respective datastore.

Use Case: - Some business transactions require data from multiple services. Such transactions may also need to update or process data across services. Therefore, a mechanism to handle data consistency across multiple services is required.

**Application Overview** : -

A sample Order Management Operation which lets place order then proceed with payment activity and eventually initiate the shipment of the product upon successful payment. Whole architecture is based on Saga and Event Sourcing

In this implementation we are using spring boot and some of its popular framework such as **Axon Framework** to develop our event based microservices and **Axon Server** as a means of **Event store.**

![](RackMultipart20200811-4-ve3dyd_html_c76daf677f551ce.gif)

SAGA

![](RackMultipart20200811-4-ve3dyd_html_f011041a9d228888.gif) ![](RackMultipart20200811-4-ve3dyd_html_1426dc4b6bc1690a.gif) ![](RackMultipart20200811-4-ve3dyd_html_6eac56765d1bd23f.gif) ![](RackMultipart20200811-4-ve3dyd_html_a9887fd73289ccf9.gif)

Choreography Based SAGA

Orchestration Based SAGA

**Choreography Based SAGA** : - In this type of  **Saga** Implementation, each service publishes one or more domain events. These domain events trigger local transactions in other microservices.

**Orchestration Based SAGA** : - In Orchestration-Based Saga, there is an orchestrator. An orchestrator can also be thought of as a manager that directs the participant services to execute local transactions.

Order Management viewed with Choreography Based SAGA approach then HLD would look like

![](RackMultipart20200811-4-ve3dyd_html_6f7ad865c340b106.png)

In case of if we adhere to orchestration-based approach then HLD would look like as follows

![](RackMultipart20200811-4-ve3dyd_html_cb2a988d632bfa88.png)

**Components** : -

- **Order Service**  – This service exposes APIs that help creating an Order in the system. Also, the service manages the  **Order Aggregate**. Order Aggregate is nothing but an entity that maintains the  **Order**  related information. However, the  **Order Service**  also acts as the home for the actual  **Order Management Saga**  implementation.
- **Payment Service**  – The  **Payment Service**  acts upon the Create Invoice Command issued by the  **Order Management Saga**. Once it finishes its job, it publishes an event. This event pushes the Saga forward onto the next step.
- **Shipping Service**  – This service takes care of creating a shipment in the system corresponding to the Order. It acts upon a command issued by the Saga Manager. Once it does its job, it also publishes an event that pushes the Saga forward.
- **Core-APIs**  – This is not a service as such. However, Core-APIs acts as the integration-glue between various services that form a part of the Saga. In our case, the Core-APIs will consist of the various commands and event definitions required for our Saga implementation to function
- **Axon Server**  – This will discover our services namely order-service/shipping-service/payment-service/core-domain
