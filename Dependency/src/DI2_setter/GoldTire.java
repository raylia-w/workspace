package DI2_setter;

public class GoldTire implements Tire {

	@Override
	public String getTire() {
		return "gold";
	}

	@Override
	public String getProduct() {
		return getTire();
	}

}
