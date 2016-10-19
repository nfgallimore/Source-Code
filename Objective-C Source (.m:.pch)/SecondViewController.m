//
//  SecondViewController.m
//  Tabbed
//
//  David J. Malan
//  Harvard University
//  malan@harvard.edu
//
//  Demonstrates a Tabbed Application.
//

#import "SecondViewController.h"

@implementation SecondViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        self.title = NSLocalizedString(@"Second", @"Second");
        self.tabBarItem.image = [UIImage imageNamed:@"second"];
    }
    return self;
}

@end
