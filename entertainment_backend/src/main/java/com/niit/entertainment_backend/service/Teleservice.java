/*package com.niit.entertainment_backend.service;

import java.util.List;

import com.niit.entertainment_backend.dao.*;
import com.niit.entertainment_backend.impl.*;
import com.niit.entertainment_backend.model.*;

public class Teleservice {
	 private static Teledaoimpl teledaoimpl;

	    public Teleservice() {
	    	teledaoimpl = new Teledaoimpl();
	    }

	    public void persist(Telemodel tv1) {
	    	teledaoimpl.openCurrentSessionwithTransaction();
	    	teledaoimpl.persist(tv1);
	        teledaoimpl.closeCurrentSessionwithTransaction();
	    }

	    public void update(Telemodel entity) {
	    	teledaoimpl.openCurrentSessionwithTransaction();
	    	teledaoimpl.update(entity);
	    	teledaoimpl.closeCurrentSessionwithTransaction();
	    }

	    public Telemodel findById(int pid) {
	    	teledaoimpl.openCurrentSession();
	    	Telemodel Telemodel = teledaoimpl.findById(pid);
	    	teledaoimpl.closeCurrentSession();
	        return Telemodel;
	    }

	    public void delete(int pid) {
	    	teledaoimpl.openCurrentSessionwithTransaction();
	    	Telemodel Telemodel = teledaoimpl.findById(pid);
	    	teledaoimpl.delete(Telemodel);
	    	teledaoimpl.closeCurrentSessionwithTransaction();
	    }

	    public List<Telemodel> findAll() {
	    	teledaoimpl.openCurrentSession();
	        List<Telemodel> Telemodel = teledaoimpl.findAll();
	        teledaoimpl.closeCurrentSession();
	        return Telemodel;
	    }

	    public void deleteAll() {
	    	teledaoimpl.openCurrentSessionwithTransaction();
	    	teledaoimpl.deleteAll();
	    	teledaoimpl.closeCurrentSessionwithTransaction();
	    }

	
	}


*/