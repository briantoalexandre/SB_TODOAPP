package org.ldv.todoapp.controller

import jakarta.servlet.http.HttpSession
import org.ldv.todoapp.model.repository.UtilisateurRepository
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class UserSessionAdvice(
    private val utilisateurRepository: UtilisateurRepository
) {
    @ModelAttribute
    fun enrichirModeleUtilisateurs(
        model: Model,
        session: HttpSession
    ) {
        // Récupération de la liste des utilisateurs
        val utilisateurs = utilisateurRepository.findAll()

        // Transmission de la liste au modèle
        model.addAttribute("utilisateurs", utilisateurs)

    }


}