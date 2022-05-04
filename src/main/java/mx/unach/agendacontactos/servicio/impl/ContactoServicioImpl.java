package mx.unach.agendacontactos.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.unach.agendacontactos.modelo.Contacto;
import mx.unach.agendacontactos.repositorio.ContactoRepositorio;
import mx.unach.agendacontactos.servicio.ContactoSerivico;

@Service("contactoServicioImpl")
public class ContactoServicioImpl implements ContactoSerivico{

	@Autowired
	@Qualifier("contactoRepositorio")
	private ContactoRepositorio contactoRepositorio;
	
	@Override
	public List<Contacto> listaContacto() {
		// TODO Auto-generated method stub
		return contactoRepositorio.findAll();
	}

	@Override
	public Contacto contacto(Integer id) {
		// TODO Auto-generated method stub
		return contactoRepositorio.getById(id);
	}

	@Override
	public Contacto actualizar(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepositorio.save(contacto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		contactoRepositorio.delete(contactoRepositorio.getById(id));
	}

	@Override
	public Contacto agregar(Contacto contacto) {
		// TODO Auto-generated method stub
		return contactoRepositorio.save(contacto);
	}

}
