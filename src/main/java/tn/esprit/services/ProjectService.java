package tn.esprit.services;

import tn.esprit.interfaces.IService;
import tn.esprit.models.Project;
import tn.esprit.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService implements IService<Project> {
    // Connexion à la base de données
    Connection conn = DBConnection.getInstance().getConn();

   // 1ére methode Insert(Statement)/ N'est pas Protège contre les injections SQL/ Rapide mais non sécurisé	/ Moins lisible
   /* @Override
    public void add(Project project) {
        String SQL = "INSERT INTO `project`(`titre`, `description`, `statut`, `date_debut`, `date_fin`) VALUES ('"+project.getTitre()+"','"+project.getDescription()+"','"+project.getStatut()+"','"+project.getDate_debut()+"','"+project.getDate_fin()+"')";
        try { Statement stmt = conn.createStatement();
              stmt.executeUpdate(SQL);
              System.out.println("Project added");
            } catch (SQLException e) { System.out.println(e.getMessage()); } } */

    /* 2éme methode
    // ✅ Ajouter un projet (PreparedStatement)/ Protège contre les injections SQL	/ Légèrement plus lent / Plus propre et lisible*/
    @Override
    public void add(Project project) {
        String query = "INSERT INTO project (titre, description, statut, date_debut, date_fin) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, project.getTitre());
            ps.setString(2, project.getDescription());
            ps.setString(3, project.getStatut());
            ps.setDate(4, project.getDate_debut());
            ps.setDate(5, project.getDate_fin());

            ps.executeUpdate();
            System.out.println("✅ Project added successfully!");
        } catch (SQLException e) { System.out.println("❌ Error: " + e.getMessage()); }
    }

    // ✅ Affichage de tous les projets
    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM project";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setTitre(rs.getString("titre"));
                project.setDescription(rs.getString("description"));
                project.setStatut(rs.getString("statut"));
                project.setDate_debut(rs.getDate("date_debut"));
                project.setDate_fin(rs.getDate("date_fin"));
                projects.add(project);
            }
        } catch (SQLException e) { System.out.println("❌ Error: " + e.getMessage()); }
        return projects;
    }

    // ✅ Update un projet
    public void update(Project project) {
        String query = "UPDATE project SET titre=?, description=?, statut=?, date_debut=?, date_fin=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, project.getTitre());
            ps.setString(2, project.getDescription());
            ps.setString(3, project.getStatut());
            ps.setDate(4, project.getDate_debut());
            ps.setDate(5, project.getDate_fin());
            ps.setInt(6, project.getId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Project updated successfully!");
            } else { System.out.println("⚠️ No project found with ID: " + project.getId()); }
        } catch (SQLException e) { System.out.println("❌ Error: " + e.getMessage()); }
    }

    // ✅ Supprimer un projet (Delete)
    public void delete(Project project) {
        String query = "DELETE FROM project WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, project.getId()); // Utilisation de l'ID du projet
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("✅ Project deleted successfully!");
            } else { System.out.println("⚠️ No project found with ID: " + project.getId()); }
        } catch (SQLException e) { System.out.println("❌ Error: " + e.getMessage()); }
    }

}
