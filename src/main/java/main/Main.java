package main;

import java.util.Set;

import CSV.MembreImporter;
import Model.Membre;

public class Main {
    public static void main(String[] args) {
        MembreImporter importer = new MembreImporter();
        Set<Membre> membres = importer.chargerListeMembre("C:/Users/pc/Desktop/Membre.csv");

        // Afficher les membres importés
        for (Membre membre : membres) {
            System.out.println(membre);
        }
    }
}

