package br.wals.citiesapi.cities.entities;

import br.wals.citiesapi.cities.types.PointType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Data
@Entity(name = "City")
@Table(name = "cidade")
@TypeDefs(
        @TypeDef(name = "point", typeClass = PointType.class)
)
public class City {
    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private Integer state;

    private Integer ibge;

    @Column(name = "lat_lon")
    private String geolocation;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

}
