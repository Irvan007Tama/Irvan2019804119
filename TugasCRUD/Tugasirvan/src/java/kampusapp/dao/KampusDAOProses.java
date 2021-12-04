/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.dao;

import java.util.List;
import kampusapp.model.Mahasiswa;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import kampusapp.model.DatabaseConfig;

/**
 *
 * @author This-PC
 */
public class KampusDAOProses implements KampusDAO{
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedstatement = null;
    private PreparedStatement preparedStatement;
    
    @Override
    public List<Mahasiswa> get() {
        List<Mahasiswa> list = null;
        Mahasiswa mhs = null;
        try {
            list = new ArrayList<Mahasiswa>();
            String sql = "SELECT * FROM tbl_tgs";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                mhs = new Mahasiswa();
                mhs.setId(resultSet.getInt("id"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setJumlah(resultSet.getString("jumlah"));
                mhs.setKeterangan(resultSet.getString("keterangan"));
                list.add(mhs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Mahasiswa mahasiswa) {
        boolean flag = false;
        try {
            String sql="INSERT INTO tbl_tgs(nim, nama, jumlah, keterangan) VALUES(?,?,?,?)";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mahasiswa.getNim());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setString(3, mahasiswa.getJumlah());
            preparedStatement.setString(4, mahasiswa.getKeterangan());
            preparedStatement.executeUpdate();
            flag = true;
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public Mahasiswa getSinggle(int id) {
        Mahasiswa mhs=null;
        try{
            String sql="select * from tbl_tgs where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                mhs=new Mahasiswa();
                mhs.setId(resultSet.getInt("id"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setJumlah(resultSet.getString("jumlah"));
                mhs.setKeterangan(resultSet.getString("keterangan"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return mhs;
    }

    @Override
    public boolean update(Mahasiswa mahasiswa) {
        boolean flag=false;
        try{
            String sql="update tbl_mhs set nim=?,nama=?,jumlah=?,keterangan=? where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, mahasiswa.getNim());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setString(3, mahasiswa.getJumlah());
            preparedStatement.setString(4, mahasiswa.getKeterangan());
            preparedStatement.setInt(5, mahasiswa.getId());
            preparedStatement.executeUpdate();
            flag=true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag=false;
        try{
            String sql="delete from tbl_tgs where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag=true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }
}
