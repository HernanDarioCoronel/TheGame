package Main;

public enum SpeedEnum {
	VerySlow(1.0f), Slow(2.0f), Normal(3.0f), Fast(4.0f), VeryFast(5.0f);

	private float value;

	private SpeedEnum(float value) {
		this.setValue(value);
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
