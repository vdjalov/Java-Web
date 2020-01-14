package casebook.domain.models.view;

public class FriendViewModel {

	private Integer id;
	private String username;
	private String gender;
	
	
	public FriendViewModel() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
