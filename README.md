# Getting Started

### Build
mvn clean install

### Deploy
Deploy infrastructure through AWS CDK
cdk deploy

### Assumptions 
The application has been split into three different package
	The Model Layer (Data Layer: Employee.java, MonthlyPayslip.java) which handles incoming data
	The Service Layer (Business Layer: EmployeeService.java) which handles all the calculations
	The Rest Layer (Controller EmployeeEndpoint.java) which handles the output that is being shown
	
Employee and MonthlyPayslip Models are created separately but work closely together. The Employee Model accepts user inputs, which the application will feed into the MonthlyPayslip Model to be handled by the EmployeeService class to compute calculations. The calculated values will then be passed back to the MonthlyPayslip Model to be stored which we can then use the Controller class (EmployeeEndpoint) to display the results in JSON format.

The reason for this structure was to allow user inputs to be simplified and have the variables such as gross income, income tax and so on to be handled by the back-end to apply the calculations, which will be output to the user.

The output will return a List object to allow users to input multiple employees and be returned with multiple outputs.

### Access endpoints

*POST http://localhost:5000/employee/payslip

curl --location --request POST 'http://localhost:5000/employee/payslip' \ 
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"firstName",
    "lastName":"lastName",
    "annualSalary":10000,
    "paymentMonth":1,
    "superRate":0.01
}'


### Further Improvements
Add comments
Add Security
Add Database to store employees