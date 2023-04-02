/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.anhquoc0304.library;

import Services.DocGiaServices;
import Services.SachServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pojo.DocGia;
import pojo.Sach;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MuonSachController implements Initializable {
    @FXML private Label lblTenDocGia;
    @FXML private Label lblMaDocGia;
    @FXML private Label lblDoiTuong;
    @FXML private Label lblSoDienThoai;
    @FXML private TableView<DocGia> tbDocGia;
    @FXML private TableView<Sach> tbSach;
    @FXML private TableView<Sach> tbSachMuon;
    @FXML private TextField txtKeyWord;
    @FXML private TextField txtTimKiemSach;
    @FXML private ComboBox<String> cbTimKiemDG;
    @FXML private ComboBox<String> cbTimKiemSach;
    String [] itemsOfSach = {"Tên Sách", "Mã Sách", "Tên Tác Giả"};
    String [] itemsOfDocGia = {"Tên Độc Giả", "Mã Độc Giả"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbTimKiemDG.getItems().addAll(itemsOfDocGia);
        cbTimKiemDG.setValue("Tên Độc Giả");
        cbTimKiemSach.getItems().addAll(itemsOfSach);
        cbTimKiemSach.setValue("Tên Sách");
        loadTableDocGia();
        LoadTableSach();
        LoadTableMuon();
        try {
            LoadDataViewSach(tbSach);
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadDocGia(null);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtKeyWord.textProperty().addListener((evt) ->{
            try {
                this.FillterDataTableDG(tbDocGia, this.txtKeyWord.getText(), cbTimKiemDG.getValue());
            } catch (SQLException ex) {
                Logger.getLogger(MuonSachController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.txtTimKiemSach.textProperty().addListener(o -> {
            try {
                FillterDataTableSach(tbSach, this.txtTimKiemSach.getText(), cbTimKiemSach.getValue());
            } catch (SQLException ex) {
                Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//        ObservableList timKiemDG = FXCollections
//        this.cbTimKiemDG.setItems(ol);
    }    
    private void loadTableDocGia(){
        TableColumn colMaDocGia = new TableColumn("Mã Độc Giả");
        colMaDocGia.setCellValueFactory(new PropertyValueFactory("maDocGia"));
        colMaDocGia.setPrefWidth(100);
        TableColumn colTenDocGia = new TableColumn("Tên Độc Giả");
        colTenDocGia.setCellValueFactory(new PropertyValueFactory("tenDocGia"));
        colTenDocGia.setPrefWidth(250);
        TableColumn colDoiTuong = new TableColumn("Đối tượng");
        colDoiTuong.setCellValueFactory(new PropertyValueFactory("doiTuong"));
        colDoiTuong.setPrefWidth(100);
        TableColumn colSoDienThoai = new TableColumn("Số điện thoại");
        colSoDienThoai.setCellValueFactory(new PropertyValueFactory("soDT"));
        colSoDienThoai.setPrefWidth(120);
        this.tbDocGia.getColumns().addAll(colMaDocGia, colTenDocGia, colDoiTuong, colSoDienThoai);
    }
    private void loadDocGia(String kw) throws SQLException{
        DocGiaServices s = new DocGiaServices();
        List<DocGia> dgs = s.listDocGiaByName(kw);
        this.tbDocGia.getItems().clear();
        this.tbDocGia.setItems(FXCollections.observableList(dgs));
    }
    private void FillterDataTableDG(TableView table, String keywords, String type) throws SQLException {
        DocGiaServices s = new DocGiaServices();
        if (type.equals(itemsOfDocGia[0]))
            table.setItems(FXCollections.observableArrayList(s.listDocGiaByName(keywords)));
        else if(type.equals(itemsOfDocGia[1]))
            table.setItems(FXCollections.observableArrayList(s.listDocGiaByID(keywords)));
    }
    @FXML
    public void RowCLickTBGocGia(MouseEvent event) {

        TableView<DocGia> table = (TableView<DocGia>) event.getSource();
        DocGia dg = table.getSelectionModel().getSelectedItem();
//        
        if (dg != null) {
            lblTenDocGia.setText(dg.getTenDocGia());
            lblMaDocGia.setText(dg.getMaDocGia());
            lblDoiTuong.setText(dg.getDoiTuong().toString());
            lblSoDienThoai.setText(dg.getSoDT());
        }
    }
    private void LoadTableSach() {
        TableColumn colID = new TableColumn("Mã Sách");
        TableColumn colName = new TableColumn("Tên Sách");
        TableColumn colAuthor = new TableColumn("Tác giả");
        TableColumn colType = new TableColumn("Thể Loại");
//        TableColumn colYear = new TableColumn(" Năm Xuất Bản");
//        TableColumn colPlace = new TableColumn("Nơi Xuất Bản");
//        TableColumn colDate = new TableColumn("Ngày Nhập");
        TableColumn colPosition = new TableColumn("Vi Trí Sách");
        TableColumn colStateofBook = new TableColumn("Trạng Thái");
//        TableColumn colDescription = new TableColumn("Mô Tả Sách");

        // Đổ dữ liệu
        colID.setCellValueFactory(new PropertyValueFactory("maSach"));
        colName.setCellValueFactory(new PropertyValueFactory("tenSach"));
        colAuthor.setCellValueFactory(new PropertyValueFactory("tacGia"));
        colType.setCellValueFactory(new PropertyValueFactory("theLoai"));
//        colYear.setCellValueFactory(new PropertyValueFactory("namXB"));
//        colPlace.setCellValueFactory(new PropertyValueFactory("noiXB"));
//        colDate.setCellValueFactory(new PropertyValueFactory("ngayNhap"));
        colPosition.setCellValueFactory(new PropertyValueFactory("viTri"));
        colStateofBook.setCellValueFactory(new PropertyValueFactory("trangThai"));
//        colDescription.setCellValueFactory(new PropertyValueFactory("motaSach"));

        this.tbSach.getColumns().addAll(colID, colName, colAuthor, colType,
          colPosition, colStateofBook);

    }
    private void LoadDataViewSach(TableView table) throws SQLException {
        table.setItems(FXCollections.observableArrayList(new SachServices().listDachKhaDung()));
    }
    private void FillterDataTableSach(TableView table, String keywords, String type) throws SQLException {
        SachServices s = new SachServices();
        if (type.equals(itemsOfSach[0]))
            table.setItems(FXCollections.observableArrayList(s.listSachKhaDungByName(keywords)));
        else if(type.equals(itemsOfSach[1]))
            table.setItems(FXCollections.observableArrayList(s.GetBookByID(keywords)));
        else
            table.setItems(FXCollections.observableArrayList(s.listSachKhaDungByTG(keywords)));
    }
    public void themHandler(ActionEvent event){
        int r = tbSach.getSelectionModel().getSelectedIndex();
        if(r >= 0){
            Sach s = tbSach.getSelectionModel().getSelectedItem();
            tbSachMuon.getItems().add(s);
            tbSach.getItems().remove(r);
            tbSach.getSelectionModel().clearSelection();
        }
    }
    public void xoaHandler(ActionEvent event){
          int r = tbSachMuon.getSelectionModel().getSelectedIndex();
          if(r >= 0){
              Sach s = tbSachMuon.getSelectionModel().getSelectedItem();
              tbSach.getItems().add(s);
              tbSachMuon.getItems().remove(r);
              tbSachMuon.getSelectionModel().clearSelection();
          }
    }
    private void LoadTableMuon() {
        TableColumn colID = new TableColumn("Mã Sách");
        TableColumn colName = new TableColumn("Tên Sách");
        TableColumn colAuthor = new TableColumn("Tác giả");
        TableColumn colType = new TableColumn("Thể Loại");
//        TableColumn colYear = new TableColumn(" Năm Xuất Bản");
//        TableColumn colPlace = new TableColumn("Nơi Xuất Bản");
//        TableColumn colDate = new TableColumn("Ngày Nhập");
        TableColumn colPosition = new TableColumn("Vi Trí Sách");
        TableColumn colStateofBook = new TableColumn("Trạng Thái");
//        TableColumn colDescription = new TableColumn("Mô Tả Sách");

        // Đổ dữ liệu
        colID.setCellValueFactory(new PropertyValueFactory("maSach"));
        colName.setCellValueFactory(new PropertyValueFactory("tenSach"));
        colAuthor.setCellValueFactory(new PropertyValueFactory("tacGia"));
        colType.setCellValueFactory(new PropertyValueFactory("theLoai"));
//        colYear.setCellValueFactory(new PropertyValueFactory("namXB"));
//        colPlace.setCellValueFactory(new PropertyValueFactory("noiXB"));
//        colDate.setCellValueFactory(new PropertyValueFactory("ngayNhap"));
//        colPosition.setCellValueFactory(new PropertyValueFactory("viTri"));
//        colStateofBook.setCellValueFactory(new PropertyValueFactory("trangThai"));
//        colDescription.setCellValueFactory(new PropertyValueFactory("motaSach"));

        this.tbSachMuon.getColumns().addAll(colID, colName, colAuthor, colType);
    }
}
