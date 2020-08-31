package br.com.rd.testeR102D.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FilialModel implements Serializable {

    @Id
    @Column(name = "cd_filial")
    private Integer cdFilial;

    @Column(name = "nm_razao")
    String nmRazao;

    @Column(name = "nm_fantasia")
    String nmFantasia;

}
