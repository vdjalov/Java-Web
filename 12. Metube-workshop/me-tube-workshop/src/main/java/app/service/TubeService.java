package app.service;

import java.util.List;

import app.domain.model.service.TubeDetailsServiceModel;
import app.domain.model.service.UploadTubeServiceModel;

public interface TubeService {

	void saveTube(UploadTubeServiceModel uploadTubeServiceModel);
	List<UploadTubeServiceModel> allTubes();
	TubeDetailsServiceModel findTubeByYouTubeId(String youTubeId);
}
