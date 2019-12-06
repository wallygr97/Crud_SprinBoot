package edu.pucmm.tarea_clase_crud_springboot.repositorios;

import edu.pucmm.tarea_clase_crud_springboot.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepo extends JpaRepository<Estudiante, Integer> {

    List<Estudiante> findAllByNombreLike(String nombre);
}
