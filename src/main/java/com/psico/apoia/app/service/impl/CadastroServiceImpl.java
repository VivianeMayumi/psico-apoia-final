package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.mapper.UsuarioMapper;
import com.psico.apoia.app.repository.UsuarioRepository;
import com.psico.apoia.app.service.ICadastroService;
import com.psico.apoia.app.service.IPacienteService;
import com.psico.apoia.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroServiceImpl implements ICadastroService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPacienteService pacienteService;

    @Override
    public void cadastrar(Usuario usuario) {
        Usuario usuarioCriado = usuarioService.criarUsuario(usuario.getUsuario(), usuario.getSenha(), usuario.getSenhaConfirmacao());
        Paciente paciente = usuarioMapper.usuarioToPaciente(usuario);
        paciente.setIdUsuario(usuarioCriado.getId());
        pacienteService.criarPaciente(paciente);
    }
}
