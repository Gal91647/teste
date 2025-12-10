package com.example.demo.Service;

import com.example.demo.DTO.RecursoDTO;
import com.example.demo.Entity.Recurso;
import com.example.demo.Repository.RecursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class RecursoService extends BaseService <Recurso, RecursoDTO> {



    private RecursoRepository repository;

    protected RecursoService(RecursoRepository repository) {
        super(repository);
    }

    public List<RecursoDTO> findByTipo(String nome){
        List<Recurso> recursos = repository.findByTipo(nome);

        List<RecursoDTO> RecursoDTOs = new ArrayList<>();
        for(Recurso recurso : recursos){
            RecursoDTOs.add(toDto(recurso));
        }

        return RecursoDTOs;
    }

    public RecursoDTO findById(Long id) {
        Recurso recurso = repository.findById(id).orElseThrow();
        return toDto(recurso);
    }

    public RecursoDTO update(Long id, RecursoDTO recursoDto) {
        Recurso recurso = toEntity(recursoDto);
        recurso.setId(id);
        recurso = repository.save(recurso);
        return toDto(recurso);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<RecursoDTO> findAll() {
        List<Recurso> recursos = repository.findAll();
        List<RecursoDTO> recursosDto = new ArrayList<>();
        for (Recurso recurso : recursos) {
            recursosDto.add(toDto(recurso));
        }
        return recursosDto;
    }

//    public RecursoDTO save(RecursoDTO recursoDto) {
//        Recurso recurso = toEntity(recursoDto);
//        recurso = repository.save(recurso);
//
//    }

    public RecursoDTO toDto(Recurso recurso) {
        RecursoDTO dto = new RecursoDTO();
        BeanUtils.copyProperties(recurso, dto);
        return dto;
    }

    public Recurso toEntity(RecursoDTO dto) {
        Recurso recurso = new Recurso();
        BeanUtils.copyProperties(dto, recurso);
        return recurso;
    }
}