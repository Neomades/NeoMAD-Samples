<?xml version="1.0"?>
<urs xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:noNamespaceSchemaLocation="http://www.neomades.com/XSD/3.9.5/urs.xsd">
	<parameters>
		<mainclassname>XmlPullParserApplication</mainclassname>
		<applicationname>XmlPullParserExample</applicationname>
		<description>XmlPullParserExample application example.</description>
		<packagename>com.neomades.xmlpullparserexample</packagename>

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

	<strings path="res/strings.csv" />

	<resourcelot>
		<layout name="MAIN_SCREEN" path="/res/layout/main_screen.xml" />
		<layout name="READING_SCREEN" path="/res/layout/reading_screen.xml" />
		<layout name="DISCUSSION_SCREEN" path="/res/layout/discussion_screen.xml" />
		<layout name="DISCUSSION_ITEM" path="/res/layout/discussion_item.xml" />
		<rawdata name="XML_FILE" path="/res/xml/parse.xml" />
	</resourcelot>
</urs>
