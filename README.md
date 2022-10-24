# Table of Contents

1. [Step Project](#step-project---tinder-clone)
2. [Tech Stack](#tech-stack)
   <!-- 1. [User service](#user-service)
        1. [User model](#user-model)
        2. [Skill model](#skill-model)
        3. [UserSkill model](#userskill-model)
    2. [Timestamp service](#timestamp-service) -->
3. [Back-End](#back-end)
    1. [Endpoints](#endpoints)
        1. [Login](#login)
        2. [Register](#register)
        3. [All users](#all-users)
        4. [Liked users](#liked-users)
        5. [Messages](#messages)
        6. [Logout](#logout)


# Step Project - Tinder Clone

This is the source code of the 2<sup>nd</sup> step project at ABB - Backend Development course.

The main goal of this project was to create a Java Servlet App which represents a simple clone of the Tinder App that contains some of its essential features.

This project was a group work and developed by two students:
* __Parviz Valiyev__
* __Farid Aliyev__

# Tech Stack
In this project following technologies were used:

**Back-end:** Java Maven Build

**Front-end:** FreeMarker, HTML, CSS

**Database:** PostgreSQL

# Back-End

## Endpoints

### Login

```bash
  GET /login
```
### Register

```bash
  GET /register
```

### All Users

```bash
  GET /users
```

### Liked Users

```bash
  GET /liked
```

### Messages

```bash
  GET /message/{id}
```

| Parameter | Type      | Description  |
|:----------|:----------|:-------------|
| `id`      | `Integer` | **Required** |


### Logout

```bash
  GET /logout
```
<hr>



