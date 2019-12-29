package app.service;

import java.util.List;

public interface MappingService {

	<K, T> List<T> map(List<K> object, Class<T> clazz);
}
