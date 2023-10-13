package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidCredentials")
    public static Object invalidCredentialsDataSet(){
        Object[][] dataset = {
                {"","","Epic sadface: Username is required"},
                {"standard_user","", "Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"username","password", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user","password","Epic sadface: Username and password do not match any user in this service"}
        };
        return dataset;
    }
}
