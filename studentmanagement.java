import java.sql.*;
import java.util.*;
class Student {
                int id,age;
                String name,fathername;
                public void setid(int id ) {
                    this.id = id;
                }
                public void setname(String name) {
                    this.name = name;
                }
                public void setfathername(String fathername) {
                    this.fathername = fathername;

                }
                public void setage(int age) {
                    this.age = age;
                }
                public int getid() {
                    return id;
                }
                public String getname(){
                    return name;

                }
                public String getfathername() {
                    return fathername;
                }
                public int getage() {
                    return   age;
                }

}
class StudentData{
    public  void updateData(){

            Student student = new Student();
            Scanner scanner = new Scanner(System.in);
            

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException clx) {
                System.out.println(clx + "Exception class not found coming");
                }

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement statement = con.createStatement();
            
                
                System.out.println("enter id for update");
                int id = scanner.nextInt();
                student.setid(id);
                scanner.nextLine();

                System.out.println("enter student name");
                String name = scanner.nextLine();
                student.setname(name);
                System.out.println("enter father name");
                String fathername = scanner.nextLine();
                student.setfathername(fathername);
                System.out.println("enter age");
                int age = scanner.nextInt();
                student.setage(age);

                String query = "update students set name = ?,fathername = ?,age = ? where id = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, student.getname());
                preparedStmt.setString(2, student.getfathername());
                preparedStmt.setInt(3, student.getage());
                preparedStmt.setInt(4, student.getid());
                preparedStmt.executeUpdate();
               
              
                
            
            
            con.close();
        }
         catch (Exception e) {
            System.out.println(e);

            }

        }
        public  void deleteData(){

            Student student = new Student();
            Scanner scanner = new Scanner(System.in);
            

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException clx) {
                System.out.println(clx + "Exception class not found coming");
                }

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement statement = con.createStatement();
            
                
                
                System.out.println("enter id for delete");
                int id = scanner.nextInt();
                student.setid(id);
                scanner.nextLine();

                String query = "delete from students where id = ?";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                
                preparedStmt.setInt(1, student.getid());
                preparedStmt.execute();
               

                
            
            
            con.close();
        }
         catch (Exception e) {
            System.out.println(e);

            }
    }
    public  void displayData(){

            Student student = new Student();
            Scanner scanner = new Scanner(System.in);
            

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
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "  + rs.getInt(4));
                }
               

                
            
            
            con.close();
        }
         catch (Exception e) {
            System.out.println(e);

            }

        }
        public  void insertData(){

            Student student = new Student();
            Scanner scanner = new Scanner(System.in);
            

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException clx) {
                System.out.println(clx + "Exception class not found coming");
                }

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
            Statement statement = con.createStatement();
            
                
                
                System.out.println("enter student details");
            System.out.println("enter student name");
            String name = scanner.nextLine();
            scanner.nextLine();
            student.setname(name);
            System.out.println("enter father name");
            String fathername = scanner.nextLine();
            student.setfathername(fathername);
            System.out.println("enter age");
            int age = scanner.nextInt();
            student.setage(age);

            
            String q = " insert into students (name, fathername, age)"
            + " values (?, ?, ?)";

     
            PreparedStatement preparedStmt = con.prepareStatement(q);
            //preparedStmt.setInt (1,2);
            preparedStmt.setString (1, student.getname());
            preparedStmt.setString(2, student.getfathername());
            preparedStmt.setInt(3, student.getage());
            preparedStmt.execute();
               

                
            
            
            con.close();
        }
         catch (Exception e) {
            System.out.println(e);

            }
    }
    public void swit(){
        Scanner scanner = new Scanner(System.in);
            int choice=0;
            System.out.println("enter 1 for insert details");
            System.out.println("enter 2 for display details");
            System.out.println("enter 3 for update  details");
            System.out.println("enter 4 for delete  details");
            System.out.println("enter 5 for exit  details");
            System.out.println();
                System.out.print("your choice is:-   ");

            if(scanner.hasNextInt()){
             choice = scanner.nextInt();
            }
            if(choice==1 || choice==2 || choice==3|| choice==4 ){
            switch (choice) {
                case 1:
            insertData();
            swit();
           swit();
            break;
            case 2:
                displayData();
                swit();
            break; 
                
            case 3:
                updateData();
                swit();
                break;
            case 4:
                deleteData();
                 swit();
                break;
            }}
            else if(choice==5)
                    {
                    System.out.println("you press exit");

                }
                else{
                    System.out.println("number not valid"); 
                    swit();
                }
           
             }


}


class StudentManagement extends StudentData {
    public static void main(String args[]) {
            StudentData sd = new StudentData();
            
            sd.swit();
            

    }


}


