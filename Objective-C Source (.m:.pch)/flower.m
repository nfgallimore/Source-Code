//
//  flower.m
//  objCIntro_template
//
//  Created by Shawn Arney on 8/16/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "flower.h"

@implementation flower

- (id)init
{
    self = [super init];
    if (self) {
        // Initialization code here.
        self.imageName = @"flower.png";
    }
    
    return self;
}


- (void) displayImageOnView:(UIView *)view
{
    self.x = 78;
    
    y = 300;
    
    [super displayImageOnView:view];
}

@end
