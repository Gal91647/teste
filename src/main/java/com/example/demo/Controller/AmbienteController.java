package com.example.demo.Controller;

import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.Service.AmbienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ambientes")

public class AmbienteController extends BaseController<AmbienteDTO> {

    protected AmbienteController(AmbienteService service){
        super(service);
    }
    @GetMapping("/recursos/{ambienteId}/{recursoId}")

    public AmbienteDTO findById(@PathVariable("id") Long id)
    {
        return service.findById(id);
    }



}
