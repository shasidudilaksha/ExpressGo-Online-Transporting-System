package com.transport.model;

public class Driver {
    private int driverId;
    private String name;
    private String licenseNumber;
    private String contact;
    private String nic;

    // Getters and Setters
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getNic() {
	    return nic;
	}

	public void setNic(String nic) {
	    this.nic = nic;
	}
    
    
}
