package cl.duoc.gabrielflores.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import cl.duoc.gabrielflores.model.Solicitud;

@Repository
public class SolicitudRepo 
{
    private final Map<Long, Solicitud> registroSolicitud = new HashMap<>();

    //Método para listar todas las solicitudes
    public List<Solicitud> encontrarTodo()
    {
        return new ArrayList<>(registroSolicitud.values());
    }

    //Método para listar solicitud por id
    public Optional<Solicitud> encontrarPorId(Long id)
    {
        return Optional.ofNullable(registroSolicitud.get(id));
    }

    //Método para guardar solicitud
    public Solicitud guardar(Solicitud solicitud)
    {
        registroSolicitud.put(solicitud.getId(),solicitud);
        return solicitud;
    }

    //Método para eliminar solicitud por id
    public void eliminarPorId(Long id)
    {
        registroSolicitud.remove(id);
    }

    //Método para comprobar existencia por id
    public boolean existePorId(Long id)
    {
        return registroSolicitud.containsKey(id);
    }

    //Método para listar x solicitudes más antiguas
    public List<Solicitud> solicitudAntigua(int x)
        {
            if (x <= 0 || registroSolicitud == null || registroSolicitud.isEmpty())
            {
                return Collections.emptyList();
            }

            return registroSolicitud.values().stream()
                .sorted((s1,s2)->s1.getFechaRegistro()
                .compareTo(s2.getFechaRegistro())).limit(x)
                .collect(Collectors.toList());
        }
}
