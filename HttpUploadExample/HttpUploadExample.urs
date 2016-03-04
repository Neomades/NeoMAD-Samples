<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>HttpUploadApplication</mainclassname>
		<applicationname>HttpUploadExample</applicationname>
		<description>HttpUploadExample application example.</description>
		<packagename>com.neomades.httpuploadexample</packagename>

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
		<permission name="INTERNET" />
	</permissions>

	<strings path="res/strings.csv" />

	<jarfiles>
		<file diskpath="res/files/logo_neomades_48x48.png" jarpath="/" />
		<file diskpath="res/files/logo_neomades_68x68.png" jarpath="/" />
	</jarfiles>

	<resourcelot>
		<layout name="MAIN_SCREEN" path="res/layout/main_screen.xml" />
	</resourcelot>
</urs>
