package br.com.mpx.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mpx.api.model.DTOUsuario;
import br.com.mpx.api.model.input.DTOUsuarioInput;
import br.com.mpx.domain.model.Usuario;

@Component
public class DTOUsuarioMapper implements DTOMapper<DTOUsuario, Usuario> {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Usuario dtoToEntidade(DTOUsuario dtoUsuario) {
		return modelMapper.map(dtoUsuario, Usuario.class);		
	}
	
	@Override
	public DTOUsuario entidadeToDto(Usuario usuario) {
		return modelMapper.map(usuario, DTOUsuario.class);
	}
	
	@Override
	public List<DTOUsuario> listaEntidadeToListaDto(List<Usuario> usuarios){
		return usuarios.stream()
				.map(usuario -> entidadeToDto(usuario))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listaDtoToListaEntidade(List<DTOUsuario> dtoUsuarios){
		return dtoUsuarios.stream()
				.map(dto -> this.dtoToEntidade(dto))
				.collect(Collectors.toList());
	}
	
	public void copiarToEntidade(DTOUsuarioInput usuarioInput, Usuario usuario) {		
		modelMapper.map(usuarioInput, usuario);
	}

}
