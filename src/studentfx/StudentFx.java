package studentfx;

import content.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Advit
 */
public class StudentFx extends Application {

    private ArrayList<Student> studentList = new ArrayList<>();

    private Label lblID = new Label("Student ID: ");
    private TextField txtID = new TextField();

    private Label lblCourse1 = new Label("Enter Course 1 Grade: ");
    private TextField txtCourse1 = new TextField();

    private Label lblCourse2 = new Label("Enter Course 2 Grade: ");
    private TextField txtCourse2 = new TextField();

    private Label lblCourse3 = new Label("Enter Course 3 Grade: ");
    private TextField txtCourse3 = new TextField();

    private Label lblCourse4 = new Label("Enter Course 4 Grade: ");
    private TextField txtCourse4 = new TextField();

    private Label lblCourse5 = new Label("Enter Course 5 Grade : ");
    private TextField txtCourse5 = new TextField();

    private Button btnDisplay = new Button("Click to process ");

    private Button btnAdd = new Button("Click to Add Student ");

    private Button btnFile = new Button("Click to Make a file ");

    private Pane addPAne() {

        GridPane pane = new GridPane();

        pane.add(lblID, 1, 0);
        pane.add(txtID, 1, 1);

        pane.add(lblCourse1, 1, 2);
        pane.add(txtCourse1, 1, 3);

        pane.add(lblCourse2, 1, 4);
        pane.add(txtCourse2, 1, 5);

        pane.add(lblCourse3, 1, 6);
        pane.add(txtCourse3, 1, 7);

        pane.add(lblCourse4, 1, 8);
        pane.add(txtCourse4, 1, 9);

        pane.add(lblCourse5, 1, 10);
        pane.add(txtCourse5, 1, 11);

        pane.add(btnDisplay, 1, 14);
        pane.add(btnAdd, 1, 16);
        pane.add(btnFile, 1, 18);

        return pane;

    }

    private void addStudent() {

        Student one = new Student();

        one.setID(txtID.getText());

        one.setGrade1(Double.parseDouble(txtCourse1.getText()));
        one.setGrade2(Double.parseDouble(txtCourse2.getText()));
        one.setGrade3(Double.parseDouble(txtCourse3.getText()));
        one.setGrade4(Double.parseDouble(txtCourse4.getText()));
        one.setGrade5(Double.parseDouble(txtCourse5.getText()));

        studentList.add(one);

        txtID.clear();
        txtCourse1.clear();
        txtCourse2.clear();
        txtCourse3.clear();
        txtCourse4.clear();
        txtCourse5.clear();
        txtID.requestFocus();

    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(addPAne(), 500, 450);

        primaryStage.setTitle("Student Grade!");
        primaryStage.setScene(scene);
        primaryStage.show();

        btnDisplay.setOnAction((e) -> {

            addStudent();
            DisplayStage ds = new DisplayStage(studentList);
            ds.show();

        });

        btnAdd.setOnAction((e) -> {

            addStudent();

        });

        btnFile.setOnAction((e) -> {

            try {
                //FileWriter fw = new FileWriter("Barney.dat");

                FileWriter fw = new FileWriter("Student.dat", true);
                BufferedWriter bw = new BufferedWriter(fw);

                int size = studentList.size();

                for (int i = 0; i < size; i++) {
                    String str = studentList.get(i).toString();
                    bw.write(str);
                    if (i < size - 1) {
                        bw.write("\n");
                    }
                }

                bw.flush();

                bw.close();
                fw.close();

                FileReader fr = new FileReader("Student.dat");

                BufferedReader br = new BufferedReader(fr);

                String line = br.readLine();

                while (line != null) {
                    System.out.println(line);

                    line = br.readLine();

                }

            } catch (Exception f) {
                System.err.println(f);

            }

        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
