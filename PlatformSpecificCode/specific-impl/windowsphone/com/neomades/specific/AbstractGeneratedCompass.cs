using com.neomades.win.ext;

namespace com.neomades.specific
{
	public abstract class AbstractGeneratedCompass : java.lang.Object
	{

		public com.neomades.specific.CompassListener listener;

		public virtual bool isSupported()
		{
			return false;
		}

		public virtual void setCompassListener(com.neomades.specific.CompassListener listener)
		{
			this.listener = listener;
		}

	}
}