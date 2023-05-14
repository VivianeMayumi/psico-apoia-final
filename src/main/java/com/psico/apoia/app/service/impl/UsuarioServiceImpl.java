package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.entity.UsuarioEntity;
import com.psico.apoia.app.exception.SenhaInvalidaException;
import com.psico.apoia.app.mapper.PacienteMapper;
import com.psico.apoia.app.mapper.UsuarioMapper;
import com.psico.apoia.app.repository.PacienteRepository;
import com.psico.apoia.app.repository.UsuarioRepository;
import com.psico.apoia.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Override
    public boolean validarUsuario(String usuario, String senha) {
        UsuarioEntity usuarioEncontrado = usuarioRepository.findByUsuario(usuario);
        Optional<UsuarioEntity> optionalUsuarioEncontrado = Optional.ofNullable(usuarioEncontrado);
        return optionalUsuarioEncontrado.map(usuarioEncontradoValue -> {
            return usuarioEncontradoValue.getSenha().equals(senha);
        }).orElse(false);
    }

    public Usuario obterUsuario(String usuario) {
        UsuarioEntity usuarioEncontrado = usuarioRepository.findByUsuario(usuario);
        PacienteEntity pacienteEntity = pacienteRepository.findByUsuarioId(usuarioEncontrado.getId());
        Usuario usuarioRetorno = pacienteMapper.pacienteEntityToUsuario(pacienteEntity);
        usuarioRetorno.setId(usuarioEncontrado.getId());
        usuarioRetorno.setUsuario(usuarioEncontrado.getUsuario());
        return usuarioRetorno;
    }

    @Override
    public Usuario criarUsuario(String nomeUsuario, String senha, String senhaConfirmacao) {
        Usuario usuario = new Usuario(nomeUsuario, senha);
        UsuarioEntity usuarioEntity = usuarioMapper.usuarioToUsuarioEntity(usuario);
        UsuarioEntity usuarioCriado = usuarioRepository.save(usuarioEntity);
        return usuarioMapper.usuarioEntityToUsuario(usuarioCriado);
    }

    @Override
    public void alterarSenha(String email, String senhaAntiga, String senhaNova, String senhaNovaConfirmacao) throws SenhaInvalidaException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsuario(email);
        if (usuarioEntity.getSenha().equals(senhaAntiga)) {
            if(senhaNova.equals(senhaNovaConfirmacao)) {
                usuarioEntity.setSenha(senhaNova);
                usuarioRepository.save(usuarioEntity);
                return;
            } else {
                throw new SenhaInvalidaException("Nova senha não é igual a senha de confirmação");
            }
        } else {
            throw new SenhaInvalidaException("Senha antiga inválida!");
        }
    }

    @Override
    public void deletarUsuario(String usuario, String senhaConfirmacao) throws SenhaInvalidaException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsuario(usuario);
        if (usuarioEntity.getSenha().equals(senhaConfirmacao)) {
                usuarioRepository.delete(usuarioEntity);
        } else {
                throw new SenhaInvalidaException("Senha inválida!");
        }
    }

}
