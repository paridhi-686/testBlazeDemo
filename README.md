# testBlazeDemo

Automated blazedemo travel agency https://blazedemo.com/

The automation was done using Selenium Webdriver, Maven,testng,pom,pagefactory

Folder structure

src/main/java -
com.blazedemo.base -Testbase.java  (containing logic for reading from the config.properties and involes lanuching browser)
com.blazedemo.config -config.properties (contains the url,username ,password etc required to be filled in test case)
com.blazedemo.pages - contains page factory /object respository page wise for the application
com.blazedemo.util -TestUtil.java -contains static values used in class files

src/test/java -
com.blazedemo.qa.test -contains different testcases page wise 

Test cases

Verify that on launching https://blazedemo.com/ we get redirected to travel booking application
Verify that find flights have flight details, timings and availability.
Verify that user can choose a flight succesfully after selecting place for journey start and journey end.
Verify that users enter passenger details after choosing the flight and get the booking confirmed.
Verify that on successful booking we get a booking confirmation id along with passed.
Verify that all the different types of payment cards work fine.
Verify clicking on links on landing page redirects us to corresponding link page


Tests related to the
Page title for each page
Checking elementes visible on a page 

Login page 
Verify when clicked on home link user gets redirected to home page with login and registration options
Verify login works correctly
Verify registration works correctly

