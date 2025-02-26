package com.yassineS31.sqlcda.repository;
import com.yassineS31.sqlcda.db.Bdd;
import com.yassineS31.sqlcda.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    /*
    * Attribut
    * */
    private static Connection connection= Bdd.getConnexion();
    /*
    * Méthodes (CRUD)
     *  */
    public static User save(User addUser){
        User newUser =null;
    try {
        String sql ="INSERT INTO users(firstname, lastname,email,password) VALUE (?,?,?,?)";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        // Bind
        prepareStatement.setString(1, addUser.getFirstname());
        prepareStatement.setString(2, addUser.getLastname());
        prepareStatement.setString(3, addUser.getEmail());
        prepareStatement.setString(4, addUser.getPassword());
// executer la requête
        int nbrRows = prepareStatement.executeUpdate();
        if( nbrRows>0){
            newUser = new User (
                    addUser.getFirstname(),
                    addUser.getLastname(),
                    addUser.getEmail(),
                    addUser.getPassword()
            );

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return newUser;
    };
    public static boolean isExist(String email) {
        boolean getUser = false;
        try {
            String sql = "SELECT id FROM users WHERE email = ?";
            //préparer la requête
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //Bind le paramètre
            preparedStatement.setString(1, email);
            //récupérer le resultat de la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            //Vérification du résultat
            while(resultSet.next()){
                getUser = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return getUser;
    };

    public static boolean findByEmail(String email) {
        Boolean findUser= false;
        try {
            String sql = "SELECT id,firstname,lastname,email FROM users WHERE email = ?";
            //préparer la requête
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // Bind param
            preparedStatement.setString(1, email);
            //récupérer le resultat de la requête
            ResultSet resultSet = preparedStatement.executeQuery();
            // Verification
            if (resultSet.next()) {
                findUser = true;
            }
        } catch (Exception e){
        e.printStackTrace();
        }

        return findUser;
    }

}
