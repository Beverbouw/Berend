package org.beverbouw.berend;

import lejos.hardware.port.SensorPort;

public class Berend implements IRCommandListener {

	public Berend() {
	
		IRCommandSensor sr = new IRCommandSensor(this,SensorPort.S4,0);
		sr.setDaemon(true);
		sr.start();
		while(true){
			Thread.yield();
		}
	
	}

	public static void main(String[] args) {
		new Berend();
	}

	@Override
	public void handleSensorCommand(IRCode code) {

		switch(code){
		case ZERO :{
			break;
		}
		case TOP_LEFT :{
			System.out.println(IRCode.TOP_LEFT.toString());
			break;
		}
		case BOTTOM_LEFT :{
			System.out.println(IRCode.BOTTOM_LEFT.toString());
			break;
		}
		case TOP_RIGHT :{
			System.out.println(IRCode.TOP_RIGHT.toString());
			break;
		}
		case BOTTOM_RIGHT :{
			System.out.println(IRCode.BOTTOM_RIGHT.toString());
			break;
		}
		case TOP_LEFT_TOP_RIGHT :{
			System.out.println(IRCode.TOP_LEFT_TOP_RIGHT.toString());
			break;
		}
		case TOP_LEFT_BOTTOM_RIGHT :{
			break;
		}
		case BOTTOM_LEFT_TOP_RIGHT :{
			break;
		}
		case BOTTOM_LEFT_BOTTOM_RIGHT :{
			break;
		}
		case CENTRE_BEACON :{
			System.out.println(IRCode.CENTRE_BEACON.toString());
			System.exit(0);
			break;
		}
		case BOTTOM_LEFT_TOP_LEFT :{
			break;
		}
		case TOP_RIGHT_BOTTOM_RIGHT :{
			break;
		}
		}
	}

}
