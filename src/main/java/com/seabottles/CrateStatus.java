package com.seabottles;

enum CrateStatus
{
	YES("Yes"),
	NO("No"),
	MAYBE("Maybe");

	final String label;

	CrateStatus(String label)
	{
		this.label = label;
	}
}
