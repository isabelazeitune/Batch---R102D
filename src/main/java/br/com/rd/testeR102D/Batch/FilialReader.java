package br.com.rd.testeR102D.Batch;

import br.com.rd.testeR102D.Model.FilialModel;
import br.com.rd.testeR102D.Repository.FilialRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class FilialReader implements ItemReader<FilialModel> {

    private int nextFilialIndex;

    @Autowired
    FilialRepository filialRepository;

    @Override
    public FilialModel read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        List<FilialModel> lista = filialRepository.itemReader();

        FilialModel nextFilial = null;

        if(nextFilialIndex < lista.size()) {
            nextFilial = lista.get(nextFilialIndex);
            nextFilialIndex++;
        } else {
            nextFilialIndex = 0;
        }

        return nextFilial;
    }

}
