package com.example.demo.Controller;

import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Entity.Recurso;
import com.example.demo.Service.RecursoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.ReservaDTO;
import com.example.demo.Service.ReservaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recurso")
@CrossOrigin

public class RecursoController extends BaseController<RecursoDTO> {

    private RecursoService service;

    protected RecursoController(RecursoService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/filtro/{nome}")
    public List<RecursoDTO> filtro(@PathVariable("nome") String nome){
        return service.findByTipo(nome);
    }

    @GetMapping("/{id}")
    public RecursoDTO findById(@PathVariable("id") Long id)
    {
        return service.findById(id);
    }

    @GetMapping
    public List<RecursoDTO> findAll(){
        return service.findAll();
    }



    @PostMapping
    public RecursoDTO save(
            @RequestBody @Valid RecursoDTO recursoCreateDTO ){
        return service.save(recursoCreateDTO);
    }

    @PutMapping("/{id}")
    public RecursoDTO update(
            @PathVariable("id")Long id,
            @RequestBody RecursoDTO recursoCreateDTO){
        return service.update(id,recursoCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")Long id){
        service.deleteById(id);
    }
}
