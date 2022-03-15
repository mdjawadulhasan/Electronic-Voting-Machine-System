package com.example.evm.Candidate;

import com.example.evm.Voters.Voters;

import javax.sql.DataSource;
import java.sql.*;

public class Candidateutill {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    public boolean create(Candidates candidate, DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "INSERT INTO candidate (cnid,candidatename,candidateareacode,candidateage, candidategender,candidateemail, candidateusername,candidatepass,canisactive) VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";

        this.preparedStatement = connection.prepareStatement(sql);

        this.preparedStatement.setInt(1, 0);
        this.preparedStatement.setString(2, null);
        this.preparedStatement.setString(3, null);
        this.preparedStatement.setString(4, null);
        this.preparedStatement.setString(5, null);
        this.preparedStatement.setString(6, candidate.getEmail());
        this.preparedStatement.setString(7, candidate.getUsername());
        this.preparedStatement.setString(8, candidate.getPass());
        this.preparedStatement.setInt(9, 0);
        boolean result = this.preparedStatement.execute();
        this.close();
        return result;
    }

    public Candidates GetCandidate(String username, String password, DataSource dataSource) throws SQLException {

        Candidates candidate = null;

        this.connection = dataSource.getConnection();
        String sql = "SELECT * FROM candidate where candidateusername = ? and candidatepass = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, username);
        this.preparedStatement.setString(2, password);
        ResultSet result = this.preparedStatement.executeQuery();


        try {
            if (result.next()) {
                candidate = new Candidates();


                candidate.setId(result.getInt("cnid"));
                candidate.setName(result.getString("candidatename"));
                candidate.setAreacode(result.getString("candidateareacode"));
                candidate.setAge(result.getInt("candidateage"));
                candidate.setGender(result.getString("candidategender"));
                candidate.setEmail(result.getString("candidateemail"));
                candidate.setUsername(result.getString("candidateusername"));
                candidate.setPass(result.getString("candidatepass"));
                candidate.setIsActive(result.getInt("canisactive"));

                return candidate;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return candidate;

    }


    public Candidates GetCandidateforaprv(int id, DataSource dataSource) throws SQLException {

        Candidates candidate = null;

        this.connection = dataSource.getConnection();
        String sql = "SELECT * FROM candidate where cnid = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        ResultSet result = this.preparedStatement.executeQuery();


        try {
            if (result.next()) {
                candidate = new Candidates();


                candidate.setId(result.getInt("cnid"));
                candidate.setName(result.getString("candidatename"));
                candidate.setAreacode(result.getString("candidateareacode"));
                candidate.setAge(result.getInt("candidateage"));
                candidate.setGender(result.getString("candidategender"));
                candidate.setEmail(result.getString("candidateemail"));
                candidate.setUsername(result.getString("candidateusername"));
                candidate.setPass(result.getString("candidatepass"));
                candidate.setIsActive(result.getInt("canisactive"));

                return candidate;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return candidate;

    }

    private void close() throws SQLException {
        if (this.connection != null)
            this.connection.close();
        if (this.preparedStatement != null)
            this.preparedStatement.close();
        if (this.statement != null)
            this.statement.close();
    }


    public boolean UpdateCandidate(Candidates cn, DataSource dataSource) throws SQLException {

        this.connection = dataSource.getConnection();
        String sql = "UPDATE  candidate set candidatename= ?,candidateareacode=?,candidateage=?,candidategender=? where cnid=?";


        this.preparedStatement = connection.prepareStatement(sql);

        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, cn.getName());
        this.preparedStatement.setString(2, cn.getAreacode());
        this.preparedStatement.setInt(3, cn.getAge());
        this.preparedStatement.setString(4, cn.getGender());
        this.preparedStatement.setInt(5, cn.getId());
        boolean result = this.preparedStatement.execute();
        this.close();
        return result;
    }


    public Candidates GetApprvcn(int scanid, DataSource dataSource) throws SQLException {
        Candidates candidate = null;

        this.connection = dataSource.getConnection();
        String sql = "SELECT * FROM approvedcandidate where appcnid = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, scanid);
        ResultSet result = this.preparedStatement.executeQuery();


        try {
            if (result.next()) {
                candidate = new Candidates();


                candidate.setId(result.getInt("appcnid"));
                candidate.setName(result.getString("appcnname"));
                candidate.setAreacode(result.getString("areacode"));
                candidate.setAge(result.getInt("apcnage"));
                candidate.setGender(result.getString("apcngender"));


                return candidate;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return candidate;
    }
}

