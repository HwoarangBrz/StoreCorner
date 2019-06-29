package br.com.runner.storecorner.domain.enums;

public enum ClientType {
	
	PHYSICALPERSON(1, "Pessoa Física"),
	LEGALPERSON(2, "Pessoa Jurídica");
	
	private int cod;
	private String description;
	
	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription () {
		return description;
	}
	
	public static ClientType toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (ClientType x : ClientType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
