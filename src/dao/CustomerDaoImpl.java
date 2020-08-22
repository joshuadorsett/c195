package dao;

import utilities.MakeConnection;
import utilities.MakePreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author joshuadorsett
 */
public class CustomerDaoImpl {
    /**
     * create Customer object and convert it into SQL code and add it to database
     */
    public static void addCustomer() throws SQLException{
        // from text field make a new Customer Object adn then convert that customer object into sql with concactaenion of the variables?

    }

    /**
     * get a  Customer object from database
     */
    public void getCustomer() throws SQLException{

    }

    /**
     * get all Customer objects from database
     */
    public void getAllCustomers() throws SQLException{

    }

    /**
     * modify Customer object and convert it into SQl code and update database
     */
    public void modifyCustomer() throws SQLException {
        Connection connection = MakeConnection.getConnection(); //get reference to connection object

        // make the sql code with ? for each value that is variable. this index starts at 1 and skips if a value is entered.
        String updateStatement = "UPDATE country SET country = ?, createdBy = ? WHERE country = ?";

        //create prepared statement
        MakePreparedStatement.makePreparedStatement(connection, updateStatement); //create statement object
        PreparedStatement ps = MakePreparedStatement.getPreparedStatement();

        // make variables for ps
        String countryName, newCountry, createdBy;

        // keyboard input
        Scanner keyboard = new Scanner(System.in);
        //promt one enter country for filter
        System.out.print("enter a country to update! ");
        countryName = keyboard.nextLine();
        // prompt for new country
        System.out.print("enter new country! ");
        newCountry = keyboard.nextLine();
        //prompt for who created it
        System.out.print("enter user name! ");
        createdBy = keyboard.nextLine();

        // key-value mapping
        ps.setString(1, newCountry);
        ps.setString(2, createdBy);
        ps.setString(3, countryName);

        //execute statement
        ps.execute();

        if (ps.getUpdateCount() > 0 ){
            System.out.println(ps.getUpdateCount() + " rows updated.");
        } else {
            System.out.println("no rows updated");
        }

    }
    /**
     * delete Customer object from database
     */
    public void deleteCustomer() throws SQLException{
        Connection connection = MakeConnection.getConnection(); //get reference to connection object

        // make the sql code with ? for each value that is variable. this index starts at 1 and skips if a value is entered.
        String deleteStatement = "DELETE FROM country WHERE country = ?";

        //create prepared statement
        MakePreparedStatement.makePreparedStatement(connection, deleteStatement); //create statement object
        PreparedStatement ps = MakePreparedStatement.getPreparedStatement();

        // make variables for ps
        String countryName;

        // keyboard input
        Scanner keyboard = new Scanner(System.in);

        System.out.print("enter a country to delete! ");
        countryName = keyboard.nextLine();

        // key-value mapping
        ps.setString(1, countryName);


        //execute statement
        ps.execute();

        if (ps.getUpdateCount() > 0 ){
            System.out.println(ps.getUpdateCount() + " rows deleted.");
        } else {
            System.out.println("no rows deleted");
        }

    }
}