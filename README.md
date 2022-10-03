ixigo QA automation assignment

This is JAVA and selenium based automation code for ixigo.

Download project in your local machine and Import Project as  'maven project'.



----pre-requsite----
JDK 8+
testNG plugin for eclipse


Note: -  You can execute this project by testng.xml file , from maven or by selecting test class and run as testNG.

It is basic framework with limited functionality and is designed specifically for given problem statement.

Problem : -
for any domestic round trip combination generate a lujst of top 20 cheapest flights combination on ixigo website using UI/API automation script


sample url :  https://www.ixigo.com/search/result/flight?from=DEL&to=BLR&date=03112022&returnDate=13112022&adults=1&children=0&infants=0&class=e&source=Search%20Form

website https://www.ixigo.com

departure date  - currentdate + 10 days (03012022)
arrival date  - currentdate +11 days (13112022)
No. of adults  = 1;
source/destination = any city 