package com.tuyo.tuyofood.api.controller;

import com.tuyo.tuyofood.domain.entity.Restaurant;
import com.tuyo.tuyofood.domain.exception.EntidadeNaoEncontradaException;
import com.tuyo.tuyofood.domain.repository.RestaurantRepository;
import com.tuyo.tuyofood.domain.service.RestaurantRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/* <?> = WILDCARD: é um coringa. Alí, no caso, aceita um ResponseEntity com
* qualquer tipo de corpo. Podendo ser uma String, um Restaurant ou qualquer outro tipo ou coisa. */

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantRegisterService restaurantRegisterService;

    @GetMapping
    public List<Restaurant> listar() {
        return restaurantRepository.listar();
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> buscar(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantRepository.buscar(restaurantId);

        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurant restaurant) {
        try {
            restaurant = restaurantRegisterService.salvar(restaurant);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restaurant);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<?> atualizar(@PathVariable Long restaurantId,
                                       @RequestBody Restaurant restaurant) {
        try {
            Restaurant restaurantAtual = restaurantRepository.buscar(restaurantId);

            if (restaurantAtual != null) {
                BeanUtils.copyProperties(restaurant, restaurantAtual, "id");

                restaurantAtual = restaurantRegisterService.salvar(restaurantAtual);
                return ResponseEntity.ok(restaurantAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/{restaurantId}")
    public ResponseEntity<?> atualizarParcial(@PathVariable Long restaurantId,
                                              @RequestBody Map<String, Object> campos) {
        Restaurant restaurantAtual = restaurantRepository.buscar(restaurantId);

        if (restaurantAtual == null) {
            return ResponseEntity.notFound().build();
        }

        merge(campos, restaurantAtual);

        return atualizar(restaurantId, restaurantAtual);
    }

    private void merge(Map<String, Object> camposOrigem, Restaurant restaurantDestino) {
        camposOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            System.out.println(nomePropriedade + " = " + valorPropriedade);
        });
    }
}
