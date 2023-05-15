package sql.demo.repository;

import java.sql.SQLException;

public class Bus extends BaseTable implements TableOperations{

    public Bus() throws SQLException {
        super("buses");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS buses(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "changeProbability INTEGER NOT NULL,"+
                "delta INTEGER NOT NULL)", "Создана таблица " + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
    }
}
