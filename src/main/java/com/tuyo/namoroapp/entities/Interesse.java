package com.tuyo.namoroapp.entities;

import javax.persistence.*;

@Entity
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String likes;
    private String disLikes;
    private String hobbies;
    private String perfilUrl;
    private String sobre;

    @OneToOne
    @JoinColumn(name = "usuario_id")                    // Realizando o join
    private ContaUsuario contaUsuario;                  //Definindo o relacionamento: Isso é onde queremos ter a FK, que é o usuário ID que aponta para o ID que referencia o ID de ContaUsuario que é usuario_id,
                                                        // sendo essa a FK de ContaUsuario dentro de Interesse.
}                                                       // Configurar o JOIN em ContaUsuario
                                                        // Interesse foi definido como o proprietário. Significando que ele tem no Join a maior porção de tudo.
                                                        // Já em ContaUsuario, com "@OneToOne(mappedBy = "contaUsuario")" ele fala o que é mapeado e que não é o proprietário do Join.
                                                        // mas aqui em Interesse, como proprietário do Join, no relacionamento OneToOne.
                                                        // Então, ContaUsuario tem agora um Interesse e Interesse também tem um ContaUsuario.
