package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Palestra;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.entity.PalestraEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.entity.UsuarioEntity;
import com.psico.apoia.app.enums.TipoUsuarioEnum;
import com.psico.apoia.app.exception.SenhaInvalidaException;
import com.psico.apoia.app.mapper.PacienteMapper;
import com.psico.apoia.app.mapper.PalestraMapper;
import com.psico.apoia.app.mapper.PsicologoMapper;
import com.psico.apoia.app.mapper.UsuarioMapper;
import com.psico.apoia.app.repository.PacienteRepository;
import com.psico.apoia.app.repository.PalestraRepository;
import com.psico.apoia.app.repository.PsicologoRepository;
import com.psico.apoia.app.repository.UsuarioRepository;
import com.psico.apoia.app.service.IPalestraService;
import com.psico.apoia.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PalestraServiceImpl implements IPalestraService {

    @Autowired
    private PalestraRepository palestraRepository;

    @Autowired
    private PalestraMapper palestraMapper;
    @Override
    public List<Palestra> obterTodasPalestras() {
        Iterable<PalestraEntity> todasPalestras = palestraRepository.findAll();
        List<PalestraEntity> resultado = new ArrayList<>();
        todasPalestras.forEach(resultado::add);
        return palestraMapper.palestraEntityToPalestra(resultado);
    }
}
