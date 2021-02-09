We will be configuring Spring Security and JWT for performing 2 operations-

Generating JWT - Expose a POST API with mapping /authenticate. On passing correct username and password it will generate a JSON Web Token(JWT)
Validating JWT - If user tries to access GET API with mapping /hello. It will allow access only if request has a valid JSON Web Token(JWT)

In application.properties we have specified the secret key which will be used for hashing algorithm. 
The secret key is combined with the header and the payload to create a unique hash. 
We are only able to verify this hash if Client have the secret key.

#Architecture diagram:
Go to the root DIR  
credit-card-system/JWT_Architecture_diagram.pngJWT_Architecture_diagram.png


#creating the token -

1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
2. Sign the JWT using the HS512 algorithm and secret key.
3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string


We have generated the Bcrypt password for now, that can be generated online using below link:
https://www.javainuse.com/onlineBcrypt

and the parameters used to generate are (test, 20)

we are using username = test 
and brypt password = $2a$10$cluoi/Lvix8ladV3RdLQIeUZZJO85Oe3iiiXpXs3Wlc4nmgwuO1cW

#Generate the token using below command
curl --location --request POST 'localhost:8080/authenticate' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=4F363B4B2D78F2A094DD6BA900EA11E8' \
--data-raw '{
	"username":"test",
	"password":"test"
}'

1) In order to access GET endpoint, please use below curl command
curl --location --request GET 'http://localhost:8080/creditcard/getAll' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjEyODQ5MDU2LCJpYXQiOjE2MTI4MzEwNTZ9.kpTULcxU0_xLObEAm51acF2wRc0I35jXXuF-y1CCDP9CcDoBPov5_ol4IDRj632fhgD98wf7ea1aYU3UcX2xNA' \
--header 'Cookie: JSESSIONID=4F363B4B2D78F2A094DD6BA900EA11E8' \
--data-raw ''

Please note that the Token needs to be replaced by the Token generated in above step

2) In order to access POST endpoint, please use below command
curl --location --request POST 'http://localhost:8080/creditcard/add' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjEyODQ5MDU2LCJpYXQiOjE2MTI4MzEwNTZ9.kpTULcxU0_xLObEAm51acF2wRc0I35jXXuF-y1CCDP9CcDoBPov5_ol4IDRj632fhgD98wf7ea1aYU3UcX2xNA' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=4F363B4B2D78F2A094DD6BA900EA11E8' \
--data-raw '{
 "userName" : "test1",
 "cardNumber" : "12345678903555",
 "cardLimit": "200",
 "accountBalance": "100"
}'

Please note that the Token needs to be replaced by the Token generated in above step
