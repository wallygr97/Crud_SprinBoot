package edu.pucmm.tarea_clase_crud_springboot.controlador;

import edu.pucmm.tarea_clase_crud_springboot.entidades.Estudiante;
import edu.pucmm.tarea_clase_crud_springboot.repositorios.EstudianteRepo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiante/")
public class EstudianteController {

    //@Autowired
    EstudianteRepo estudianteRepo;

    public EstudianteController(EstudianteRepo estudianteRepo) {
        this.estudianteRepo = estudianteRepo;
    }

    @RequestMapping("/")
    public String listaEstudiante(Model modelo){
        modelo.addAttribute("titulo", "Lista de Estudiante");
        modelo.addAttribute("lista", estudianteRepo.findAll());
        return "lista";
    }

    @RequestMapping("/crear")
    public String crearEstudiante(Model modelo){
        modelo.addAttribute("titulo", "Crear Estudiante");
        modelo.addAttribute("label", "Crear Estudiante");
        return "crearEditar";
    }

    /*@PostMapping("/procesarEstudiante")
    public String procesarEstudiante(Model modelo,
                                     @RequestParam("matricula") int matricula,
                                     @RequestParam String nombre){
        System.out.println("Matricula: "+matricula);
        System.out.println("Nombre: "+nombre);
        //
        return "redirect:/estudiante//";
    }*/

    @PostMapping(path = "/procesarEstudiante", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String parsearEstudianteFormulario(Estudiante estudiante){
        System.out.println("El estudiante: "+estudiante.toString());
        estudianteRepo.save(estudiante);
        return "redirect:/estudiante//";
    }

    @GetMapping("/{matricula}")
    public String editarEstudiante(Model model, @PathVariable int matricula){
        Estudiante estudiante = estudianteRepo.getOne(matricula);
        String label = "Actualizando Matricula: "+estudiante.getNombre();
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("titulo", label);
        model.addAttribute("label", label);
        return "crearEditar";
    }

    @GetMapping(path = "/eliminar/{matricula}")
    public String borrarEstudiante(Model model, @PathVariable int matricula){
        Estudiante estudiante = estudianteRepo.getOne(matricula);
        estudianteRepo.delete(estudiante);
        return "redirect:/estudiante//";
    }

}