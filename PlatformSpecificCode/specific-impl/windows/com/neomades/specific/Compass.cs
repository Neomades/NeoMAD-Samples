using Windows.Devices.Sensors;

namespace com.neomades.specific {

	public class Compass : AbstractGeneratedCompass {

        private Windows.Devices.Sensors.Compass compass;
		
		public Compass()
		{
            compass = Windows.Devices.Sensors.Compass.GetDefault();
			if (compass != null)
			{
                compass.ReadingChanged += compass_ReadingChanged;
			}
		}

        void compass_ReadingChanged(Windows.Devices.Sensors.Compass sender, CompassReadingChangedEventArgs args)
        {
            if (listener != null)
            {
                CompassReading reading = args.Reading;
                if (reading.HeadingTrueNorth.HasValue)
                {
                    listener.onDirectionChanged(this, (int) reading.HeadingTrueNorth.Value);
                }
            }
        }
		
		public override bool isSupported()
		{
			return compass != null;
		}
	}
}