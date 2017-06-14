# rest-oauth
POC - CAS Oauth with Grails spring security rest plugin

This poc shows how to use the CAS Ouath with resource owner password credentials grant type and integrate with spring security rest plugin for mobile clients.
And without needing client side browser redirect.

1. Check out https://github.com/casinthecloud/cas-pac4j-oauth-demo
2. run mvn clean package on above repo
3. run java -jar cas-pac4j-oauth-server-demo/target/cas2.war — it will run cas server on port 8081
4. check out https://github.com/snimavat/rest-oauth
5. use gradle 3.4.1/grails 3.2.9 — gradle bootRun or grails run-app
6. you will need a rest client plugin installed in ur browser
7. From ur browser, send post request to http://localhost:8081/cas/oauth2.0/accessToken?client_id=this_is_the_key&grant_type=password&username=jleleu&password=jleleu
8. From ur browser  http://localhost:8080/casOauth/authenticate?token=xxxx (token from step 7)
9. From ur browser: http://localhost:8080/api — pass header X-Auth-Token=xxx from step 8 above

You should get authenticated and receive echo from api controller
