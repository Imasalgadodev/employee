package Ima.Salgado.Empleados02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class ControladorEmpleados {
    
        @Autowired
        private RepositorioEmpleados RepositorioEmpleados;

        @GetMapping
        public List<Empleados> getAllEmpleados() {
            return RepositorioEmpleados.findAll();
        }

        @PostMapping
        public Empleados createEmpleados(@RequestBody Empleados empleados) {
            return RepositorioEmpleados.save(empleados);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Empleados> getEmpleadosById(@PathVariable Long id) {
            Empleados empleados = RepositorioEmpleados.findById(id).orElse(null);
            if (empleados == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(empleados);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Empleados> updateEmpleados(@PathVariable Long id, @RequestBody Empleados updatedempleados) {
            Empleados empleados = RepositorioEmpleados.findById(id).orElse(null);
            if (empleados == null) {
                return ResponseEntity.notFound().build();
            }
            empleados.setNombre(updatedempleados.getNombre());
            empleados.setApellido(updatedempleados.getApellido());

            RepositorioEmpleados.save(empleados);
            return ResponseEntity.ok(empleados);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEmpleados(@PathVariable Long id) {
            Empleados empleados = RepositorioEmpleados.findById(id).orElse(null);
            if (empleados == null) {
                return ResponseEntity.notFound().build();
            }
            RepositorioEmpleados.delete(empleados);
            return ResponseEntity.noContent().build();
        }
}
