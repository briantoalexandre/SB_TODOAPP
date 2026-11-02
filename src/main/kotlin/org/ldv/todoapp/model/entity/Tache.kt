package org.ldv.todoapp.model.entity


import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import javax.print.attribute.standard.DateTimeAtCreation

@Entity
@Table(name="tache")
open class Tache(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tache")
    open var idTache: Long? = null,
    @Column(name="titre", nullable = false, length=255)
    open var titre: String = "",
    @Column(name = "description", columnDefinition = "TEXT")
    open var description: String? = null,
    @Column(name = "date_creation", nullable = false)
    open var dateCreation: LocalDateTime = LocalDateTime.now(),
    @Column(name = "date_echeance")
    open var  dateEcheance: LocalDate? = null,
    @Column(name = "termine", nullable = false)
    open var termine: Boolean = false,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fkid_utilisateur", referencedColumnName = "id_utilisateur", nullable = false)
    open var utilisateur: Utilisateur? = null
) {
}