package com.example.evm.Voters;

import com.example.evm.Candidate.Candidates;

import javax.sql.DataSource;
import java.sql.*;

public class VotersUtil {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    public boolean create(Voters voters, DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "INSERT INTO voters (nid,votersname,votersareacode, votersage, votersgender, votersemail, votersusername, voterspass, isactive) VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";

        this.preparedStatement = connection.prepareStatement(sql);

        this.preparedStatement.setString(1, null);
        this.preparedStatement.setString(2, null);
        this.preparedStatement.setString(3, null);
        this.preparedStatement.setString(4, null);
        this.preparedStatement.setString(5, null);
        this.preparedStatement.setString(6, voters.getEmail());
        this.preparedStatement.setString(7, voters.getUsername());
        this.preparedStatement.setString(8, voters.getPass());
        this.preparedStatement.setInt(9, 0);
        boolean result = this.preparedStatement.execute();
        this.close();
        return result;
    }

    public Voters GetVoters(String username, String password, DataSource dataSource) throws SQLException {

        Voters voter = null;

        this.connection = dataSource.getConnection();
        String sql = "SELECT * FROM voters where votersusername = ? and voterspass = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, username);
        this.preparedStatement.setString(2, password);
        ResultSet result = this.preparedStatement.executeQuery();


        try {
            if (result.next()) {
                voter = new Voters();


                voter.setId(result.getInt("nid"));
                voter.setName(result.getString("votersname"));
                voter.setAreacode(result.getString("votersareacode"));
                voter.setAge(result.getInt("votersage"));
                voter.setGender(result.getString("votersgender"));
                voter.setEmail(result.getString("votersemail"));
                voter.setUsername(result.getString("votersusername"));
                voter.setPass(result.getString("voterspass"));
                voter.setIsActive(result.getInt("isactive"));

                return voter;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voter;

    }

    public Voters GetVoterforaprv(int id, DataSource dataSource) throws SQLException {


        Voters voter=null;

        this.connection = dataSource.getConnection();
        String sql = "SELECT * FROM voters where nid = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        ResultSet result = this.preparedStatement.executeQuery();


        try {
            if (result.next()) {
                voter = new Voters();


                voter.setId(result.getInt("nid"));
                voter.setName(result.getString("votersname"));
                voter.setAreacode(result.getString("votersareacode"));
                voter.setAge(result.getInt("votersage"));
                voter.setGender(result.getString("votersgender"));
                voter.setEmail(result.getString("votersemail"));
                voter.setUsername(result.getString("votersusername"));
                voter.setPass(result.getString("voterspass"));
                voter.setIsActive(result.getInt("isactive"));

                return voter;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voter;

    }


    private void close() throws SQLException {
        if (this.connection != null)
            this.connection.close();
        if (this.preparedStatement != null)
            this.preparedStatement.close();
        if (this.statement != null)
            this.statement.close();
    }


    public boolean UpdateVoter(Voters voters, DataSource dataSource) throws SQLException {

        this.connection = dataSource.getConnection();
        String sql = "UPDATE  voters set votersname= ?,votersareacode=?,votersage=?,votersgender=? where nid=?";
        this.preparedStatement = connection.prepareStatement(sql);

        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, voters.getName());
        this.preparedStatement.setString(2, voters.getAreacode());
        this.preparedStatement.setInt(3, voters.getAge());
        this.preparedStatement.setString(4, voters.getGender());
        this.preparedStatement.setInt(5, voters.getId());
        boolean result = this.preparedStatement.execute();
        this.close();
        return result;
    }


    public int ValidateVoter(int voterid, DataSource dataSource) throws SQLException {

        //this.connection = dataSource.getConnection();
        String sql = "select count(voterid)  as total  from votecount where voterid=?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, voterid);
        ResultSet result = this.preparedStatement.executeQuery();
        int count=0;
        try {
            if (result.next()) {
                 count=result.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        this.close();
        return count;
    }


}