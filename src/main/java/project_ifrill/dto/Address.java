package project_ifrill.dto;

public class Address {
	private String zipNum;
	private String sido;
	private String gugun;
	private String dong;
	private String zipCode;
	private String bunji;

	public Address() {
	}

	public Address(String zipNum, String sido, String gugun, String dong, String zipCode, String bunji) {
		this.zipNum = zipNum;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.zipCode = zipCode;
		this.bunji = bunji;
	}

	public String getZipNum() {
		return zipNum;
	}

	public void setZipNum(String zipNum) {
		this.zipNum = zipNum;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}

	@Override
	public String toString() {
		return String.format("Address [zipNum=%s, sido=%s, gugun=%s, dong=%s, zipCode=%s, bunji=%s]", zipNum, sido,
				gugun, dong, zipCode, bunji);
	}

}
