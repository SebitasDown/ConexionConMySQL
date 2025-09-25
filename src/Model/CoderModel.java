package Model;

import Entity.Coder;
import database.CRUD;
import database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel  implements CRUD {
    @Override
    public Object insert(Object obj) {
        // Abrir conexion
        Connection objConnection = ConfigDB.openConnection();

        // Convertir objeto abstracto en coder
        Coder objCoder = (Coder) obj;
        try {
            String sql = "INSERT INTO coder (name, age, clan) VALUES (?,?,?)";


            // Prepararingresar los statement para ingresar los datos , ademas agregar el return generated keys para que devuelva el id generado
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Asignar el valor a los ? ? ?
            objPrepare.setString(1, objCoder.getName());
            objPrepare.setInt(2, objCoder.getAge());
            objPrepare.setString(3, objCoder.getClan());


            // Ejecutar la query
            objPrepare.execute();
            // Obtener resultado con los id generados
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while(objRest.next()){
                objCoder.setId(objRest.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Coder was succesfull add");

        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public List<Object> findAll() {
        // Para guardar los coders de la db
        List<Object> listCoders = new ArrayList<>();
        // generando la conexion a la db
        Connection objConnection = ConfigDB.openConnection();

        try {
            // Hacemos la sentencia sql
            String sql = "SELECT * FROM coder";
            // Usamos el preparedStatemend que me permite hacer la consulta
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // Ejecutamos la query y la guardamos en una variable
            ResultSet objResult = objPrepare.executeQuery();
            while  (objResult.next()){
                // crear coder para poder agregarlo a la lista
                Coder objCoder = new Coder();
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setId(objResult.getInt("id"));

                listCoders.add(objCoder);

            }


        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        ConfigDB.closeConnection();
        return listCoders;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        // Convertir el objeto en un coder
        Coder objCoder = (Coder) obj;

        Connection objConnection = ConfigDB.openConnection();

        boolean isDelete = false;
        try {
            String sql = "DELETE FROM coder WHERE id = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //Le paso el id del coder que nos pasan por parametros para eliminarlo
            objPrepare.setInt(1, objCoder.getId());
            //obtengo cuantas columnas fueron afectadas
            int result = objPrepare.executeUpdate();

            // Si mas de una columna fue modificada (eliminada) eso significa que se fue eliminado
            if (result > 0){
                isDelete = true;
                JOptionPane.showMessageDialog(null, "Coder eliminado correctamente");
            }


        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        //cerrar conexion
        ConfigDB.closeConnection();
        return isDelete;
    }

    public  Coder findById(int id){
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = new Coder();
        try {
            String sql = "SELECT * FROM coder where id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet objResult = objPrepare.executeQuery();
            if(objResult.next()){
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }
}
