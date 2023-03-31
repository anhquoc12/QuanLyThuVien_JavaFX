/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.anhquoc0304.library;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Sach;
import Services.SachServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class BookController implements Initializable {

    @FXML
    private TableView<Sach> tbBook;
    @FXML
    private ToggleButton tgAdd;
    @FXML
    private ToggleButton tgEdit;
    @FXML
    private ToggleButton tgDelete;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTacGia;
    @FXML
    private TextField txtTheLoai;
    @FXML
    private TextField txtNamXB;
    @FXML
    private TextField txtNoiXB;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtPosition;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup groupBook = new ToggleGroup();
        tgAdd.setToggleGroup(groupBook);
        tgDelete.setToggleGroup(groupBook);
        tgEdit.setToggleGroup(groupBook);
        // TODO
        LoadTableView();
        try {
            LoadDataView(this.tbBook);
        } catch (SQLException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void RowCLick(MouseEvent event) {

        TableView<Sach> table = (TableView<Sach>) event.getSource();
        Sach s = table.getSelectionModel().getSelectedItem();
//        
        if (s != null) 
        {
            txtID.setText(s.getMaSach());
            txtName.setText(s.getTenSach());
            txtTacGia.setText(s.getTacGia());
            txtTheLoai.setText(s.getTheLoai());
            txtNamXB.setText(String.valueOf(s.getNamXB()));
            txtDescription.setText(s.getMotaSach());
            txtPosition.setText(s.getViTri());
            txtNoiXB.setText(s.getNoiXB());
        }
    }
    
    @FXML void SearchCLick(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Search.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private void LoadTableView() {
        TableColumn colID = new TableColumn("Mã Sách");
        TableColumn colName = new TableColumn("Tên Sách");
        TableColumn colAuthor = new TableColumn("Tác giả");
        TableColumn colType = new TableColumn("Thể Loại");
        TableColumn colYear = new TableColumn(" Năm Xuất Bản");
        TableColumn colPlace = new TableColumn("Nơi Xuất Bản");
        TableColumn colDate = new TableColumn("Ngày Nhập");
        TableColumn colPosition = new TableColumn("Vi Trí Sách");
        TableColumn colStateofBook = new TableColumn("Trạng Thái");
        TableColumn colDescription = new TableColumn("Mô Tả Sách");

        // Đổ dữ liệu
        colID.setCellValueFactory(new PropertyValueFactory("maSach"));
        colName.setCellValueFactory(new PropertyValueFactory("tenSach"));
        colAuthor.setCellValueFactory(new PropertyValueFactory("tacGia"));
        colType.setCellValueFactory(new PropertyValueFactory("theLoai"));
        colYear.setCellValueFactory(new PropertyValueFactory("namXB"));
        colPlace.setCellValueFactory(new PropertyValueFactory("noiXB"));
        colDate.setCellValueFactory(new PropertyValueFactory("ngayNhap"));
        colPosition.setCellValueFactory(new PropertyValueFactory("viTri"));
        colStateofBook.setCellValueFactory(new PropertyValueFactory("trangThai"));
        colDescription.setCellValueFactory(new PropertyValueFactory("motaSach"));

        this.tbBook.getColumns().addAll(colID, colName, colAuthor, colType, colYear,
                colPlace, colDate, colPosition, colStateofBook, colDescription);

    }

    private void LoadDataView(TableView table) throws SQLException {
        table.setItems(FXCollections.observableArrayList(new SachServices().SachList()));
    }
}
