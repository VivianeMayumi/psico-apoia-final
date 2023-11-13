package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.enums.TipoUsuarioEnum;
import com.psico.apoia.app.mapper.UsuarioMapper;
import com.psico.apoia.app.repository.UsuarioRepository;
import com.psico.apoia.app.service.ICadastroService;
import com.psico.apoia.app.service.IPacienteService;
import com.psico.apoia.app.service.IPsicologoService;
import com.psico.apoia.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroServiceImpl implements ICadastroService {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IPsicologoService psicologoService;
    @Override
    public void cadastrar(Usuario usuario) {
        Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
        if(TipoUsuarioEnum.PACIENTE.name().equals(usuario.getTipoUsuario())) {
            Paciente paciente = usuarioMapper.usuarioToPaciente(usuario);
            paciente.setIdUsuario(usuarioCriado.getId());
            pacienteService.criarPaciente(paciente);
        } else if(TipoUsuarioEnum.PSICOLOGO.name().equals(usuario.getTipoUsuario())) {
            Psicologo psicologo = usuarioMapper.usuarioToPsicologo(usuario);
            psicologo.setIdUsuario(usuarioCriado.getId());
            psicologoService.criarPsicologo(psicologo);
        }
    }
}
