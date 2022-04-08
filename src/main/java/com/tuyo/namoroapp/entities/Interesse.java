package com.tuyo.namoroapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter                                                             // Usando Lombok anotações. Economiza vários blocos de código = Getter
@Setter                                                             // Usando Lombok anotações. Economiza vários blocos de código = Setter
@NoArgsConstructor                                                  // Usando Lombok anotações = NoArgsConstructor. Esta função dirá ao lombok para gerar um construtor sem argumento para ContaUsuario. Não é obrigatório o uso.
@AllArgsConstructor                                                 // Estas anotações farão o Lombok gerar Getter e Setter sem Construtores (NoArgsConstructor) e também um Construtor(AllArgsConstructor) que pegará todos os argumentos e também os argumentos construtores.
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String likes;
    @Column(name="dislikes")
    private String disLikes;
    private String hobbies;
    @Column(name="perfil_url")
    private String perfilUrl;
    private String sobre;
    @Transient
    private int contaUsuarioId;                                     // permite que apenas uma vez seja criada uma conta para cada usuário.
                                                                    // @Transient = este campo nunca será salvo no Database.
    @OneToOne
    @JoinColumn(name = "usuario_id")                    // Realizando o join
    private ContaUsuario contaUsuario;                  //Definindo o relacionamento: Isso é onde queremos ter a FK, que é o usuário ID que aponta para o ID que referencia o ID de ContaUsuario que é usuario_id,
                                                        // sendo essa a FK de ContaUsuario dentro de Interesse.
}                                                       // Configurar o JOIN em ContaUsuario
                                                        // Interesse foi definido como o proprietário. Significando que ele tem no Join a maior porção de tudo.
                                                        // Já em ContaUsuario, com "@OneToOne(mappedBy = "contaUsuario")" ele fala o que é mapeado e que não é o proprietário do Join.
                                                        // mas aqui em Interesse, como proprietário do Join, no relacionamento OneToOne.
                                                        // Então, ContaUsuario tem agora um Interesse e Interesse também tem um ContaUsuario.
