package com.controller;

import com.model.Livre;
import com.database.DatabaseLib;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import java.sql.*;

public class MainController {
    @FXML private TextField txtTitre, txtAuteur;
    @FXML private TableView<Livre> table;
    @FXML private TableColumn<Livre, Integer> colId;
    @FXML private TableColumn<Livre, String> colTitre, colAuteur;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(d -> d.getValue().idProperty().asObject());
        colTitre.setCellValueFactory(d -> d.getValue().titreProperty());
        colAuteur.setCellValueFactory(d -> d.getValue().auteurProperty());
        loadData();
    }

    private void loadData() {
        ObservableList<Livre> data = FXCollections.observableArrayList();
        try (Connection c = DatabaseLib.getConnection(); ResultSet rs = c.createStatement().executeQuery("SELECT * FROM livres")) {
            while (rs.next()) data.add(new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur")));
            table.setItems(data);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @FXML
    private void handleAdd() {
        String sql = "INSERT INTO livres(titre, auteur) VALUES(?, ?)";
        try (Connection c = DatabaseLib.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, txtTitre.getText());
            ps.setString(2, txtAuteur.getText());
            ps.executeUpdate();
            txtTitre.clear(); txtAuteur.clear();
            loadData();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
