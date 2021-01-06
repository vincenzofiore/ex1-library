# Book Library ![Java CI](https://github.com/vincenzofiore/ex1-library/workflows/Java%20CI/badge.svg?branch=develop)
Applicazione che consente di gestire una biblioteca distribuita e condivisa tra un gruppo di amici.

# OpenAPI
[ui-index](http://localhost:8080/swagger-ui/index.html)

[api-docs](http://localhost:8080/v3/api-docs)

# Registration (username must be unique)
To register a new application user, run the following command:

`curl -H "Content-Type: application/json" -X POST -d '{"username": "any", "password": "any"}' http://localhost:8080/users/sign-up`

# Login
To login as registered user run the following command:

`curl -i -H "Content-Type: application/json" -X POST -d '{"username": "user0","password": "password1"}' http://localhost:8080/login`

In the response header you will find the token that allows you to use the other REST services: 

`Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTYxMDQ3NDk1N30.p1a3HmThHsgfTdo9XIPOULqB4PL9Xxc27W54pAmGSJb_rbtTp7qWYDAX_ltY7_IAbAYNu_aF5qcKOxnCcb_OJQ`

Now you can use the Bearer:

`curl -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMCIsImV4cCI6MTYxMDQ3NDk1N30.p1a3HmThHsgfTdo9XIPOULqB4PL9Xxc27W54pAmGSJb_rbtTp7qWYDAX_ltY7_IAbAYNu_aF5qcKOxnCcb_OJQ" http://localhost:8080/booklibrary/core/ANTONELLA/status`


