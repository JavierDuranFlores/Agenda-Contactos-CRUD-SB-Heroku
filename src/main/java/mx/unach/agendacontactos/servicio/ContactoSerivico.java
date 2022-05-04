package mx.unach.agendacontactos.servicio;

import java.util.List;

import mx.unach.agendacontactos.modelo.Contacto;

public interface ContactoSerivico {

	public abstract List<Contacto> listaContacto();

	public abstract Contacto contacto(Integer id);

	public abstract Contacto agregar(Contacto contacto);

	public abstract Contacto actualizar(Contacto contacto);

	public abstract void eliminar(Integer id);

}
