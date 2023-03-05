### deploy
webLogicServer -> local
- WebLogic 12.2.1.4.0
- domain Name: D:\Oracle\Middleware\Oracle_Home\user_projects\domains\base_domain
- AdminServer: AdminServer
- UserName: weblogic
- Password: .....

### soap
- http://127.0.0.1:7001/customer-soap/Service?WSDL
- http://127.0.0.1:7001/AccountServiceImpl/AccountFacadeImpl?WSDL

### rest
- GET http://127.0.0.1:7001/customer-rest/api/customer
- GET http://127.0.0.1:7001/customer-rest/api/customer/14
- POST http://127.0.0.1:7001/customer-rest/api/customer
  {
  "firstName": "parvin1",
  "lastName": "Aghazadeh2",
  "phone": "1111",
  "mobile": "09123",
  "customerType": "LEGAL",
  "nationalCode" : "005555021"
  }
- DELETE http://127.0.0.1:7001/customer-rest/api/customer/18

- GET http://127.0.0.1:7001/customer-rest/api/account/22
- GET http://127.0.0.1:7001/customer-rest/api/account
- POST http://127.0.0.1:7001/customer-rest/api/account
  {
  "accountNumber": "1212334544-5445",
  "status": "ACTIVE",
  "amount": 10000,
  "customerId": 18
  }
- DELETE http://127.0.0.1:7001/customer-rest/api/account/9