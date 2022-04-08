package com.tuyo.namoroapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter                                                 // Usando Lombok anotações. Economiza vários blocos de código = Getter
@Setter                                                 // Usando Lombok anotações. Economiza vários blocos de código = Setter
@NoArgsConstructor                                      // Usando Lombok anotações = NoArgsConstructor. Esta função dirá ao lombok para gerar um construtor sem argumento para ContaUsuario. Não é obrigatório o uso.
@AllArgsConstructor                                     // Estas anotações farão o Lombok gerar Getter e Setter sem Construtores (NoArgsConstructor) e também um Construtor(AllArgsConstructor) que pegará todos os argumentos e também os argumentos construtores.
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
