package br.com.rd.testeR102D.Repository;

import br.com.rd.testeR102D.Model.FilialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilialRepository extends JpaRepository<FilialModel, Integer> {

    @Query(value = "SELECT CD_FILIAL, NM_RAZAO, NM_FANTASIA FROM TB_FILIAL WHERE CD_FILIAL IN (1, 2, 3, 4, 5)", nativeQuery = true)
    List<FilialModel> itemReader();

}
