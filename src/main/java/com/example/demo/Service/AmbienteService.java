package com.example.demo.Service;

import com.example.demo.DTO.AmbienteDTO;
import com.example.demo.Entity.Ambiente;
import com.example.demo.Repository.AmbienteRepository;
import org.springframework.stereotype.Service;

@Service
public class AmbienteService extends BaseService<Ambiente, AmbienteDTO> {

    private AmbienteRepository repository;

    protected AmbienteService(AmbienteRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void delete(Long id) {
        boolean reservado = repository.temReservaFutura(id);

        if (reservado) {
            throw new IllegalStateException("Ambiente possui reservas futuras e não pode ser excluído.");
        }

        super.delete(id);
    }

    public AmbienteDTO findById(Long id) {
        Ambiente ambiente = repository.findById(id).orElseThrow();
        return toDto(ambiente);


    }
}