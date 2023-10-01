
# Reece Spring Boot

A brief description of what this project does and who it's for

Spring boot project to have multiple endpoints to maintain address books and contacts

## Features

- Embedded in Mem Database used (H2)
- Dockerised the solution
- Unit test cases written using DtaJpa


## API Reference

#### Get all address

```http
  GET /address-books
```
 Returns the address stored in address book table


#### Get contact from a  certain address
```http
  GET /{id}/contacts
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of address-book table |


#### Deletes addesses from address-book table
```http
  Delete /address-books/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of address-book table |


#### Posts new Addresses in address-book table
```http
  Post /address-books
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**. name of address-book table |
| `phoneNumber`      | `string` | **Required**. phone nUmber of the user |
| `contactid`      | `string` | **Required**. Primary key of contact table |

#### Posts new Contact in address-book table
```http
  Post /contacts
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**. name of address-book table |
| `emailId`      | `string` | **Required**. pemailId of the contact |


#### Deletes contacts from contact table
```http
  Delete /contacts/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of contact table |

#### Get all contacts

```http
  GET /contacts
```
 Returns the contacts stored in contact table

#### Get all unique contacts for an adress

```http
  GET /api/contacts/all
```
 Returns the unique contacts stored
## Deployment

To run this project

```bash
  docker run -p 8080:8080 reece_spring_test:kanav_reece
```

