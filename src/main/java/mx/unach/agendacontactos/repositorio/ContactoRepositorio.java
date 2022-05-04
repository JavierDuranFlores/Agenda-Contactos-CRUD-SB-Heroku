package mx.unach.agendacontactos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.unach.agendacontactos.modelo.Contacto;

@Repository("contactoRepositorio")
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer>{

	//Contacto deteleByIdContacto(Integer id);
	
}
