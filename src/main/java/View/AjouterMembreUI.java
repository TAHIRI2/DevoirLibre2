package View;

import Model.Membre;
import DAO.MembreDao;
import DAOimp.MembreDaoImpl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AjouterMembreUI extends Application {
    private MembreDao membreDao = new MembreDaoImpl(); 
    @Override
    public void start(Stage primaryStage) {
       
        primaryStage.setTitle("Ajouter un nouveau membre");

        // Création du GridPane pour organiser les éléments
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Champs de saisie
        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();
        grid.add(nomLabel, 0, 0);
        grid.add(nomField, 1, 0);

        Label prenomLabel = new Label("Prénom:");
        TextField prenomField = new TextField();
        grid.add(prenomLabel, 0, 1);
        grid.add(prenomField, 1, 1);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);

        Label phoneLabel = new Label("Téléphone:");
        TextField phoneField = new TextField();
        grid.add(phoneLabel, 0, 3);
        grid.add(phoneField, 1, 3);

        // Bouton "Ajouter"
        Button ajouterButton = new Button("Ajouter");
        grid.add(ajouterButton, 1, 4);

        // Gestion de l'événement de clic
        ajouterButton.setOnAction(event -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                showAlert("Erreur", "Tous les champs doivent être remplis !");
                return;
            }

            // Génération d'un identifiant aléatoire
            String identifiant = "ID-" + (int) (Math.random() * 10000);

            // Création du membre
            Membre nouveauMembre = new Membre(identifiant, nom, prenom, email, phone);

            // Ajout du membre dans le DAO
            membreDao.ajouterMembre(nouveauMembre);

            // Message de succès
            showAlert("Succès", "Membre ajouté avec succès !\n" + nouveauMembre);
        });

        // Création et affichage de la scène
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode pour afficher une alerte
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Méthode principale
    public static void main(String[] args) {
        launch(args);
    }
}
