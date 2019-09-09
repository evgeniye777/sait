package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DataBaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+"?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void  signUpuser(User user) {
        String firstname=user.getFirstname();
        String lastname=user.getLastname();
        String username=user.getUsername();
        String password=user.getPassword();
        String location=user.getLocation();
        String gender=user.gender;
        String insert = "INSERT INTO "+Const.USER_TABLE+"("+Const.USER_FIRSTNAME+","+Const.USER_LASTNAME+","
                +Const.USER_USERNAME+","+Const.USER_PASSWORD+","+Const.USER_LOCATION+","+
                Const.USER_GENDER+")"+"VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,firstname);
            prSt.setString(2,lastname);
            prSt.setString(3,username);
            prSt.setString(4,password);
            prSt.setString(5,location);
            prSt.setString(6,gender);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
