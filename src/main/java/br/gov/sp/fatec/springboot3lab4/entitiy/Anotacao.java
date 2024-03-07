package br.gov.sp.fatec.springboot3lab4.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ant_anotacao")
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    private Long id;
    @Column(name = "ant_texto")
    private String texto;
    @Column(name = "ant_data_hora")
    private LocalDateTime dataHora;
    @JoinColumn(name = "ant_usr_id")
    @ManyToOne
    @JsonIgnore
    private Usuario usuario;


}
