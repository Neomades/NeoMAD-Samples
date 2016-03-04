<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>NotificationExample</mainclassname>
		<applicationname>NotificationExample</applicationname>
		<packagename>com.neomades.notificationexample</packagename>
		<description>Notification application example.</description>

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


	<!-- PushService tag should be declared for all platforms -->
	<pushservice androidGCMProjectId="Your Google Console key here" />

	<permissions>
		<!-- Local Notification permission should be declared in order to be used in Application -->
		<permission name="LOCAL_NOTIFICATION" />
	</permissions>

	<strings path="res/strings.csv" />

	<!-- notification icons -->
	<resourcelot>
		<image name="NOTIF_ICON" path="res/notification_icons/icon.png" />
		<image name="LAUNCH_IMG" path="res/notification_icons/launch_image.png" />
		<image name="ACCESSORY_ICON" path="res/notification_icons/accessory_icon.png" />
	</resourcelot>

	<!-- sounds -->
	<resourcelot>
		<music name="SOUND_NOTIF" path="res/sounds/notif.mp3" />
		<music name="SOUND_NOTIF_IOS" path="res/sounds/notif.caf" />
	</resourcelot>

	<!-- layouts -->
	<resourcelot>
		<layout name="LOCAL_NOTIFICATION_SCREEN" path="res/layouts/local_notification_screen.xml" />
		<layout name="NOT_SUPPORTED_LAYOUT" path="res/layouts/not_supported_layout.xml" />
		<layout name="LOCAL_NOTIFICATION_DETAILS_SCREEN" path="res/layouts/local_notification_details_screen.xml" />

		<layout name="PUSH_NOTIFICATION_SCREEN" path="res/layouts/push_notification_screen.xml" />
		<layout name="PUSH_MESSAGE_DETAILS_SCREEN" path="res/layouts/push_message_details_screen.xml" />
	</resourcelot>
</urs>
