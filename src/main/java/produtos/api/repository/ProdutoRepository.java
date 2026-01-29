package produtos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import produtos.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
