package app.domain.model.view;

import app.domain.entity.User;

public class TubesViewModel {
	
	private String title;
	private String youTubeId;
	private User uploader;
	
	public TubesViewModel() {
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
