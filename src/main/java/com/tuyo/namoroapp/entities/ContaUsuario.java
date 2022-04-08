package com.tuyo.namoroapp.entities;

import javax.persistence.*;

@Entity
public class ContaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private int idade;
    private String email;
    private String genero;
    private String teleNumero;
    private String cidade;
    private String estado;
    private String pais;

    @OneToOne(mappedBy = "contaUsuario")                    // Ele fala o que é mapeado e que não é o proprietário do Join.
    private Interesse interesse;                            // Então, ContaUsuario tem agora um Interesse e Interesse também tem um ContaUsuario.

}
