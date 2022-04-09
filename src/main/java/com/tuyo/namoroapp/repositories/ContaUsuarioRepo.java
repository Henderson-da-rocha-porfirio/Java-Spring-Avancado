package com.tuyo.namoroapp.repositories;

import com.tuyo.namoroapp.entities.ContaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContaUsuarioRepo extends JpaRepository<ContaUsuario, Integer> {                                    // A querie utilizada alí é usada diretamente com o nome da entidade. Uma nativa querie será gerada para nós sem vermos.
                                                                                                                    //id!=id = significa que queremos passar o find em todos os usuários menos para o id que está sendo passado para este usuarioId porque o usuário está buscando outros id's e não o seu próprio.
    @Query("from ContaUsuario where idade=:idade and cidade=:cidade and estado=:estado and pais=:pais and id!=id")                // Query trabalha com Entidades e não com tabelas do Database. Por isso é utilizado a entidade ContaUsuario diretamente.
    List<ContaUsuario> findMatches(@Param("idade") int idade,@Param("cidade") String cidade,                   //E são passados os parâmetros.
                                   @Param("estado") String estado,@Param("pais") String pais,                  //@Param = Se faz necessário para que se passe o nome do parâmetro, que estamos vinculando.
                                   @Param("id") int id);                                                       // Os parâmetros passados alí serão conectados aos valores passados nas variáveis do controller.

}
