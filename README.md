# API Spec

## Company

### Create Company
Request : 
- Method : POST
- Endpoint : `/api/companies`
- Header : 
    - Content-Type : application/json
    - Accept : application/json
- Body : 
```json
{
  "name": "string",
  "address": "string",
  "country": "string"
}

```
Response :
```json
{
  "code": "integer",
  "status": "string",
  "data": {
    "id": "string,unique",
    "name": "string",
    "address": "string",
    "country": "string",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

### Get Company
Request :
- Method : GET
- Endpoint : `/api/companies/{idCompany}`
- Header :
    - Accept : application/json

Response : 
```json
{
  "code": "integer",
  "status": "string",
  "data": {
    "id": "string,unique",
    "name": "string",
    "address": "string",
    "country": "string",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

### Update Company
Request :
- Method : PUT
- Endpoint : `/api/companies/{idCompany}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "name": "string",
  "address": "string",
  "country": "string"
}
```
Response :
```json
{
  "code": "integer",
  "status": "string",
  "data": {
    "id": "string,unique",
    "name": "string",
    "address": "string",
    "country": "string",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

### Delete Company
Request :
- Method : DELETE
- Endpoint : `/api/companies/{idCompany}`
- Header :
    - Accept : application/json
    
Response :
```json
{
  "code": "integer",
  "status": "string"
}
```

### List Company
Request :
- Method : GET
- Endpoint : `/api/companies`
- Header :
  - Accept : application/json
- Query Param :
    - size : number
    - page : number
    
Response :
- Header : 
  - X-Pagination : 
    ```json
    {
      "page": "integer",
      "size": "integer",
      "totalPage": "integer",
      "totalData": "integer",
      "hasPrevious": "bool",
      "hasNext": "bool"      
    }
    ```
```json
{
  "code": "integer",
  "status": "string",
  "data": [
    {
      "id": "string,unique",
      "name": "string",
      "address": "string",
      "country": "string",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "id": "string,unique",
      "name": "string",
      "address": "string",
      "country": "string",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}
```

## Employee

### Create Employee

### Get Employee

### Update Employee

### Delete Employee

### List Employee

