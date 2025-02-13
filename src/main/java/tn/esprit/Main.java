package tn.esprit;

import tn.esprit.models.ProjectTask;
import tn.esprit.services.ProjectTaskService;
import tn.esprit.util.DBConnection;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //Tester connectivite du bd
        DBConnection db = DBConnection.getInstance(); //avec singleton afficher 1 seul connexion

         // Initialiser le service
      //  ProjectService ps = new ProjectService();
           ProjectTaskService projectTaskService = new ProjectTaskService();
      /*  Project project = new Project("Web1.0","SiteWeb Static","Inactif",Date.valueOf("2024-01-15"), Date.valueOf("2024-04-25"));
        ps.add(project);
        System.out.println(ps.getAll());*/


/*
        // 🔹 Ajouter un projet
        Project newProject = new Project(0, "New Project", "New Description", "Pending",
                Date.valueOf("2025-03-01"), Date.valueOf("2025-08-15"));
        ps.add(newProject);

        // 🔹 Update d'un projet
        Project updatedProject = new Project(1, "Updated JavaFX", "Updated Description", "Completed",
                Date.valueOf("2025-02-15"), Date.valueOf("2025-07-01"));
        ps.update(updatedProject);
*/
        // 🔹 Suppression d'un projet (tester avec un ID existant et inexistant)
      /*  Project pToDelete = new Project();
        pToDelete.setId(5);
        ps.delete(pToDelete); // Test avec un ID inexistant

        // 🔹 Afficher tous les projets après mise à jour/suppression
        System.out.println("\n📌 Liste des projets :");
        List<Project> projects = ps.getAll();
        for (Project p : projects) {
            System.out.println("🔹 " + p.getId() + " | " + p.getTitre() + " | " + p.getDescription() + " | " +
                    p.getStatut() + " | " + p.getDate_debut() + " → " + p.getDate_fin()); }*/

/*

        // Créer un nouvel objet ProjectTask
        ProjectTask newTask = new ProjectTask("Déterminer CRUD du Projet",
                "Graphique Designer ",
                Date.valueOf("2025-02-13"),
                ProjectTask.Statut.IN_PROGRESS,
                8,
                2);
        // Ajouter une nouvelle tâche
        try {
            projectTaskService.create(newTask);
            System.out.println("✅ Tâche ajoutée avec succès.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout de la tâche : " + e.getMessage());
        }

        // Afficher toutes les tâches
        try {
            List<ProjectTask> tasks = projectTaskService.readAll();
            System.out.println("📌 Liste des tâches :");
            for (ProjectTask task : tasks) {
                System.out.println(task);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des tâches : " + e.getMessage());
        }

// 🔹 Update d'une tâche existante
        ProjectTask updatedTask = new ProjectTask(3, "Push tous les travails sur GITHUB ",
                "Avec GIT", Date.valueOf("2025-02-11"), ProjectTask.Statut.DONE, 4 , 3);
        try {
            projectTaskService.update(updatedTask);
            System.out.println("✅ Tâche mise à jour avec succès.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la mise à jour de la tâche : " + e.getMessage());
        }

        // 🔹 Lire et afficher les tâches après mise à jour
        try {
            List<ProjectTask> tasks = projectTaskService.readAll();
            System.out.println("📌 Liste des tâches après mise à jour :");
            for (ProjectTask task : tasks) {
                System.out.println(task);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des tâches après mise à jour : " + e.getMessage());
        }
*/
        // 🔹 Changer le statut d'une tâche
        try {
            projectTaskService.changeTaskStatus(3, ProjectTask.Statut.TODO);
            System.out.println("✅ Statut de la tâche changé avec succès.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors du changement de statut : " + e.getMessage());
        }

        // 🔹 Afficher toutes les tâches après changement de statut
        try {
            List<ProjectTask> tasks = projectTaskService.readAll();
            System.out.println("📌 Liste des tâches après changement de statut :");
            for (ProjectTask task : tasks) {
                System.out.println(task);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des tâches après changement de statut : " + e.getMessage());
        }
/*
        // 🔹 Assigner une tâche à un utilisateur
        try {
            projectTaskService.assignTaskToUser(3, 3);
            System.out.println("✅ Tâche assignée à un utilisateur avec succès.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'assignation de la tâche : " + e.getMessage());
        }

        // 🔹 Afficher les tâches assignées après assignation
        try {
            List<ProjectTask> tasks = projectTaskService.getTasksByUser(3);
            System.out.println("📌 Liste des tâches assignées à l'utilisateur 3 :");
            for (ProjectTask task : tasks) {
                System.out.println(task);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des tâches assignées : " + e.getMessage());
        }

        // 🔹 Supprimer une tâche
        try {
            projectTaskService.delete(4);
            System.out.println("✅ Tâche supprimée avec succès.");
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la suppression de la tâche : " + e.getMessage());
        }

        // 🔹 Afficher toutes les tâches après suppression
        try {
            List<ProjectTask> tasks = projectTaskService.readAll();
            System.out.println("📌 Liste des tâches après suppression :");
            for (ProjectTask task : tasks) {
                System.out.println(task);
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la récupération des tâches après suppression : " + e.getMessage());
        }*/
    }

}