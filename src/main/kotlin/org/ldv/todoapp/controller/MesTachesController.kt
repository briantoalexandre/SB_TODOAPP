package org.ldv.todoapp.controller

import jakarta.servlet.http.HttpSession
import org.ldv.todoapp.model.repository.TacheRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MesTachesController(
    private val tacheRepository: TacheRepository
){
    @GetMapping("/mes-taches")
    fun mesTaches(model: Model, session: HttpSession): String {
        // Récupération de l'identifiant de l'utilisateur actif
        val utilisateurId =
            session.getAttribute("utilisateurId") as? Long
        // Récupération des tâches de l'utilisateur actif
        val taches = if (utilisateurId != null) {
            tacheRepository.findByUtilisateur_IdUtilisateur(utilisateurId)
        } else {
            emptyList()
        }
        // Transmission de la liste des tâches au modèle
        model.addAttribute("taches", taches)
        // Affichage du template mes-taches.html
        return "mes-taches"
    }
}