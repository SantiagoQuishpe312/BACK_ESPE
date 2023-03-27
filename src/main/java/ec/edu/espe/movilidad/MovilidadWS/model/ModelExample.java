package ec.edu.espe.movilidad.MovilidadWS.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "UZITAREA", schema = "UTIC")
public class ModelExample {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UZITAREA_CODE")
    private Long id;

    @Column(name = "UZITAREA_NAME", nullable = false)
    private String name;

    @Column(name = "UZITAREA_STATE", nullable = false)
    private Boolean state;

    @Column(name = "UZITAREA_FECHA_CREA")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.DATE)
    private Date creationDateA;

    @Column(name = "UZITAREA_USUA_CREA")
    private String creationUser;

    @Column(name = "UZITAREA_FECHA_MODIF")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.DATE)
    private Date modificationDate;

    @Column(name = "UZITAREA_USUA_MODIF")
    private String modificationUser;

}
