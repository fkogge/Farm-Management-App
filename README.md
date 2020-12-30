# Farm-Management-App
Final project for the Database Systems course in Seattle University's Computer Science Fundamentals program.
## About this Project
The goal of this project was to develop a tool that can be utilized for more efficient management of farm-related tasks and to discover optimal winning strategies for racehorses, through the usage of SQL queries and stored procedures. A relational database was designed then reverese engineered in MySQL Workbench. The database was then integrated into a Java Swing Application that communicates to the database through a JDBC API. The application may also be run through a command line console version of the application, using an executable `.jar` file.
## Running the Application
There are two ways to use the application: through the Java Swing GUI or the command line console. The GUI may be invoked either through an IDE or the command prompt.
### Using an IDE:
1. Open the project code in an IDE, such as IntelliJ IDEA.
2. Run the main method in `QueryRunner.java`.
      
### Using Command Prompt
1. In the `QueryRunnerApp` folder, navigate to `classes` -> `artifacts` -> `QueryRunner_jar`, where the executable `.jar` file is located.
2. Copy the file path for `QueryRunner.jar`.
3. Open your computer's Command Prompt, then navigate to the copied file path.
4. To invoke the GUI application, run the `.jar` file using the command `java -jar QueryRunner.jar`.
5. To invoke the console application, run the `.jar` file with the additional command line argument, using the command `java -jar QueryRunner.jar -console`.

## GUI
- Once the application loads, enter the necessary login credentials then click the "Connect" button.

  ![login](https://user-images.githubusercontent.com/75452235/103324047-819af580-49fa-11eb-931f-df57f726f596.PNG)
  
  ![GUIExample](https://user-images.githubusercontent.com/75452235/103324690-739aa400-49fd-11eb-951b-ffc698121542.PNG)
## Console
- Enter the necessary login credentials to the console as prompted.

  ![enterHostname](https://user-images.githubusercontent.com/75452235/103324620-29b1be00-49fd-11eb-8302-b25d3c0aa48d.PNG)
  
  ![consoleOutput](https://user-images.githubusercontent.com/75452235/103324052-8c558a80-49fa-11eb-87c3-3dfe2bff1a26.PNG)
