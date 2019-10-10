package com.mock.ws.rest.bso.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mock.ws.rest.bso.validators.ValidationResult;

public enum Status {
	
	NEW (1, "Not used"),
	//2("Not used"),
	//3("Not used"),
	USED (4, "Used"),
	RETURNED (5, "Returned");

    private static final Map<Integer, Status> lookup = new TreeMap<Integer, Status>();
    
	private final int code;
	private final String description;
	
	private Status(int code, String description) {
		this.code = code;
		this.description = description;
	}

	static {
        for (Status el : Status.values()) {
            lookup.put(el.getCode(), el);
        }
    }
	
	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Status getByCode(int code) {
	    return lookup.get(code);
	}

	public static Status findByDescription(final String description){
	    return Arrays.stream(values()).filter(el -> el.description.equals(description)).findFirst().get();
	}
	
    public ValidationResult checkIfValid(Status bsoStatus) {
      //In case of check request
        if(bsoStatus == null) {
            List<Status> toUse = new ArrayList<Status>(Arrays.asList(NEW, RETURNED));
            if(!toUse.contains(this)) {
                return ValidationResult.fail("BSO already in use");
            }
        }
        
      //In case set status to USED
        if(bsoStatus == USED) {
            List<Status> toUse = new ArrayList<Status>(Arrays.asList(NEW, RETURNED));
            if(!toUse.contains(this)) {
                return ValidationResult.fail("BSO already in use");
            }
        }
        
        //In case set status to RETURN
        if(bsoStatus == RETURNED) {
            if(!this.equals(USED)) {
                return ValidationResult.fail("BSO in wrong state: " + this.description);
            }
        }
        
        return ValidationResult.ok();
    }
}
