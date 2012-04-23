package de.vpe.simplebundle.impl;

import java.text.DateFormat;
import java.util.Date;
import de.vpe.firstservice.FirstService;

public class FirstServiceImpl implements FirstService {
	public String getFormattedDate(Date date) {
		return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
	}
}
