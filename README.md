# springServerSideValidation
 Validating api input data at server side and sending custom validation message for bad request validation error.

## Post User
**Request URI:** [POST] {{base URI}}+/users  
**ContentType:** application/json

### SUCCESS:
**Request Body:**
```json
{
    "firstName": "Jyoti",
    "lastName": "Singh",
    "email": "jyoti.singhd102@gmail.com",
    "password": "Test@123",
    "phone": "9874563210"
}
```
**Http Status Code:** 201 Created

### BAD REQUEST:
**Request Body:**
```json
{
    "lastName": "1253sdas",
    "email": "jyoti.singgmail.com",
    "password": "e",
    "phone": "12345"
}
```
**Http Status Code:** 400 Bad Request

**Response Body:**
```json
{
    "message": "There is a validation error",
    "fieldError": [
        {
            "field message": "First name must not be null",
            "field": "firstName"
        },
        {
            "field message": "size must be between 8 and 16",
            "field": "password"
        },
        {
            "field message": "Last name must be letter of min length 2 and max length 10.",
            "field": "lastName"
        },
        {
            "field message": "Phone number must be digit of max length 10.",
            "field": "phone"
        }
    ]
}
```

