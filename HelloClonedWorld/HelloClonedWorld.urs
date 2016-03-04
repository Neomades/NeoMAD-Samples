<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>HelloWorld</mainclassname>
		<applicationname>${APP_NAME}</applicationname>
		<description>HelloClonedWord application example.</description>
		<packagename>com.neomades.helloworld</packagename>
		<applicationidentifier>com.neomades.${APP_ID}</applicationidentifier>

		<!-- Icon images are organized in platform directories in the res folder.
			See the Constants class for the declaration of the ICON_PATH constant. -->
		<icon path="${ICON_PATH}">
			<windowsphone tilebackgroundpath="res/icon-windowsphone/${ICON_NAME}-173.png" />
		</icon>

		<vendor>Neomades</vendor>
		<version>1.0.0</version>
		<srcpath>src</srcpath>
		<outputpath>out</outputpath>
	</parameters>
	
	<binaryname filename="${BINARY_NAME}" />
	
	<strings path="res/strings.csv" />
</urs>
