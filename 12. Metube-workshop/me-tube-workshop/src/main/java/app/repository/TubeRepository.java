package app.repository;

import java.util.List;

import app.domain.entity.Tube;
import app.domain.model.service.TubeDetailsServiceModel;

public interface TubeRepository {

	void save(Tube tube);
	List<Tube> findAllTubes();
	Tube findByYouTubeId(String youTubeId);
}
