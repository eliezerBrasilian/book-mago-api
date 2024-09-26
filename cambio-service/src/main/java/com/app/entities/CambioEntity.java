package com.app.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cambios")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CambioEntity {
    @Id
    String id;
    String from;
    String to;
    Double convertionFactor;

    public CambioEntity(String from, String to, Double convertionFactor) {
        this.from = from;
        this.to = to;
        this.convertionFactor = convertionFactor;
    }
}
