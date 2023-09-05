package ibs;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {

    public static List<String> sqlReq() throws SQLException {
        List<String> names = new ArrayList<>();
        String sqlShowFood = "select * from food";
        try (HikariDataSource dataSource = new HikariDataSource()){
            dataSource.setJdbcUrl(ConfProperties.getProperty("urlBd"));
            dataSource.setUsername(ConfProperties.getProperty("username"));
            dataSource.setPassword(ConfProperties.getProperty("password"));
            try(Connection connection = dataSource.getConnection()){
                try (PreparedStatement ps  = connection.prepareStatement(sqlShowFood)) {
                    try (ResultSet resultSet = ps.executeQuery()) {
                        while (resultSet.next()) {
                            Integer id = resultSet.getInt(1);
                            String name = resultSet.getString(2);
                            names.add(resultSet.getString(2));
                            System.out.println(id + ". " + " " + name);
                        }
                        System.out.println();
                    }
                }
            }
        }
        return names;
    }

}
