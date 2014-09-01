package work.ken.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortingBetweenTwoCollection {
	public List<Offer> getOrderedOffersObject(Set<Offer> allOffers, Set<Long> offerIds) {
		//the ordered offer list
		List<Offer> orderedList = new ArrayList<Offer>();
		List<Offer> unOrderedList = new ArrayList<Offer>();
		List<Offer> list = new ArrayList<Offer>();
		Map<Long,Offer> orderedOfferMap = new HashMap<Long,Offer>();
		
		//divide the offers
		for (Offer offer : allOffers) {
			if(offerIds.contains(Long.valueOf(offer.getId()))){
				orderedOfferMap.put(Long.valueOf(offer.getId()), offer);		
			}else{
				unOrderedList.add(offer);
			}	
		}
		
		//set the offers in the list
		for(Long offerId: offerIds){	
			if(orderedOfferMap.get(offerId) !=null){
				orderedList.add(orderedOfferMap.get(offerId));
			}
		}
		
		//set the offer sort order
		for(int i=0; i < orderedList.size();i++){
			orderedList.get(i).setOfferSortOrder(i+1);
		}
		
		list.addAll(orderedList);
		list.addAll(unOrderedList);
		
		return list;
	}
}
