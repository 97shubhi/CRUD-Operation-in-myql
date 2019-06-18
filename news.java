import java.sql.*;

class ConnectionTest {
    public static void main(String args[]) {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException clx) {
                System.out.println(clx + "Exception class not found coming");
                }
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement statement = con.createStatement();
            String query = "Select * from students";
            ResultSet rs = statement.executeQuery(query);
            System.out.println();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "  + rs.getInt(4));
            }
            /*String q = "INSERT INTO students(id,name,fathername,age) VALUES ('3', 'Lokesh', 'Kumar', '7')";
            rs = statement.executeQuery(q);*/
            String q = " insert into students (name, fathername, age)"
            + " values (?, ?, ?)";

     
            PreparedStatement preparedStmt = con.prepareStatement(q);
            //preparedStmt.setInt (1,2);
            preparedStmt.setString (1, "ss");
            preparedStmt.setString(2, "ff");
            preparedStmt.setInt(3, 45);
            preparedStmt.execute();
            con.close();

         } catch (Exception e) {
            System.out.println(e);

             }


    }


}
