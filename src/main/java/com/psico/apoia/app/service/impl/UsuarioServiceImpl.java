package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.entity.UsuarioEntity;
import com.psico.apoia.app.exception.SenhaInvalidaException;
import com.psico.apoia.app.mapper.UsuarioMapper;
import com.psico.apoia.app.repository.UsuarioRepository;
import com.psico.apoia.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public boolean validarUsuario(String email, String senha) {
        List<UsuarioEntity> usuarios = usuarioRepository.findByUsuario(email);
        for (UsuarioEntity usuarioEntity : usuarios) {
            if (usuarioEntity.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario criarUsuario(String nomeUsuario, String senha, String senhaConfirmacao) {
        Usuario usuario = new Usuario(nomeUsuario, senha);
        UsuarioEntity usuarioEntity = usuarioMapper.usuarioToUsuarioEntity(usuario);
        UsuarioEntity usuarioCriado = usuarioRepository.save(usuarioEntity);
        return usuarioMapper.usuarioEntityToUsuario(usuarioCriado);
    }

    @Override
    public void alterarSenha(String email, String senhaAntiga, String senhaNova) throws SenhaInvalidaException {
        List<UsuarioEntity> usuarios = usuarioRepository.findByUsuario(email);
        for (UsuarioEntity usuarioEntity : usuarios) {
            if (usuarioEntity.getSenha().equals(senhaAntiga)) {
                usuarioEntity.setSenha(senhaNova);
                usuarioRepository.save(usuarioEntity);
                return;
            }
        }
        throw new SenhaInvalidaException("Senha antiga inválida!");
    }


}
