using System;
using Microsoft.Devices.Sensors;

namespace com.neomades.specific {

	public class Compass : AbstractGeneratedCompass {
		Microsoft.Devices.Sensors.Compass compass;
		private bool supported = true;
		
		public Compass()
		{
			// here we check in a try catch if the compass access throws an exception
			// because on the emulator the compass is not supported 
			try {
				compass = new Microsoft.Devices.Sensors.Compass();
				compass.CurrentValueChanged += new EventHandler<SensorReadingEventArgs<CompassReading>>(compass_CurrentValueChanged);
				compass.Start();
			}
			catch(Exception)
			{
				supported = false;
			}
		}
		
		void compass_CurrentValueChanged(object sender, SensorReadingEventArgs<CompassReading> e)
		{
			if (this.listener != null)
			{
				listener.onDirectionChanged(this, (int) compass.CurrentValue.TrueHeading);
			}
		}
		
		public override bool isSupported()
		{
			return supported;
		}
	}
}