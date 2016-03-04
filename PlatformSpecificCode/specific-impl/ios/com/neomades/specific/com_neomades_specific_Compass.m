#import "com_neomades_specific_Compass.h"
#import "com_neomades_specific_CompassListener.h"

@interface com_neomades_specific_Compass (private)

@end

@implementation com_neomades_specific_Compass (private)

@end


@implementation com_neomades_specific_Compass
@synthesize locationManager;

+ (void) initialize {
    
}

- (id) init_com_neomades_specific_Compass {
	if ((self = [super init_com_neomades_specific_AbstractGeneratedCompass])) {
	    locationManager=[[CLLocationManager alloc] init];
		locationManager.desiredAccuracy = kCLLocationAccuracyBest;
		locationManager.headingFilter = 1;
		locationManager.delegate=self;
		[locationManager startUpdatingHeading];
	}
    
	return self;
}

- (BOOL) isSupported {
	return YES;
}

- (void)locationManager:(CLLocationManager *)manager didUpdateHeading:(CLHeading *)newHeading {
    if(self->listener != [JavaNull null]) {
        [self->listener onDirectionChanged___com_neomades_specific_Compass___int:self param:manager.heading.trueHeading];
    }
}

@end