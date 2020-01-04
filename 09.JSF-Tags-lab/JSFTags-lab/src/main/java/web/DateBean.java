package web;

import java.util.Date;

import javax.inject.Named;

@Named("dateBean")
public class DateBean {

	private Date date;
	
	
	public DateBean() {
		this.setDate(new Date());
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	
}
