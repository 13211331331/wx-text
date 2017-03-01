package com.hhl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 * @author HuangHL
 * @date 2017/3/1
 * @see
 */
public class SqlServer2008Test
{


    public static void main(String[] args) throws SQLException
    {
        Connection conn = getConnection();
        Statement st = null;
         st = conn.createStatement();
        ResultSet set = st.executeQuery("select * from t_user");
        while (set.next()) {
            System.out.println(set.getString("name"));

        }
        set.close();
        st.close();
        conn.close();
    }

    public static Connection getConnection() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String url = "jdbc:jtds:sqlserver://192.168.0.70:63679;DatabaseName=zhongtou";
            String username = "sa";
            String password = "cfwx2017";
            Connection conn = DriverManager.getConnection(url, username,
                    password);
            return conn;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
