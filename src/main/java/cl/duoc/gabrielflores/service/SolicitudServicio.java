package cl.duoc.gabrielflores.service;

//imports
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.gabrielflores.model.Solicitud;
import cl.duoc.gabrielflores.repository.SolicitudRepo;

//Clase
@Service
public class SolicitudServicio 
{
    //inicializa repo
    @Autowired
    private SolicitudRepo solicitudRepo;

    //Métodos
    public SolicitudServicio(SolicitudRepo solicitudRepo)
    {
        this.solicitudRepo = solicitudRepo;
    }

    //Método para obtener todas las solicitudes
    public List<Solicitud> obtenerTodasSolicitud()
    {
        return solicitudRepo.encontrarTodo();
    }

    //Método para obtener solicitud por Id
    public Optional<Solicitud> obtenerSolicitudPorId(Long id)
    {
        return solicitudRepo.encontrarPorId(id);
    }

    //Método para crear una solicitud
    public Solicitud crearSolicitud(Solicitud solicitud)
    {
        return solicitudRepo.guardar(solicitud);
    }

    public Optional<Solicitud> actualizarSolicitud(Long id, Solicitud solicitud)
    {
        if (solicitudRepo.existePorId(id))
        {
            solicitud.setId(id);
            return Optional.of(solicitudRepo.guardar(solicitud));
        }
        return Optional.empty();
    }

    public boolean eliminarSolicitud(Long id)
    {
        if (solicitudRepo.existePorId(id))
        {
            solicitudRepo.eliminarPorId(id);
            return true;
        }
        return false;
    }

    public List<Solicitud> obtenerSolicitudAntiguas(int x)
    {
        return solicitudRepo.solicitudAntigua(x);
    }
}
