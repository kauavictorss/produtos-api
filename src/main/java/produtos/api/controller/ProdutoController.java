package produtos.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import produtos.api.model.Produto;
import produtos.api.repository.ProdutoRepository;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        repository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable String id, @RequestBody Produto produto) {
        produto.setId(id);
        repository.save(buscarPorId(id));
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable String id) {
        repository.deleteById(id);
    }
}
