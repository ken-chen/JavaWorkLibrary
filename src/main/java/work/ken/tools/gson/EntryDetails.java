package work.ken.tools.gson;

/**
 * @author kchen
 * POJO for the UGC Response
 */
public class EntryDetails {
	private String Title;
	private String FirstName;
	private String LastName;
	private String City;
	private String Email;
	private String Decade;
	private String StoryHeading;
	private String Story;
	private String YouTubeKey;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDecade() {
		return Decade;
	}
	public void setDecade(String decade) {
		Decade = decade;
	}
	public String getStoryHeading() {
		return StoryHeading;
	}
	public void setStoryHeading(String storyHeading) {
		StoryHeading = storyHeading;
	}
	public String getStory() {
		return Story;
	}
	public void setStory(String story) {
		Story = story;
	}
	public String getYouTubeKey() {
		return YouTubeKey;
	}
	public void setYouTubeKey(String youTubeKey) {
		YouTubeKey = youTubeKey;
	}
	@Override
	public String toString() {
		return "EntryDetails [Title=" + Title + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", City=" + City + ", Email="
				+ Email + ", Decade=" + Decade + ", StoryHeading="
				+ StoryHeading + ", Story=" + Story + ", YouTubeKey="
				+ YouTubeKey + "]";
	}

}
