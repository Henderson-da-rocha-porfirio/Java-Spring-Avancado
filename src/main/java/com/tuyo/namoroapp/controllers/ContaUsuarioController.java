package com.tuyo.namoroapp.controllers;

import com.tuyo.namoroapp.entities.ContaUsuario;
import com.tuyo.namoroapp.entities.Interesse;
import com.tuyo.namoroapp.repositories.ContaUsuarioRepo;
import com.tuyo.namoroapp.repositories.InteresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContaUsuarioController {

    @Autowired
    private ContaUsuarioRepo usuarioRepo;
    @Autowired
    private InteresseRepo interesseRepo;
                                                                                        //@PostMapping = é o mapeamento do endpoint para a pagina de registros:
    @PostMapping("/usuarios/registrar_usuarios")                                        //@PostMapping =  Este método fica limitado ao Post (publicacão). Ou seja, o usuário usará um histórico das postagens para fazer esta restfull chamar.
    public ContaUsuario registrarUsuario(@RequestBody ContaUsuario contaUsuario) {      //@RequestBody = requerer retorna em requisições JSON
        return usuarioRepo.save(contaUsuario);
    }

    @PostMapping("/interesses/update")
    public Interesse atualizarInteresse(@RequestBody Interesse interesse) {
        ContaUsuario contaUsuario = usuarioRepo.findById(interesse.getContaUsuarioId()).get();
        interesse.setContaUsuario(contaUsuario);
        return interesseRepo.save(interesse);

    }
}
