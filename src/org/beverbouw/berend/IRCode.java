package org.beverbouw.berend;

public enum IRCode {

	ZERO (0),
    TOP_LEFT (1),
    BOTTOM_LEFT(2),
    TOP_RIGHT (3),
    BOTTOM_RIGHT (4),
    TOP_LEFT_TOP_RIGHT (5),
    TOP_LEFT_BOTTOM_RIGHT (6),
    BOTTOM_LEFT_TOP_RIGHT (7),
    BOTTOM_LEFT_BOTTOM_RIGHT (8),
    CENTRE_BEACON (9),
    BOTTOM_LEFT_TOP_LEFT (10),
    TOP_RIGHT_BOTTOM_RIGHT (11);
	
    private final int irCode;
    
    private IRCode(int irCode){
    	this.irCode = irCode;
    }
   
    public static IRCode getCode(int control){
        
    	IRCode code = null;
    	
    	switch (control) {
        case 0:{
        	code = IRCode.ZERO;
        	break;
	    }
	    case 1:{
        	code = IRCode.TOP_LEFT;
	    	break;
	    }
	    case 2: {
        	code = IRCode.BOTTOM_LEFT;
		    break;
	    }
	    case 3:{
        	code = IRCode.TOP_RIGHT;
            break;
	    }
	    case 4:{
        	code = IRCode.BOTTOM_RIGHT;
            break;
	    }
	    case 5:{
        	code = IRCode.TOP_LEFT_TOP_RIGHT;
            break;
	    }
	    case 6:{
        	code = IRCode.TOP_LEFT_BOTTOM_RIGHT;
            break;
	    }
	    case 7:{
        	code = IRCode.BOTTOM_LEFT_TOP_RIGHT;
            break;
	    }
	    case 8:{
        	code = IRCode.BOTTOM_LEFT_BOTTOM_RIGHT;
            break;
	    }
	    case 9: {
        	code = IRCode.CENTRE_BEACON;
            break;
	    }
	    case 10 : { 
        	code = IRCode.BOTTOM_LEFT_TOP_LEFT;
            break;
	    }
	    case 11 : {
        	code = IRCode.TOP_RIGHT_BOTTOM_RIGHT;
            break;
	    }
	    default:
        	code = IRCode.ZERO;
	        break;
	    }
    	
    	return code;
    }
}
