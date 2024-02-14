# SauceDemo

This framework is created to automate some test cases for the SauceDemo website.
The project have 3 main packages: Pages, data & Tests Packages.
- The first one Pages, contain some classes created for each page of the product like: Login Page, Home Page,...
   these classes created containing the elements of each page and thier corresponding functionalities that would be used.

- The Socend one Tests, contain the classes which include the test cases that would be checked using the data from an excel sheet and using also the functions and the element defined on the classes which created in the Pages Package

   - We have classes in Tests Package like: LoginTest, which validate the successful login and un successful login
     also there classes to check selecting a product till completing the checkout process.

- The Third one is Data which include the Excel file which contain the data to be used, and the other file is the excel reader which allows to read these data from the file.
