package work.ken.tools;

public class Offer {
	private int id;
	private int offerSortOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOfferSortOrder() {
		return offerSortOrder;
	}

	public void setOfferSortOrder(int offerSortOrder) {
		this.offerSortOrder = offerSortOrder;
	}


    public static void main(String []args){
        int product = 1;
        for (int i = 10; i < 99; i++) {
            product *= i;
        }
        System.out.println(product);
        
        Integer a = null;
        Integer b = null;
        System.out.println(a>b);
    }
}
