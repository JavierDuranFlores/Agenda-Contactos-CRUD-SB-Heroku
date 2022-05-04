package mx.unach.agendacontactos.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.unach.agendacontactos.modelo.Contacto;
import mx.unach.agendacontactos.servicio.impl.ContactoServicioImpl;

@Controller("contactoControlador")
public class ContactoControlador {

	@Autowired
	@Qualifier("contactoServicioImpl")
	private ContactoServicioImpl contactoServicioImpl;

	@RequestMapping( path = {"/", ""}, method = RequestMethod.GET  )
	public String home(Model modelo) {
		List<Contacto> contactos = contactoServicioImpl.listaContacto();
		modelo.addAttribute("contactos", contactos);
		return "index";
	}
	
	@RequestMapping( path = "/nuevo", method = RequestMethod.GET)
	public String mostratFormularioRegistroContacto(Model modelo) {
		modelo.addAttribute("contacto", new Contacto());
		return "nuevo";
	}
	
	@RequestMapping( path = "/nuevo", method = RequestMethod.POST)
    public String mostartFormRegistroContacto(@Validated Contacto contacto, 
    										  BindingResult bindingResult,
    										  RedirectAttributes redirect,
    										  Model modelo) {
		if (bindingResult.hasErrors()) {
			modelo.addAttribute("contacto", contacto);
			return "nuevo";
		}
		
		contactoServicioImpl.agregar(contacto);
    	redirect.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");
    	
        return "redirect:/";
    }

    @RequestMapping( path = "/{id}/editar", method = RequestMethod.GET)
    public String mostratFormularioEditarContacto(@PathVariable Integer id,  Model modelo) {
        Contacto contacto = contactoServicioImpl.contacto(id);
        modelo.addAttribute("contacto", contacto);
        return "nuevo";
    }

    @RequestMapping( path = "/{id}/editar", method = RequestMethod.POST)
    public String actualizarContacto(@PathVariable Integer id, @Validated Contacto contacto,
                                              BindingResult bindingResult,
                                              RedirectAttributes redirect,
                                              Model modelo) {
        Contacto contactoDB = contactoServicioImpl.contacto(id);


        if (bindingResult.hasErrors()) {
            modelo.addAttribute("contacto", contacto);
            return "nuevo";
        }

        contactoDB.setNombre(contacto.getNombre());
        contactoDB.setCelular(contacto.getCelular());
        contactoDB.setEmail(contacto.getEmail());
        contactoDB.setPais(contacto.getPais());
        contactoDB.setFechaNacimiento(contacto.getFechaNacimiento());

        contactoServicioImpl.agregar(contactoDB);
        redirect.addFlashAttribute("msgExito", "El contacto ha sido actualizado correctamente");

        return "redirect:/";
    }

    @RequestMapping( path = "/{id}/eliminar", method = RequestMethod.POST)
    public String eliminarContacto(@PathVariable Integer id, RedirectAttributes redirect) {
        contactoServicioImpl.eliminar(id); 
        redirect.addFlashAttribute("msgExito", "El contacto ha sido eliminado correctamente");
        return "redirect:/";
    }
	
}
