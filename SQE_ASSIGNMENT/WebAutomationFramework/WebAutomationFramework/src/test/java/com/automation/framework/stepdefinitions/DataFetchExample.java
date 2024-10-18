package com.automation.framework.stepdefinitions;

import com.automation.framework.utils.ExcelUtils;

import java.sql.ResultSet;

import com.automation.framework.utils.DatabaseUtils;
import com.automation.framework.utils.RedisUtils;

public class DataFetchExample {

    public void fetchData() throws Exception {
        // Excel Data
        ExcelUtils excelUtils = new ExcelUtils("path/to/excel/file.xlsx");
        String excelData = excelUtils.getCellData("Sheet1", 1, 0);
        excelUtils.close();

        // Database Data
        DatabaseUtils dbUtils = new DatabaseUtils("jdbc:mysql://localhost:3306/mydb", "user", "password");
        ResultSet resultSet = dbUtils.executeQuery("SELECT username FROM users WHERE id=1");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }
        dbUtils.close();

        // Redis Data
        RedisUtils redisUtils = new RedisUtils("localhost", 6379);
        redisUtils.setValue("key1", "value1");
        String redisValue = redisUtils.getValue("key1");
        System.out.println(redisValue);
        redisUtils.close();
    }
}
