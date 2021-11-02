package com.sing.selfEditor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class AddressPropertyEditor extends PropertiesEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] s = text.split("_");
		Address address = new Address();
		address.setProvince(s[0]);
		address.setCity(s[1]);
		address.setTown(s[2]);
		this.setValue(address);
	}
}
