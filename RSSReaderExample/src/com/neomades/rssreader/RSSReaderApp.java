package com.neomades.rssreader;

import com.neomades.app.Application;
import com.neomades.app.Controller;
import com.neomades.content.ContentManager;
import com.neomades.content.cache.FileCache;
import com.neomades.content.network.HttpNetwork;
import com.neomades.io.file.File;
import com.neomades.io.file.FileStorage;
import com.neomades.mad.TargetInfo;
import com.neomades.rssreader.screens.RSSMainScreen;
import com.neomades.rssreader.services.FeedParser;

/**
 * Application Entry Point
 */
public class RSSReaderApp extends Application {
	
	/**
	 * @return
	 */
	private static File getAppCacheDir() {
		File cacheDir = null;
		if (TargetInfo.WINDOWS_PHONE) {
			// no cache dir on windows phone
			cacheDir = FileStorage.getPrivateDir();
		}
		else {
			cacheDir = FileStorage.getCacheDir();
		}
		return cacheDir;
	}

	/* */
	private ContentManager manager;

	protected void onCreate(Controller controller) {
		// Set up the ContentManager
		// Cache : a FileCache
		// Network : Http
		// Parsers : RSS Parser - XML
		manager = new ContentManager();
		manager.putCache(RSSConstants.RSS_CACHE, new FileCache(new File(getAppCacheDir(), RSSConstants.ROOT_CACHE)));
		manager.putNetwork(RSSConstants.HTTP, new HttpNetwork());
		manager.putParser(RSSConstants.FEED_PARSER, new FeedParser());
		
		// Starting an eventBus between Screen and ContentManager
		setEventBusEnabled(true);
		
		// Register a ContentManager to this application
		registerContentManager(manager);
	}

	protected void onStart(Controller controller) {
		// Enable actionBar on android
		// and lock the application to be in Portrait mode
		setActionBarEnabled(true);

		controller.pushScreen(RSSMainScreen.class);
	}

	protected boolean onBeforeExit(Controller controller) {
		// Stop and unregister the ContentManager
		manager.stop();
		unregisterContentManager(manager);

		return super.onBeforeExit(controller);
	}

}
