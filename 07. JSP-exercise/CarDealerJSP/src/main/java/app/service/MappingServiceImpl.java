package app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

public class MappingServiceImpl implements MappingService{

	private final ModelMapper modelMapper;
	
	
	@Inject
	public MappingServiceImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}


	@Override
	public <K, T> List<T> map(List<K> object, Class<T> clazz) {
		return object.stream()
					 .map(o-> this.modelMapper.map(o, clazz))
					 .collect(Collectors.toList());
	}

}
