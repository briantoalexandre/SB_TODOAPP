package org.ldv.todoapp.controller

import jakarta.servlet.http.HttpSession
import org.ldv.todoapp.model.repository.UtilisateurRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SessionController(
    private val utilisateurRepository: UtilisateurRepository
) {
    @PostMapping("/session/utilisateur")
    fun selectionnerUtilisateur(
        @RequestParam
        utilisateurId: Long,
        session: HttpSession
    ): String {
        // Vérification de l'existence de l'utilisateur
        if (!utilisateurRepository.existsById(utilisateurId)) {
            return "redirect:/"
        }
        // Enregistrement de l'identifiant dans la session HTTP
        session.setAttribute("utilisateurId", utilisateurId)

        // Redirection vers la page d'accueil
        return "redirect:/"
    }
}