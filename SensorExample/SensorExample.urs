<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>SensorApplication</mainclassname>
		<applicationname>SensorExample</applicationname>
		<description>SensorExample application example.</description>
		<packagename>com.neomades.example.sensor</packagename>

		<!-- Icon images are organized in platform directories in the res folder.
			See the Constants class for the declaration of the ICON_PATH constant. -->
		<icon path="@icon/icon">
			<windowsphone tilebackgroundpath="res/icon-windowsphone/icon-173.png" />
		</icon>

		<vendor>Neomades</vendor>
		<version>1.0.0</version>
		<srcpath>src</srcpath>
		<outputpath>out</outputpath>
	</parameters>

	<permissions>
		<permission name="SENSORS" />
	</permissions>

	<strings path="res/strings.csv" />

	<resourcelot>
		<layout name="MENU_SCREEN" path="/res/layout/menu_screen.xml" />
		<layout name="SENSOR_EXAMPLE_SCREEN" path="/res/layout/sensor_example_screen.xml" />
		<layout name="NO_SENSOR" path="/res/layout/no_sensor.xml" />
	</resourcelot>
</urs>
