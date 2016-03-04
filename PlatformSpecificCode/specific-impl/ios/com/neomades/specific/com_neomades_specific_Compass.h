#import <GenericAPI/GenericAPI.h>
#import "com_neomades_specific_AbstractGeneratedCompass.h"
#import <CoreLocation/CoreLocation.h>

@protocol com_neomades_specific_CompassListener;

@interface com_neomades_specific_Compass : com_neomades_specific_AbstractGeneratedCompass <CLLocationManagerDelegate>

@property (nonatomic,retain) CLLocationManager *locationManager;

- (id) init_com_neomades_specific_Compass;
- (BOOL) isSupported;

@end