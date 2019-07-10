package com.absingh.photoApp.dataAcces.databases;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AsyncQuery extends AsyncTask<String,Void, ArrayList<String>> {
    private Connection connect;
    private Statement statement = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet ;

    public AsyncQuery() {
        this.connect = null;
        this.preparedStatement = null;
        this.resultSet = null;
    }

    @Override
    protected ArrayList<String> doInBackground(String... strings) {
        ArrayList<String> results=new ArrayList<>();
        try {
            Class.forName(SQLHelper.driver);

            String username = SQLHelper.usr;
            String password = SQLHelper.pwd;
            String url = SQLHelper.url;
            String query=strings[0];
            connect = DriverManager.getConnection(url, username, password);
            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                results.add(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getInt(4)+" "+resultSet.getInt(5));
            }

        } catch (ClassNotFoundException | SQLException e) {
            Log.e("error: ", e.getMessage());
        } finally {
            close();
        }
        return results;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            Log.e("error de close",e.getMessage());
        }
    }
}
