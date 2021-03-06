<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>ServiceExample</mainclassname>
		<applicationname>ServiceExample</applicationname>
		<description>Service application example.</description>
		<packagename>com.neomades.serviceexample</packagename>

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

	<!-- Subclasses of Service must be declared here in order to be seen by the system -->
	<service name="com.neomades.serviceexample.backgroundservices.ServiceImmediate" />
	<service name="com.neomades.serviceexample.backgroundservices.ServiceEveryMinute" />
	<service name="com.neomades.serviceexample.backgroundservices.ServiceEvery30Minutes" />

	<strings path="res/strings.csv" />

	<resourcelot>
		<layout name="SERVICE_SCREEN" path="res/layout/service_screen.xml" />
		<layout name="NOT_SUPPORTED_LAYOUT" path="res/layout/not_supported_layout.xml" />
	</resourcelot>

	<permissions>
		<!-- Local Notification permission should be declared in order to be used in Application -->
		<permission name="LOCAL_NOTIFICATION" />
		<!-- Vibration permission should be declared in order to be used with the local notification -->
		<permission name="VIBRATE" />
	</permissions>

	<!-- notification icons -->
	<resourcelot>
		<image name="NOTIF_ICON" path="res/notification_icons/icon.png" />
		<image name="LAUNCH_IMG" path="res/notification_icons/launch_image.png" />
		<image name="ACCESSORY_ICON" path="res/notification_icons/accessory_icon.png" />
	</resourcelot>

	<!-- sounds -->
	<resourcelot>
		<music name="SOUND_NOTIF" path="res/sounds/notif.${SOUND_FORMAT}" />
	</resourcelot>
</urs>
