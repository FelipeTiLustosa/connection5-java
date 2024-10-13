package src.applicantion;

import src.db.DB;
import src.db.DbException;
import src.db.DbIntegrityException;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "DELETE  FROM department "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1,2  );

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            throw  new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
