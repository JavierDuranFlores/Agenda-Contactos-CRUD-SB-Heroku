package mx.unach.agendacontactos.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "contactos" )
@AllArgsConstructor
@NoArgsConstructor
public class Contacto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	@Getter @Setter
	private Integer id;
		
	@NotBlank( message = "Debe ingresar su nombre")
	@Getter @Setter
	private String nombre;
	
	@NotEmpty( message = "Debe ingresar su email")
	@Email
	@Getter @Setter
	private String email;
	
	@NotBlank( message = "Debe ingresar su celular")
	@Getter @Setter
	private String celular;
	
	@NotBlank( message = "Debe ingresar su pais")
	@Getter @Setter
	private String pais;
	
	@DateTimeFormat( iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe ingresar su fecha de nacimiento")
	@Column( name = "fecha_nacimiento" )
	@Getter @Setter
	private LocalDate fechaNacimiento;
	
	@Column( name = "fecha_registro" )
	@Getter @Setter
	private LocalDateTime fechaRegistro;
	
	@PrePersist
	public void asignarFechaRegistro() {
		fechaRegistro = LocalDateTime.now();
	}
	
}
