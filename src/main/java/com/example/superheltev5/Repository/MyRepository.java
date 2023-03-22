package com.example.superheltev5.Repository;

import com.example.superheltev5.DTO.CityDTO;
import com.example.superheltev5.DTO.CountPowerDTO;
import com.example.superheltev5.DTO.HeroPowerDTO;
import com.example.superheltev5.Modul.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MyRepository implements com.example.superheltev5.Repository.Repository {

    @Value("jdbc:mysql://localhost:3306/superhero_database")
    private String db_url;

    @Value("TBK")
    private String uid;

    @Value("1234")
    private String pwd;

    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT HERO_ID, HERO_NAME, REAL_NAME, CREATION_YEAR, CITY_ID FROM SUPERHERO;";
            Statement sm = connection.createStatement();
            ResultSet rs = sm.executeQuery(SQL);
            while (rs.next()) {
                int ID = rs.getInt("HERO_ID");
                String heroName = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                int creationYear = rs.getInt("CREATION_YEAR");
                int cityID = rs.getInt("CITY_ID");

                superheroes.add(new Superhero(ID, heroName, realName, creationYear, cityID));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public HeroPowerDTO heroPower(String name) {
        HeroPowerDTO heroPowerDTO = null;
        try (Connection connection = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT s.HERO_NAME, s.REAL_NAME, sp.NAME AS SUPERPOWER \n" +
                    "FROM SUPERHERO s \n" +
                    "JOIN SUPERPOWER sp ON s.HERO_ID = sp.POWER_ID  \n" +
                    "WHERE HERO_NAME = ?";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String heroName = rs.getString("HERO_NAME");
                String realName = rs.getString("REAL_NAME");
                String superpowers = rs.getString("SUPERPOWER");
                heroPowerDTO = new HeroPowerDTO(heroName, realName, superpowers);
            }
            return heroPowerDTO;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public CityDTO heroCity(String name){
        CityDTO cityDTO = null;
        try (Connection connection = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT NAME, HERO_NAME FROM SUPERHERO INNER JOIN CITY USING(CITY_ID) WHERE NAME = ? ORDER BY NAME;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String heroName = rs.getString("HERO_NAME");
                String cityName = rs.getString("NAME");
                cityDTO = new CityDTO(cityName,heroName);
            }
            return cityDTO;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CountPowerDTO heroPowerCount(String name){
        CountPowerDTO countPowerDTO = null;
        try (Connection connection = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superhero.hero_name, COUNT(superpower.power_id) AS superpowerCount FROM superhero JOIN superpower ON superhero.hero_id = superpower.power_id WHERE superhero.hero_name = ? GROUP BY superhero.hero_name;";
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String heroName = rs.getString("HERO_NAME");
                int countpower = rs.getInt("superpowerCount");
                countPowerDTO = new CountPowerDTO(heroName,countpower);
            }
            return countPowerDTO;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
