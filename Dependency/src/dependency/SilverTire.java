package dependency;

public class SilverTire implements Tire{

	@Override
	public String getTire() {
		return "silver";
	}

	@Override
	public String getProduct() {
		return getTire();
	}

}
