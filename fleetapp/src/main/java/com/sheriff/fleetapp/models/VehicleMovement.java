package com.sheriff.fleetapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleMovement {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne
	@JoinColumn(name="vehicleid", insertable=false, updatable=false)
	private Vehicle vehicle;
	private int vehicleid;

	@ManyToOne
	@JoinColumn(name="departedFromId", insertable=false, updatable=false)
	private Location departedFrom;
	private int departedFromId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date departureDate;

	@ManyToOne
	@JoinColumn(name="arrivalAtId", insertable=false, updatable=false)
	private Location arrivalAt;
	private int arrivalAtId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;

	private String remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public Location getDepartedFrom() {
		return departedFrom;
	}

	public void setDepartedFrom(Location departedFrom) {
		this.departedFrom = departedFrom;
	}

	public int getDepartedFromId() {
		return departedFromId;
	}

	public void setDepartedFromId(int departedFromId) {
		this.departedFromId = departedFromId;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Location getArrivalAt() {
		return arrivalAt;
	}

	public void setArrivalAt(Location arrivalAt) {
		this.arrivalAt = arrivalAt;
	}

	public int getArrivalAtId() {
		return arrivalAtId;
	}

	public void setArrivalAtId(int arrivalAtId) {
		this.arrivalAtId = arrivalAtId;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
