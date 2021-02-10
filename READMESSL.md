#This is the guide to re-generate the certificate, when it gets expired.

#To generate https certificate

use keytool command with parameters hostname and RSA key algorithm with key size 2048 and self signed certificate PKCS12: Public Key Cryptographic Standards
The certificate "creditcard-ssl-key.p12" is generated on 9 Feb 2021 and will remain valid for 3650 days

password used to generate the certificate: changeit
to generate the certificate, I have used below data:
Is CN=neha pandey, OU=sap, O=sap, L=sap, ST=sap, C=uk correct? y

In order to run the below command on MAC, make sure that you shift to sudo bash 

$sudo bash
and then run below command  to generate the certificate:

keytool -genkeypair -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore creditcard-ssl-key.p12 -validity 3650

#Once the certificate is generated place the certificate in the src/main/resources folder

