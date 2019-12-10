package com.springboot.personal.document;

import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "cliente-personal")
public class Personal {

  @Id
  private String id;
  private String tipoDoc;
  private String numDoc;
  private String name;
  private String apePat;
  private String apeMat;
  private String address;
  private List<String> idCuentas;


}
