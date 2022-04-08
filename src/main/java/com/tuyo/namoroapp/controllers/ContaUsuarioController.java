package com.tuyo.namoroapp.controllers;

import com.tuyo.namoroapp.entities.ContaUsuario;
import com.tuyo.namoroapp.repositories.ContaUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContaUsuarioController {

    @Autowired
    private ContaUsuarioRepo usuarioRepo;                                                // Para salvar o usuario no database, precisamos usar ContaUsuarioRepo
                                                                                        //@PostMapping = é o mapeamento do endpoint para a pagina de registros:
    @PostMapping("/usuarios/registrar_usuarios")                                        //@PostMapping =  Este método fica limitado ao Post (publicacão). Ou seja, o usuário usará um histórico das postagens para fazer esta restfull chamar.
    public ContaUsuario registrarUsuario(@RequestBody ContaUsuario contaUsuario) {      //@RequestBody = requerer retorna em requisições JSON
        return usuarioRepo.save(contaUsuario);

    }
}
