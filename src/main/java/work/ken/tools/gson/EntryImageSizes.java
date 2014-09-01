package work.ken.tools.gson;

/**
 * @author kchen
 * POJO for the UGC Response
 */
public class EntryImageSizes {
	private String Url;
	private String ImageSizeDefinitionName;
	private String Width;
	private String Height;
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getImageSizeDefinitionName() {
		return ImageSizeDefinitionName;
	}
	public void setImageSizeDefinitionName(String imageSizeDefinitionName) {
		ImageSizeDefinitionName = imageSizeDefinitionName;
	}
	public String getWidth() {
		return Width;
	}
	public void setWidth(String width) {
		Width = width;
	}
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	@Override
	public String toString() {
		return "EntryImageSizes [Url=" + Url + ", ImageSizeDefinitionName="
				+ ImageSizeDefinitionName + ", Width=" + Width + ", Height="
				+ Height + "]";
	}
}
