import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement("DELETE FROM users WHERE id = ?")){

            int idToUpdate = 3;
            statement.setInt(1, idToUpdate);

            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                System.out.println("Data deleted successfully!");
            }else{
                System.out.println("Data deleted unsuccessfully!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
