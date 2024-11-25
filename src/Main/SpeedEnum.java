package Main;

public enum SpeedEnum {
	VerySlow(1), Slow(2), Normal(3), Fast(4), VeryFast(5);

	private int value;

	private SpeedEnum(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
