package ec.edu.espe.plantillaEspe.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoExample {
    private Long id;
    private String nombre;
    private Boolean estado;
    private Date fechaCreacion;
    private String UsuarioCreacion;
    private Date fechaModificacion;
    private String UsuarioModificacion;
}
