<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>CameraExample</mainclassname>
		<applicationname>Camera Example</applicationname>
		<packagename>com.neomades.cameraexample</packagename>
		<description>Simple application demonstrating the use of the Camera class.</description>

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
		<permission name="CAMERA" />
	</permissions>

	<resourcelot>
		<layout name="MAINSCREEN" path="/res/layout/mainscreen.xml" />
	</resourcelot>

	<strings path="res/strings.csv" />
</urs>
