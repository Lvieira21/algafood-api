package com.lucas.algafood.api.controller;

import com.lucas.algafood.domain.exceptions.EntidadeEmUsoException;
import com.lucas.algafood.domain.exceptions.EntidadeNaoEncontradaException;
import com.lucas.algafood.domain.model.Cozinha;
import com.lucas.algafood.domain.repository.CozinhaRepository;
import com.lucas.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/cozinhas"/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    //Chamada de Collection Resource
    @GetMapping(/*produces = MediaType.APPLICATION_JSON_VALUE*/) //- Se quiser que somente responda com representações JSON
    public List<Cozinha> listar() {
        return cozinhaRepository.getCozinhas();
    }

    //Singleton Resource
    //@ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) { //@PathVariable - Pegando a variavel no header da requisição e atribuindo à Long id
        Cozinha cozinha = cozinhaRepository.getCozinhaById(id);

        if (cozinha != null)
            return ResponseEntity.ok(cozinha);

        return ResponseEntity.notFound().build();

//        return ResponseEntity.status(HttpStatus.OK).body(cozinha);
//        return ResponseEntity.status(HttpStatus.FOUND)
//                .headers(httpHeaders -> httpHeaders
//                        .add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas"))
//                .build(); //Redirecionamento por headers
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cozinha adicionar (@RequestBody Cozinha cozinha) {
        return cadastroCozinhaService.setCozinha(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinhaNova) {
        Cozinha cozinhaPersistida = cozinhaRepository.getCozinhaById(cozinhaId);
        if (cozinhaPersistida == null)
            return ResponseEntity.notFound().build();

        BeanUtils.copyProperties(cozinhaNova, cozinhaPersistida, "id");

        cadastroCozinhaService.setCozinha(cozinhaPersistida);

        return ResponseEntity.ok(cozinhaPersistida);
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
        try {
            cadastroCozinhaService.removeCozinha(cozinhaId);

            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
