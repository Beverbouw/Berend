package org.beverbouw.berend;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;

public class IRCommandSensor extends Thread {

	private int control = 0;
	private int channel	= 0;
	private int	lastcommand = 0;
	private EV3IRSensor ir = null;
	private IRCommandListener irl = null;
	
	public IRCommandSensor() {

	}

	public IRCommandSensor(IRCommandListener irl,Port port, int channel) {
		
	    ir = new EV3IRSensor(port);
	    this.irl   = irl;
	    this.channel = channel;
	}

    public void run()
    {
        while (true)
        {
            control = ir.getRemoteCommand(channel);

            if(control != lastcommand && control != 0) {
            	IRCode irCode = IRCode.getCode(control);
           		irl.handleSensorCommand(irCode);
           		lastcommand = control;
            }	
		  
        }	
    }
        
}
