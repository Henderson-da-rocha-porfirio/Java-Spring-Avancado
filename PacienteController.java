package com.tuyo.clinicaapi.controllers;

import com.tuyo.clinicaapi.model.Paciente;
import com.tuyo.clinicaapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController                                 // Isso realiza um restfull controller.
@RequestMapping("/api")                         // Mapear a Path URL
public class PacienteController {               // Isso se tornará um restfull Controller.
                                                // US1: 1. Mostrar em tela todos os detalhes dos pacientes com o seu id, primeiroNome, ultimoNome e idade.
    private PacienteRepository repository;      // Construtor injetor

    @Autowired                                              // @Autowired = injeção de dependência. Essa anotação diz ao Spring que esse bean em particular tem que ser autowired
    PacienteController(PacienteRepository repository){      // Dentro deste construtor, this.repository é igual ao repository que receberemos como um construtor
        this.repository = repository;                          // Traz a injeção a esse repositório para o nosso runtime
    }

    public List<Paciente> getPacientes() {
          return null;                          // Este método tanto faz a lista de importação de nomes, bem como o controle de um paciente.
                                                // E dentro deste método, necessitamos acessar o repositório, então aperte o controle um para "adicionar" uma declaração escrita
    }
}
