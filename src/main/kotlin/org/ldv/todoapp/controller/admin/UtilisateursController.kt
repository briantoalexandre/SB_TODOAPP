package org.ldv.todoapp.controller.admin

import jakarta.servlet.http.HttpSession
import org.ldv.todoapp.model.repository.UtilisateurRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class UtilisateursController(private val utilisateurRepository: UtilisateurRepository) {
    @GetMapping("/admin/utilisateurs")
    fun mesUtilisateur(model: Model, session: HttpSession): String {

        val utilisateurs = utilisateurRepository.findAllAvecRole()

        model.addAttribute("listeUtilisateurs", utilisateurs)

        return "admin/utilisateurs"
    }
}