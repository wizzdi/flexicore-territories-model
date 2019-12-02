package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class Zip extends Baseclass {

	static private Zip s_Singleton = new Zip();
	static public Zip s() { return s_Singleton; }

	public Zip() {
	}

	public Zip(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}
}