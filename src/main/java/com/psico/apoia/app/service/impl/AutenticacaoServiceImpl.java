package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.entity.UsuarioEntity;
import com.psico.apoia.app.exception.SenhaInvalidaException;
import com.psico.apoia.app.mapper.UsuarioMapper;
import com.psico.apoia.app.repository.UsuarioRepository;
import com.psico.apoia.app.service.IAutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacaoServiceImpl implements IAutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public boolean autenticar(String email, String senha) {
        List<UsuarioEntity> usuarios = usuarioRepository.findByEmail(email);
        for (UsuarioEntity usuarioEntity : usuarios) {
            if (usuarioEntity.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void cadastrarLogin(String email, String senha) {
        Usuario usuario = new Usuario(email, senha);
        UsuarioEntity usuarioEntity = usuarioMapper.usuarioToUsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    @Override
    public void alterarSenha(String email, String senhaAntiga, String senhaNova) throws SenhaInvalidaException {
        List<UsuarioEntity> usuarios = usuarioRepository.findByEmail(email);
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
