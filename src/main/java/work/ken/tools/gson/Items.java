package work.ken.tools.gson;

import java.util.List;

/**
 * @author kchen
 * POJO for the UGC Response
 */
public class Items {
	private String EntryId;
	private String ImageSourceUrl;
	private boolean IsFeatured;
	private boolean IsShortListed;
	private boolean IsWinner;
	private String ModerationStatus;
	private String DateAdded;
	private String DateTimeStamp;
	private String EntryReferenceId;
	private EntryDetails EntryDetails;
	private List<EntryImageSizes> EntryImageSizes;
	private List<EntrySortFieldValues> EntrySortFieldValues;
	public String getEntryId() {
		return EntryId;
	}
	public void setEntryId(String entryId) {
		EntryId = entryId;
	}
	public String getImageSourceUrl() {
		return ImageSourceUrl;
	}
	public void setImageSourceUrl(String imageSourceUrl) {
		ImageSourceUrl = imageSourceUrl;
	}
	public boolean isIsFeatured() {
		return IsFeatured;
	}
	public void setIsFeatured(boolean isFeatured) {
		IsFeatured = isFeatured;
	}
	public boolean isIsShortListed() {
		return IsShortListed;
	}
	public void setIsShortListed(boolean isShortListed) {
		IsShortListed = isShortListed;
	}
	public boolean isIsWinner() {
		return IsWinner;
	}
	public void setIsWinner(boolean isWinner) {
		IsWinner = isWinner;
	}
	public String getModerationStatus() {
		return ModerationStatus;
	}
	public void setModerationStatus(String moderationStatus) {
		ModerationStatus = moderationStatus;
	}
	public String getDateAdded() {
		return DateAdded;
	}
	public void setDateAdded(String dateAdded) {
		DateAdded = dateAdded;
	}
	public String getDateTimeStamp() {
		return DateTimeStamp;
	}
	public void setDateTimeStamp(String dateTimeStamp) {
		DateTimeStamp = dateTimeStamp;
	}
	public String getEntryReferenceId() {
		return EntryReferenceId;
	}
	public void setEntryReferenceId(String entryReferenceId) {
		EntryReferenceId = entryReferenceId;
	}
	public List<EntryImageSizes> getEntryImageSizes() {
		return EntryImageSizes;
	}
	public void setEntryImageSizes(List<EntryImageSizes> entryImageSizes) {
		EntryImageSizes = entryImageSizes;
	}
	public List<EntrySortFieldValues> getEntrySortFieldValues() {
		return EntrySortFieldValues;
	}
	public void setEntrySortFieldValues(
			List<EntrySortFieldValues> entrySortFieldValues) {
		EntrySortFieldValues = entrySortFieldValues;
	}
	public EntryDetails getEntryDetails() {
		return EntryDetails;
	}
	public void setEntryDetails(EntryDetails entryDetails) {
		EntryDetails = entryDetails;
	}
	@Override
	public String toString() {
		return "Items [EntryId=" + EntryId + ", ImageSourceUrl="
				+ ImageSourceUrl + ", IsFeatured=" + IsFeatured
				+ ", IsShortListed=" + IsShortListed + ", IsWinner=" + IsWinner
				+ ", ModerationStatus=" + ModerationStatus + ", DateAdded="
				+ DateAdded + ", DateTimeStamp=" + DateTimeStamp
				+ ", EntryReferenceId=" + EntryReferenceId + ", EntryDetails="
				+ EntryDetails + ", EntryImageSizes=" + EntryImageSizes
				+ ", EntrySortFieldValues=" + EntrySortFieldValues + "]";
	}

}
