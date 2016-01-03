package org.beverbouw.berend;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class TestIR {

    static RegulatedMotor leftMotor  = new EV3LargeRegulatedMotor(MotorPort.A);
    static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.D);
    
	public TestIR() {
	}

	public static void main(String[] args) {

        leftMotor.resetTachoCount();
        rightMotor.resetTachoCount();
        leftMotor.rotateTo(0);
        rightMotor.rotateTo(0);
        leftMotor.setSpeed(400);
        rightMotor.setSpeed(400);
        leftMotor.setAcceleration(800);
        rightMotor.setAcceleration(800);

		
		Brick brick = BrickFinder.getDefault();
		Port s4 = brick.getPort("S4");
		EV3IRSensor ir = null;
		
		try {
			ir = new EV3IRSensor(s4);
		
		  System.out.println("Ir : getModeCount" + ir.getModeCount());
		  for (String mode : ir.getAvailableModes()){
			  System.out.println("Ir mode :" + mode);
		  }
		
		  while (!Button.ESCAPE.isDown()) {
	    	//Sound.twoBeeps();
		    int control = ir.getRemoteCommand(0);

			switch (control) {
		    case 0:
			  Delay.msDelay(1000);
			  break;
		    case 1:{
		    	//Sound.twoBeeps();
				System.out.println("Ir control :" + control);
                //leftMotor.stop();;
                //rightMotor.forward();
				break;
		    }
		    case 2: {
		    	//Sound.twoBeeps();
				System.out.println("Ir control :" + control);
                //leftMotor.forward();
                //rightMotor.stop();;
			    break;
		    }
		    case 3:{
		    	//Sound.twoBeeps();
				System.out.println("Ir control :" + control);
                //leftMotor.forward();
                //rightMotor.forward();
                break;
		    }
		    case 4:{
		    	//Sound.twoBeeps();
				System.out.println("Ir control :" + control);
		    	//leftMotor.stop();;
		    	//rightMotor.stop();;
                break;
		    }
		    case 9:
		    	Sound.twoBeeps();
		    	Sound.twoBeeps();
				System.out.println("Ir control :" + control);
				System.exit(0);
				ir.close();
				leftMotor.close();
				rightMotor.close();
		      break;
		    case 10 : 
		      break;
		    case 11 : 
		      break;
		    default:
		        break;
		    }

		  }	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
