package by.htp.ishop.entity;

import java.util.Date;

public class Delivery {

	private int id;
	private String typeDelivery;
	private Date date;

	public Delivery() {

	}

	public Delivery(int id, String typeDelivery, Date date) {

		this.id = id;
		this.typeDelivery = typeDelivery;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeDelivery() {
		return typeDelivery;
	}

	public void setTypeDelivery(String typeDelivery) {
		this.typeDelivery = typeDelivery;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((typeDelivery == null) ? 0 : typeDelivery.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (typeDelivery == null) {
			if (other.typeDelivery != null)
				return false;
		} else if (!typeDelivery.equals(other.typeDelivery))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", typeDelivery=" + typeDelivery + ", date=" + date + "]";
	}
	
}
