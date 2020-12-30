/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queryrunner;

import com.sun.tools.javac.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * QueryRunner takes a list of Queries that are initialized in it's constructor
 * and provides functions that will call the various functions in the QueryJDBC class 
 * which will enable MYSQL queries to be executed. It also has functions to provide the
 * returned data from the Queries. Currently the eventHandlers in QueryFrame call these
 * functions in order to run the Queries.
 */
public class QueryRunner {

    public QueryRunner() {
        this.m_jdbcData = new QueryJDBC();
        m_updateAmount = 0;
        m_queryArray = new ArrayList<>();
        m_error = "";
        
        this.m_projectTeamApplication = "Double Star Ranch";
        
        // Each row that is added to m_queryArray is a separate query. It does not work on Stored procedure calls.
        // The 'new' Java keyword is a way of initializing the data that will be added to QueryArray. Please do not change
        // Format for each row of m_queryArray is: (QueryText, ParamaterLabelArray[], LikeParameterArray[], IsItActionQuery, IsItParameterQuery)
        
        //    QueryText is a String that represents your query. It can be anything but Stored Procedure
        //    Parameter Label Array  (e.g. Put in null if there is no Parameters in your query, otherwise put in the Parameter Names)
        //    LikeParameter Array  is an array I regret having to add, but it is necessary to tell QueryRunner which parameter has a LIKE Clause. If you have no parameters, put in null. Otherwise put in false for parameters that don't use 'like' and true for ones that do.
        //    IsItActionQuery (e.g. Mark it true if it is, otherwise false)
        //    IsItParameterQuery (e.g.Mark it true if it is, otherwise false)

        m_queryArray.add(new QueryData("SELECT * FROM horse", null, null, false, false, "Select All Horses"));

        m_queryArray.add(new QueryData("SELECT horse_race_name, hay_type, hay_flakes, grain_name, grain_scoops\n" +
                "FROM horse, diet, hay, grain\n" +
                "WHERE horse.diet_diet_id = diet.diet_id\n" +
                "AND diet.hay_hay_id = hay.hay_id\n" +
                "AND diet.grain_grain_id = grain.grain_id\n" +
                "ORDER BY horse_race_name;", null, null, false, false, "Feeding Info"));

        m_queryArray.add(new QueryData("SELECT horse_race_name, paddock_paddock_id, turnout_start_hr, turnout_end_hr," +
                "\n" +
                "turnout_end_hr - turnout_start_hr + 1 AS total_turnout_hrs\n" +
                "FROM horse, turnout\n" +
                "WHERE horse.TURNOUT_turnout_id = turnout.turnout_id\n" +
                "ORDER BY turnout_start_hr, paddock_paddock_id;", null, null, false, false, "Turnout Schedule"));

        m_queryArray.add(new QueryData("SELECT horse_race_name,\n" +
                "ROUND(COUNT(CASE WHEN finish = 1 THEN 1 END) / COUNT(finish) * 100, 2) AS first_place_percentage,\n" +
                "training_regimen_id,\n" +
                "flatwork_hours, flatwork_days_per_week,\n" +
                "hot_walker_hours, hot_walker_days_per_week\n" +
                "FROM horse, training_regimen, `Racing Results`\n" +
                "WHERE horse.horse_id = `Racing Results`.horse_horse_id\n" +
                "AND horse.training_regimen_training_regimen_id = training_regimen.training_regimen_id\n" +
                "GROUP BY horse_horse_id\n" +
                "ORDER BY first_place_percentage DESC;", null, null, false, false, "Horses by Win PCT"));

        m_queryArray.add(new QueryData("SELECT\n" +
                "jockey_jockey_id1, jockey_fname, jockey_lname, jockey_wage,\n" +
                "ROUND(COUNT(CASE WHEN finish = 1 THEN 1 END) / COUNT(finish) * 100, 2) AS\n" +
                "first_place_percentage,\n" +
                "ROUND(COUNT(CASE WHEN finish BETWEEN 1 AND 3 THEN 1 END) / COUNT(finish) * 100, 2) AS\n" +
                "top_3_percentage\n" +
                "FROM `Racing Results` JOIN jockey ON jockey_jockey_id1 = jockey_id\n" +
                "GROUP BY jockey_jockey_id1;", null, null, false, false, "Jockey Performance PCT"));

        m_queryArray.add(new QueryData("SELECT\n" +
                "trainer_trainer_id1, trainer_fname, trainer_lname, trainer_wage,\n" +
                "ROUND(COUNT(CASE WHEN finish = 1 THEN 1 END) / COUNT(finish) * 100, 2) AS\n" +
                "first_place_percentage,\n" +
                "ROUND(COUNT(CASE WHEN finish BETWEEN 1 AND 3 THEN 1 END) / COUNT(finish) * 100, 2) AS\n" +
                "top_3_percentage\n" +
                "FROM `Racing Results` JOIN trainer ON trainer_trainer_id1 = trainer_id\n" +
                "GROUP BY trainer_trainer_id1;", null, null, false, false, "Trainer Performance PCT"));

        m_queryArray.add(new QueryData("SELECT\n" +
                "`Breeding Rights`.horse_horse_id, horse_race_name,\n" +
                "AVG(stud_fee_total) AS average_stud_fee,\n" +
                "ROUND(COUNT(CASE WHEN finish = 1 THEN 1 END) / COUNT(finish) * 100, 2) AS first_place_percentage,\n" +
                "ROUND(COUNT(CASE WHEN finish BETWEEN 1 AND 3 THEN 1 END) / COUNT(finish) * 100, 2) AS top_3_percentage\n" +
                "FROM `Breeding Rights`,`Racing Results`, horse\n" +
                "WHERE `Breeding Rights`.horse_horse_id = `Racing Results`.horse_horse_id\n" +
                "AND `Racing Results`.horse_horse_id = horse_id\n" +
                "GROUP BY horse_horse_id\n" +
                "ORDER BY average_stud_fee DESC;", null, null, false, false,
                "Stud Fee to Performance Percentage Correlation"));   // THIS NEEDS TO CHANGE FOR YOUR APPLICATION


        m_queryArray.add(new QueryData("SELECT\n" +
                "jockey_jockey_id1, jockey_fname, jockey_lname, jockey_wage,\n" +
                "ROUND(COUNT(CASE WHEN finish = 1 THEN 1 END) / COUNT(finish) * 100, 2) AS\n" +
                "first_place_percentage,\n" +
                "ROUND(COUNT(CASE WHEN finish BETWEEN 1 AND 3 THEN 1 END) / COUNT(finish) * 100, 2) AS\n" +
                "top_3_percentage\n" +
                "FROM `Racing Results` JOIN jockey ON jockey_jockey_id1 = jockey_id\n" +
                "GROUP BY jockey_jockey_id1;", null, null, false, false,
                "Jockey Performance Percentages and Corresponding Wage"));

        m_queryArray.add(new QueryData("INSERT INTO `horse` (`horse_id`, `horse_race_name`,\n" +
                "`horse_purchase_price`, `gender_gender_id`,\n" +
                "`horse_age`, `horse_height`,\n" +
                "`horse_weight`, `diet_diet_id`,\n" +
                "`TURNOUT_turnout_id`, `training_regimen_training_regimen_id`,\n" +
                "`INJURY_injury_id`, `bloodline_id`)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
                new String [] {"Horse ID", "Name", "Purchase Price", "Gender ID", "Age", "Height", "Weight",
                               "Diet ID", "Turnout ID", "Training Regimen ID", "Injury ID", "Bloodline ID"},
                new boolean [] {false, false, false, false, false, false, false, false, false, false, false, false},
                true, true, "Add New Horse to Database"));


        m_queryArray.add(new QueryData("select distinct horse_id as `Horse ID`, horse_race_name as `Name`, gender" +
                ".gender_name as Gender,\n" +
                "sire_name as Sire, mare_name as Mare\n" +
                "from horse inner join gender on horse.gender_gender_id = gender.gender_id\n" +
                "inner join Bloodline on horse.`bloodline_id` = `Bloodline`.bloodline_id\n" +
                "inner join `Racing Results` on horse.horse_id = `Racing Results`.horse_horse_id\n" +
                "inner join sire on `Bloodline`.sire_id = sire.sire_id\n" +
                "inner join mare on `Bloodline`.mare_id = mare.mare_id\n" +
                "inner join trainer on `Racing Results`.trainer_trainer_id1 = trainer.trainer_id\n" +
                "where `trainer_lname` = ?\n" +
                "order by horse.horse_id asc;", new String [] {"Trainer Last Name"},
                new boolean [] {false}, false, true, "Horses Trained by Particular Trainer"));

    }


    public int GetTotalQueries() {
        return m_queryArray.size();
    }
    
    public int GetParameterAmtForQuery(int queryChoice) {
        QueryData e = m_queryArray.get(queryChoice);
        return e.GetParmAmount();
    }
              
    public String  GetParamText(int queryChoice, int parmnum ) {
       QueryData e=m_queryArray.get(queryChoice);        
       return e.GetParamText(parmnum); 
    }   

    public String GetQueryText(int queryChoice) {
        QueryData e=m_queryArray.get(queryChoice);
        return e.GetQueryString();        
    }
    
    /**
     * Function will return how many rows were updated as a result
     * of the update query
     * @return Returns how many rows were updated
     */
    
    public int GetUpdateAmount() {
        return m_updateAmount;
    }
    
    /**
     * Function will return ALL of the Column Headers from the query
     * @return Returns array of column headers
     */
    public String [] GetQueryHeaders() {
        return m_jdbcData.GetHeaders();
    }
    
    /**
     * After the query has been run, all of the data has been captured into
     * a multi-dimensional string array which contains all the row's. For each
     * row it also has all the column data. It is in string format
     * @return multi-dimensional array of String data based on the resultset 
     * from the query
     */
    public String[][] GetQueryData() {
        return m_jdbcData.GetData();
    }

    public String GetProjectTeamApplication() {
        return m_projectTeamApplication;
    }

    public boolean  isActionQuery (int queryChoice) {
        QueryData e = m_queryArray.get(queryChoice);
        return e.IsQueryAction();
    }
    
    public boolean isParameterQuery(int queryChoice) {
        QueryData e = m_queryArray.get(queryChoice);
        return e.IsQueryParm();
    }
    
     
    public boolean ExecuteQuery(int queryChoice, String [] parms) {
        boolean bOK = true;
        QueryData e = m_queryArray.get(queryChoice);
        bOK = m_jdbcData.ExecuteQuery(e.GetQueryString(), parms, e.GetAllLikeParams());
        return bOK;
    }
    
    public boolean ExecuteUpdate(int queryChoice, String [] parms) {
        boolean bOK = true;
        QueryData e = m_queryArray.get(queryChoice);
        bOK = m_jdbcData.ExecuteUpdate(e.GetQueryString(), parms);
        m_updateAmount = m_jdbcData.GetUpdateCount();
        if(!bOK)
            m_error = m_jdbcData.GetError();
        return bOK;
    }   
    
      
    public boolean Connect(String szHost, String szUser, String szPass, String szDatabase) {
        boolean bConnect = m_jdbcData.ConnectToDatabase(szHost, szUser, szPass, szDatabase);
        if (!bConnect) {
            m_error = m_jdbcData.GetError();
        }
        return bConnect;
    }
    
    public boolean Disconnect() {
        // Disconnect the JDBCData Object
        boolean bConnect = m_jdbcData.CloseDatabase();
        if (!bConnect)
            m_error = m_jdbcData.GetError();
        return true;
    }
    
    public String GetError() {
        return m_error;
    }

    /**
     * Executes the user-selected query for the console application.
     *
     * @param paramArray Array of query parameters
     * @param queryNum   Query number
     */
    public void runQuery(String[] paramArray, int queryNum) {
        System.out.println((queryNum + 1) + ": " + QueryData.getQueryNames(queryNum) + "\n");
        // If query results in an update to the database
        if (this.isActionQuery(queryNum)) {
            if (this.ExecuteUpdate(queryNum, paramArray)) {
                System.out.println("Rows affected: " + this.GetUpdateAmount());
            } else {
                this.GetError();
            }
            // If query is to only display rows (not make an update)
        } else {
            if (this.ExecuteQuery(queryNum, paramArray)) {
                this.printDataTable();
            } else {
                this.GetError();
            }
        }
    }

    /**
     * Prints to the console the data tables, similar to the output one would
     * see in a database visualizer application such as MySQL Workbench.
     */
    public void printDataTable() {
        // Array of column headers
        String[] headers = this.GetQueryHeaders();
        // Array of data to be displayed via the query
        String[][] allData = this.GetQueryData();
        // Queue to keep track of printing order
        Queue<String> toPrint = new LinkedList<>();
        // Array to keep track of spaces needed in each cell of the table
        int[] spacesForCol = new int[headers.length];
        // Add each header to the queue
        for (int i = 0; i < headers.length; i++) {
            toPrint.add(headers[i]);
            spacesForCol[i] = headers[i].length();
        }
        for (int i = 0; i < allData.length; i++) {
            for (int j = 0; j < allData[i].length; j++) {
                // Add each cell field to the queue
                toPrint.add(allData[i][j]);
                if (allData[i][j] != null) {
                    // The spaces needed in each cell is the field that is the longest
                    // length string in column
                    spacesForCol[j] = Math.max(spacesForCol[j], allData[i][j].length());
                }
            }
        }
        // Column tracker index
        int col = 0;
        while (!toPrint.isEmpty()) {
            // Create formatted output string to depend on the spaces needed in each column
            String formatSpec = "%-" + (spacesForCol[col] + 1) + "s";
            System.out.printf("| " + formatSpec, toPrint.remove());
            // Once we've printed each cell for a given row
            if (++col == headers.length) {
                System.out.println("|");
                // On a new line, print out the dividing line
                for (int i = 0; i < headers.length; i++) {
                    System.out.print("|");
                    for (int j = 0; j <= spacesForCol[i] + 1; j++) {
                        System.out.print("-");
                    }
                }
                // Print new line then reset column tracker
                System.out.println("|");
                col = 0;
            }
        }
    }

    /**
     * Returns an array containing the query parameters.
     *
     * @param queryNum Query number
     * @param console  Scanner object for user input
     * @return         String array with query parameters
     */
    public String[] getParameterArray(int queryNum, Scanner console) {
        // Get parameter amount if the query requires parameters
        int paramAmt = this.GetParameterAmtForQuery(queryNum);
        String[] paramArray = new String[paramAmt];
        // If query requires parameters
        if (this.isParameterQuery(queryNum)) {
            System.out.println("Please enter the query parameters.");
            for (int paramNum = 0; paramNum < paramAmt; paramNum++) {
                System.out.print("\t- " + this.GetParamText(queryNum, paramNum) + ": ");
                paramArray[paramNum] = console.nextLine();
            }
            System.out.println();
        }
        return paramArray;
    }

    /**
     * Prints the query names to the console.
     */
    public void printQueryNames() {
        System.out.println("\nAvailable Queries:");
        for (int i = 0; i < m_queryArray.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + QueryData.getQueryNames(i));
        }
    }
 
    private QueryJDBC m_jdbcData;
    private String m_error;    
    private String m_projectTeamApplication;
    private ArrayList<QueryData> m_queryArray;
    private int m_updateAmount;
            
    /**
     * The main method will execute either the Query Runner GUI, if no command
     * line argument is provided, or the console application, if "-console" is
     * provided as an argument.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) throws IOException {
        final QueryRunner queryrunner = new QueryRunner();
        Scanner console = new Scanner(System.in);

        if (args.length == 0) {
            //File f = new File("src/queryrunner/back.jpg");
            //System.out.println(f.getCanonicalPath()+" "+f.exists());
            //URL url = Main.class.getResource("/back.jpg");

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new QueryFrame(queryrunner).setVisible(true);
                }            
            });
        } else {
            if (args[0].equals ("-console")) {
                String hostname, username, password, database;
                System.out.print("Enter hostname: ");
                hostname = console.nextLine();
                System.out.print("Enter username: ");
                username = console.nextLine();
                System.out.print("Enter password: ");
                password = console.nextLine();
                System.out.print("Enter database: ");
                database = console.nextLine();
                /*
                * If don't want to login every time comment out lines 377 to 386 which ask for user input, and
                * add in the login credentials as string literal arguments on line 392
                */
                // Establish connection to database
                boolean connection = queryrunner.Connect(hostname, username, password, database);
                if (connection) {

                    int numQueries = queryrunner.GetTotalQueries();
                    String input;
                    do {
                        // Display queries and prompt user for input
                        queryrunner.printQueryNames();
                        System.out.print("\nEnter the query number (1 - " + numQueries + ") or enter \"exit\" to " +
                                         "quit: ");
                        input = console.nextLine();
                        System.out.println();
                        if (!input.equalsIgnoreCase("exit")) {
                            // Get integer entered by user from the input string
                            int queryNum = Integer.parseInt(input) - 1;
                            // Validate query number is within array bounds
                            if (queryNum >= 0 && queryNum < queryrunner.m_queryArray.size()) {
                                String[] paramArray = queryrunner.getParameterArray(queryNum, console);
                                queryrunner.runQuery(paramArray, queryNum);
                            } else {
                                System.out.println("Invalid query number! Please try again.");
                            }
                        }
                    } while (!input.equalsIgnoreCase("exit"));
                } else {
                    // Print error message if unable to connect to the database
                    System.out.println("Error, could not login. Please double check login credentials. More " +
                                       " details below:");
                    System.out.println(queryrunner.GetError());
                }
                connection = queryrunner.Disconnect();
                if (!connection) {
                    System.out.println(queryrunner.GetError());
                }
            }
        }
        console.close();
    }
}
