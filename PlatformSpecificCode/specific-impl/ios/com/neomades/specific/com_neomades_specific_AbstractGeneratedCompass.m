#import "com_neomades_specific_AbstractGeneratedCompass.h"
#import "com_neomades_specific_Compass.h"
#import "com_neomades_specific_CompassListener.h"

@interface com_neomades_specific_AbstractGeneratedCompass (private)

- (void) com_neomades_specific_AbstractGeneratedCompass_initFields;

@end

@implementation com_neomades_specific_AbstractGeneratedCompass (private)

- (void) com_neomades_specific_AbstractGeneratedCompass_initFields {
	self->listener = [JavaNull null];
}

@end

@implementation com_neomades_specific_AbstractGeneratedCompass

+ (void) initialize {
}

- (id) init_com_neomades_specific_AbstractGeneratedCompass {
	[self com_neomades_specific_AbstractGeneratedCompass_initFields];
	if ((self = [super init_java_lang_Object])) {
	}
	return self;
}

- (BOOL) isSupported {
	return FALSE;
}

- (void) setCompassListener___com_neomades_specific_CompassListener:(java_lang_Object<com_neomades_specific_CompassListener> *)listener {
	((com_neomades_specific_Compass *)[BridgeTools isNull:self])->listener = listener;
}

@end