package app.domain.model.service;

import app.domain.entity.User;

public class TubesServiceModel {

	private String title;
	private String youTubeId;
	private User uploader;
	
	public TubesServiceModel() {
	}

	public String getYouTubeId() {
		return youTubeId;
	}

	public void setYouTubeId(String youTubeId) {
		this.youTubeId = youTubeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUploader() {
		return uploader;
	}

	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
	
}
