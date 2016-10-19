//
//  ball.m
//  objCIntro_template
//
//  Created by Shawn Arney on 8/16/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "ball.h"

@implementation ball

- (id)init
{
    self = [super init];
    if (self) {
        // Initialization code here.
        
        self.imageName = @"ball.png";
        
    }
    
    return self;
}

- (void) displayImageOnView:(UIView *)view
{
    self.x = 220;
    
    [super displayImageOnView:view];
}


@end
