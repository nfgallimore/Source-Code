//
//  objCIntro_templateViewController.m
//  objCIntro_template
//
//  Created by Shawn Arney on 8/16/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "objCIntro_templateViewController.h"
#import "flower.h"
#import "ball.h"
#import "octagon.h"
#import "Shape.h"
#import "NSString+Formatter.h"


@implementation objCIntro_templateViewController
@synthesize btnClickMe;

-(void) dealloc
{
    [btnClickMe release];
    [super dealloc];
}

- (void) shapeDisplayed: (Shape *) myShape
{
    UILabel *myLabel = [[UILabel alloc] initWithFrame:CGRectMake(30, 30, 200, 30)];
    
    myLabel.text = [myShape.imageName formattedString];
    
    [self.view addSubview:myLabel];
    
    [myLabel release];
}


- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
    
    // Release any cached data, images, etc that aren't in use.
}

#pragma mark - View lifecycle

//SEL
-(void) buttonClicked:(id) selector
{
    NSLog(@"button was clicked");
}


// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad
{
    [super viewDidLoad];
    
    
    //performSelector:, performSelector:withObject:, and performSelector:withObject:withObject:
    //NSObject 
    
    //SEL
    
   
   /*
    [friend performSelector:@selector((gossip:))
     
                 withObject:neighbor];
    
    [friend gossip:neighbor];
    
    id helper = getTheReceiver();
    SEL request = getSelector();
    
    [helper performSelector:request];
  */
    
  //  [self.btnClickMe setAction:@selector(buttonClicked:)]; //SEL
    
   // [self.btnClickMe setTarget:self];
    
    [self.btnClickMe addTarget:self action:@selector(buttonClicked:) forControlEvents:UIControlEventTouchUpInside];
    
    [self performSelector:@selector(buttonClicked:)];
    
      
   /* flower *oFlower = [[flower alloc] init];

    [oFlower displayImageOnView:self.view]; 
    
   // [oFlower displayImageOnView:self.view];
    
   // [oFlower displayImageComplete:@"" finished:myNum context:context];
    
    [oFlower release];
    
    ball *oBall = [[ball alloc]init];
    
    [oBall displayImageOnView:self.view];
    
    [oBall release];
    */
    
    NSMutableArray *myArray = [[NSMutableArray alloc] init];
    
    flower *aFlower = [[flower alloc] init];
    
    [myArray addObject:aFlower]; // first object
    
    aFlower.delegateShapeDisplay = self;
    
    [aFlower release];
    
    ball *aBall = [[ball alloc] init];
    
    [myArray addObject:aBall]; // second object
    
    [aBall release];
    
    // normal enumeration
    for (int i = 0; i < [myArray count] ; i++)
    {
        Shape *aObject = (Shape*)[myArray objectAtIndex:i];
        [aObject displayImageOnView:self.view];
    }
    
    
    // fast enumeration; NSArray, NSDictionary, NSSet
    for (Shape *aObject in myArray ) // NSEnumerator protocol
    {
        [aObject displayImageOnView:self.view];
    }
    
    
    // NSException example
    
    
    // @try, @catch, @throw, and @finally
    
    
    
    @try {
        
        //NSException
       // Shape *aObject = (Shape*)[myArray objectAtIndex:10];
        Shape *aObject = (Shape*)[myArray objectAtIndex:1];
    
    } // NSException
 //   @catch (CustomException *exception) {
    
 //       NSLog(@"we got a custom exception");
        
 //   }
    @catch (NSException *exception) {
        
        NSLog(@"we got an exception");
        
    }
    
    @finally {
        NSLog(@"code done");
    }
    
    
    
    
    
    
    [myArray release];
}


- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    // e.g. self.myOutlet = nil;
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

@end
