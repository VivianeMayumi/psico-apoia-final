package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Paciente;
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
    @Autowired
    private PacienteServiceImpl pacienteServiceImpl;

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

    //validar senha com senhaConfirmada e verificar se foram preenchidas
    @Override
    public Usuario criarUsuario(String nomeUsuario, String senha, String senhaConfirmacao)  {

        if(nomeUsuario == null||nomeUsuario.isEmpty()){
            throw new IllegalArgumentException("Usuário não preenchido!");
        }else if(senha==null ||senha.isEmpty()||  senhaConfirmacao ==null|| senhaConfirmacao.isEmpty()){
            throw new IllegalArgumentException("Senha não informada, por favor preencher");
        }
        UsuarioEntity usuarioBusca = usuarioRepository.findByUsuario(nomeUsuario);
        if(usuarioBusca!=null){
            throw new IllegalArgumentException("Usuário já existente!");
        }else if (senha.equals(senhaConfirmacao)) {
            Usuario usuario = new Usuario(nomeUsuario, senha);
            UsuarioEntity usuarioEntity = usuarioMapper.usuarioToUsuarioEntity(usuario);
            UsuarioEntity usuarioCriado = usuarioRepository.save(usuarioEntity);
            return usuarioMapper.usuarioEntityToUsuario(usuarioCriado);

        }
        throw new IllegalArgumentException("As senhas não correspondem.");
    }

    @Override
    public void alterarSenha(Integer id, String senhaAntiga, String senhaNova, String senhaNovaConfirmacao) throws SenhaInvalidaException {
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(id);
        optionalUsuarioEntity.ifPresent(usuarioEntity -> {
            if (usuarioEntity.getSenha().equals(senhaAntiga)) {
                if (senhaNova.equals(senhaNovaConfirmacao)) {
                    usuarioEntity.setSenha(senhaNova);
                    usuarioRepository.save(usuarioEntity);
                    return;
                } else {
                    throw new SenhaInvalidaException("Nova senha não é igual a senha de confirmação");
                }
            } else {
                throw new SenhaInvalidaException("Senha antiga inválida!");
            }
        });
    }

    @Override
    public void deletarUsuario(String usuario) throws SenhaInvalidaException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByUsuario(usuario);
        usuarioRepository.delete(usuarioEntity);
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) {
        Optional<UsuarioEntity> optinalUsuarioEntityBancoDados = usuarioRepository.findById(usuario.getId());
        return optinalUsuarioEntityBancoDados.map(usuarioEntityBancoDados ->{
            Paciente paciente = usuarioMapper.usuarioToPaciente(usuario); //método que converte objeto usuário em objeto paciente
            paciente.setId(usuario.getId()); //copia o id de um para o outro
            Paciente pacienteAtualizado = pacienteServiceImpl.atualizarPaciente(paciente);
            Usuario usuarioAtualizado = usuarioMapper. pacienteToUsuario(pacienteAtualizado);//set de paciente em usuário implementado em mapper

            return usuarioAtualizado;
        }).orElse(null);

    }
}
