package com.model;

import javafx.beans.property.*;

public class Livre {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty titre = new SimpleStringProperty();
    private final StringProperty auteur = new SimpleStringProperty();

    public Livre(int id, String titre, String auteur) {
        this.id.set(id);
        this.titre.set(titre);
        this.auteur.set(auteur);
    }
    public IntegerProperty idProperty() { 
        return id; 
    }
    public StringProperty titreProperty() { 
        return titre; 
    }
    public StringProperty auteurProperty() { 
        return auteur; 
    }
}
