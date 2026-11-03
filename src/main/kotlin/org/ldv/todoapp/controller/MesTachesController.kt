package org.ldv.todoapp.controller


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MesTachesController {
    @GetMapping("/mes-taches")
    fun mesTaches(): String {
        return "mes-taches"
    }
}