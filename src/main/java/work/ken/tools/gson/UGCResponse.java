package work.ken.tools.gson;

import java.util.Set;

/**
 * @author kchen
 * POJO Response
 */
public class UGCResponse {
	private String NextPageLink;

	private Set<Items> Items;

	public UGCResponse(String nextPageLink,
			Set<Items> items) {
		NextPageLink = nextPageLink;
		Items = items;
	}
	
	public UGCResponse(){}

	public String getNextPageLink() {
		return NextPageLink;
	}
	public void setNextPageLink(String nextPageLink) {
		NextPageLink = nextPageLink;
	}
	

	public Set<Items> getItems() {
		return Items;
	}
	
	public void setItems(Set<Items> items) {
		Items = items;
	}

	@Override
	public String toString() {
		return "IsobarResponse [NextPageLink=" + NextPageLink + ", Items="
				+ Items + "]";
	}

}
