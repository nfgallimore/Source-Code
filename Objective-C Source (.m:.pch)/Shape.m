//
//  Shape.m
//  objCIntro_template
//
//  Created by Shawn Arney on 8/16/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "Shape.h"

@implementation Shape

@synthesize imageName;
@synthesize x;
@synthesize delegateShapeDisplay;

//-(NSString *) imageName; // getter
//-(void)setImageName: (NSString *) value; // setter

- (void) dealloc
{
    self.imageName = nil;
    [imageName release]; imageName = nil;
    
    [super dealloc];
}

- (id)init
{
    self = [super init];
    if (self) {
        // Initialization code here.
        self.imageName = @"";
        y = 200;
    }
    
    return self;
}

- (void) displayImageOnView 
: (UIView *) view
{
    UIImageView* imgView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:self.imageName]];
    
    imgView.frame = CGRectMake(self.x, -50, imgView.frame.size.width, imgView.frame.size.height);
    
    [view addSubview:imgView];
    
    [UIView beginAnimations:nil context:imgView];
    
    [UIView setAnimationDuration:12]; // image speed
    
    imgView.frame = CGRectMake(self.x * 1.6, 500.0, 0, 0); // move and shrink image
    
    [UIView setAnimationDidStopSelector:@selector(displayImageComplete:finished:context:)]; // cleanup
    [UIView setAnimationDelegate:self];
    [UIView commitAnimations];
    
    [imgView release]; // release from memory
}

- (void)displayImageComplete :(NSString *)animationID 

    finished:(NSNumber *)finished 
    context:(void *)context 

{    

    UIImageView *imgView = context;
    
    /// message sender;
    
    if ( [self.delegateShapeDisplay respondsToSelector:@selector(shapeDisplayed:)] ) {
        [self.delegateShapeDisplay shapeDisplayed:self];
    }
    
    [imgView removeFromSuperview]; // remove image from view; done
}


@end
