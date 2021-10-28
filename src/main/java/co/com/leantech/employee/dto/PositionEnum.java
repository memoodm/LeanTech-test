package co.com.leantech.employee.dto;

public enum PositionEnum {
	EMPTY(""),
	DEVELOPER("DEVELOPER"),
	TESTER("TESTER"),
	MANAGER("MANAGER"),
	INFRAESTRUCTURE("INFRAESTRUCTURE"),
	DEVOPS("DEVOPS"),
	REQUIREMENTS("REQUIREMENTS");
	
	public String value;
	
	PositionEnum(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static PositionEnum internalValue(String value) {
		for(PositionEnum e: values()) {
			if(e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}
}