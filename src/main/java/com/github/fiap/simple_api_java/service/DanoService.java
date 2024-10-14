package com.github.fiap.simple_api_java.service;
import com.github.fiap.simple_api_java.Exception.UserNaoEncontrado;
import com.github.fiap.simple_api_java.dto.DanoCadastroDTO;
import com.github.fiap.simple_api_java.dto.DanoExibicaoDTO;
import com.github.fiap.simple_api_java.model.Danos;
import com.github.fiap.simple_api_java.repository.DanoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DanoService {

    @Autowired
    private DanoRepository danoRepository;

    public DanoExibicaoDTO cadastrar (DanoCadastroDTO danoCadastroDTO){
        Danos danos = new Danos();
        BeanUtils.copyProperties(danoCadastroDTO, danos);

        Danos salvarDanos = danoRepository.save(danos);
        return new DanoExibicaoDTO(salvarDanos);
    }

    public DanoExibicaoDTO atualizar (Danos danos){
        Optional<Danos> danosOptional = danoRepository.findById(danos.getId());
        if(danosOptional.isPresent()){
            danoRepository.save(danos);
            return new DanoExibicaoDTO(danos);
        }else{
            throw new UserNaoEncontrado("Dano não Cadastrado");
        }
    }

    public void excluir (Long id){
        Optional<Danos> danosOptional = danoRepository.findById(id);
        if (danosOptional.isPresent()){
            danoRepository.delete(danosOptional.get());
        }else{
            throw new UserNaoEncontrado("Dano não cadastrado");
        }
    }

    public Page<DanoExibicaoDTO> listarTodos (Pageable pageable){
        return danoRepository.findAll(pageable) .map(DanoExibicaoDTO::new);
    }

}
