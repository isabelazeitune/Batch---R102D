package br.com.rd.testeR102D.Batch;

import br.com.rd.testeR102D.Model.FilialModel;
import br.com.rd.testeR102D.Repository.FilialRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.util.List;

@Component
public class FilialWriter implements ItemWriter<FilialModel> {

    @Autowired
    private FilialRepository filialRepository;

    @Override
    public void write(List<? extends FilialModel> filialModels) throws Exception {
        salvarAquivo(filialModels);
    }

    public void salvarAquivo(List<? extends FilialModel> filialModels) throws Exception {

        FileWriter writer = new FileWriter("src/main/resources/filial.csv");
        writer.append("CD_FILIAL, NM_RAZAO, NM_FANTASIA");

        System.out.println(filialModels);

        if(filialModels != null) {
            for (int i = 0; i < filialModels.size(); i++) {
                Integer cdFilial = filialModels.get(i).getCdFilial();
                String nmRazao = filialModels.get(i).getNmRazao();
                String nmFantasia = filialModels.get(i).getNmFantasia();

                writer.append('\n');
                writer.append(cdFilial + ", " + nmRazao + ", " + nmFantasia);
                System.out.println(cdFilial + ", " + nmRazao + ", " + nmFantasia);
            }
        }

        writer.flush();
        writer.close();

    }
}
