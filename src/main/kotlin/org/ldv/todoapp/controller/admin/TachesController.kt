package org.ldv.todoapp.controller.admin

import jakarta.servlet.http.HttpSession
import org.ldv.todoapp.model.repository.TacheRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TachesController(private val tacheRepository: TacheRepository) {
    @GetMapping("/admin/taches")
    fun mesTaches(model: Model, session: HttpSession): String {

        val taches = tacheRepository.findAllAvecUtilisateur()

        model.addAttribute("listeTaches", taches)

        return "admin/taches"
    }
}