package app.service;

import java.util.List;

import app.domain.model.service.TubeDetailsServiceModel;
import app.domain.model.service.TubesServiceModel;
import app.domain.model.service.UploadTubeServiceModel;

public interface TubeService {

	void saveTube(UploadTubeServiceModel uploadTubeServiceModel);
	List<TubesServiceModel> allTubes();
	TubeDetailsServiceModel findTubeByYouTubeId(String youTubeId);
}
