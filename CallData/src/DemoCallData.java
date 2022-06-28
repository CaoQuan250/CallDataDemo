import java.sql.*;


public class DemoCallData {
    public DemoCallData() throws SQLException{}
    public static void getAllData() throws SQLException {
        Connection conn = Connector.getMssql();
        CallableStatement cast = conn.prepareCall("{call getall}");
        ResultSet resultSet = cast.executeQuery();
        while (resultSet.next()){
            System.out.println("name: "+ resultSet.getString(2));
        }
        resultSet.close();
        cast.close();

    }
    public static void preparedStatementDemo() throws SQLException {
        Connection conn = Connector.getMssql();
        CallableStatement cast = conn.prepareCall("{call getall}",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = cast.executeQuery();
        if (resultSet.first()){
            System.out.println(resultSet.getString(2));
        }
        if (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
        if (resultSet.previous()) {
            System.out.println(resultSet.getString(2));
        }
        if (resultSet.relative(4)){
            System.out.println(resultSet.getString(2));
        }
        if (resultSet.absolute(3)){
            System.out.println(resultSet.getString(2));
        }
    }
    public static void update() throws SQLException{
        Connection conn = Connector.getMssql();
        PreparedStatement cast = conn.prepareStatement("select * from class",
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = cast.executeQuery();
        if(resultSet.absolute(3)){
            resultSet.updateString("name","adudu");
            resultSet.updateRow();
        }
    }

    public static void main(String[] args) throws SQLException{
        //preparedStatementDemo();
        update();
        getAllData();

    }
}
