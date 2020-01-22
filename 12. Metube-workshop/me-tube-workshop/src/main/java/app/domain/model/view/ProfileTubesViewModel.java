package app.domain.model.view;

public class ProfileTubesViewModel {

	private String views;
	private String title;
	private String author;
	private String youTubeId;
	
	
	public ProfileTubesViewModel() {
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getYouTubeId() {
		return youTubeId;
	}


	public void setYouTubeId(String youTubeId) {
		this.youTubeId = youTubeId;
	}


	public String getViews() {
		return views;
	}


	public void setViews(String views) {
		this.views = views;
	}

	
	
}
