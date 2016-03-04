#import <GenericAPI/GenericAPI.h>
@protocol com_neomades_specific_CompassListener;
@class com_neomades_specific_Compass;

@interface com_neomades_specific_AbstractGeneratedCompass : java_lang_Object {

	@public
	java_lang_Object<com_neomades_specific_CompassListener> *listener;

}

- (id) init_com_neomades_specific_AbstractGeneratedCompass;
- (BOOL) isSupported;
- (void) setCompassListener___com_neomades_specific_CompassListener:(java_lang_Object<com_neomades_specific_CompassListener> *)listener;

@end