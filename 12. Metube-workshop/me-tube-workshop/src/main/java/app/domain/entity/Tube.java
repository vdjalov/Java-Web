package app.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tubes")
public class Tube extends BaseEntity {

	@Column(name = "title", columnDefinition = "varchar(100) not null unique")
	private String title;
	
	@Column(name = "author", columnDefinition = "varchar(100) not null")
	private String author;
	
	@Column(name = "description", columnDefinition = "varchar(100000) not null")
	private String description;
	
	@Column(name = "you_tube_id", columnDefinition = "varchar(100) not null")
	private String youTubeId;
	
	@Column(name = "views", columnDefinition = "int default 0")
	private Integer views;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User uploader;
	
	
	
	public Tube() {
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getViews() {
		return views;
	}



	public void setViews(Integer views) {
		this.views = views;
	}



	public User getUploader() {
		return uploader;
	}



	public void setUploader(User uploader) {
		this.uploader = uploader;
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
	
	
	
	
	
	
}
