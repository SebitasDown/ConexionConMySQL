package Controller;

import Entity.Coder;
import Model.CoderModel;

import javax.swing.*;

public class CoderController {
    public static void create(){
        // Usamos el modelo
        CoderModel objCoderModel = new CoderModel();

        // Pedir los datos al usuario
        String name = JOptionPane.showInputDialog("Nombre: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Edad: "));
        String clan = JOptionPane.showInputDialog("Clan: ");

        Coder objCoder = new Coder();
        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        // Llamando
        objCoder = (Coder) objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());
    }

    public static void getAll(){
        CoderModel coderModel = new CoderModel();
        String listCoders = "\n" + "List coders" + "\n"; ;
        for(Object i : coderModel.findAll()){
            Coder objCoder = (Coder) i;
            listCoders += objCoder.toString()+ "\n";
        }
        JOptionPane.showMessageDialog(null, listCoders);
    }

    public static void delte (){
        CoderModel coderModel = new CoderModel();



        int isDelete = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del coder que desea eliminar: "));
        Coder objCoder = coderModel.findById(isDelete);
        if(objCoder == null){
            JOptionPane.showMessageDialog(null, "Coder no encontrado");

        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Estas seguro?");
            if (confirm == 0) coderModel.delete(objCoder);
        }

    }
}
