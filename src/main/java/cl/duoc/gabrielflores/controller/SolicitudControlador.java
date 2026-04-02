package cl.duoc.gabrielflores.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.gabrielflores.model.Solicitud;
import cl.duoc.gabrielflores.service.SolicitudServicio; 
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("api/v1/solicitudes")
public class SolicitudControlador 
{
    @Autowired
    private SolicitudServicio solicitudServicio;

    @GetMapping
    public ResponseEntity<List<Solicitud>> obtenerTodasSolicitud()  
    {
        return ResponseEntity.ok(solicitudServicio.obtenerTodasSolicitud());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerSolicitudPorId(@PathVariable Long id)
    {
        return solicitudServicio.obtenerSolicitudPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<?> crearSolicitud(@Valid @RequestBody Solicitud solicitud)
    {
        return ResponseEntity.ok(solicitudServicio.crearSolicitud(solicitud));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSolicitud(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud)
    {
        return solicitudServicio.actualizarSolicitud(id, solicitud)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id)
    {
        return solicitudServicio.eliminarSolicitud(id)
            ? ResponseEntity.noContent().build()
            : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/antiguas/{x}")
    public ResponseEntity<List<Solicitud>> obtenerSolicitudAntiguas(@PathVariable int x) 
    {
        return ResponseEntity.ok(solicitudServicio.obtenerSolicitudAntiguas(x));
    }
    
}
