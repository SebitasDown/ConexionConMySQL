import Controller.CoderController;
import database.ConfigDB;


import javax.swing.*;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection connection = ConfigDB.openConnection();
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. create coder
                    2. list coders
                    3. delte for by id coder
                    4. update coder
                    5. Leave
                    """);
            if (option == null){
                break;
            }
            switch (option){
                case "1":
                    CoderController.create();
                    break;
                case "2":
                    CoderController.getAll();
                    break;
                case "3":
                    CoderController.delte();
                    break;
                case "4":
                    CoderController.update();
                    break;
                case "5":
                    break;
            }
        }while (!option.equals("5"));
    }
}